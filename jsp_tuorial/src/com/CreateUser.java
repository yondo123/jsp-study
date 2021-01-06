package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/membership")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("user_name");
		String userId = request.getParameter("user_id");
		String userHobby = request.getParameter("user_hobby");

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "jsp_user";
		String pw = "oracle";

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
				System.out.println("QUERY INSERT SUCCESS!");
			} else {
				System.out.println("QUERY INSERT FAIL!");
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
			}
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
