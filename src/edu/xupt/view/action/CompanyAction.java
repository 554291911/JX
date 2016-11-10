package edu.xupt.view.action;

import java.io.File;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import edu.xupt.base.ModelDrivenBaseAction;
import edu.xupt.entites.Company;
import edu.xupt.entites.Junction;
import edu.xupt.util.QueryHelper;
import edu.xupt.util.UploadUtils;

@Controller
@Scope("prototype")
public class CompanyAction extends ModelDrivenBaseAction<Company> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String comName = "";

	private File contract;// 附件
	private String contractFileName;// 附件名

	private File comintro;// 公司简介附件
	private String comintroFileName;
	private File prointro;// 项目简介附件
	private String prointroFileName;

	private List<String> name;
	private List<String> position;
	private List<String> phoneNumber;
	private List<String> email;
	private List<String> birthday;

	public String list() throws Exception {
		// 准备分页信息
		new QueryHelper(Company.class, "c").addCondition(
				(!comName.trim().equals("")), "c.companyName LIKE ?",
				"%" + comName + "%").preparePageBean(companyService, pageNum,
				pageSize);

		return "list";
	}

	public String saveUI() throws Exception {
		return "saveUI";
	}

	public String save() throws Exception {

		UploadUtils up = new UploadUtils();
		// 上传合同附件
		if (contract != null) {
			String contractPath = up.wordUpload(contract, contractFileName);
			model.setContractName(contractPath);
		}

		if (comintro != null) {
			String comintroPath = up.wordUpload(comintro, comintroFileName);
			model.setComIntroductionName(comintroPath);
		}

		if (prointro != null) {
			String prointroPath = up.wordUpload(prointro, prointroFileName);
			model.setProIntroductionName(prointroPath);
		}

		companyService.save(model);
		if (name != null) {
			for (int i = 0; i < name.size(); i++) {
					Junction jn = new Junction();
					jn.setName(name.get(i));
					jn.setPosition(position.get(i));
					jn.setPhoneNumber(phoneNumber.get(i));
					jn.setEmail(email.get(i));
					jn.setBirthday(birthday.get(i));
					jn.setCompany(model);
					junctionService.save(jn);
				}
		}
		return "toList";
	}

	public String delete() throws Exception {
		companyService.delete(model.getId());
		return "toList";
	}

	public String editUI() throws Exception {
		// 准备回显的数据
		Company company = companyService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(company);
		return "editUI";
	}

	public String edit() throws Exception {
		// 1，从数据库中获取原对象
		Company company = companyService.getById(model.getId());

		// 2，设置要修改的属性
		company.setCompanyName(model.getCompanyName());
		company.setPayConstruction(model.getPayConstruction());
		company.setPreference(model.getPreference());
		company.setAddress(model.getAddress());
		company.setComIntroduction(model.getComIntroduction());
		company.setProIntroduction(model.getProIntroduction());
		UploadUtils pu = new UploadUtils();
		if (contract != null) {
			String contractName = pu.wordUpload(contract, contractFileName);
			company.setContractName(contractName);
		}
		if (comintro != null) {
			String comintroPath = pu.wordUpload(comintro, comintroFileName);
			company.setComIntroductionName(comintroPath);
		}

		if (prointro != null) {
			String prointroPath = pu.wordUpload(prointro, prointroFileName);
			company.setProIntroductionName(prointroPath);
		}

		junctionService.setJunctions(company, name, position, phoneNumber, email, birthday);
	
		// 3，更新到数据库
		companyService.update(company);
		return "toList";
}

	/** 查看详细页面 */
	public String detailUI() throws Exception {
		Company company = companyService.getById(model.getId());
		ActionContext.getContext().put("company", company);
		return "detailUI";
	}

	public File getContract() {
		return contract;
	}

	public void setContract(File contract) {
		this.contract = contract;
	}

	public String getContractFileName() {
		return contractFileName;
	}

	public void setContractFileName(String contractFileName) {
		this.contractFileName = contractFileName;
	}

	public List<String> getName() {
		return name;
	}

	public void setName(List<String> name) {
		this.name = name;
	}

	public List<String> getPosition() {
		return position;
	}

	public void setPosition(List<String> position) {
		this.position = position;
	}

	public List<String> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(List<String> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<String> getEmail() {
		return email;
	}

	public void setEmail(List<String> email) {
		this.email = email;
	}

	public List<String> getBirthday() {
		return birthday;
	}

	public void setBirthday(List<String> birthday) {
		this.birthday = birthday;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public File getComintro() {
		return comintro;
	}

	public void setComintro(File comintro) {
		this.comintro = comintro;
	}

	public String getComintroFileName() {
		return comintroFileName;
	}

	public void setComintroFileName(String comintroFileName) {
		this.comintroFileName = comintroFileName;
	}

	public File getProintro() {
		return prointro;
	}

	public void setProintro(File prointro) {
		this.prointro = prointro;
	}

	public String getProintroFileName() {
		return prointroFileName;
	}

	public void setProintroFileName(String prointroFileName) {
		this.prointroFileName = prointroFileName;
	}

}
