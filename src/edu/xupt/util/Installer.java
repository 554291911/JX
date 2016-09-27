package edu.xupt.util;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.xupt.entites.Privilege;
import edu.xupt.entites.User;


@Component
public class Installer {

	@Resource
	private SessionFactory sessionFactory;

	/**
	 * 执行安装
	 */
	@Transactional
	public void install() {
		Session session = sessionFactory.getCurrentSession();

		// ==============================================================
		// 保存超级管理员用户
		User user = new User();
		user.setLoginName("admin");
		user.setName("超级管理员");
		user.setPassword(DigestUtils.md5Hex("admin"));
		session.save(user); // 保存

		// ==============================================================
		// 保存权限数据
		
		
		
		//系统管理权限
		Privilege menu1, menu11, menu12;
		menu1 = new Privilege("系统管理", null, null);
		menu11 = new Privilege("岗位管理", "/role_list", menu1);
		menu12 = new Privilege("用户管理", "/user_list", menu1);
		session.save(menu1);
		session.save(menu11);
		session.save(menu12);

		session.save(new Privilege("岗位列表", "/role_list", menu11));
		session.save(new Privilege("岗位删除", "/role_delete", menu11));
		session.save(new Privilege("岗位添加", "/role_save", menu11));
		session.save(new Privilege("岗位修改", "/role_edit", menu11));
		session.save(new Privilege("岗位设置权限", "/role_setPrivilege", menu11));

		session.save(new Privilege("用户列表", "/user_list", menu12));
		session.save(new Privilege("用户删除", "/user_delete", menu12));
		session.save(new Privilege("用户添加", "/user_save", menu12));
		session.save(new Privilege("用户修改", "/user_edit", menu12));
		session.save(new Privilege("用户个人设置", "/user_editpassword", menu12));
		session.save(new Privilege("初始化密码", "/user_initPassword", menu12));

		// 人才管理权限
		Privilege menu2, menu21, menu22;
		menu2 = new Privilege("人才系统管理", null, null);
		menu21 = new Privilege("人才信息管理", "/talent_list", menu2);
		menu22 = new Privilege("通讯录", "/address_list", menu2);
		session.save(menu2);
		session.save(menu21);
		session.save(menu22);
		
		session.save(new Privilege("人才信息列表", "/talent_list", menu21));
		session.save(new Privilege("人才信息删除", "/talent_delete", menu21));
		session.save(new Privilege("人才信息添加", "/talent_save", menu21));
		session.save(new Privilege("人才信息修改", "/talent_edit", menu21));
		session.save(new Privilege("人才信息查看", "/talent_detail", menu21));
		
		session.save(new Privilege("通讯录列表", "/address_list", menu22));
		session.save(new Privilege("删除通讯录", "/address_delete", menu22));
		session.save(new Privilege("上传通讯录", "/address_upload", menu22));
		session.save(new Privilege("下载通讯录", "/download", menu22));
		
		
		//客户公司资料管理
		Privilege menu3, menu31;
		menu3 = new Privilege("客户公司资料管理", null, null);
		menu31 = new Privilege("客户公司资料", "/company_list", menu3);
		session.save(menu3);
		session.save(menu31);
		
		session.save(new Privilege("客户公司资料列表", "/company_list", menu31));
		session.save(new Privilege("客户公司资料删除", "/company_delete", menu31));
		session.save(new Privilege("客户公司资料添加", "/company_save", menu31));
		session.save(new Privilege("客户公司资料修改", "/company_edit", menu31));
		session.save(new Privilege("客户公司资料查看", "/company_detail", menu31));
		
		//查看职位管理
		Privilege menu4, menu41;
		menu4 = new Privilege("职位管理", null, null);
		menu41 = new Privilege("查看职位", "/job_list", menu4);
		session.save(menu4);
		session.save(menu41);
		
		session.save(new Privilege("职位列表", "/job_list", menu41));
		session.save(new Privilege("删除岗位", "/job_delete", menu41));
		session.save(new Privilege("添加职位", "/job_save", menu41));
		session.save(new Privilege("编辑职位信息", "/job_edit", menu41));
		session.save(new Privilege("查看职位信息", "/job_detail", menu41));
		session.save(new Privilege("查看职位进度", "/job_schedule", menu41));
		
		//周工作计划表管理
		Privilege menu5, menu51, menu52;
		menu5 = new Privilege("周工作计划表管理", null, null);
		menu51 = new Privilege("待我审批列表", "/week_approvallist", menu5);
		menu52 = new Privilege("我的申请列表", "/week_mylist", menu5);
		session.save(menu5);
		session.save(menu51);
		session.save(menu52);
		
		
		//季度重点工作管理
		Privilege menu6, menu61, menu62;
		menu6 = new Privilege("季度重点工作管理", null, null);
		menu61 = new Privilege("待我审批列表", "/quarter_approvallist", menu6);
		menu62 = new Privilege("我的申请列表", "/quarter_mylist", menu6);
		session.save(menu6);
		session.save(menu61);
		session.save(menu62);
		
		//潜在客户信息管理
		Privilege menu7, menu71;
		menu7 = new Privilege("潜在客户信息管理", null, null);
		menu71 = new Privilege("潜在客户信息", "/potential_list", menu7);
		session.save(menu7);
		session.save(menu71);
		
		session.save(new Privilege("潜在客户信息列表", "/potential_list", menu71));
		session.save(new Privilege("删除潜在客户信息", "/potential_delete", menu71));
		session.save(new Privilege("添加潜在客户信息", "/potential_save", menu71));
		session.save(new Privilege("编辑潜在客户信息", "/potential_edit", menu71));
		session.save(new Privilege("查看潜在客户信息", "/potential_detail", menu71));
		//突发事件流转管理
		Privilege menu8, menu81, menu82;
		menu8 = new Privilege("突发事件流转管理", null, null);
		menu81 = new Privilege("我的流转列表", "/transfer_mylist", menu8);
		menu82 = new Privilege("流转处理列表", "/transfer_list", menu8);
		session.save(menu8);
		session.save(menu81);
		session.save(menu82);
		

		//经营指标统计管理
		Privilege menu9, menu91;
		menu9 = new Privilege("经营指标统计管理", null, null);
		menu91 = new Privilege("经营指标统计", "/indicator_list", menu9);
		session.save(menu9);
		session.save(menu91);
		
		session.save(new Privilege("经营指标统计列表", "/indicator_list", menu91));
		session.save(new Privilege("删除经营指标统计", "/indicator_delete", menu91));
		session.save(new Privilege("上传经营指标统计", "/indicator_upload", menu91));
		session.save(new Privilege("下载经营指标统计", "/download", menu91));
		//付款明细管理
		Privilege menu10, menu101;
		menu10 = new Privilege("付款明细管理", null, null);
		menu101 = new Privilege("付款明细", "/payment_list", menu10);
		session.save(menu10);
		session.save(menu101);
		
		session.save(new Privilege("付款明细列表", "/payment_list", menu101));
		session.save(new Privilege("删除付款明细", "/payment_delete", menu101));
		session.save(new Privilege("添加付款明细", "/payment_save", menu101));
		session.save(new Privilege("编辑付款明细", "/payment_edit", menu101));
		session.save(new Privilege("查看付款明细", "/payment_detail", menu101));
		// --------------------
	}

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Installer installer = (Installer) ac.getBean("installer");
		installer.install();
	}
}
