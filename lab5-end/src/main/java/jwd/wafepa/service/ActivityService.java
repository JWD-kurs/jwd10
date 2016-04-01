package jwd.wafepa.service;

import java.util.List;

import jwd.wafepa.model.Activity;

public interface ActivityService {
	/**
	 * Returns an activity with specified ID.
	 * @param id ID of the activity
	 * @return Activity, if activity with such ID
	 * exists, {@code null} if activity is not found.
	 */
	Activity findOne(Long id);
	
	/**
	 *  
	 * @return List of all existing activities.
	 */
	List<Activity> findAll();
	
	/**
	 * Persists an activity. If activity's id is null,
	 * a new id will be assigned automatically.
	 * @param activity
	 * @return Activity state after persisting. 
	 */
	Activity save(Activity activity);
	
	/**
	 * Deletes an activity having specified ID.
	 * @param id ID of the activity to be removed. 
	 * @return Removed activity if removal is successful. 
	 * {@code null} if activity was not found. 
	 */
	Activity delete(Long id);
	
	/**
	 * 
	 * @param name
	 * @return List of Activities who's name equals the string
	 * given in the @{code name} parameter.
	 */
	List<Activity> findByName(String name);
	
}
