package jwd.wafepa.service;

import java.util.List;

import jwd.wafepa.model.Activity;
import jwd.wafepa.service.impl.InMemoryActivityService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InMemoryActivityServiceTest {
	private ActivityService activityService;
	
	@Before
	public void setUp(){
		activityService = new InMemoryActivityService();
		
		Activity swimming = new Activity();
		swimming.setName("Swimming");
		Activity running = new Activity();
		running.setName("Running");
		
		activityService.save(swimming);
		activityService.save(running);
	}
	
	
	@Test
	public void testFindOne(){
		Activity activity = activityService.findOne(0L);
		Assert.assertNotNull(activity);
		Assert.assertEquals("Swimming", activity.getName());
	}
	
	@Test
	public void testFindAll(){
		List<Activity> activities = activityService.findAll();
		Assert.assertNotNull(activities);
		Assert.assertEquals(2, activities.size());
		
	}
	
}
