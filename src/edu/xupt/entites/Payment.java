package edu.xupt.entites;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_payment")
public class Payment implements Serializable{

	private int id;
	private Company company;//客户
	private String clientName;//客户姓名
	private String status;//收款状态
	private String year;//年度
	private String paymentMethod;//付款方式
	private String candidate;//候选人
	private String arrivalTime;//到岗时间
	private String positiveTime;//转正时间
	private String headHuntingExpenses;//猎头费用
	private String firstAmount;//首款金额
	private String firstBillingTime;//开票时间（首款）
	private String firstArrivalTime;//到账时间（首款）
	private String retainage;//尾款金额
	private String retainageBillingTime;//开票时间（尾款）
	private String retainageArrivalTime;//到账时间（尾款）
	private String account;//付款账户
	private String remarks;//备注
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getCandidate() {
		return candidate;
	}
	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getPositiveTime() {
		return positiveTime;
	}
	public void setPositiveTime(String positiveTime) {
		this.positiveTime = positiveTime;
	}
	public String getHeadHuntingExpenses() {
		return headHuntingExpenses;
	}
	public void setHeadHuntingExpenses(String headHuntingExpenses) {
		this.headHuntingExpenses = headHuntingExpenses;
	}
	public String getFirstAmount() {
		return firstAmount;
	}
	public void setFirstAmount(String firstAmount) {
		this.firstAmount = firstAmount;
	}
	public String getFirstBillingTime() {
		return firstBillingTime;
	}
	public void setFirstBillingTime(String firstBillingTime) {
		this.firstBillingTime = firstBillingTime;
	}
	public String getFirstArrivalTime() {
		return firstArrivalTime;
	}
	public void setFirstArrivalTime(String firstArrivalTime) {
		this.firstArrivalTime = firstArrivalTime;
	}
	public String getRetainage() {
		return retainage;
	}
	public void setRetainage(String retainage) {
		this.retainage = retainage;
	}
	public String getRetainageBillingTime() {
		return retainageBillingTime;
	}
	public void setRetainageBillingTime(String retainageBillingTime) {
		this.retainageBillingTime = retainageBillingTime;
	}
	public String getRetainageArrivalTime() {
		return retainageArrivalTime;
	}
	public void setRetainageArrivalTime(String retainageArrivalTime) {
		this.retainageArrivalTime = retainageArrivalTime;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	@ManyToOne
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
}
