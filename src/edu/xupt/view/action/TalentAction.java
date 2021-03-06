package edu.xupt.view.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import edu.xupt.base.ModelDrivenBaseAction;
import edu.xupt.entites.Talent;
import edu.xupt.entites.User;
import edu.xupt.util.QueryHelper;
import edu.xupt.util.TimeUtil;
import edu.xupt.util.UploadUtils;

/**
 * ================人才系统管理================= 人才信息管理
 * 
 * @author 郭磊，周豪
 * 
 */

@Controller
@Scope("prototype")
public class TalentAction extends ModelDrivenBaseAction<Talent> {

	private String name;
	private String sex;
	private String postLevel;
	private String nowJob;

	private List<String> startDate;
	private List<String> endDate;
	private List<String> company;
	private List<String> job;
	private List<String> duty;
	private List<String> kpi;

	// 获取照片
	private File photo;
	private String photoFileName;

	// 获取原始简历oldResume
	private File oldResume;
	private String oldResumeFileName;

	// 获取标准简历standardResume
	private File standardResume;
	private String standardResumeFileName;

	// 获取查询内容
	private String sexType = "";// 性别查询
	private String levelType = "";// 岗位级别查询
	private String jobCondition = "";
	private String companyCondition = "";
	private String firstDegreeType = "";// 第一学历查询
	private String character = "";// 个人性格
	private String ncompany = "";// 目前公司
	private String nrecommend = "";// 推荐职位
	private String startTime = "";
	private String endTime = "";
	private String operator = "";
	private String tname = "";// 候选人姓名

	// 获取登录信息
	User user = getCurrentUser();

