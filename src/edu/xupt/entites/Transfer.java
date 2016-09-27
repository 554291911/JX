package edu.xupt.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_transfer")
public class Transfer implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int id;
	private Set<UserForTransfer> userForTransfers = new HashSet<UserForTransfer>();
	private String subject;// 科目
	private String description;// 事件及描述情况
	private String solutionAndImpl;// 解决方案及执行人
	private String feedback;// 事件处理结果反馈
	private String status;//状态
	private String nowTime;//现在时间
	private String nowPromoter;//现在发起人
	private String nowRecipient;//现在接收人
	
	private Set<User> users = new HashSet<User>();

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSolutionAndImpl() {
		return solutionAndImpl;
	}

	public void setSolutionAndImpl(String solutionAndImpl) {
		this.solutionAndImpl = solutionAndImpl;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@ManyToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_transfer", joinColumns = { @JoinColumn(name = "transferId") }, inverseJoinColumns = { @JoinColumn(name = "userId") })
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNowTime() {
		return nowTime;
	}

	public void setNowTime(String nowTime) {
		this.nowTime = nowTime;
	}

	public String getNowPromoter() {
		return nowPromoter;
	}

	public void setNowPromoter(String nowPromoter) {
		this.nowPromoter = nowPromoter;
	}

	public String getNowRecipient() {
		return nowRecipient;
	}

	public void setNowRecipient(String nowRecipient) {
		this.nowRecipient = nowRecipient;
	}

	@OneToMany(mappedBy = "transfer", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	public Set<UserForTransfer> getUserForTransfers() {
		return userForTransfers;
	}

	public void setUserForTransfers(Set<UserForTransfer> userForTransfers) {
		this.userForTransfers = userForTransfers;
	}
	
}
