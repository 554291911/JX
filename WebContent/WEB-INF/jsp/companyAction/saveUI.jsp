<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html xmlns="undefined">
<head>
<title>添加客户公司资料</title>
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
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />添加客户公司资料
			</div>
			<div id="Title_End"></div>
		</div>
	</div>
<!--显示表单内容-->
<div id="MainArea">
	<s:form action="company_save.action" method="post"
		enctype="multipart/form-data">
		<div class="ItemBlockBorder">
			<div class="ItemBlock">
				<table class="table table-bordered">
					<thead >
						<th colspan="5">公司姓名</th>
					</thead>
					<tr>
						<td colspan="5"><s:textfield name="companyName" cssClass="inputStyle1"/></td>
					</tr>
					<thead >
						<th colspan="5">公司简介</th>
					</thead>
					<tr>
						<td colspan="5"><label class="control-label">上传公司简介</label><s:file name="comintro"></s:file></td>
					</tr>
					<tr>
						<td colspan="5"><s:textarea  cols="160=" rows="7" name="comIntroduction" /></td>
					</tr>
					<thead >
						<th colspan="5">项目简介</th>
					</thead>
					<tr>
						<td colspan="5"><label class="control-label">上传项目简介</label><s:file name="prointro"></s:file></td>
					</tr>
					<tr>
						<td colspan="5"><s:textarea name="proIntroduction"  cols="160=" rows="7" /></td>
					</tr>
				
					<thead>
						<th colspan="5">合同附件</th>
					</thead>
					<tr>
						<td colspan="5"><s:file name="contract">点击上传附件</s:file></td>
					</tr>
					<thead>
						<th colspan="5">薪资结构</th>
					</thead>
					<tr>
						<td colspan="5"><s:textarea name="payConstruction" cols="160"
								rows="5"></s:textarea></td>
					</tr>
					
					<thead>
						<th colspan="5">用人偏好</th>
					</thead>
					<tr>
						<td colspan="5">
						<s:textarea name="preference" cols="160" rows="5"></s:textarea>
						</td>
					</tr>
					<thead>
						<th colspan="5">公司对接人<input type="button"
								value="增加" onClick="addMore()" /></th>
					</thead>
					<tr align="center">
						<td>姓名</td>
						<td>职位</td>
						<td>电话</td>
						<td>邮箱</td>
						<td>生日</td>
					</tr>
					<tbody id="more">
						
					</tbody>
					<thead>
						<th colspan="5">公司地址</th>
					</thead>
					<tr>
						<td colspan="5"><s:textarea name="address" cols="160"
								rows="5"></s:textarea></td>
					</tr>
				</table>
			</div>
		</div>
		<!-- 其他功能超链接 -->
		<div id="InputDetailBar">
			<button type="submit" class="btn btn-default">保存</button>
			<a href="javascript:history.go(-1);">
				<button type="button" class="btn btn-default">返回</button>
			</a>
		</div>
	</s:form>
	<div class="Description">
	说明：<br />
	上传文件不得大于【10M】
</div>
</div>
</body>
<script type="text/javascript">
	function addMore() {

		var tbody = document.getElementById("more");

		var tr = document.createElement("tr");
		var td1 = document.createElement("td");
		td1.innerHTML = "<input type='text' name='name' class='InputStyle2'/>";
		tr.appendChild(td1);

		var td2 = document.createElement("td");
		td2.innerHTML = "<input type='text' name='position' class='InputStyle2'/>";
		tr.appendChild(td2);

		var td3 = document.createElement("td");
		td3.innerHTML = "<input type='text' name='phoneNumber' class='InputStyle2'/>";
		tr.appendChild(td3);

		var td4 = document.createElement("td");
		td4.innerHTML = "<input type='text' name='email' class='InputStyle2'/>";
		tr.appendChild(td4);

		var td5 = document.createElement("td");
		td5.innerHTML = "<input type='text' name='birthday' />&nbsp;";
		tr.appendChild(td5);

		var button = document.createElement("input");
		td5.appendChild(button);

		button.type = "button";
		button.value = "删除";
		button.onclick = function() {
			tr.removeChild(td1);
			tr.removeChild(td2);
			tr.removeChild(td3);
			tr.removeChild(td4);
			tr.removeChild(td5);
		}
		tbody.appendChild(tr);

	}
</script>
</html>


