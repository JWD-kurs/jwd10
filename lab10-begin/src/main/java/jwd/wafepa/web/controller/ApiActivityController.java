package jwd.wafepa.web.controller;

import java.util.ArrayList;
import java.util.List;

import jwd.wafepa.model.Activity;
import jwd.wafepa.service.ActivityService;
import jwd.wafepa.service.LogService;
import jwd.wafepa.web.dto.ActivityDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/activities")
public class ApiActivityController {

	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private LogService logService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ActivityDTO>> getActivities(
			@RequestParam(value="name", required=false) String name,
			@RequestParam(value="page", required=true) int page) {
		List<Activity> activities = null;
		
		int totalPages = 0;
		
		if (name != null) {
			activities = activityService.findByName(name);
		} else {
			Page<Activity> activitiesPage = activityService.findAll(page);
			activities = activitiesPage.getContent();
			totalPages = activitiesPage.getTotalPages();
		}

		List<ActivityDTO> activitiesDTO = new ArrayList<>();
		for (Activity activity : activities) {
			ActivityDTO activityDTO = new ActivityDTO(activity);
			int logsCount = logService.countByActivity(activity);
			activityDTO.setLogsCount(logsCount);
			activitiesDTO.add(activityDTO);
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("total-pages", String.valueOf(totalPages));

		return new ResponseEntity<>(activitiesDTO, httpHeaders, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}")
	public ResponseEntity<ActivityDTO> getActivity(@PathVariable Long id) {
		Activity activity = activityService.findOne(id);
		if (activity == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new ActivityDTO(activity), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ActivityDTO> delete(@PathVariable Long id) {

		try {
			Activity activity = activityService.delete(id);

			return new ResponseEntity<>(new ActivityDTO(activity), HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<ActivityDTO> addActivity(
			@RequestBody ActivityDTO activityDTO) {

		Activity activity = new Activity();
		activity.setName(activityDTO.getName());

		Activity activitySaved = activityService.save(activity);

		return new ResponseEntity<>(new ActivityDTO(activitySaved), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<ActivityDTO> editActivity(
			@RequestBody ActivityDTO activityDTO, @PathVariable Long id) {

		if (activityDTO == null || activityDTO.getId() != id) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Activity activity = activityService.findOne(id);
		activity.setName(activityDTO.getName());
		Activity activitySaved = activityService.save(activity);

		return new ResponseEntity<>(new ActivityDTO(activitySaved), HttpStatus.OK);
	}

}
