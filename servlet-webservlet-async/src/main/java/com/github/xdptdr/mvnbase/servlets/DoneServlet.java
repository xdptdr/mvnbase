package com.github.xdptdr.mvnbase.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/done")
public class DoneServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String query = request.getParameter("query");
		Object responseToQuery = request.getAttribute("response");
		response.setContentType("text/plain; charset=UTF-8");
		response.getWriter().println("Response to query " + query + " is " + responseToQuery);
	}
}
