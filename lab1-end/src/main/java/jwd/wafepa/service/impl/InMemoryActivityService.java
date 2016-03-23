package jwd.wafepa.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jwd.wafepa.model.Activity;
import jwd.wafepa.service.ActivityService;

public class InMemoryActivityService implements ActivityService {

	private Map<Long, Activity> activities = new HashMap<>();
	private long nextId = 0;

	@Override
	public Activity findOne(Long id) {
		return activities.get(id);
	}

	@Override
	public List<Activity> findAll() {
		// Collection<Activity> all = activities.values();
		// List<Activity> ret = new ArrayList<Activity>();
		// for(Activity activity : all){
		// ret.add(activity);
		// }
		// return ret;

		return new ArrayList<Activity>(activities.values());
	}

	@Override
	public Activity save(Activity activity) {
		if (activity.getId() == null) {
			activity.setId(nextId++);
		}
		activities.put(activity.getId(), activity);
		return activity;
	}

	@Override
	public Activity delete(Long id) {
		Activity activity = activities.get(id);
		if(activity!=null){
			activities.remove(activity);
		}
		return activity;
	}

}
