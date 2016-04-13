package jwd.wafepa.web.controller;

import java.util.ArrayList;
import java.util.List;

import jwd.wafepa.model.Activity;
import jwd.wafepa.model.Log;
import jwd.wafepa.service.ActivityService;
import jwd.wafepa.service.LogService;
import jwd.wafepa.web.dto.ActivityDTO;
import jwd.wafepa.web.dto.LogDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/logs")
public class ApiLogController {

	@Autowired
	private LogService logService;
	
	@Autowired
	private ActivityService activityService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<LogDTO>> getLogs() {
		List<Log> logs = logService.findAll();
		
		List<LogDTO> logsDTO = new ArrayList<LogDTO>();
		
		for (Log log : logs) {
			LogDTO logDTO = new LogDTO();
			logDTO.setId(log.getId());
			logDTO.setDate(log.getDate());
			logDTO.setDuration(log.getDuration());
			Activity activity = log.getActivity();
			ActivityDTO activityDTO = new ActivityDTO(activity);
			logDTO.setActivity(activityDTO);
			
			logsDTO.add(logDTO);
		}
		
		return new ResponseEntity<>(logsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<LogDTO> addLog(@RequestBody LogDTO logDTO) {
		Log log = new Log();
		
		log.setDate(logDTO.getDate());
		log.setDuration(logDTO.getDuration());
		
		Activity activity = activityService.findOne(logDTO.getActivity().getId());
		log.setActivity(activity);
		
		log = logService.save(log);
		
		return new ResponseEntity<>(logDTO, HttpStatus.CREATED);
	}
}
