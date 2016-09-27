package edu.xupt.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import edu.xupt.base.ModelDrivenBaseAction;
import edu.xupt.entites.Potential;
import edu.xupt.util.QueryHelper;

@Controller
@Scope("prototype")
public class PotentialAction extends ModelDrivenBaseAction<Potential>{

	/**  列表*/
	public String list() throws Exception {
		
		// 准备分页信息
		new QueryHelper(Potential.class, "p").preparePageBean(potentialService, pageNum, pageSize);
		
		return "list";
	}

	public String saveUI() throws Exception {
		return "saveUI";
	}

	public String save() throws Exception {

		potentialService.save(model);
		return "toList";
	}

	public String delete() throws Exception {
		potentialService.delete(model.getId());
		return "toList";
	}
	
	public String editUI() throws Exception{
		// 准备回显的数据
		Potential company = potentialService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(company);
		return "editUI";
	}
	
	public String edit() throws Exception{
		// 1，从数据库中获取原对象
		Potential company = potentialService.getById(model.getId());
		// 2，设置要修改的属性
		company.setHeadHunting(model.getHeadHunting());
		company.setStartTime(model.getStartTime());
		company.setName(model.getName());
		company.setIntroduction(model.getIntroduction());
		company.setRecruitment(model.getRecruitment());
		company.setFirstContactTime(model.getFirstContactTime());
		company.setContactPerson(model.getContactPerson());
		company.setContactInformation(model.getContactInformation());
		company.setInitialContactInformation(model.getInitialContactInformation());
		company.setProblem(model.getProblem());
		company.setAgainContactTime(model.getAgainContactTime());
		company.setAgainContactInformation(model.getAgainContactInformation());
		
		
		// 3，更新到数据库
		potentialService.update(company);
		return "toList";
	}

	/** 查看详细页面*/
	public String detailUI() throws Exception{
		// 准备回显的数据
		Potential company = potentialService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(company);
		return "detailUI";
	}
}
