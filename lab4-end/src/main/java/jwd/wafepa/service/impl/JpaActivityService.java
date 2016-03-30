package jwd.wafepa.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import jwd.wafepa.model.Activity;
import jwd.wafepa.repository.ActivityRepository;
import jwd.wafepa.service.ActivityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class JpaActivityService 
implements ActivityService {

	@Autowired
	private ActivityRepository activityRepository;
	
	@Override
	public Activity findOne(Long id) {
		return activityRepository.findOne(id);
	}

	@Override
	public List<Activity> findAll() {
		return activityRepository.findAll();
	}

	@Override
	public Activity save(Activity activity) {
		
		return activityRepository.save(activity);
	}

	@Override
	public Activity delete(Long id) {
		Activity activity = activityRepository.findOne(id);
		if(activity == null){
			throw new RuntimeException(
					"Activity not found with ID " + id);
		}
		activityRepository.delete(activity);
		return activity;
	}

	@Override
	public List<Activity> findByName(String name) {
		
		return activityRepository.findByName( name );
	}

}