	/** 人才信息列表 */
	public String list() throws Exception {
		if (user.getLoginName().equals("admin")) {
			if (!(companyCondition.trim().equals(""))) {
				new QueryHelper(Talent.class, "t", "jobExperiences", "j")
						.addCondition(!(sexType.equals("")), "t.sex=?", sexType)
						.addCondition(!(firstDegreeType.equals("")), "t.firstDegree=?", firstDegreeType)
						.addCondition(!(levelType.equals("")), "t.postLevel=?", levelType)
						.addCondition(!(jobCondition.equals("")), "t.position LIKE ?", "%" + jobCondition.trim() + "%")
						.addCondition(!(companyCondition.equals("")), "j.company LIKE ?",
								"%" + companyCondition.trim() + "%")
						.addCondition(!(jobCondition.equals("")), "t.position LIKE ?", "%" + jobCondition.trim() + "%")
						.addCondition(!(character.equals("")), "t.disposition LIKE ?", "%" + character.trim() + "%")
						.addCondition(!(ncompany.equals("")), "t.company LIKE ?", "%" + ncompany.trim() + "%")
						.addCondition(!(nrecommend.equals("")), "t.recommend LIKE ?", "%" + nrecommend.trim() + "%")
						.addCondition(!(tname.equals("")), "t.name LIKE ?", "%" + tname.trim() + "%")
						.addCondition(!(operator.equals("")), "t.creator LIKE ?", "%" + operator.trim() + "%")
						.addCondition(!(startTime.equals("") && startTime != null), "t.modified > ?",
								TimeUtil.stringToDate(startTime))
						.addCondition(!(endTime.equals("") && endDate != null), "t.modified < ?",
								TimeUtil.addDay(TimeUtil.stringToDate(endTime)))
						.addOrderProperty("t.modified", false).preparePageBean(talentService, pageNum, pageSize);
			} else {
				new QueryHelper(Talent.class, "t").addCondition(!(sexType.equals("")), "t.sex=?", sexType)
						.addCondition(!(firstDegreeType.equals("")), "t.firstDegree=?", firstDegreeType)
						.addCondition(!(levelType.equals("")), "t.postLevel=?", levelType)
						.addCondition(!(jobCondition.equals("")), "t.position LIKE ?", "%" + jobCondition.trim() + "%")
						.addCondition(!(character.equals("")), "t.disposition LIKE ?", "%" + character.trim() + "%")
						.addCondition(!(ncompany.equals("")), "t.company LIKE ?", "%" + ncompany.trim() + "%")
						.addCondition(!(nrecommend.equals("")), "t.recommend LIKE ?", "%" + nrecommend.trim() + "%")
						.addCondition(!(operator.equals("")), "t.creator LIKE ?", "%" + operator.trim() + "%")
						.addCondition(!(tname.equals("")), "t.name LIKE ?", "%" + tname.trim() + "%")
						.addCondition(!(startTime.equals("")), "t.modified > ?", TimeUtil.stringToDate(startTime))
						.addCondition(!(endTime.equals("")), "t.modified < ?",
								TimeUtil.addDay(TimeUtil.stringToDate(endTime)))
						.addCondition(!(operator.equals("")), "t.creator LIKE ?", "%" + operator.trim() + "%")
						.addOrderProperty("t.modified", false).preparePageBean(talentService, pageNum, pageSize);
			}
		}

		else {
			if (!(companyCondition.equals(""))) {
				new QueryHelper(Talent.class, "t", "jobExperiences", "j")
						.addCondition(!(sexType.equals("")), "t.sex=?", sexType)
						.addCondition(!(firstDegreeType.equals("")), "t.firstDegree=?", firstDegreeType)
						.addCondition(!(levelType.equals("")), "t.postLevel=?", levelType)
						.addCondition(!(jobCondition.equals("")), "t.position LIKE ?", "%" + jobCondition.trim() + "%")
						.addCondition(!(companyCondition.equals("")), "j.company LIKE ?",
								"%" + companyCondition.trim() + "%")
						.addCondition(!(character.equals("")), "t.disposition LIKE ?", "%" + character.trim() + "%")
						.addCondition(!(ncompany.equals("")), "t.company LIKE ?", "%" + ncompany.trim() + "%")
						.addCondition(!(nrecommend.equals("")), "t.recommend LIKE ?", "%" + nrecommend.trim() + "%")
						.addCondition(!(operator.equals("")), "t.creator LIKE ?", "%" + operator.trim() + "%")
						.addCondition(!(tname.equals("")), "t.name LIKE ?", "%" + tname.trim() + "%")
						.addCondition(!(startTime.equals("")), "t.modified > ?", TimeUtil.stringToDate(startTime))
						.addCondition(!(endTime.equals("")), "t.modified < ?",
								TimeUtil.addDay(TimeUtil.stringToDate(endTime)))
						/* .addCondition("t.user=?", user) */
						.addOrderProperty("t.modified", false).preparePageBean(talentService, pageNum, pageSize);
			} else {
				// 准备分页信息
				new QueryHelper(Talent.class, "t").addCondition(!(sexType.equals("")), "t.sex=?", sexType)
						.addCondition(!(firstDegreeType.equals("")), "t.firstDegree=?", firstDegreeType)
						.addCondition(!(levelType.equals("")), "t.postLevel=?", levelType)
						.addCondition(!(jobCondition.equals("")), "t.position LIKE ?", "%" + jobCondition.trim() + "%")
						.addCondition(!(character.equals("")), "t.disposition LIKE ?", "%" + character.trim() + "%")
						.addCondition(!(ncompany.equals("")), "t.company LIKE ?", "%" + ncompany.trim() + "%")
						.addCondition(!(nrecommend.equals("")), "t.recommend LIKE ?", "%" + nrecommend.trim() + "%")
						.addCondition(!(operator.equals("")), "t.creator LIKE ?", "%" + operator.trim() + "%")
						.addCondition(!(tname.equals("")), "t.name LIKE ?", "%" + tname.trim() + "%")
						.addCondition(!(startTime.equals("")), "t.modified > ?", TimeUtil.stringToDate(startTime))
						.addCondition(!(endTime.equals("")), "t.modified < ?",
								TimeUtil.addDay(TimeUtil.stringToDate(endTime)))
						// .addCondition("t.user=?", user)
						.addOrderProperty("t.modified", false).preparePageBean(talentService, pageNum, pageSize);
			}
		}
		return "list";
	}

