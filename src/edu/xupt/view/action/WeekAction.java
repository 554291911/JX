package edu.xupt.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import edu.xupt.base.ModelDrivenBaseAction;
import edu.xupt.entites.Candidate;
import edu.xupt.entites.User;
import edu.xupt.entites.Week;
import edu.xupt.util.QueryHelper;
import edu.xupt.util.TimeUtil;

@Controller
@Scope("prototype")
public class WeekAction extends ModelDrivenBaseAction<Week> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String yearType = "";
	private String monthType = "";
	private String statusType = "";
	private String nameType = "";
	private List<String> cname;
	private List<String> phone;
	private List<String> customer;
	private List<String> bu;
	private List<String> job;
	private List<String> date;
	private List<String> cstatus;

	User user = (User) ActionContext.getContext().getSession().get("user");

	/** 发送给管理员 */
	public String send() throws Exception {
		// 准备数据
		Week week = weekService.getById(model.getId());
		TimeUtil nowdate = new TimeUtil();

		// 更新
		week.setStatus("未审批");
		week.setTime(nowdate.getNowDate());
		week.setSendstatus("已发送");
		weekService.update(week);
		return "toMylist";
	}

	/** 待我审批列表 */
	public String approvallist() throws Exception {
		// 准备数据
		if (!(statusType.trim().equals(""))) {
			new QueryHelper(Week.class, "w")
					//
					.addCondition(!(yearType.trim().equals("")), "w.year=?", yearType)
					.addCondition(!(monthType.trim().equals("")), "w.month=?", monthType)
					.addCondition("w.status=?", statusType)
					.addCondition(!(nameType.trim().equals("")), "w.name LIKE ?", "%" + nameType + "%")
					.preparePageBean(weekService, pageNum, pageSize);
		} else {
			new QueryHelper(Week.class, "w")//
					.addCondition("w.status=?", "未审批").preparePageBean(weekService, pageNum, pageSize);
		}
		return "approvallist";
	}

	/** 我的申请查询列表 */
	public String mylist() throws Exception {
		// 准备数据
		new QueryHelper(Week.class, "w")
				//
				.addCondition("user_id=?", user.getId())
				.addCondition(!(yearType.trim().equals("")), "w.year=?", yearType)
				.addCondition(!(monthType.trim().equals("")), "w.month=?", monthType)
				.addCondition(!(statusType.trim().equals("")), "w.status=?", statusType)
				.addCondition(!(nameType.trim().equals("")), "w.name LIKE ?", "%" + nameType + "%")
				.preparePageBean(weekService, pageNum, pageSize);

		return "mylist";
	}

	/** 添加页面 */
	public String saveUI() throws Exception {
		// 准备上周回显的数据
		Week week = weekService.getByLastWeek();
		if(week != null){
			ActionContext.getContext().getValueStack().push(week);
		}
		return "saveUI";
	}

	/** 添加 */
	public String save() throws Exception {
		model.setUser(user);
		model.setStatus("未开始");
		model.setSendstatus("未发送");
		weekService.save(model);
		if (cname != null) {
			for (int i = 0; i < cname.size(); i++) {
				Candidate c = new Candidate();
				c.setCname(cname.get(i).trim().equals("") ? "" : cname.get(i));
				c.setPhone(phone.get(i).trim().equals("") ? "" : phone.get(i));
				c.setCustomer(customer.get(i).trim().equals("") ? "" : customer.get(i));
				c.setBu(bu.get(i).trim().equals("") ? "" : bu.get(i));
				c.setJob(job.get(i).trim().equals("") ? "" : job.get(i));
				c.setDate(date.get(i).trim().equals("") ? "" : date.get(i));
				c.setCstatus(cstatus.get(i).trim().equals("") ? "" : cstatus.get(i));
				c.setWeeks(model);
				candidateService.save(c);
			}
		}
		return "toMylist";
	}

	/** 删除 */
	public String delete() throws Exception {

		weekService.delete(model.getId());
		return "toMylist";
	}

	/** 编辑页面 */
	public String editUI() throws Exception {
		// 准备回显的数据
		Week week = weekService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(week);
		return "editUI";
	}

	/** 编辑 */
	public String edit() throws Exception {

		// 1，从数据库中获取原对象
		Week week = weekService.getById(model.getId());

		week.setEvaluation(model.getEvaluation());
		week.setName(model.getName());
		week.setNextManager(model.getNextManager());
		week.setNextName(model.getNextName());
		week.setNextQuestion(model.getNextQuestion());
		week.setNextWeek(model.getNextWeek());
		week.setPhoneNum(model.getPhoneNum());
		week.setStatus("未审批");
		candidateService.setCandidates(week, cname, phone, customer, bu, job, date, cstatus);

		// 3，更新到数据库
		weekService.update(week);
		return "toMylist";
	}

	/** 详细页面 */
	public String detailUI() throws Exception {
		// 准备回显的数据
		Week week = weekService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(week);

		return "detailUI";
	}

	/** 撤销 */
	public String revoke() throws Exception {
		Week week = weekService.getById(model.getId());

		week.setStatus("未开始");
		week.setTime("");
		week.setSendstatus("未发送");
		weekService.update(week);

		return "toMylist";
	}

	/** 查阅审批页面 */
	public String examineUI() throws Exception {
		// 准备数据
		Week week = weekService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(week);
		return "examineUI";
	}

	/** 查阅审批 */
	public String examine() throws Exception {
		// 准备数据
		Week week = weekService.getById(model.getId());
		// 2，设置要修改的属性
		// week.setEmployeeName(model.getEmployeeName());
		// week.setEndDate(model.getEndDate());
		// week.setPlan(model.getPlan());
		// week.setReason(model.getReason());
		// week.setRemarks(model.getRemarks());
		// week.setSituationDescription(model.getSituationDescription());
		// week.setOutput(model.getOutput());
		// week.setRemarks(model.getRemarks());
		week.setApproval(model.getApproval());
		week.setStatus("已审批");
		week.setSendstatus("未发送");

		weekService.update(week);
		return "toApprovallist";
	}

	/** 审批结束 */
	public String end() throws Exception {
		Week week = weekService.getById(model.getId());

		week.setStatus("已结束");

		weekService.update(week);
		return "toApprovallist";
	}

	public String getYearType() {
		return yearType;
	}

	public void setYearType(String yearType) {
		this.yearType = yearType;
	}

	public String getMonthType() {
		return monthType;
	}

	public void setMonthType(String monthType) {
		this.monthType = monthType;
	}

	public String getNameType() {
		return nameType;
	}

	public void setNameType(String nameType) {
		this.nameType = nameType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	public List<String> getCname() {
		return cname;
	}

	public void setCname(List<String> cname) {
		this.cname = cname;
	}

	public List<String> getPhone() {
		return phone;
	}

	public void setPhone(List<String> phone) {
		this.phone = phone;
	}

	public List<String> getCustomer() {
		return customer;
	}

	public void setCustomer(List<String> customer) {
		this.customer = customer;
	}

	public List<String> getBu() {
		return bu;
	}

	public void setBu(List<String> bu) {
		this.bu = bu;
	}

	public List<String> getJob() {
		return job;
	}

	public void setJob(List<String> job) {
		this.job = job;
	}

	public List<String> getDate() {
		return date;
	}

	public void setDate(List<String> date) {
		this.date = date;
	}

	public List<String> getCstatus() {
		return cstatus;
	}

	public void setCstatus(List<String> cstatus) {
		this.cstatus = cstatus;
	}
}
