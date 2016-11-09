package edu.xupt.service;

import java.util.List;

import edu.xupt.base.DaoSupport;
import edu.xupt.entites.JobExperience;
import edu.xupt.entites.Talent;


public interface JobExperienceService extends DaoSupport<JobExperience>{

	//根据人才ID删除职位经历
	public <JobExperience> void eliminate(int talent_id);

	void setJobExperiences(Talent talent, List<String> startDate,
			List<String> endDate, List<String> job, List<String> company, List<String> duty, List<String> kpi);
}
