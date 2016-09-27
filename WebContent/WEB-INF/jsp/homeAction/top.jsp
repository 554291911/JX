<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>TopMenu</title>
	<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
	<LINK href="${pageContext.request.contextPath}/style/blue/top.css" type=text/css rel=stylesheet>
	
	<script type="text/javascript">
	</script>
</head>

<body class="PageBody" style="margin: 0">
<script type="text/javascript">
		var req;
		window.onload = function() {
		}
		$(document).ready(function(){

			var url = "home_getTaskCount.action";
			$.post(url,
			function(data, textStatus) {
				if(data != null){
					$("#messageArea").append("您有突发事件未处理，请及时处理！★★★★★");
				}
				if(data == "0"){
					$("#messageArea").hide();
				}
			});

		function callback() {
			if (req.readyState == 4) {
				if (req.status == 200) {
					alert("success");
				} else {
					alert("Not able to retrieve description" + req.statusText);
				}
			}
		}
		function parseMessage() {
			var paymentMethod = $(".b").val();
			alert(paymentMethod);

		}
		});
	</script>
	<div id="Head1">
		<div id="Logo">
			<a id="msgLink" href="javascript:void(0)"></a>
			<img border="0" src="${pageContext.request.contextPath}/style/blue/images/logo.png" height="40" width="40"/>
            <font color="#0000CC" style="color:#F1F9FE; font-size:20px; font-family:Arial Black, Arial">西安聚贤企业管理咨询有限公司</font> 	
        </div>
		
		<div id="Head1Right">
			<div id="Head1Right_UserName">
                <img border="0" width="13" height="14" src="${pageContext.request.contextPath}/style/images/top/user.gif" /> 您好，<b>${user.name }</b>
			</div>
			<div id="Head1Right_UserDept"></div>
			<div id="Head1Right_UserSetup">
            	<a target="right" href="user_editpasswordUI.action?id=${user.id }" ><img border="0" width="13" height="14" src="${pageContext.request.contextPath}/style/images/top/user_setup.gif" /> 个人设置</a>
			</div>
			<div id="Head1Right_Time">
				</div>
		</div>
			<div id="Head1Right_UserDept"></div>
		
		</div>
		
        <div id="Head1Right_SystemButton">
            <a href="${pageContext.request.contextPath}/user_logout.action" target="_parent">
				<img width="78" height="20" alt="退出系统" src="${pageContext.request.contextPath}/style/blue/images/top/logout.gif" />
			</a>
        </div>
	</div>	
<div id="Head2">
        <div id="Head2_Awoke">
            <ul id="AwokeNum">
               
                <!-- 是否有待审批文档的提示2，提示审批 -->
                <li id="messageArea"></li>
            </ul>
        </div>
        
	
	</div>


   
</body>
</html>
