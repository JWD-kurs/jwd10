package jwd.wafepa.web.controller;

import java.util.List;

import jwd.wafepa.model.Activity;
import jwd.wafepa.service.ActivityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/activities")
public class ActivitiesController {
	@Autowired
	private ActivityService activityService;
	
//	@PostConstruct
//	public void init(){
//		activityService.save(new Activity("Running"));
//		activityService.save(new Activity("Tennis"));
//	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String getActivities(Model model){
		List<Activity> activities = activityService.findAll();
		model.addAttribute("activitiesModel",activities);
		model.addAttribute("title", "Activities");
		return "activities";
	}
	
	@RequestMapping(value="/remove/{id}")
	public String remove(@PathVariable Long id,
						Model model){
		
		activityService.delete(id);
		
		return "redirect:/activities";
	}
	
	@RequestMapping(value="/add")
	public String add(Model model){
		model.addAttribute("activity", new Activity());
		return "addEditActivity";
	}
	
	@RequestMapping(value="/edit/{id}")
	public String edit(Model model,
						@PathVariable Long id){
		
		Activity activity = activityService.findOne(id);
		if(activity==null){
			return "redirect:/activities";
		}
		
		model.addAttribute("activity",activity);
		
		return "addEditActivity";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String post(Activity activity){
		activityService.save(activity);
		return "redirect:/activities";
	}
	
	@RequestMapping(value="/name/{name}")
	public String findByName(@PathVariable String name,
			Model model){
		List<Activity> activities =
				activityService.findByName(name);
		model.addAttribute("activitiesModel",activities);
		return "activities";
	}
}
