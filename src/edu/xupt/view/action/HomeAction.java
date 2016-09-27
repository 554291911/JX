package edu.xupt.view.action;

import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edu.xupt.base.BaseAction;
import edu.xupt.entites.User;

@Controller
@Scope("prototype")
public class HomeAction extends BaseAction implements ServletResponseAware{

	private HttpServletResponse res;
	
	User user = getCurrentUser();
	public String index() throws Exception {
		return "index";
	}

	public String top() throws Exception {
		return "top";
	}

	public String bottom() throws Exception {
		return "bottom";
	}

	public String left() throws Exception {
		return "left";
	}

	public String right() throws Exception {
		return "right";
	}
	public void getTaskCount() throws Exception {
		String count = transferService.getCountByUserName(user.getName());
		Writer writer = res.getWriter();
		writer.append(count);
		writer.flush();
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
