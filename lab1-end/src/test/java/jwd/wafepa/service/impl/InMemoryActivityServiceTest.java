package jwd.wafepa.service.impl;

import java.util.List;

import jwd.wafepa.model.Activity;
import jwd.wafepa.service.ActivityService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InMemoryActivityServiceTest {
	private static final String SWIMMING = "Swimming";
	private static final String RUNNING = "Running";
	private ActivityService activityService;
	
	@Before
	public void setUp(){
		activityService = new InMemoryActivityService();
		
		Activity running = new Activity(RUNNING);
		Activity swimming = new Activity (SWIMMING);
		
		activityService.save(swimming);
		activityService.save(running);
	}
	
	@Test
	public void testFindOne(){
		Activity activity = activityService.findOne(1L);
		Assert.assertNotNull(activity);
		Assert.assertEquals(RUNNING, activity.getName());
	}
	
	@Test
	public void testFindAll(){
		List<Activity> activities = activityService.findAll();
		Assert.assertNotNull(activities);
		Assert.assertEquals(2, activities.size());
	}
}
