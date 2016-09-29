<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<html xmlns="undefined">
<head>
<title>审批结果</title>
	<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
	<link type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<link type="text/css" href="${pageContext.request.contextPath}/css/my.css" rel="stylesheet">
</head>
<body>
<!-- 标题显示 -->
<div id="Title_bar">
  <div id="Title_bar_Head">
    <div id="Title_Head"></div>
    <div id="Title">
      <!--页面标题-->
      <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/>审批结果 </div>
    <div id="Title_End"></div>
  </div> 
</div>
</head>
  <!--显示表单内容-->
 <div id="MainArea">
  <div class="ItemBlockBorder">
            <div class="ItemBlock">
            <div class="ItemBlockBorder">
			<div class="ItemBlock">
				<!-- 标题-->
				<div class="table-responsive" align="center">
					<table class="table table-bordered" >
						<thead>
							<s:textfield name="year" />
							年
							<s:textfield name="month" />
							月
							<s:textfield name="week" />
							周工作计划表
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
								<td><s:textfield name="year" /></td>
								<td><s:textfield name="year" /></td>
								<td><s:textfield name="year" /></td>
								<td><s:textfield name="year" /></td>
								<td><s:textfield name="year" /></td>
								<td><s:textfield name="year" /></td>
								<td><s:textfield name="year" /></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="table-responsive">
					<table class="table table-bordered">
						<thead>
							<tr>
								<td colspan="8">二，截止到今日在流程中的候选人 <input type="button"
									value="增加" onClick="addMore()" /></td>
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
								<td colspan="8"><s:textarea name="reason" cols="150"
										rows="5"></s:textarea></td>
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
								<td colspan="8"><s:textarea name="reason" cols="150"
										rows="5"></s:textarea></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
            
       <table class="table table-bordered" id="tab" cellpadding="0" cellspacing="0" >
		<thead><h3 align="center">${year }年${month }月${week }周工作计划表</h3></thead>
		<tr align="center">
			<td>员工姓名</td><td>${employeeName }</td><td>完成日期</td><td>${endDate }</td>
			
			</tr>
		<tr>
			<td>工作计划</td>
			<td colspan="3">${plan }</td>
		</tr>
		<tr>
			<td>应完成情况描述</td>
			<td colspan="3">${situationDescription }</td>
		</tr>		
		<tr>
			<td>工作输出结果</td>
			<td colspan="3">${output }</td>
		</tr>		
		<tr>
			<td>未完成原因</td>
			<td colspan="3">${reason }</td>
		</tr>		
		<tr>
			<td>审批意见</td>
			<td colspan="3">${remarks }</td>
		</tr>
		<tr>
			<td>审批状态</td>
			<td colspan="3">${status }</td>
		</tr>		
</table>
</div>
</div>
<!-- 其他功能超链接 -->
    <!-- 表单操作 -->
        <div id="InputDetailBar">
            <a href="javascript:history.go(-1);"><button type="button" class="btn btn-default" >返回</button></a>
        </div>
</div>
</body>
</html>
