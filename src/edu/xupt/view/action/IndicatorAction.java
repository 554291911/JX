package edu.xupt.view.action;

import java.io.File;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edu.xupt.base.ModelDrivenBaseAction;
import edu.xupt.entites.Indicator;
import edu.xupt.util.QueryHelper;
import edu.xupt.util.UploadUtils;

@Controller
@Scope("prototype")
public class IndicatorAction extends ModelDrivenBaseAction<Indicator>{

	//获取通讯录文件
	private File indicator;
	private String indicatorFileName;
	
	
	/**  列表*/
	public String list() throws Exception {

		// 准备分页信息
		new QueryHelper(Indicator.class, "i").preparePageBean(indicatorService, pageNum, pageSize);
		
		return "list";
	}

	/** 上传页面*/
	public String uploadUI() throws Exception{
		return "uploadUI";
	}

	/** 上传*/
	public String upload() throws Exception{
		UploadUtils up = new UploadUtils();
		if(indicator != null){
			String indicatorName = up.wordUpload(indicator, indicatorFileName);
			model.setIndicatorName(indicatorName);
		}
		indicatorService.save(model);
		return "toAddressList";
	}
	
	/** 删除*/
	public String delete() throws Exception{
		indicatorService.delete(model.getId());
		return "toAddressList";
	}

	public File getIndicator() {
		return indicator;
	}

	public void setIndicator(File indicator) {
		this.indicator = indicator;
	}

	public String getIndicatorFileName() {
		return indicatorFileName;
	}

	public void setIndicatorFileName(String indicatorFileName) {
		this.indicatorFileName = indicatorFileName;
	}

	
	
}
