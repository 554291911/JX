<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<html xmlns="undefined">
<head>
<title>添加周工作计划</title>
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
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />添加周工作计划
			</div>
			<div id="Title_End"></div>
		</div>
	</div>
<!--显示表单内容-->
<div id="MainArea">
	<s:form action="week_save.action">
		<div class="ItemBlockBorder">
			<div class="ItemBlock">
				<!-- 标题-->
				<div class="table-responsive" align="center">
					<table class="table table-bordered">
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
								<td><s:textfield name="name" /></td>
								<td><s:textfield name="recommend" /></td>
								<td><s:textfield name="phoneNum" /></td>
								<td><s:textfield name="evaluation" /></td>
								<td><s:textfield name="nextWeek" /></td>
								<td><s:textfield name="nextName" /></td>
								<td><s:textfield name="other" /></td>
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
	<s:iterator value="candidates">
							<tr id="${id }">
								<td><input type="text" name="cname" value="${cname }"/></td>
								<td><input type="text" name="phone" value="${phone }"/></td>
								<td><input type="text" name="customer" value="${customer }"/></td>
								<td><input type="text" name="bu" value="${bu }"/></td>
								<td><input type="text" name="job" value="${job }"/></td>
								<td><input type="text" name="date" value="${date }"/></td>
								<td><input type="text" name="cstatus" value="${cstatus }"/>&nbsp<input type="button" value="删除"
									onclick="del_tr(${id});" /></td>
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
								<td colspan="8"><s:textarea name="nextQuestion" cols="150"
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
								<td colspan="8"><s:textarea name="nextManager" cols="150"
										rows="5"></s:textarea></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- 其他功能超链接 -->
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
<script type="text/javascript">
	function addMore() {

		var tbody = document.getElementById("more");

		var tr = document.createElement("tr");
		tr.className = "gzjl_item";
		var td1 = document.createElement("td");
		td1.innerHTML = "<input type='text' name='cname'/>";
		tr.appendChild(td1);
		var td2 = document.createElement("td");
		td2.innerHTML = "<input type='text' name='phone'/>";
		tr.appendChild(td2);
		var td3 = document.createElement("td");
		td3.innerHTML = "<input type='text' name='customer'/>";
		tr.appendChild(td3);
		var td4 = document.createElement("td");
		td4.innerHTML = "<input type='text' name='bu'/>";
		tr.appendChild(td4);
		var td5 = document.createElement("td");
		tr.appendChild(td5);
		td5.innerHTML = "<input type='text' name='job'/>";
		var td6 = document.createElement("td");
		td6.innerHTML = "<input type='text' name='date'/>";
		tr.appendChild(td6);
		var td7 = document.createElement("td");
		td7.innerHTML = "<input type='text' name='cstatus'/>&nbsp;";
		var button = document.createElement("input");
		tr.appendChild(td7);
		td7.appendChild(button);

		button.type = "button";
		button.value = "删除";
		button.onclick = function() {
			tr.removeChild(td1);
			tr.removeChild(td2);
			tr.removeChild(td3);
			tr.removeChild(td4);
			tr.removeChild(td5);
			tr.removeChild(td6);
			tr.removeChild(td7);
		}
		tbody.appendChild(tr);

	}
	function del_tr(id){
		var tr = document.getElementById(id);
	    tr.parentNode.removeChild(tr);
	}
</script>