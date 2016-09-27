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
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" /> 订单
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!--显示表单内容-->
	<div id=MainArea>
			<div class="ItemBlock_Title1">
				<!-- 信息说明 -->
				<div class="ItemBlock_Title1">
					<img border="0" width="4" height="7"
						src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 支付信息
				</div>
			</div>

			<!-- 表单内容显示 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<table cellpadding="0" cellspacing="0" class="table table-bordered">
						<s:iterator value="company">
						<tr>
							<td width="100">客户</td>
							<td>${companyName }</td>
						</tr>
						</s:iterator>
						<tr>
							<td width="100">付款方式</td>
							<td>
							${paymentMethod }
						</td>
						</tr>
						<tr>
						<td>年度</td>
						<td>${year }年度</td>
						</tr>
						<tr>
							<td>收款状态</td>
							<td>
							${status }
							</td>
						</tr>
						<tr>
							<td>候选人</td>
							<td>
							${candidate }
							</td>
						</tr>

						<tr>
							<td>到岗时间</td>
							<td>${arrivalTime }</td>
						</tr>
						<tr>
							<td>转正时间</td>
							<td>${positiveTime }</td>
						</tr>
						<tr>
							<td>猎头费用</td>
							<td>${headHuntingExpenses }</td>
						</tr>
						<tr>
							<td>首款金额</td>
							<td>${firstAmount }</td>
						</tr>
						<tr>
							<td>开票时间(首款)</td>
							<td>${firstBillingTime }</td>
						</tr>
						<tr>
							<td>到账时间(首款)</td>
							<td>${firstArrivalTime }</td>
						</tr>
						<tr>
							<td>尾款金额</td>
							<td>${retainage }</td>
						</tr>
						<tr>
							<td>开票时间(尾款)</td>
							<td>${retainageBillingTime }</td>
						</tr>
						<tr>
							<td>到账时间(尾款)</td>
							<td>${retainageArrivalTime }</td>
						</tr>
						<tr>
							<td>付款账户</td>
							<td>${account }</td>
						</tr>
						<tr>
							<td>备注</td>
							<td>${remarks }</td>
						</tr>
					</table>
				</div>
			</div>


			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<a href="javascript:history.go(-1);"><button type="button"
						class="btn btn-default">返回</button></a>
			</div>
	</div>
</body>
</html>
