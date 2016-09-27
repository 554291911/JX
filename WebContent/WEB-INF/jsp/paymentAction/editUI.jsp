<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<html>
<head>
<title>用户信息</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
<link type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link type="text/css"
	href="${pageContext.request.contextPath}/css/my.css" rel="stylesheet">
</head>
<body>

	<!-- 标题显示 -->
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" /> 编辑订单
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!--显示表单内容-->
	<div id=MainArea>
		<s:form action="payment_edit.action">
		<s:hidden name="id"></s:hidden>
			<div class="ItemBlock_Title1">
				<!-- 信息说明 -->
				<div class="ItemBlock_Title1">
					<img border="0" width="4" height="7"
						src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 用户信息
				</div>
			</div>

			<!-- 表单内容显示 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<table cellpadding="0" cellspacing="0" class="table table-bordered">
						<tr>
							<td width="100">客户</td>
							<td>
							<s:select name="companyId" cssClass="SelectStyle" 
                        		list="#companylist" listKey="id" listValue="companyName"
                        		headerKey="" headerValue="==请选择客户公司==" 
                        	/></td>
						</tr>
						<tr>
							<td>年度</td>
							<td><s:select headerKey="" headerValue="请选择年度" name="year" 
         list="{'2020', '2019', '2018', '2017', '2016', '2015', '2014', '2013', '2012', '2011', '2010' }"/>年度</td>
						</tr>
						<tr>
							<td width="100">付款方式</td>
							<td>
							<s:textfield name="paymentMethod" cssClass="InputStyle"/>
						</td>
						</tr>
						<tr>
							<td>收款状态</td>
							<td>
							<s:select headerKey="" headerValue="请选择收款状态" name="status" 
         list="{'正在进行','完成'}"/> 
							</td>
						</tr>
						<tr>
							<td>候选人</td>
							<td>
							<s:textfield name="candidate" cssClass="InputStyle"/>
							</td>
						</tr>

						<tr>
							<td>到岗时间</td>
							<td><input type="text" name="arrivalTime" class="InputStyle" value="${arrivalTime }" /></td>
						</tr>
						<tr>
							<td>转正时间</td>
							<td><input type="text" name="positiveTime" class="InputStyle"  value="${positiveTime }"/></td>
						</tr>
						<tr>
							<td>猎头费用</td>
							<td><s:textfield name="headHuntingExpenses" cssClass="InputStyle"/></td>
						</tr>
						<tr>
							<td>首款金额</td>
							<td><s:textfield name="firstAmount" cssClass="InputStyle"/></td>
						</tr>
						<tr>
							<td>开票时间(首款)</td>
							<td><input type="text" name="firstBillingTime" class="InputStyle" value="${firstBillingTime }"/></td>
						</tr>
						<tr>
							<td>到账时间(首款)</td>
							<td><input type="text" name="firstArrivalTime" class="InputStyle" value="${firstArrivalTime }"/></td>
						</tr>
						<tr>
							<td>尾款金额</td>
							<td><s:textfield name="retainage" cssClass="InputStyle"/></td>
						</tr>
						<tr>
							<td>开票时间(尾款)</td>
							<td><input type="text" name="retainageBillingTime" class="InputStyle" value="${retainageBillingTime }"/></td>
						</tr>
						<tr>
							<td>到账时间(尾款)</td>
							<td><input type="text" name="retainageArrivalTime" class="InputStyle" value="${retainageArrivalTime }"/></td>
						</tr>
						<tr>
							<td>付款账户</td>
							<td><s:textfield name="account" cssClass="InputStyle"/></td>
						</tr>
						<tr>
							<td>备注</td>
							<td><s:textarea name="remarks" cssClass="TextareaStyle" /></td>
						</tr>
					</table>
				</div>
			</div>


			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<button type="submit" class="btn btn-default">保存</button>
				<a href="javascript:history.go(-1);"><button type="button"
						class="btn btn-default">返回</button></a>
			</div>
		</s:form>
	</div>
</body>
</html>
