package edu.xupt.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import edu.xupt.base.ModelDrivenBaseAction;
import edu.xupt.entites.Job;
import edu.xupt.entites.JobProgress;
import edu.xupt.util.QueryHelper;


@Controller
@Scope("prototype")
public class JobAction extends ModelDrivenBaseAction<Job>{

	private List<String> candidate;
	private List<String> result;
	private List<String> startTime;
	private List<String> endTime;
	
	//查询条件
	private String statusType = "";//状态
	private String degreeType = "";//紧急程度
	private String jobType = "";//岗位
	private String companyType = "";//客户公司
	
	/**  列表*/
	public String list() throws Exception {
		
		// 准备分页信息
		if(statusType.equals("")){
		new QueryHelper(Job.class, "j")
		.addCondition("j.status=?", "发布")
		.addCondition((!jobType.trim().equals("")), "j.jobName LIKE ?", "%" + jobType + "%")
		.addCondition((!degreeType.equals("")), "j.emergencyDegree=?", degreeType)
		.addCondition((!companyType.trim().equals("")), "j.companyName LIKE ?", "%" + companyType + "%")
		.preparePageBean(jobService, pageNum, pageSize);
		}
		else if(statusType.equals("全部")){
			new QueryHelper(Job.class, "j")
			.addCondition((!degreeType.equals("")), "j.emergencyDegree=?", degreeType)
			.addCondition((!jobType.trim().equals("")), "j.jobName LIKE ?", "%" + jobType + "%")
			.addCondition((!companyType.trim().equals("")), "j.companyName LIKE ?", "%" + companyType + "%")
			.preparePageBean(jobService, pageNum, pageSize);
		}
		else
		{
			new QueryHelper(Job.class, "j")
		.addCondition((!statusType.equals("")), "j.status=?", statusType)
		.addCondition((!degreeType.equals("")), "j.emergencyDegree=?", degreeType)
		.addCondition((!jobType.trim().equals("")), "j.jobName LIKE ?", "%" + jobType + "%")
		.addCondition((!companyType.trim().equals("")), "j.companyName LIKE ?", "%" + companyType + "%")
		.preparePageBean(jobService, pageNum, pageSize);
		}
		return "list";
	}

	/**  添加页面	 */
	public String saveUI() throws Exception {
		
		return "saveUI";
	}

	
	public String save() throws Exception {

		jobService.save(model);
		return "toList";
	}

	public String delete() throws Exception {
		
		talentService.delete(model.getId());
		return "toList";
	}
	
	public String editUI() throws Exception{
		
		// 准备回显的数据
		Job job = jobService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(job);
		return "editUI";
	}
	
	public String edit() throws Exception{
		// 1，从数据库中获取原对象
				Job job = jobService.getById(model.getId());

				// 2，设置要修改的属性
				job.setJobName(model.getJobName());
				job.setCompanyName(model.getCompanyName());
				job.setEmergencyDegree(model.getEmergencyDegree());
				job.setWorkingPlace(model.getWorkingPlace());
				job.setStatus(model.getStatus());
				job.setTreatment(model.getTreatment());
				job.setReleaseDate(model.getReleaseDate());
				job.setRequirement(model.getRequirement());
				job.setDescription(model.getDescription());
		
				// 3，更新到数据库
				jobService.update(job);
		return "toList";
	}

	/** 查看职位描述页面*/
	public String detailUI() throws Exception{
		Job job = jobService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(job);
		return "detailUI";
	}
	
	
	/** 职位进度*/
	public String scheduleUI() throws Exception{
		Job job = jobService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(job);
		
		
		
		return "scheduleUI";
	}
	
	/** 职位进度*/
	public String schedule() throws Exception{
		
		Job job = jobService.getById(model.getId());
		
		job.setStatus(model.getStatus());
		
		jobService.update(job);
		
		if(candidate != null){
			for(int i = 0; i < candidate.size(); i++){
				JobProgress jobprogress =new JobProgress();
				jobprogress.setCandidate(candidate.get(i));
				jobprogress.setResult(result.get(i));
				jobprogress.setStartTime(startTime.get(i));
				jobprogress.setEndTime(endTime.get(i));
				jobprogress.setJob(job);
				jobProgressSerivce.save(jobprogress);
			}
		}
		
		return "toList";
	}

	public List<String> getCandidate() {
		return candidate;
	}

	public void setCandidate(List<String> candidate) {
		this.candidate = candidate;
	}

	public List<String> getResult() {
		return result;
	}

	public void setResult(List<String> result) {
		this.result = result;
	}

	

	public List<String> getStartTime() {
		return startTime;
	}

	public void setStartTime(List<String> startTime) {
		this.startTime = startTime;
	}

	public List<String> getEndTime() {
		return endTime;
	}

	public void setEndTime(List<String> endTime) {
		this.endTime = endTime;
	}

	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	public String getDegreeType() {
		return degreeType;
	}

	public void setDegreeType(String degreeType) {
		this.degreeType = degreeType;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
}
