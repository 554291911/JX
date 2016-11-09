<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>添加人才信息</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
<link type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrapValidator.css"
	rel="stylesheet">
<link type="text/css"
	href="${pageContext.request.contextPath}/css/my.css" rel="stylesheet">
<script language="javascript"
	src="${pageContext.request.contextPath}/script/bootstrapValidator.js"></script>
<style type="text/css">
.muted{
	color:#FF0000;
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
				添加人才信息
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!--显示表单内容-->
	<div id=MainArea>
		<s:form action="talent_save.action" method="post"
			enctype="multipart/form-data" onsubmit="return register();">
			<!-- 表单内容显示 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<table class="table table-bordered">
						<thead align="left">
							<th colspan="3">个人资料</th>
						</thead>
						<tr>
							<td> <label class="muted">*</label>姓名:<s:textfield name="name"
							onBlur="name_validate();"
							/>
							<p id="talent_save_action_name_info" class="muted"></p>
							</td>
							<td>邮&nbsp;&nbsp;箱: 
							<s:textfield name="email"/>
							</td>
							<td rowspan="7"><label class="control-label">上传照片</label> <s:file
									name="photo"></s:file></td>
						</tr>
						<tr>
							<td>婚姻状况: <s:radio list="{'已婚','未婚','离异', '其他'}"
									name="isMarried" />
							</td>
							<td>有无子女 ： <s:radio list="{'有子女','无子女'}" name="hasChildren" /></td>
						</tr>
						<tr>
							<td><label class="muted">*</label>出生年月: <s:textfield name="birthday" onBlur="birthday_validate();"/>
							<p id="talent_save_action_birthday_info" class="muted"></p>
							<td>岗位级别: <s:select headerKey="" headerValue="请选择"
									name="postLevel"
									list="{'A+', 'A', 'A-', 'B+', 'B', 'B-', 'C', 'D'}" />
							</td>

						</tr>
						<tr>
							<td><label class="muted">*</label>性别: 
							<input name="sex" type="radio" id="sex-1" value="男" class="css-checkbox" checked="checked"
                               ><label class="radio-label" for="sex-1">男</label>
                        <input name="sex" type="radio" id="sex-2" value="女" class="css-checkbox">
							<label class="radio-label" for="sex-2">女</label>
							<%-- <s:radio list="{'男','女'}" name="sex" value="男"/> --%>
							<td><label class="muted">*</label>联系电话: <s:textfield name="phoneNumber" onBlur="phoneNumber_validate();"/>
							<p id="talent_save_action_phoneNumber_info" class="muted"></p>
							</td>
						</tr>
						<tr>
							<td><label class="muted">*</label>第一学历: <s:select headerKey="小学" headerValue="小学"
									name="firstDegree"
									list="{ '初中', '高中', '专科', '本科', '硕士研究生', '博士研究生', '博士后'}" 
									/>
							</td>
							<td>最高学历: <s:select headerKey="" headerValue="请选择"
									name="highestDegree"
									list="{'小学', '初中', '高中', '专科', '本科', '硕士研究生', '博士研究生', '博士后'}" />
							</td>
						</tr>
						<tr>
							<td>目前公司:<s:textfield name="company"/></td>
							<td><label class="muted">*</label>现任职位:<s:textfield name="position" onBlur="position_validate();"
							/>
							<p id="talent_save_action_position_info" class="muted"></p>
							</td>
						</tr>
						<tr>
							<td colspan="2">现所在地: <s:textarea name="address" cols="80"
									rows="1"></s:textarea>
						</tr>
						<thead>
							<th colspan="3">教育经历</th>
						</thead>
						<tr>
							<td colspan="3"><s:textarea name="eduExperience" cols="160"
									rows="5"></s:textarea></td>
						</tr>
						<thead>
							<th colspan="3"><label class="muted">*</label>工作经历 <!-- <input type="button" value="增加"
								onClick="addMore()" /> -->
							</th>
						</thead>
						<tr>
							<td colspan="3"><s:textarea name="experience" cols="160"
									rows="10"></s:textarea></td>
						</tr>
						<!-- <tbody id="more">
						<tr>
							<td><h4>工作时间</h4></td>
							<td><h4>所在公司</h4></td>
							<td><h4>所在职位</h4></td>
						</tr>
						</tbody> -->
						<thead>
							<th colspan="3">期望职位</th>
						</thead>
						<tr>
							<td colspan="3"><s:textarea name="hopeJob" cols="160"
									rows="5"></s:textarea></td>
						</tr>
						<thead>
							<th colspan="3">待遇水平</th>
						</thead>
						<tr>
							<td colspan="3"><s:textarea name="treatmentLevel" cols="160"
									rows="5"></s:textarea></td>
						</tr>
						<thead>
							<th colspan="3">期望待遇</th>
						</thead>
						<tr>
							<td colspan="3"><s:textarea name="hopeTreatment" cols="160"
									rows="5"></s:textarea></td>
						</tr>
						<thead>
							<th colspan="3">整体评价</th>
						</thead>
						<tr>
							<td colspan="3"><s:textarea name="description" cols="160"
									rows="5"></s:textarea></td>
						</tr>
						<thead>
							<th colspan="3">简历</th>
						</thead>
						<tr>
							<td colspan="1"><label class="control-label">上传原始简历</label>
								<s:file name="oldResume"></s:file></td>
							<td colspan="2"><label class="control-label">上传标准简历</label>
								<s:file name="standardResume"></s:file></td>
						</tr>
						<thead>
							<th colspan="3">个人特点</th>
						</thead>
						<tr>
							<td colspan="3"><s:textarea name="disposition" cols="160"
									rows="5"></s:textarea></td>
						</tr>
					</table>
				</div>
			</div>
			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<input value="保存" type="submit" class="btn btn-default">
				<!-- <button type="submit" class="btn btn-default" id="validateBtn">保存</button> -->
				<a href="javascript:history.go(-1);"><button type="button"
						class="btn btn-default">返回</button></a>

			</div>
		</s:form>
	</div>
</body>
<script type="text/javascript">

var name;
var birthday;
var phoneNumber;
var position;

$(function (){
	//清空表单中的信息
	$("div#name input").val("");
	$("div#birthday input").val("");
	$("div#phoneNumber input").val("");
	$("div#position input").val("");
});
//提交注册，当所有验证都通过时，才准许提交
function register(){
	//$("#submit").disable();
	var register = name_validate() && birthday_validate() && phoneNumber_validate() && position_validate();
	return register;
}

	function addMore() {

		var tbody = document.getElementById("more");

		var tr1 = document.createElement("tr");
		tr1.className = "gzjl_item";
		var td1 = document.createElement("td");
		td1.innerHTML = "<input type='text' name='startDate'/> 至 <input type='text' name='endDate'/>";
		tr1.appendChild(td1);
		var td2 = document.createElement("td");
		td2.innerHTML = "<input type='text' name='company' />";
		tr1.appendChild(td2);
		var td3 = document.createElement("td");
		td3.innerHTML = "<input type='text' name='job' />";
		tr1.appendChild(td3);
		var tr2 = document.createElement("tr");
		var td4 = document.createElement("td");
		td4.colSpan="3";
		td4.innerHTML = "岗位职责";
		tr2.appendChild(td4);
		var tr3 = document.createElement("tr");
		var td5 = document.createElement("td");
		td5.colSpan="3";
		td5.innerHTML = "<textarea name='duty' rows='3' cols='150'>";
		tr3.appendChild(td5);
		var tr4 = document.createElement("tr");
		var td6 = document.createElement("td");
		td6.colSpan="3";
		td6.innerHTML = "工作业绩";
		tr4.appendChild(td6);
		var tr5 = document.createElement("tr");
		var td7 = document.createElement("td");
		td7.colSpan="3";
		td7.innerHTML = "<textarea name='kpi' rows='3' cols='150'>&nbsp;";
		var button = document.createElement("input");
		td7.appendChild(button);
		tr5.appendChild(td7);
		button.type = "button";
		button.value = "删除";
		button.onclick = function() {
			tr1.removeChild(td1);
			tr1.removeChild(td2);
			tr1.removeChild(td3);
			tr2.removeChild(td4);
			tr3.removeChild(td5);
			tr4.removeChild(td6);
			tr5.removeChild(td7);
		}
		tbody.appendChild(tr1);
		tbody.appendChild(tr2);
		tbody.appendChild(tr3);
		tbody.appendChild(tr4);
		tbody.appendChild(tr5);

	}
	
	function name_validate(){
		var name = $.trim( $('#talent_save_action_name').val() );
		if( name == '' ){
			$('#talent_save_action_name').val('');
			return change_validate_style('toError','#talent_save_action_name','请填写姓名');
		} else {
			return change_validate_style('toSuccess','#talent_save_action_name','');
		}
	}
	
	function birthday_validate(){
		var birthday = $.trim( $('#talent_save_action_birthday').val() );
		if( birthday == '' ){
			$('#talent_save_action_birthday').val('');
			return change_validate_style('toError','#talent_save_action_birthday','请填写出生年月');
		} else {
			return change_validate_style('toSuccess','#talent_save_action_birthday','');
		}
	}
	
	function phoneNumber_validate(){
		var phoneNumber = $.trim( $('#talent_save_action_phoneNumber').val() );
		if( phoneNumber == '' ){
			$('#talent_save_action_phoneNumber').val('');
			return change_validate_style('toError','#talent_save_action_phoneNumber','请填写联系电话');
		} else {
			return change_validate_style('toSuccess','#talent_save_action_phoneNumber','');
		}
	}
	
	function position_validate(){
		var position = $.trim( $('#talent_save_action_position').val() );
		if( position == '' ){
			$('#talent_save_action_position').val('');
			return change_validate_style('toError','#talent_save_action_position','请填写现任职位');
		} else {
			return change_validate_style('toSuccess','#talent_save_action_position','');
		}
	}
	
	 //改变输入框样式、图标、错误信息的封装方法
	function change_validate_style(type, id, info){
		if( type == 'toError' ){
			$(id + '_info').html(info);		//显示错误信息
			/* $(id).addClass('has-error'); */
			return false;
		} else if ( type == 'toSuccess' ){
			$(id + '_info').html(info);		//显示错误信息
			$(id + '').removeClass('muted');	//让输入框变回蓝色
			return true;
		}
	} 
</script>
</html>
