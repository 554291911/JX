package edu.xupt.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_week")
public class Week implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;// 员工姓名
	private String recommend;// 推荐量
	private String phoneNum;// 电话数
	private String evaluation;// 简历评估通过数
	private String nextWeek;// 下周F2F候选人个数
	private String nextName;// F2F候选人姓名
	private String other;// 其他
	private String year;// 年
	private String month;// 月
	private String week;// 周
	private List<Candidate> candidates = new ArrayList<Candidate>();// 工作输出结果
	private String nextQuestion;
	private String nextManager;
	private String status;//状态
	private String time;//申请时间
	private String sendstatus;//发送状态
	private String approval;//审批意见
	
	private User user;// 用户
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public String getNextWeek() {
		return nextWeek;
	}

	public void setNextWeek(String nextWeek) {
		this.nextWeek = nextWeek;
	}

	public String getNextName() {
		return nextName;
	}

	public void setNextName(String nextName) {
		this.nextName = nextName;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	@OneToMany(mappedBy = "weeks", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	public String getNextQuestion() {
		return nextQuestion;
	}

	public void setNextQuestion(String nextQuestion) {
		this.nextQuestion = nextQuestion;
	}

	public String getNextManager() {
		return nextManager;
	}

	public void setNextManager(String nextManager) {
		this.nextManager = nextManager;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSendstatus() {
		return sendstatus;
	}

	public void setSendstatus(String sendstatus) {
		this.sendstatus = sendstatus;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}
	
}