package edu.xupt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xupt.base.DaoSupportImpl;
import edu.xupt.entites.JobExperience;
import edu.xupt.entites.Talent;
import edu.xupt.service.JobExperienceService;

@Service
@Transactional
public class JobExperienceServiceImpl extends DaoSupportImpl<JobExperience>
		implements JobExperienceService {
 
	@SuppressWarnings("hiding")
	public <JobExperience> void eliminate(int talent_id) {
		String sql = "update t_jobexperience set talent_id = null where talent_id = "
				+ talent_id;
		SQLQuery sqlQuery = getSession().createSQLQuery(sql);
		sqlQuery.executeUpdate();
		sql = "delete from t_jobexperience where talent_id is null";
		sqlQuery = getSession().createSQLQuery(sql);
		sqlQuery.executeUpdate();
	}

	@Override
	public void setJobExperiences(Talent talent, List<String> startDate,
			List<String> endDate, List<String> job, List<String> company,  List<String> duty, List<String> kpi) {
		
		int talent_id = talent.getId();
		int size = 0;
		if (company != null)
			size = company.size();
		else if (startDate != null)
			size = startDate.size();
		else if (endDate != null)
			size = endDate.size();
		else if (job != null)
			size = job.size();
		else if (duty != null)
			size = duty.size();
		else if (kpi != null)
			size = kpi.size();
		

		List<JobExperience> newJobExperiences = new ArrayList<JobExperience>();
		for (int i = 0; i < size; i++) {
			if (!(startDate.get(i).trim().equals(""))
					&& !(endDate.get(i).trim().equals(""))
					&& !(company.get(i).trim().equals(""))
					&& !(job.get(i).trim().equals(""))
					&& !(duty.get(i).trim().equals(""))
					&& !(kpi.get(i).trim().equals(""))) {
				JobExperience jobExperience = new JobExperience(talent);
				jobExperience.setStartDate(startDate.get(i));
				jobExperience.setEndDate(endDate.get(i));
				jobExperience.setJob(job.get(i));
				jobExperience.setCompany(company.get(i));
				jobExperience.setDuty(duty.get(i));
				jobExperience.setKpi(kpi.get(i));
				newJobExperiences.add(jobExperience);
			}
		}
		eliminate(talent_id);
		talent.setJobExperiences(newJobExperiences);
	}
}
