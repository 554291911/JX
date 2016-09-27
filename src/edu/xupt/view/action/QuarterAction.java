package edu.xupt.view.action;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import edu.xupt.base.ModelDrivenBaseAction;
import edu.xupt.entites.Quarter;
import edu.xupt.entites.User;
import edu.xupt.util.QueryHelper;
import edu.xupt.util.TimeUtil;

/**
 * 月工作计划
 * 
 * @author dell-pc
 * 
 */

@Controller
@Scope("prototype")
public class QuarterAction extends ModelDrivenBaseAction<Quarter> {

	private String yearType = "";
	private String monthType = "";
	private String statusType = "";
	private String nameType = "";

	User user = (User) ActionContext.getContext().getSession().get("user");

	/** 我的申请列表 */
	public String mylist() throws Exception {
		// 准备数据
		new QueryHelper(Quarter.class, "q")//
				.addCondition("user_id=?", user.getId())
				.addCondition(!(yearType.trim().equals("")), "q.year=?",
						yearType)
				.addCondition(!(monthType.trim().equals("")), "q.month=?",
						monthType)
				.addCondition(!(statusType.trim().equals("")), "q.status=?",
						statusType)
				.addCondition(!(nameType.trim().equals("")),
						"q.accepter LIKE ?", "%" + nameType + "%")
				.preparePageBean(quarterService, pageNum, pageSize);

		return "mylist";
	}

	public String saveUI() throws Exception {
		return "saveUI";
	}

	public String save() throws Exception {
		model.setUser(user);
		model.setStatus("未开始");
		model.setSendstatus("未发送");
		quarterService.save(model);
		return "toMylist";
	}

	public String delete() throws Exception {
		quarterService.delete(model.getId());
		return "toMylist";
	}

	public String editUI() throws Exception {
		// 准备回显的数据
		Quarter quarter = quarterService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(quarter);
		return "editUI";
	}

	public String edit() throws Exception {
		// 1，从数据库中获取原对象
		Quarter quarter = quarterService.getById(model.getId());
		// 2，设置要修改的属性
		quarter.setAccepter(model.getAccepter());
		quarter.setAcceptDate(model.getAcceptDate());
		quarter.setEndDate(model.getEndDate());
		quarter.setKeyWork(model.getKeyWork());
		quarter.setResult(model.getResult());
		quarter.setTarget(model.getTarget());
		quarter.setAnalysis(model.getAnalysis());

		// 3，更新到数据库
		quarterService.update(quarter);
		return "toMylist";
	}

	/** 查看详细页面 */
	public String detailUI() throws Exception {

		// 准备回显的数据
		Quarter quarter = quarterService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(quarter);
		return "detailUI";
	}

	/** 发送给管理员 */
	public String send() throws Exception {

		// 准备数据
		Quarter quarter = quarterService.getById(model.getId());
		TimeUtil nowdate = new TimeUtil();

		// 更新
		quarter.setStatus("未审批");
		quarter.setTime(nowdate.getNowDate());
		quarter.setSendstatus("已发送");
		quarterService.update(quarter);
		return "toMylist";
	}

	/** 待我审批列表 */
	public String approvallist() throws Exception {
		// 准备数据
		if (!(statusType.trim().equals(""))) {
			new QueryHelper(Quarter.class, "q")
					//
					.addCondition(!(yearType.trim().equals("")), "q.year=?",
							yearType)
					.addCondition(!(monthType.trim().equals("")), "q.month=?",
							monthType)
					.addCondition("q.status=?", statusType)
					.addCondition(!(nameType.trim().equals("")),
							"q.accepter LIKE ?", "%" + nameType + "%")
					.preparePageBean(quarterService, pageNum, pageSize);
		} else {
			new QueryHelper(Quarter.class, "q")//
					.addCondition("q.status=?", "未审批").preparePageBean(
							quarterService, pageNum, pageSize);
		}
		return "approvallist";
	}

	/** 审批处理页面 */
	public String examineUI() throws Exception {
		// 准备回显的数据
		Quarter quarter = quarterService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(quarter);
		return "examineUI";
	}

	/** 审批处理 */
	public String examine() throws Exception {
		// 1，从数据库中获取原对象
		Quarter quarter = quarterService.getById(model.getId());
		// 2，设置要修改的属性
		quarter.setAccepter(model.getAccepter());
		quarter.setAcceptDate(model.getAcceptDate());
		quarter.setEndDate(model.getEndDate());
		quarter.setKeyWork(model.getKeyWork());
		quarter.setResult(model.getResult());
		quarter.setTarget(model.getTarget());
		quarter.setAnalysis(model.getAnalysis());
		quarter.setRemarks(model.getRemarks());
		quarter.setStatus("已审批");
		quarter.setSendstatus("未发送");

		quarterService.update(quarter);
		return "toApprovallist";
	}

	/** 审批结束 */
	public String end() throws Exception {
		Quarter quarter = quarterService.getById(model.getId());

		quarter.setStatus("已结束");

		quarterService.update(quarter);
		return "toApprovallist";
	}
	/** 撤销*/
	public String revoke() throws Exception{
		Quarter quarter = quarterService.getById(model.getId());
		
		quarter.setStatus("未开始");
		quarter.setTime("");
		quarter.setSendstatus("未发送");
		quarterService.update(quarter);
		
		return "toMylist";
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

	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	public String getNameType() {
		return nameType;
	}

	public void setNameType(String nameType) {
		this.nameType = nameType;
	}
	
	
}
