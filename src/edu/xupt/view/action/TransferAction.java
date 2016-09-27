package edu.xupt.view.action;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import edu.xupt.base.ModelDrivenBaseAction;
import edu.xupt.entites.Transfer;
import edu.xupt.entites.User;
import edu.xupt.entites.UserForTransfer;
import edu.xupt.util.QueryHelper;
import edu.xupt.util.TimeUtil;

@Controller
@Scope("prototype")
public class TransferAction extends ModelDrivenBaseAction<Transfer> {

	private String promoter = "";// 发起人
	private String recipient = "";// 接收人
	private String time = "";// 发起时间

	
	private String subjectType = "";//查询科目
	private String statusType = ""; //查询状态
	
	User user = getCurrentUser();
	
	/** 我的流转列表 */
	public String mylist() throws Exception {
		// 准备数据
		new QueryHelper(Transfer.class, "t", "users", "u")//
		.addCondition("u.name=?", user.getName())
		.addCondition(!(subjectType.trim().equals("")), "t.subject LIKE ?", "%" + subjectType + "%")
		.addCondition(!(statusType.trim().equals("")), "t.status=?", statusType)
		.preparePageBean(transferService, pageNum, pageSize);
		return "mylist";
	}
	
	/** 我的流转处理列表 */
	public String list() throws Exception {
		// 准备数据
		new QueryHelper(Transfer.class, "t")//
		.addCondition("t.status=?", "未完成")
		.addCondition("t.nowRecipient=?", user.getName())
		.addCondition(!(subjectType.trim().equals("")), "t.subject LIKE ?", "%" + subjectType + "%")
		.preparePageBean(transferService, pageNum, pageSize);
		return "list";
	}

	public String saveUI() throws Exception {
		return "saveUI";
	}

	public String save() throws Exception {
		UserForTransfer userForTransfer = new UserForTransfer(time, promoter, recipient, model);
		User promot = userService.findByName(promoter);
		User recipienter =  userService.findByName(recipient);
		if ( recipienter == null) {
			addActionError("找不到接收人，请输入正确的接收人姓名");
			return "saveUI";
		}

		model.setNowTime(time);
		model.setNowPromoter(promoter);
		model.setNowRecipient(recipient);
		model.setStatus("未完成");
		model.getUserForTransfers().add(userForTransfer);
		model.getUsers().add(promot);
		model.getUsers().add(recipienter);
		transferService.save(model);
		userForTransferService.save(userForTransfer);
		return "toMyList";
	}

	public String delete() throws Exception {
		transferService.delete(model.getId());
		return "toList";
	}

	public String editUI() throws Exception {
		// 准备回显的数据
		Transfer transfer = transferService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(transfer);
		return "editUI";
	}

	public String edit() throws Exception {
		// 1，从数据库中获取原对象
		Transfer transfer = transferService.getById(model.getId());

		// 2，设置要修改的属性

		transfer.setSubject(model.getSubject());
		transfer.setDescription(model.getDescription());
		transfer.setSolutionAndImpl(model.getSolutionAndImpl());
		transfer.setFeedback(model.getFeedback());
		
		
		
		if (recipient.trim().equals("")) {
			transfer.setStatus("已完成");
			transferService.update(transfer);
			return "toList";
		}

		UserForTransfer userForTransfer = new UserForTransfer(time, promoter, recipient, transfer);
		
		User recipienter = userService.findByName(recipient);
		if (recipienter == null) {
			addActionError("找不到接收人，请输入正确的接收人姓名");
			return "editUI";
		}
		
		
		transfer.setNowTime(time);
		transfer.setNowPromoter(promoter);
		transfer.setNowRecipient(recipient);
		transfer.getUsers().add(recipienter);
		transfer.getUserForTransfers().add(userForTransfer);

		// 3，更新到数据库
		transferService.update(transfer);
		userForTransferService.save(userForTransfer);
		return "toMyList";
	}

	/** 查看详细页面 */
	public String detailUI() throws Exception {
		// 准备回显的数据
		Transfer transfer = transferService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(transfer);
		return "detailUI";
	}
	
	/** 完成 */
	public String succeed() throws Exception {
		// 1，从数据库中获取原对象
		Transfer transfer = transferService.getById(model.getId());
			
		transfer.setStatus("已完成");
		
		transferService.update(transfer);
		return "toList";
	}

	
	public String getPromoter() {
		return promoter;
	}

	public void setPromoter(String promoter) {
		this.promoter = promoter;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}

	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	
}
