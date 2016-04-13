package jwd.wafepa.repository;

import java.util.List;

import jwd.wafepa.model.Activity;
import jwd.wafepa.model.Log;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

	int countByActivity(Activity activity);
	List<Log> findByActivity(Activity activity);
}
