package edu.xupt.view.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class FileDownloadAction extends ActionSupport {

	private String fileName;

	public InputStream getDownloadFile() throws Exception{

		
			String name = this.getFileName();
			String realPath = "/word/" + name;
			InputStream in = ServletActionContext.getServletContext()
					.getResourceAsStream(realPath);
			if (null == in) { 
				System.out.println("检查action中文件下载路径是否正确.");
			}
			
			return ServletActionContext.getServletContext()
					.getResourceAsStream(realPath);
			
	}

	public String execute() throws Exception{
			if(fileName.equals("")){
				return "error";
			}
		
		return "success";
	}

	public String getFileName() throws UnsupportedEncodingException {
		return fileName;
	}

	public void setFileName(String fileName){
			this.fileName = fileName;
			}

}