	/** 添加人才信息页面 */
	public String saveUI() throws Exception {

		return "saveUI";
	}

	/** 添加人才信息 */
	public String save() throws Exception {
		UploadUtils pu = new UploadUtils();
		model.setCreator(user.getName());
		model.setModifer(user.getName());
		model.setCreated(new Date());
		model.setModified(new Date());
		// 上传图片
		if (photo != null) {
			String photoPath = pu.photoUpload(photo, photoFileName);
			model.setPhotoUrl(photoPath);
		}
		// 上传原始简历
		if (oldResume != null) {
			String oldResumeName = pu.wordUpload(oldResume, oldResumeFileName);
			model.setOldResumeName(oldResumeName);
		}
		// 上传标准简历
		if (standardResume != null) {
			String standardResumeName = pu.wordUpload(standardResume, standardResumeFileName);
			model.setStandardResumeName(standardResumeName);
		}

		// model.setUser(user);

		try {
			talentService.save(model);
		} catch (Exception e) {
			return "duplicateError";
		}

		/*
		 * if (company != null) { for (int i = 0; i < company.size(); i++) { if
		 * (!(startDate.get(i).trim().equals("")) &&
		 * !(endDate.get(i).trim().equals("")) &&
		 * !(company.get(i).trim().equals("")) &&
		 * !(job.get(i).trim().equals(""))) { JobExperience je = new
		 * JobExperience(); je.setStartDate(startDate.get(i));
		 * je.setEndDate(endDate.get(i)); je.setCompany(company.get(i));
		 * je.setJob(job.get(i)); je.setDuty(duty.get(i));
		 * je.setKpi(kpi.get(i)); je.setTalent(model);
		 * jobExperienceService.save(je); } } }
		 */

		return "toList";
	}

	/** 删除人才信息 */
	public String delete() throws Exception {
		talentService.delete(model.getId());
		return "toList";
	}

	/** 修改人才信息页面 */
	public String editUI() throws Exception {
		// 准备回显的数据
		Talent talent = talentService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(talent);
		return "editUI";
	}

	public String saveCom() throws Exception {
		// 1，从数据库中获取原对象
		Talent talent = talentService.getById(model.getId());

		talent.setCommunicate(model.getCommunicate());
		try {
			talentService.update(talent);
		} catch (Exception e) {
			return "duplicateError";
		}
		return "toList";
	}

