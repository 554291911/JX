<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html xmlns="undefined">
<head>
<title>查看客户公司资料</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
<link type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link type="text/css"
	href="${pageContext.request.contextPath}/css/my.css" rel="stylesheet">
</head>
<SCRIPT LANGUAGE="javascript">    
       var downloadFileMessage = "<%=request.getAttribute("downloadFileMessage")%>";
       if(downloadFileMessage != "null"){
             alert(downloadFileMessage);
       }
 </SCRIPT>
<body>
	<!-- 标题显示 -->
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />查看客户资料
			</div>
			<div id="Title_End"></div>
		</div>
	</div>
</head>
<!--显示表单内容-->
<div id="MainArea">
	<s:iterator value="#company">
		<div class="ItemBlockBorder">
			<div class="ItemBlock">
				<table class="table table-bordered">
					<thead align="left">
						<th colspan="5">公司姓名</th>
					</thead>
					<tr>
						<td colspan="5">${companyName }</td>
					</tr>
					 <thead >
						<th colspan="5">公司简介(*限255字)</th>
					</thead>
					<tr>
					<td colspan="5">${comIntroduction }</td>
						
					</tr>
					<tr>
						<td colspan="5">
						<a href="word/${comIntroductionName }" onclick="return confirm('确定要下载吗？')">${comIntroductionName}</a>
						</td>
					</tr>
					<thead >
						<th colspan="5">项目简介(*限255字)</th>
					</thead>
					<tr>
						<td colspan="5">
						${proIntroduction }
						</td>
					</tr>
					<tr>
						<td colspan="5"><a href="word/${proIntroductionName }">${proIntroductionName}</a></td>
					</tr>
				
      <thead>
					<thead>
						<th colspan="5">合同附件</th>
					</thead>
					<tr>
						<td colspan="5">
						<a href="word/${contractName }">${contractName }</a></td>
					</tr>
					<thead>
						<th colspan="5">薪资结构</th>
					</thead>
					<tr>
						<td colspan="5">${payConstruction }</td>
					</tr>
					<thead>
						<th colspan="5">用人偏好</th>
					</thead>
					<tr>
					<td colspan="5">
						${preference }
						</td>
					</tr>
					<thead>
						<th colspan="5">公司对接人</th>
					</thead>
					<tr align="center">
						<td>姓名</td>
						<td>职位</td>
						<td>电话</td>
						<td>邮箱</td>
						<td>生日</td>
					</tr>
					<s:iterator value="jnctions">
	  <tr>
        <td >${name }</td>
		<td >${position }</td>
		<td >${phoneNumber }</td>
		<td >${email }</td>
		<td>${birthday }
      </tr>
      </s:iterator>
					<thead>
						<th colspan="5">公司地址</th>
					</thead>
					<tr>
						<td colspan="5">${address }</td>
					</tr>
				</table>
			</div>
		</div>
		<!-- 其他功能超链接 -->
		<div id="InputDetailBar">
			<a href="javascript:history.go(-1);">
				<button type="button" class="btn btn-default">返回</button>
			</a>
		</div>
	</s:iterator>
</div>


</body>
</html>


