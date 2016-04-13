package jwd.wafepa.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import jwd.wafepa.model.Activity;
import jwd.wafepa.model.Log;
import jwd.wafepa.repository.LogRepository;
import jwd.wafepa.service.LogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class JpaLogService implements LogService {
	
	@Autowired
	private LogRepository logRepository;
	
	@Override
	public Log findOne(Long id) {
		return logRepository.findOne(id);
	}

	@Override
	public List<Log> findAll() {
		return logRepository.findAll();
	}

	@Override
	public Log save(Log log) {
		return logRepository.save(log);
	}

	@Override
	public void delete(Long id) throws IllegalArgumentException {
		logRepository.delete(id);
	}

	@Override
	public int countByActivity(Activity activity) {
		return logRepository.countByActivity(activity);
	}

	@Override
	public List<Log> findByActivity(Activity activity) {
		return logRepository.findByActivity(activity);
	}

}
