package jwd.wafepa.web.dto;

import jwd.wafepa.model.Activity;

public class ActivityDTO {
	
	private Long id;
	private String name;
	private Integer logsCount;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ActivityDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public ActivityDTO(String name) {
		super();
		this.name = name;
	}
	
	public ActivityDTO() {
		super();
	}
	
	public ActivityDTO(Activity activity){
		this.name=activity.getName();
		this.id=activity.getId();
	}
	public Integer getLogsCount() {
		return logsCount;
	}
	public void setLogsCount(Integer logsCount) {
		this.logsCount = logsCount;
	}
}
