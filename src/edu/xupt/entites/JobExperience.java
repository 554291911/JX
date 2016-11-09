package edu.xupt.entites;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_jobexperience")
public class JobExperience implements java.io.Serializable {

	private int id;
	private String startDate;// 起始日期
	private String endDate;// 结束日期
	private String company;
	private String job;
	private Talent talent;
	private String duty;//职责
	private String kpi;//绩效
	public JobExperience() {
	}

	public JobExperience(Talent talent) {
		this.talent = talent;
	}

	
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public String getStartDate() {
		return startDate;
	}
	public void setId(int id) {
		this.id = id;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	public Talent getTalent() {
		return talent;
	}

	public void setTalent(Talent talent) {
		this.talent = talent;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getKpi() {
		return kpi;
	}

	public void setKpi(String kpi) {
		this.kpi = kpi;
	}
	
}
