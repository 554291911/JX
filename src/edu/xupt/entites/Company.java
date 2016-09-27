package edu.xupt.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_company")
public class Company implements Serializable{

	private int id;
	private String companyName; //公司姓名
	private String comIntroduction;//公司简介
	private String comIntroductionName;//公司简介附件名
	private String proIntroduction;//项目简介
	private String proIntroductionName;//项目简介附件名
	private String contractName; //附件名
	private String payConstruction;//薪资结构
	private String preference;
	private String address;
	
	private String payment;//付款方式
	
	private List<Junction> jnctions = new ArrayList<Junction>();//对接人
	private List<Payment> payments = new ArrayList<Payment>();//付款明细
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public String getPayConstruction() {
		return payConstruction;
	}
	public void setPayConstruction(String payConstruction) {
		this.payConstruction = payConstruction;
	}
	public String getPreference() {
		return preference;
	}
	public void setPreference(String preference) {
		this.preference = preference;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@OneToMany(mappedBy="company",cascade={CascadeType.ALL})
	public List<Junction> getJnctions() {
		return jnctions;
	}
	public void setJnctions(List<Junction> jnctions) {
		this.jnctions = jnctions;
	}
	@OneToMany(mappedBy="company")
	public List<Payment> getPayments() {
		return payments;
	}
	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
	public String getComIntroduction() {
		return comIntroduction;
	}
	public void setComIntroduction(String comIntroduction) {
		this.comIntroduction = comIntroduction;
	}
	public String getProIntroduction() {
		return proIntroduction;
	}
	public void setProIntroduction(String proIntroduction) {
		this.proIntroduction = proIntroduction;
	}
	public String getComIntroductionName() {
		return comIntroductionName;
	}
	public void setComIntroductionName(String comIntroductionName) {
		this.comIntroductionName = comIntroductionName;
	}
	public String getProIntroductionName() {
		return proIntroductionName;
	}
	public void setProIntroductionName(String proIntroductionName) {
		this.proIntroductionName = proIntroductionName;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	
}
