<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.annotation.WebServlet"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%!
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "jsp_user";
		String pw = "oracle";
		String queryResult;
%>
<%
		String userName = request.getParameter("user_name");
		String userId = request.getParameter("user_id");
		String userHobby = request.getParameter("user_hobby");
		Connection conn = null; // DBMS 연결
		Statement stmt = null; // SQL Query 연결

		try {
			Class.forName(driver);

			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
			// 쿼리 작성
			String query = "INSERT INTO USER_LIST(ID, NAME, HOBBY)";
			query += "VALUES ('" + userId + "', '" + userName + "', '" + userHobby + "')";

			int result = stmt.executeUpdate(query);
			System.out.println("시행결과 : " + result);

			if (result == 1) {
				queryResult = "QUERY INSERT SUCCESS!";
			} else {
				queryResult = "QUERY INSERT FAIL!";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
				System.out.println(queryResult);
			}
		}
%>
<html>
<head>
<meta charset="UTF-8">
<title>가입결과</title>
</head>
<body>
	<h2>
		쿼리실행 결과 :
		<%=queryResult%>
	</h2>
	<p>
		userID :
		<%=userId%></p>
	<p>
		userName :
		<%=userName%></p>
	<p>
		userHobby :
		<%=userHobby%></p>
</body>
</html>