package edu.xupt.view.action;

import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import edu.xupt.base.ModelDrivenBaseAction;
import edu.xupt.entites.Company;
import edu.xupt.entites.Payment;
import edu.xupt.util.QueryHelper;

@Controller
@Scope("prototype")
public class PaymentAction extends ModelDrivenBaseAction<Payment> implements ServletResponseAware {

	// 状态
	private String statusType = "";

	// 年度
	private String yearType = "";

	private int companyId = 0;

	private String companyName;

	private HttpServletResponse res;

	/** 列表 */
	public String list() throws Exception {

		// 准备数据 companylist
		List<Company> companylist = companyService.findAll();
		ActionContext.getContext().put("companylist", companylist);

		// 准备分页信息
		if (companyId != 0) {
			new QueryHelper(Payment.class, "p")
					//
					.addCondition((!statusType.equals("")), "p.status=?",
							statusType)
					.addCondition((!yearType.equals("")), "p.year=?", yearType)
					.addCondition(
							(companyId == companyService.getById(companyId)
									.getId()), "p.clientName=?",
							companyService.getById(companyId).getCompanyName())
					.preparePageBean(paymentService, pageNum, pageSize);
		} else {
			new QueryHelper(Payment.class, "p")
					//
					.addCondition((!statusType.equals("")), "p.status=?",
							statusType)
					.addCondition((!yearType.equals("")), "p.year=?", yearType)
					.preparePageBean(paymentService, pageNum, pageSize);
		}

		return "list";
	}

	public String saveUI() throws Exception {
		// 准备数据 companylist
		List<Company> companylist = companyService.findAll();
		ActionContext.getContext().put("companylist", companylist);
		return "saveUI";
	}

	public void getAccountWay() throws Exception {
		//查询
		String payment = paymentService.findpaymentMethodById(companyName);
		//打成JSON
		//
		Writer writer = res.getWriter();
		writer.append(payment);
		writer.flush();
	}

	public String save() throws Exception {

	
		
		Company company = companyService.getById(companyId);

		// 设置客户公司
		if (companyId != 0) {
			model.setCompany(companyService.getById(companyId));
			model.setClientName(companyService.getById(companyId)
					.getCompanyName());
		}

		company.setPayment(model.getPaymentMethod());
		companyService.update(company);
		paymentService.save(model);
		return "toList";
	}

	public String delete() throws Exception {
		paymentService.delete(model.getId());
		return "toList";
	}

	public String editUI() throws Exception {

		// 准备数据 companylist
		List<Company> companylist = companyService.findAll();
		ActionContext.getContext().put("companylist", companylist);

		// 准备回显的数据
		Payment payment = paymentService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(payment);
		if (payment.getCompany() != null) {
			companyId = payment.getCompany().getId();
		}

		return "editUI";
	}

	public String edit() throws Exception {

		// 1，从数据库中获取原对象
		Payment payment = paymentService.getById(model.getId());

		// 2，设置要修改的属性
		payment.setPaymentMethod(model.getPaymentMethod());
		payment.setCandidate(model.getCandidate());
		payment.setArrivalTime(model.getArrivalTime());
		payment.setPositiveTime(model.getPositiveTime());
		payment.setHeadHuntingExpenses(model.getHeadHuntingExpenses());
		payment.setFirstAmount(model.getFirstAmount());
		payment.setFirstBillingTime(model.getFirstBillingTime());
		payment.setFirstArrivalTime(model.getFirstArrivalTime());
		payment.setRetainage(model.getRetainage());
		payment.setRetainageArrivalTime(model.getRetainageArrivalTime());
		payment.setRetainageBillingTime(model.getRetainageBillingTime());
		payment.setAccount(model.getAccount());
		payment.setRemarks(model.getRemarks());
		payment.setStatus(model.getStatus());
		payment.setYear(model.getYear());
		// 设置客户公司
		payment.setCompany(companyService.getById(companyId));
		payment.setClientName(companyService.getById(companyId)
				.getCompanyName());
		// 3，更新到数据库
		paymentService.update(payment);
		return "toList";
	}

	/** 查看详细页面 */
	public String detailUI() throws Exception {
		Payment payment = paymentService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(payment);
		return "detailUI";
	}

	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	public String getYearType() {
		return yearType;
	}

	public void setYearType(String yearType) {
		this.yearType = yearType;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public HttpServletResponse getRes() {
		return res;
	}

	public void setRes(HttpServletResponse res) {
		this.res = res;
	}

	@Override
	public void setServletResponse(HttpServletResponse res) {
		this.res = res;
	}
}
