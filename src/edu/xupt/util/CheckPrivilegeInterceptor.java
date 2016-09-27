package edu.xupt.util;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import edu.xupt.entites.User;
import edu.xupt.service.UserService;

public class CheckPrivilegeInterceptor extends AbstractInterceptor {

	@Resource
	private UserService userService;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String intercept(ActionInvocation invocation) throws Exception {
		// System.out.println("---------> 之前");
		// String result = invocation.invoke(); // 放行
		// System.out.println("---------> 之后");
		// return result;
		// 获取信息
		User user = (User) ActionContext.getContext().getSession().get("user"); // 当前登录用户
		String namespace = invocation.getProxy().getNamespace();
		String actionName = invocation.getProxy().getActionName();
		String privUrl = namespace + actionName; // 对应的权限URL
		String IP = ServletActionContext.getRequest().getRemoteAddr();
		// 如果未登录
		if (user == null) {
			if (privUrl.startsWith("/user_login")) { // "/user_loginUI",
														// "/user_login"
				// 如果是去登录，就放行
				return invocation.invoke();
			} else {
				// 如果不是去登录，就转到登录页面
				return "loginUI";
			}
		}
		// 如果已登 录，就判断权限
		else {
			User userInDb = userService.getById(user.getId());
			if (!userInDb.getIP().equals(user.getIP())) {
				ActionContext.getContext().getSession().remove("user");
				return "noPrivilegeError2";
			}
			if (privUrl.startsWith("/user_login")) {
				ActionContext.getContext().getSession().remove("user");
				return invocation.invoke();
			}
			if (user.hasPrivilegeByUrl(privUrl)) {
				// 如果有权限，就放行
				return invocation.invoke();
			} else {
				// 如果没有权限，就转到提示页面
				return "noPrivilegeError";
			}
		}
	}

}
