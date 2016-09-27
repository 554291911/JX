package edu.xupt.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.xupt.entites.User;
import edu.xupt.service.AddressService;
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
;

/**
 * 建立公共的Action
 * @author 郭磊，周豪
 *
 * @param <T>
 */


public abstract class ModelDrivenBaseAction<T> extends BaseAction implements ModelDriven<T>{


	protected T model;

	public ModelDrivenBaseAction() {
		try {
			// 得到model的类型信息
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class clazz = (Class) pt.getActualTypeArguments()[0];

			// 通过反射生成model的实例
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public T getModel() {
		return model;
	}
		
}
