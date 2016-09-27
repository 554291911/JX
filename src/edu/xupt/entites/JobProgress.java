package edu.xupt.entites;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 职位进度
 * @author dell-pc
 *
 */

@Entity
@Table(name="t_jobProgress")
public class JobProgress implements Serializable{

	private int id;
	private String candidate;//候选人
	private String result;//面试结果
	private String startTime;//开始时间
	private String endTime;//结束时间
	private Job job;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCandidate() {
		return candidate;
	}
	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	@ManyToOne(cascade={CascadeType.ALL})
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
}
