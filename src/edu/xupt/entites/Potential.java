package edu.xupt.entites;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_potential")
public class Potential implements Serializable{

	private int id;
	private String headHunting;//猎头顾问
	private String startTime;//发起时间
	private String name;//潜在客户名称
	private String introduction;//公司简介
	private String recruitment;//招聘岗位
	private String firstContactTime;//初次联系时间
	private String contactPerson;//联系人
	private String contactInformation;//联系方式
	private String initialContactInformation;//初次联系情况
	private String problem;//存在难题
	private String againContactTime;//再次联系时间
	private String againContactInformation;//再次联系情况
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHeadHunting() {
		return headHunting;
	}
	public void setHeadHunting(String headHunting) {
		this.headHunting = headHunting;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getRecruitment() {
		return recruitment;
	}
	public void setRecruitment(String recruitment) {
		this.recruitment = recruitment;
	}
	
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getContactInformation() {
		return contactInformation;
	}
	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}
	public String getInitialContactInformation() {
		return initialContactInformation;
	}
	public void setInitialContactInformation(String initialContactInformation) {
		this.initialContactInformation = initialContactInformation;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getAgainContactInformation() {
		return againContactInformation;
	}
	public void setAgainContactInformation(String againContactInformation) {
		this.againContactInformation = againContactInformation;
	}
	public String getFirstContactTime() {
		return firstContactTime;
	}
	public void setFirstContactTime(String firstContactTime) {
		this.firstContactTime = firstContactTime;
	}
	public String getAgainContactTime() {
		return againContactTime;
	}
	public void setAgainContactTime(String againContactTime) {
		this.againContactTime = againContactTime;
	}
}
