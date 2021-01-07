package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class hellojsp
 */
@WebServlet("/hj") //servlet-url mapping
public class hellojsp extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public hellojsp() {
        super();
        // TODO Auto-generated constructor stub
    }

    /*Servlet 실행*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter print = response.getWriter();
		print.println("<html>");
		print.println("<p>asdasdasd</p>");
		print.println("</html>");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	/*Servlet 생성 전*/
	@PostConstruct
	public void postConstruct(){
		System.out.println(" --postConstruct()-- ");
	}
	
	/*Servlet 생성*/
	@Override
	public void init() throws ServletException {
		//공통적인 업무
		System.out.println(" --init()-- ");
	}
	
	/*Servlet 종료*/
	@Override
	public void destroy() {
		System.out.println(" --destroy()-- ");
	}
	
	/*Servlet 종료 후*/
	@PreDestroy
	public void preDestroy(){
		//DB 자원해제, 리소스 반납 등...
		System.out.println(" --preDestroy()-- ");
	}
	
}
