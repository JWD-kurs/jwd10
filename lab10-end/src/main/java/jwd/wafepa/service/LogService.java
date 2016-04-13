package jwd.wafepa.service;

import java.util.List;

import jwd.wafepa.model.Activity;
import jwd.wafepa.model.Log;

public interface LogService {

	Log findOne(Long id);
	List<Log> findAll();
	Log save(Log log);
	void delete(Long id) throws IllegalArgumentException;
	
	int countByActivity(Activity activity);
	List<Log> findByActivity(Activity activity);
}
