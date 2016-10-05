<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<html xmlns="undefined">
<head>
<title>审批结果</title>
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
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />审批结果
			</div>
			<div id="Title_End"></div>
		</div>
	</div>
	<!--显示表单内容-->
	<div id="MainArea">
		<div class="ItemBlockBorder">
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<!-- 标题-->
					<div class="table-responsive" align="center">
						<table class="table table-bordered">
							<thead>${year }年${month }月${week }周工作计划表
							</thead>
						</table>
					</div>

					<!-- 本周工作 -->
					<div class="table-responsive">
						<table class="table table-bordered">
							<thead>
								<tr>
									<td colspan="8">一，本周工作的完成情况</td>
								</tr>
								<tr>
									<td>姓名</td>
									<td>推荐量</td>
									<td>电话数</td>
									<td>简历通过数</td>
									<td>下周F2F候选人个数</td>
									<td>F2F候选人姓名</td>
									<td>其他</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>${name}</td>
									<td>${recommend}</td>
									<td>${phoneNum}</td>
									<td>${evaluation}</td>
									<td>${nextWeek }</td>
									<td>${nextName }</td>
									<td>${other }</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="table-responsive">
						<table class="table table-bordered">
							<thead>
								<tr>
									<td colspan="8">二，截止到今日在流程中的候选人</td>
								</tr>
								<tr>
									<td>姓名</td>
									<td>联系方式</td>
									<td>推荐客户</td>
									<td>推荐部门</td>
									<td>推荐职位</td>
									<td>推荐日期</td>
									<td>目前状态</td>
								</tr>
							</thead>
							<tbody id="more">
								<s:iterator value="candidates">
									<tr id="${id }">
										<td>${cName}</td>
										<td>${phone }</td>
										<td>${customer }</td>
										<td>${bu }</td>
										<td>${job }</td>
										<td>${date }</td>
										<td>${cstatus }</td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>

					<div class="table-responsive">
						<table class="table table-bordered">
							<thead>
								<tr>
									<td colspan="8">三、工作中遇到的问题</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td colspan="8">${nextQuestion }</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="table-responsive">
						<table class="table table-bordered">
							<thead>
								<tr>
									<td colspan="8">四、下周工作安排</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td colspan="8">${nextManager }</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!-- 其他功能超链接 -->
		<!-- 表单操作 -->
		<div id="InputDetailBar">
			<a href="javascript:history.go(-1);"><button type="button"
					class="btn btn-default">返回</button></a>
		</div>
	</div>
</body>
</html>