	/** 修改人才信息 */
	public String edit() throws Exception {
		// 1，从数据库中获取原对象
		Talent talent = talentService.getById(model.getId());

		// 2，设置要修改的属性
		talent.setModifer(user.getName());
		if (user.getName().equals(talent.getCreator())) {
			talent.setModified(new Date());
		}
		talent.setName(model.getName());
		talent.setIsMarried(model.getIsMarried());
		talent.setBirthday(model.getBirthday());
		talent.setPosition(model.getPosition());
		talent.setPostLevel(model.getPostLevel());
		talent.setSex(model.getSex());
		talent.setPhoneNumber(model.getPhoneNumber());
		talent.setFirstDegree(model.getFirstDegree());
		talent.setHighestDegree(model.getHighestDegree());
		talent.setEmail(model.getEmail());
		talent.setAddress(model.getAddress());
		talent.setEduExperience(model.getEduExperience());
		talent.setHopeJob(model.getHopeJob());
		talent.setTreatmentLevel(model.getTreatmentLevel());
		talent.setHopeTreatment(model.getHopeTreatment());
		talent.setDescription(model.getDescription());
		talent.setDisposition(model.getDisposition());
		talent.setCompany(model.getCompany());
		talent.setExperience(model.getExperience());
		talent.setRecommend(model.getRecommend());
		talent.setIsCommunicate(model.getIsCommunicate());
		talent.setCommunicate(model.getCommunicate());
		UploadUtils pu = new UploadUtils();
		// 上传图片
		if (photo != null) {
			String photoPath = pu.photoUpload(photo, photoFileName);
			talent.setPhotoUrl(photoPath);
		}
		// 上传原始简历
		if (oldResume != null) {
			String oldResumeName = pu.wordUpload(oldResume, oldResumeFileName);
			talent.setOldResumeName(oldResumeName);
		}
		// 上传标准简历
		if (standardResume != null) {
			String standardResumeName = pu.wordUpload(standardResume, standardResumeFileName);
			talent.setStandardResumeName(standardResumeName);
		}

		/*
		 * jobExperienceService.setJobExperiences(talent, startDate, endDate,
		 * job, company, duty, kpi);
		 */
		try {
			talentService.update(talent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "duplicateError";
		}
		return "toList";
	}

	/** 查看详细页面 */
	public String detailUI() throws Exception {
		Talent talent = talentService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(talent);
		return "detailUI";
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public File getOldResume() {
		return oldResume;
	}

	public void setOldResume(File oldResume) {
		this.oldResume = oldResume;
	}

	public String getOldResumeFileName() {
		return oldResumeFileName;
	}

	public void setOldResumeFileName(String oldResumeFileName) {
		this.oldResumeFileName = oldResumeFileName;
	}

	public File getStandardResume() {
		return standardResume;
	}

	public void setStandardResume(File standardResume) {
		this.standardResume = standardResume;
	}

	public String getStandardResumeFileName() {
		return standardResumeFileName;
	}

	public void setStandardResumeFileName(String standardResumeFileName) {
		this.standardResumeFileName = standardResumeFileName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPostLevel() {
		return postLevel;
	}

	public void setPostLevel(String postLevel) {
		this.postLevel = postLevel;
	}

	public List<String> getStartDate() {
		return startDate;
	}

	public void setStartDate(List<String> startDate) {
		this.startDate = startDate;
	}

	public List<String> getEndDate() {
		return endDate;
	}

	public void setEndDate(List<String> endDate) {
		this.endDate = endDate;
	}

	public List<String> getCompany() {
		return company;
	}

	public void setCompany(List<String> company) {
		this.company = company;
	}

	public String getNowJob() {
		return nowJob;
	}

	public void setNowJob(String nowJob) {
		this.nowJob = nowJob;
	}

	public List<String> getJob() {
		return job;
	}

	public void setJob(List<String> job) {
		this.job = job;
	}

	public String getSexType() {
		return sexType;
	}

	public void setSexType(String sexType) {
		this.sexType = sexType;
	}

	public String getLevelType() {
		return levelType;
	}

	public void setLevelType(String levelType) {
		this.levelType = levelType;
	}

	public String getFirstDegreeType() {
		return firstDegreeType;
	}

	public void setFirstDegreeType(String firstDegreeType) {
		this.firstDegreeType = firstDegreeType;
	}

	public String getJobCondition() {
		return jobCondition;
	}

	public void setJobCondition(String jobCondition) {
		this.jobCondition = jobCondition;
	}

	public String getCompanyCondition() {
		return companyCondition;
	}

	public void setCompanyCondition(String companyCondition) {
		this.companyCondition = companyCondition;
	}

	public List<String> getDuty() {
		return duty;
	}

	public void setDuty(List<String> duty) {
		this.duty = duty;
	}

	public List<String> getKpi() {
		return kpi;
	}

	public void setKpi(List<String> kpi) {
		this.kpi = kpi;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getNcompany() {
		return ncompany;
	}

	public void setNcompany(String ncompany) {
		this.ncompany = ncompany;
	}

	public String getNrecommend() {
		return nrecommend;
	}

	public void setNrecommend(String nrecommend) {
		this.nrecommend = nrecommend;
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

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

}
