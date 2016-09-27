package edu.xupt.entites;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_job")
public class Job implements Serializable{

	private int id;
	private String jobName;//岗位名称
	private String companyName;//客户公司
	private String emergencyDegree;//紧急程度
	private String workingPlace;//工作地点
	private String treatment;//待遇状况
	private String releaseDate;//发布日期
	private String status;//状态
	private String requirement;//岗位要求
	private String description;//职位描述
	private Set<JobProgress> jobProgresses = new HashSet<JobProgress>();
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getEmergencyDegree() {
		return emergencyDegree;
	}
	public void setEmergencyDegree(String emergencyDegree) {
		this.emergencyDegree = emergencyDegree;
	}
	public String getWorkingPlace() {
		return workingPlace;
	}
	public void setWorkingPlace(String workingPlace) {
		this.workingPlace = workingPlace;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRequirement() {
		return requirement;
	}
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@OneToMany(mappedBy="job",cascade={CascadeType.ALL})
	public Set<JobProgress> getJobProgresses() {
		return jobProgresses;
	}
	public void setJobProgresses(Set<JobProgress> jobProgresses) {
		this.jobProgresses = jobProgresses;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
}
