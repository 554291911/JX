package edu.xupt.view.action;

import java.io.File;
import java.sql.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import edu.xupt.base.BaseAction;
import edu.xupt.base.ModelDrivenBaseAction;
import edu.xupt.entites.Address;
import edu.xupt.entites.Talent;
import edu.xupt.entites.User;
import edu.xupt.util.QueryHelper;
import edu.xupt.util.UploadUtils;

/**
 * ================人才系统管理=================
 * 通讯录
 * @author 郭磊，周豪
 *
 */

@Controller
@Scope("prototype")
public class AddressAction extends ModelDrivenBaseAction<Address>{
	
	private String addressword = "";
	private String nameword = "";
	
	//获取通讯录文件
	private File address;
	private String addressFileName;

	// 获取登录信息
	User user = (User) ActionContext.getContext().getSession().get("user");
	
	/** 通讯录列表 */
	public String list() throws Exception{
		
		// 准备分页信息
		new QueryHelper(Address.class, "a")
		.addCondition((!addressword.trim().equals("")),
				"a.addressName LIKE ?", "%" + addressword + "%")
		.addCondition((!nameword.trim().equals("")),
				"a.name LIKE ?", "%" + nameword + "%")
		.preparePageBean(addressService, pageNum, pageSize);
		
		return "list";
	}
	
	/** 上传通讯录页面*/
	public String uploadUI() throws Exception{
		return "uploadUI";
	}
	
	/** 上传通讯录*/
	public String upload() throws Exception{
		UploadUtils up = new UploadUtils();
		if(address != null){
			String addressName = up.wordUpload(address, addressFileName);
			model.setAddressName(addressName);
			model.setTime(up.getNowDate());
			model.setName(user.getName());
		}
		addressService.save(model);
		return "toAddressList";
	}
	
	
	
	/** 删除通讯录*/
	public String delete() throws Exception{
		addressService.delete(model.getId());
		return "toAddressList";
	}

	public File getAddress() {
		return address;
	}

	public void setAddress(File address) {
		this.address = address;
	}

	public String getAddressFileName() {
		return addressFileName;
	}

	public void setAddressFileName(String addressFileName) {
		this.addressFileName = addressFileName;
	}

	public String getAddressword() {
		return addressword;
	}

	public void setAddressword(String addressword) {
		this.addressword = addressword;
	}

	public String getNameword() {
		return nameword;
	}

	public void setNameword(String nameword) {
		this.nameword = nameword;
	}

}
