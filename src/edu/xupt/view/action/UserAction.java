package edu.xupt.view.action;

import java.util.HashSet;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import edu.xupt.base.ModelDrivenBaseAction;
import edu.xupt.entites.Role;
import edu.xupt.entites.User;

@Controller
@Scope("prototype")
public class UserAction extends ModelDrivenBaseAction<User> {

	private int[] roleIds;

	private String newpassword;

	private String confirmpassword;

	/** 列表 */
	public String list() throws Exception {
		List<User> userList = userService.findAll();
		ActionContext.getContext().put("userList", userList);

		return "list";
	}

	/** 删除 */
	public String delete() throws Exception {
		if (model.getId() != 1)
			userService.delete(model.getId());
		return "toList";
	}

	/** 添加页面 */
	public String saveUI() throws Exception {
		// 准备数据, roleList
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);

		return "saveUI";
	}

	/** 添加 */
	public String save() throws Exception {
		// 封装到对象中（当model是实体类型时，也可以使用model，但要设置未封装的属性）
		if (model.getLoginName().equals("")) {
			addActionError("请输入登录名");
			List<Role> roleList = roleService.findAll();
			;
			ActionContext.getContext().put("roleList", roleList);
			return "saveUI";
		} else if (userService.findByLoginName(model.getLoginName()) == false) {
			addActionError("登录名重复！");
			List<Role> roleList = roleService.findAll();
			;
			ActionContext.getContext().put("roleList", roleList);
			return "saveUI";
		} else if (model.getName().equals("")) {
			addActionError("请输入姓名");
			List<Role> roleList = roleService.findAll();
			ActionContext.getContext().put("roleList", roleList);
			return "saveUI";
		} else {
			// >> 设置关联的岗位
			List<Role> roleList = roleService.getByIds(roleIds);
			model.setRoles(new HashSet<Role>(roleList));
			// >> 设置默认密码为1234（要使用MD5摘要）
			String md5Digest = DigestUtils.md5Hex("1234");
			model.setPassword(md5Digest);

			// 保存到数据库
			userService.save(model);
		}
		return "toList";
	}

	/** 修改页面 */
	public String editUI() throws Exception {

		// 准备数据, roleList
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);

		// 准备回显的数据
		User user = userService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		if (user.getRoles() != null) {
			roleIds = new int[user.getRoles().size()];
			int index = 0;
			for (Role role : user.getRoles()) {
				roleIds[index++] = role.getId();
			}
		}

		return "editUI";
	}

	/** 修改 */
	public String edit() throws Exception {
		// 1，从数据库中取出原对象
		User user = userService.getById(model.getId());

		// 2，设置要修改的属性
		user.setName(model.getName());
		user.setSex(model.getSex());
		user.setPhoneNumber(model.getPhoneNumber());
		user.setEmail(model.getEmail());
		user.setDescription(model.getDescription());

		// >> 设置关联的岗位
		List<Role> roleList = roleService.getByIds(roleIds);
		user.setRoles(new HashSet<Role>(roleList));

		// 3，更新到数据库
		userService.update(user);

		return "toList";
	}

	/** 初始化密码为1234 */
	public String initPassword() throws Exception {
		// 1，从数据库中取出原对象
		User user = userService.getById(model.getId());

		// 2，设置要修改的属性（要使用MD5摘要）
		String md5Digest = DigestUtils.md5Hex("1234");
		user.setPassword(md5Digest);

		// 3，更新到数据库
		userService.update(user);

		return "toList";
	}

	/** 修改密码页面 */
	public String editpasswordUI() throws Exception {
		return "editpasswordUI";
	}

	public String editpassword() throws Exception {
		// 1，从数据库中取出原对象
		User user = userService.getById(model.getId());
		String md5Digest1 = DigestUtils.md5Hex(model.getPassword());
		String md5Digest2 = DigestUtils.md5Hex(newpassword);
		if (user.getPassword().equals(md5Digest1) == false) {
			addActionError("旧密码不一致，请重新输入！");
			return "editpasswordUI";
		} else if (user.getPassword().equals(md5Digest2)) {
			addActionError("新密码不能跟旧密码相同，请重新输入！");
			return "editpasswordUI";
		} else if (newpassword.equals(confirmpassword) == false) {
			addActionError("密码不一致，请重新输入！");
			return "editpasswordUI";
		} else {
			// 修改密码
			user.setPassword(md5Digest2);
		}
		userService.update(user);
		return "toList";
	}

	/** 登录页面 */
	public String loginUI() throws Exception {
		return "loginUI";
	}

	/** 登录 */
	public String login() throws Exception {
		User user = userService.findByLoginNameAndPassword(model.getLoginName(), model.getPassword());
		if (user == null) {
			addFieldError("login", "用户名或密码不正确！");
			return "loginUI";
		} else {
			// 登录用户
			user.setIP(ServletActionContext.getRequest().getRemoteAddr());
			userService.update(user);
			ActionContext.getContext().getSession().put("user", user);
			return "toIndex";
		}
	}

	/** 注销 */
	public String logout() throws Exception {
		ActionContext.getContext().getSession().remove("user");
		return "logout";
	}

	// ---

	public int[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(int[] roleIds) {
		this.roleIds = roleIds;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

}
