package edu.xupt.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
@Table(name="t_talent")
public class Talent implements Serializable{
	
	private String creator;//创建人
	private String modifer;//修改人
	private Date created;//创建时间
	private Date modified;//修改时间
	private User user;
	private String username;
	private int id;
	private String name;//姓名
	private String birthday;//出生年月
	private String sex;
	private String position;//现任职位
	private String isMarried;
	private String hasChildren;//有无子女
	private String postLevel;//岗位级别
	private String phoneNumber;
	private String firstDegree;//第一学位
	private String highestDegree;//最高学位
	private String email;
	private String address;
	private String eduExperience;//教育经历
	private String hopeJob;
	private String treatmentLevel;//待遇水平
	private String hopeTreatment;//期望待遇
	private String description;
	private String photoUrl;//照片存放地址
	private String oldResumeName;//原始简历
	private String standardResumeName;//标准简历
	private String disposition;//个人性格
	private String company;//现公司
	private String experience;//工作经历
	private String communicate;//沟通情况
	private String recommend;//推荐职位
	private String isCommunicate;//是否沟通完成
	
	private List<JobExperience> jobExperiences = new ArrayList<JobExperience>();//职位经历

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIsMarried() {
		return isMarried;
	}

	public void setIsMarried(String isMarried) {
		this.isMarried = isMarried;
	}

	public String getPostLevel() {
		return postLevel;
	}

	public void setPostLevel(String postLevel) {
		this.postLevel = postLevel;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFirstDegree() {
		return firstDegree;
	}

	public void setFirstDegree(String firstDegree) {
		this.firstDegree = firstDegree;
	}

	public String getHighestDegree() {
		return highestDegree;
	}

	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEduExperience() {
		return eduExperience;
	}

	public void setEduExperience(String eduExperience) {
		this.eduExperience = eduExperience;
	}

	public String getHopeJob() {
		return hopeJob;
	}

	public void setHopeJob(String hopeJob) {
		this.hopeJob = hopeJob;
	}

	public String getTreatmentLevel() {
		return treatmentLevel;
	}

	public void setTreatmentLevel(String treatmentLevel) {
		this.treatmentLevel = treatmentLevel;
	}

	public String getHopeTreatment() {
		return hopeTreatment;
	}

	public void setHopeTreatment(String hopeTreatment) {
		this.hopeTreatment = hopeTreatment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}


	public String getOldResumeName() {
		return oldResumeName;
	}

	public void setOldResumeName(String oldResumeName) {
		this.oldResumeName = oldResumeName;
	}

	public String getStandardResumeName() {
		return standardResumeName;
	}

	public void setStandardResumeName(String standardResumeName) {
		this.standardResumeName = standardResumeName;
	}

	
	

	public String getPosition() {
		return position;
	}

	@OneToMany(mappedBy="talent",cascade={CascadeType.ALL}, fetch = FetchType.EAGER)
	public List<JobExperience> getJobExperiences() {
		return jobExperiences;
	}

	public void setJobExperiences(List<JobExperience> jobExperiences) {
		this.jobExperiences = jobExperiences;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(String hasChildren) {
		this.hasChildren = hasChildren;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDisposition() {
		return disposition;
	}

	public void setDisposition(String disposition) {
		this.disposition = disposition;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getModifer() {
		return modifer;
	}

	public void setModifer(String modifer) {
		this.modifer = modifer;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getCommunicate() {
		return communicate;
	}

	public void setCommunicate(String communicate) {
		this.communicate = communicate;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public String getIsCommunicate() {
		return isCommunicate;
	}

	public void setIsCommunicate(String isCommunicate) {
		this.isCommunicate = isCommunicate;
	}

	
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}
	
}
