<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
<head>
<title>我的申请查询</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
</head>
<body>
<script type="text/javascript">
$(document).ready(function(){
	
	var $trs = $(".a");
	for( var i=0; i<$trs.length; i++ ){
		var text = $($trs[i]).find(".b").html();
		if( text == "已发送" ){
			$($trs[i]).find(".c").hide();
			$($trs[i]).find(".d").hide();
		}
	}
	
	/*
	var $tds = $(".a");
	for( var i=0; i<$tds.length; i++ ){
		var $td = $( $tds[i] );
		alert($td.html());
		if( $td.html() == "未发送" ){
			$("#week_mylist_").hide();
		};
	}
	*/
});
</script>
<s:form action="week_mylist">
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" /> 我的申请查询
			</div>
			<div id="Title_End"></div>
		</div>
	</div>
<div id="TableTail">
				<div id="TableTail_inside">
					<table border="0" cellspacing="0" cellpadding="0" height="100%" align="left">
			
		 <s:select  name="yearType" headerKey="" headerValue="请选择年份" 
         list="{'2050', '2049', '2048', '2047', '2046', '2045', '2044', '2043', '2042', '2041', '2040', '2039', '2038', '2037', '2036', '2035', '2034', '2033', '2032', '2031', '2030', '2029', '2028', '2027', '2026', '2025', '2024', '2023', '2022', '2021', '2020', '2019', '2018', '2017', '2016'}"/> 
			
		 <s:select  name="monthType" headerKey="" headerValue="请选择月份" 
         list="{'1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'}"/> 
						
		<s:select  name="statusType" headerKey="" headerValue="请选择审批状态" 
         list="{'未开始', '未审批', '已审批', '已结束'}"/> 
		
		请输入员工姓名关键字 ：<s:textfield name="nameType"  cssClass="InputStyle2" />
						<input type="IMAGE" src="${pageContext.request.contextPath}/style/blue/images/button/submit.PNG" align="ABSMIDDLE"/>
					</table>
				</div>
			</div>
	<div id="MainArea">
		<table cellspacing="0" cellpadding="0" class="TableStyle">

			<!-- 表头-->
			<thead>
				<tr align=center valign=middle id=TableTitle>
					<td >标题</td>
					<td >申请人</td>
					<td>申请日期</td>
					<td>当前状态</td>
					<td>发送状态</td>
					<td >其他操作</td>
				</tr>
			</thead>

			<!--显示数据列表-->
			<tbody id="TableData" class="dataContainer">
				<s:iterator value="recordList">
					<tr class="TableDetail1 template a" align="center">
						<td>${year}年${ month}月${week }周工作计划考核表</td>
						<td>${employeeName }</td>
						<td>${time }</td>
						<td>${status }</td>
						<td class="b">${sendstatus }</td>
						<td>
						<s:a action="week_detailUI?id=%{id}">查阅审批</s:a>&nbsp;
						<s:a action="week_editUI?id=%{id}" cssClass="c" >编辑</s:a>
						<s:a action="week_send?id=%{id}" cssClass="d"  onclick="return confirm('确定要发送给管理员吗？')">发送管理员</s:a>
						<s:a action="week_revoke?id=%{id}" onclick="return confirm('确定要撤销吗？')">撤销</s:a>
						<s:a action="week_delete?id=%{id}" onclick="return confirm('确定要删除吗？')">删除</s:a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		
 <!-- 其他功能超链接 -->
    <div id="TableTail">
		 <div id="TableTail_inside">
			<s:a action="week_saveUI"><img src="${pageContext.request.contextPath}/style/blue/images/button/addNew.PNG" /></s:a>
        </div>
    </div>
    </div>
    <%@ include  file="/WEB-INF/jsp/public/pageView.jspf"%>
    </s:form>
</body>
</html>

