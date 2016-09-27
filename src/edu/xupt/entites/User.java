package edu.xupt.entites;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.opensymphony.xwork2.ActionContext;

@Entity
@Table(name = "t_user")
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String loginName; // 登录名
	private String password; // 密码
	private String name; // 真实姓名
	private String sex; // 性别
	private String phoneNumber; // 电话号码
	private String email; // 电子邮件
	private String description; // 说明
	private String IP; // 最后登录的IP
	private Set<Talent> talents = new HashSet<Talent>();// 人才
	private Set<Role> roles = new HashSet<Role>(); // 岗位

	private Set<Transfer> transfers = new HashSet<Transfer>();

	/**
	 * 判断本用户是否是超级管理员
	 * 
	 * @return
	 */
	public boolean Admin() {
		return "admin".equals(loginName);
	}

	/**
	 * 判断本用户是否有指定名称的权限
	 * 
	 * @param name
	 * @return
	 */
	public boolean hasPrivilegeByName(String name) {
		// 超级管理有所有的权限
		if (Admin()) {
			return true;
		}

		// 普通用户要判断是否含有这个权限
		for (Role role : roles) {
			for (Privilege priv : role.getPrivileges()) {
				if (priv.getName().equals(name)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 判断本用户是否有指定URL的权限
	 * 
	 * @param privUrl
	 * @return
	 */
	public boolean hasPrivilegeByUrl(String privUrl) {
		// 超级管理有所有的权限
		if (Admin()) {
			return true;
		}

		// >> 去掉后面的参数
		int pos = privUrl.indexOf("?");
		if (pos > -1) {
			privUrl = privUrl.substring(0, pos);
		}
		// >> 去掉UI后缀
		if (privUrl.endsWith("UI")) {
			privUrl = privUrl.substring(0, privUrl.length() - 2);
		}

		// 如果本URL不需要控制，则登录用户就可以使用
		@SuppressWarnings("unchecked")
		Collection<String> allPrivilegeUrls = (Collection<String>) ActionContext.getContext().getApplication()
				.get("allPrivilegeUrls");
		if (!allPrivilegeUrls.contains(privUrl)) {
			return true;
		} else {
			// 普通用户要判断是否含有这个权限
			for (Role role : roles) {
				for (Privilege priv : role.getPrivileges()) {
					if (privUrl.equals(priv.getUrl())) {
						return true;
					}
				}
			}
			return false;
		}
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "role_user", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = {
			@JoinColumn(name = "roleId") })
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@OneToMany(mappedBy = "user")
	public Set<Talent> getTalents() {
		return talents;
	}

	public void setTalents(Set<Talent> talents) {
		this.talents = talents;
	}

	@ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
	public Set<Transfer> getTransfers() {
		return transfers;
	}

	public void setTransfers(Set<Transfer> transfers) {
		this.transfers = transfers;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

}
