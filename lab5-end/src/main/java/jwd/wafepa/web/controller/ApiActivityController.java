package jwd.wafepa.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jwd.wafepa.model.Activity;
import jwd.wafepa.service.ActivityService;
import jwd.wafepa.web.dto.ActivityDTO;

@RestController
@RequestMapping(value="/api/activities")
public class ApiActivityController {
	@Autowired
	private ActivityService activityService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ActivityDTO>> getActivities(){
		List<Activity> activities = activityService.findAll();
		
		if(activities==null || activities.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		List<ActivityDTO> activitiesDTO=new ArrayList<>();
		for(Activity activity :activities){
			activitiesDTO.add(new ActivityDTO(activity));
		}
		
		return new ResponseEntity<>(
				activitiesDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}")
	public ResponseEntity<ActivityDTO> getActivity(@PathVariable Long id){
		Activity activity = activityService.findOne(id);
		if(activity == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(
				new ActivityDTO(activity), HttpStatus.OK); 
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<ActivityDTO> delete(@PathVariable Long id){
		
		try {
			Activity activity = activityService.delete(id);
			
			return new ResponseEntity<> (new ActivityDTO( activity)
					,HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity <> (HttpStatus.NOT_FOUND); 
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,
			consumes="application/json")
	public ResponseEntity<ActivityDTO> addActivity(
			@RequestBody ActivityDTO activityDTO){
		
		Activity activity = new Activity();
		activity.setName(activityDTO.getName());
		
		Activity activitySaved = activityService.save(activity);
		
		return new ResponseEntity<> 
			(new ActivityDTO(activitySaved), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}",
					method=RequestMethod.PUT,
					consumes="application/json")
	public ResponseEntity<ActivityDTO> editActivity(
			@RequestBody ActivityDTO activityDTO,
			@PathVariable Long id){
		
		if(activityDTO == null || activityDTO.getId()!=id){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Activity activity = activityService.findOne(id);
		activity.setId(activityDTO.getId());
		activity.setName(activityDTO.getName());
		Activity activitySaved = activityService.save(activity);
		
		return new ResponseEntity<> 
			(new ActivityDTO(activitySaved), HttpStatus.OK);
	}
	
}
