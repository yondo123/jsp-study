<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	SimpleDateFormat ftdt = new SimpleDateFormat("yyyy년 MM월 dd일");
	Date dt = new Date();
	
	String today = ftdt.format(dt);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Request/Response Test</h2>
	<!-- CreateUser.java /membership 서블릿으로 요청 (post) -->
	<form action="membership.jsp" method="post">
		<span>Id : <input type="text" name="user_id"><br></span>
		<span>name : <input type="text" name="user_name"><br></span>
		hobby : <input type="radio" name="user_hobby" id="sports"><label>sports</label><br>
		<input type="radio" name="user_hobby" id="game"><label>game</label><br>
		<input type="submit" value="Submit">
	</form>
	<!-- 회원 리스트 페이지 -->
	<button onclick="location='userlist.jsp'">users</button>
	<!--  공통영역 (오늘날짜) 알리미-->
	<jsp:include page="./common/infoSection.jsp">
		<jsp:param value="<%=today %>" name="today"/>
	</jsp:include>
	<!-- 	공통영역 (푸터) 가져옴 -->
	<jsp:include page="./common/footer.jsp" />
</body>
</html>