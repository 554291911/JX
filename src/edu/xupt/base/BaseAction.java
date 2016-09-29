package edu.xupt.base;


import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.xupt.entites.User;
import edu.xupt.service.AddressService;
import edu.xupt.service.CandidateService;
import edu.xupt.service.CompanyService;
import edu.xupt.service.IndicatorService;
import edu.xupt.service.JobExperienceService;
import edu.xupt.service.JobProgressService;
import edu.xupt.service.JobService;
import edu.xupt.service.JunctionService;
import edu.xupt.service.PaymentService;
import edu.xupt.service.PotentialService;
import edu.xupt.service.PrivilegeService;
import edu.xupt.service.QuarterService;
import edu.xupt.service.RoleService;
import edu.xupt.service.TalentService;
import edu.xupt.service.TransferService;
import edu.xupt.service.UserForTransferService;
import edu.xupt.service.UserService;
import edu.xupt.service.WeekService;

public abstract class BaseAction extends ActionSupport {

	//============  分页用的参数  ==================

	protected int pageNum = 1; // 当前页
	protected int pageSize = 15; // 每页显示多少条记录

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

// =============== Service实例的声明 ==================

@Resource
protected TalentService talentService;//人才service管理

@Resource
protected JobExperienceService jobExperienceService;//职位经历service管理

@Resource
protected AddressService addressService; //通讯录service管理

@Resource
protected UserService userService;

@Resource
protected PrivilegeService privilegeService;

@Resource
protected RoleService roleService;

@Resource
protected CompanyService companyService;

@Resource
protected JunctionService junctionService;

@Resource
protected JobService jobService;

@Resource
protected JobProgressService jobProgressSerivce;

@Resource
protected WeekService weekService;

@Resource
protected QuarterService quarterService;

@Resource
protected PotentialService potentialService;

@Resource
protected TransferService transferService;

@Resource
protected IndicatorService indicatorService;

@Resource
protected PaymentService paymentService;

@Resource
protected UserForTransferService userForTransferService;

@Resource
protected CandidateService candidateService;
/**
* 获取当前登录的用户
* 
* @return
*/
protected User getCurrentUser() {
return (User) ActionContext.getContext().getSession().get("user");
}

}
