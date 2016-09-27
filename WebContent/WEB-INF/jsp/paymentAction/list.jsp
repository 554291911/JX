<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>

<head>
    <title>付款明细 </title>
     <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<script type="text/javascript">
$(document).ready(function(){
	/*
	var $tr = $(".tr1");
	for( var i=0; i<$tr.length; i++ ){
		var text = $($tr[i]).find(".status").html();
		if( text == "完成" ){
			$($tr[i]).css("backgroundColor","red");
		}
	}
	*/
	var $tds = $(".status");
	for( var i=0; i<$tds.length; i++ ){
		var $td = $( $tds[i] );
		if( $td.html() == "完成" ){
			$td.parent().css("backgroundColor","#33CCCC");
		};
	}
});
</script>
<body>
<s:form action="payment_list">
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 付款明细表
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="TableTail">
				<div id="TableTail_inside">
					<table border="0" cellspacing="0" cellpadding="0" height="100%" align="left">
					<s:select name="companyId" cssClass="SelectStyle" 
                        		list="#companylist" listKey="id" listValue="companyName"
                        		headerKey="" headerValue="查看全部公司" 
                        	/>
		 <s:select  name="yearType" headerKey="" headerValue="请选择年度" 
         list="{'2020', '2019', '2018', '2017', '2016', '2015', '2014', '2013', '2012', '2011', '2010'}"/>  
		<s:select  name="statusType" headerKey="" headerValue="请选择状态" 
		 list="{'正在进行', '完成'}"/>  
						
		<input type="IMAGE" src="${pageContext.request.contextPath}/style/blue/images/button/submit.PNG" align="ABSMIDDLE"/>
					</table>
				</div>
			</div>


<div id="MainArea">
    <table id="table" cellspacing="0" cellpadding="0" class="TableStyle">
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
				<td >客户</td>
				<td >候选人</td>
				<td>年度</td>
				<td >到岗时间</td>
				<td >转正时间</td>
				<td >猎头费用</td>
				<td >首款金额</td>
				<td >开票时间(首款)</td>
				<td >到账时间(首款)</td>
				<td >尾款金额</td>
				<td >开票时间(尾款)</td>
				<td >到账时间(尾款)</td>
				<td >付款账户</td>
				<td >收款状态</td>
				<td>其他操作</td>
			</tr>
		</thead>	

        <tbody id="TableData" class="dataContainer">
			<s:iterator value="recordList">
			<tr  class="tr1 TableDetail1 template" align="center">
				<td>
				<s:iterator value="company">
				${companyName }<br/>${payment }
				</s:iterator>
				
				</td>
				<td>${candidate }</td>
				<td>${year }年度</td>
				<td>${arrivalTime }</td>
				<td >${positiveTime}</td>
				<td >${headHuntingExpenses }</td>
				<td >${firstAmount }</td>
				<td >${firstBillingTime }</td>
				<td >${firstArrivalTime }</td>
				<td >${retainage }</td>
				<td >${retainageBillingTime }</td>
				<td >${retainageArrivalTime }</td>
				<td >${account }</td>
				<td class="status">${status }</td>
				<td><s:a action="payment_detailUI?id=%{id}">查看详细</s:a>&nbsp;
					<s:a action="payment_editUI?id=%{id}">编辑</s:a>&nbsp;
					<s:a action="payment_delete?id=%{id}" onclick="return confirm('确定要删除吗？')">删除</s:a>
				</td> 
			</tr>
			</s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
		<div id="TableTail_inside">
		<table border="0" cellspacing="0" cellpadding="0" height="100%" align="left" class="TableStyle">
			 <tr  valign="MIDDLE" >
				 <td>
           <s:a action="payment_saveUI"><img src="${pageContext.request.contextPath}/style/blue/images/button/addNew.PNG" /></s:a>
			</td>
			<td>
			
	<%-- 	<s:select headerKey="name" headerValue="请选择客户" name="customer" 
         list=""/>  
        
		--%>	
	
				 </td>
			
			</tr>
			</table>
        </div>
	</div>
</div>	
<!-- 分页信息 -->
	<%@ include  file="/WEB-INF/jsp/public/pageView.jspf"%>
	
</s:form>

</body>
</html>
