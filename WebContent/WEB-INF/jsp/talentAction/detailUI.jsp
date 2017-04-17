<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>详细信息</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
<link type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link type="text/css"
	href="${pageContext.request.contextPath}/css/my.css" rel="stylesheet">
  <style type="text/css">
        pre{
           white-space: pre-wrap;       
           white-space: -moz-pre-wrap;  
           white-space: -pre-wrap;      
           white-space: -o-pre-wrap;    
           word-wrap: break-word;       
        }
   </style>
</head>
<body>

	<!-- 标题显示 -->
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />
				详细信息
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!--显示表单内容-->
	<div id=MainArea>
		<s:form action="talent_saveCom.action" method="post"
			enctype="multipart/form-data" onsubmit="return register();">
			<s:hidden name="id"></s:hidden>
			<!-- 表单内容显示 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<table class="table table-bordered">
						<thead align="left">
							<th colspan="3">个人资料</th>
						</thead>
						<tr>
							<td>姓名:${name }</td>
							<td>邮&nbsp;&nbsp;箱: ${email }
							</td>
							<td rowspan="8"><s:iterator id="imgUrl" value="photoUrl">
									<br />
									<img src="${imgUrl}" height="200px" width="200px" />
								</s:iterator></td>
						</tr>
						<tr>
							<td>婚姻状况: ${isMarried }</td>
							<td>有无子女 ： ${hasChildren }
						</tr>
						<tr>
							<td>出生年月: ${birthday }
							<td>岗位级别: ${postLevel }</td>

						</tr>
						<tr>
							<td>性别: ${sex }
							<td>联系电话: ${phoneNumber }
						</tr>
						<tr>
							<td>第一学历: ${firstDegree }</td>
							<td>最高学历: ${highestDegree }</td>
						</tr>
						<tr>
							<td>目前公司:${company }</td>
							<td>现任职位:${position }</td>
						</tr>
						<tr>
							<td>推荐职位:${recommend }</td>
							<td>沟通是否完成:${isCommunicate }
							</td>
						</tr>
						<tr>
							<td colspan="2">现所在地: ${address }
						</tr>
						<thead>
							<th colspan="3">教育经历</th>
						</thead>
						<tr>
							<td colspan="3"><pre>${eduExperience }</pre></td>
						</tr>
						<thead>
							<th colspan="3">工作经历</th>
						</thead>
						<tr>
							<td colspan="3">
							<pre>${experience}</pre>
							</td>
						</tr>
						<%-- <s:iterator value="jobExperiences">
						<tr>
							<td><h4>工作时间</h4></td>
							<td><h4>所在公司</h4></td>
							<td><h4>所在职位</h4></td>
						</tr>
							<tr>
								<td>${startDate }至 ${ endDate}</td>
								<td>${company }</td>
								<td>${job }</td>
							</tr>
							<tr>
							<td colspan="3"><h4>岗位职责</h4></td>
							</tr>
							<tr>
							<td colspan="3">${duty }</td>
							</tr>
							<tr>
							<td colspan="3"><h4>工作业绩</h4></td>
							</tr>
							<tr>
							<td colspan="3">${kpi }</td>
							</tr>
						</s:iterator> --%>
						<thead>
							<th colspan="3">期望职位</th>
						</thead>
						<tr>
							<td colspan="3"><pre>${hopeJob }</pre></td>
						</tr>
						<thead>
							<th colspan="3">待遇水平</th>
						</thead>
						<tr>
							<td colspan="3"><pre>${treatmentLevel }</pre></td>
						</tr>
						<thead>
							<th colspan="3">期望待遇</th>
						</thead>
						<tr>
							<td colspan="3"><pre>${hopeTreatment }</pre></td>
						</tr>
						<thead>
							<th colspan="3">整体评价</th>
						</thead>
						<tr>
							<td colspan="3">
							<pre>${description }</pre>
							</td>
						</tr>
						<thead>
							<th colspan="3">沟通情况</th>
						</thead>
						<tr>
							<td colspan="3"><s:textarea name="communicate" cols="160"
									rows="5"></s:textarea></td>
						</tr>
						<s:if test="#session.user.hasPrivilegeByName('简历全部下载权限')">
						<thead>
							<th colspan="3">简历</th>
						</thead>
						<tr>
							<td colspan="1"><a href="word/${oldResumeName }"
								onclick="return confirm('确定要下载吗？')">${oldResumeName}</a></td>
							<td colspan="2"><a href="word/${standardResumeName }"
								onclick="return confirm('确定要下载吗？')">${standardResumeName }</a></td>
						</tr>
						</s:if>
						<s:else>
           					<thead>
							<th colspan="3">简历</th>
						</thead>
						<tr>
							 <s:if test="#session.user.name == creator">
							<td colspan="1"><a href="word/${oldResumeName }"
								onclick="return confirm('确定要下载吗？')">${oldResumeName}</a></td>
							<td colspan="2"><a href="word/${standardResumeName }"
								onclick="return confirm('确定要下载吗？')">${standardResumeName }</a></td>
							</s:if>
							<s:else>
							<td colspan="1">${oldResumeName}</td>
							<td colspan="2">${standardResumeName }</td>
							</s:else>
						</tr>
        				</s:else>
						<thead>
							<th colspan="3">个人特点</th>
						</thead>
						<tr>
							<td colspan="3">${disposition }</td>
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
