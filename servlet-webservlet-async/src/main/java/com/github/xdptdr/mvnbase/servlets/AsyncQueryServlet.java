package com.github.xdptdr.mvnbase.servlets;

import java.io.IOException;
import java.util.Queue;

import javax.servlet.AsyncContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/asyncQuery", asyncSupported = true)
public class AsyncQueryServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AsyncContext asyncContext = request.startAsync(request, response);
		ServletContext servletContext = request.getServletContext();
		@SuppressWarnings("unchecked")
		Queue<AsyncContext> asyncQueue = (Queue<AsyncContext>) (servletContext.getAttribute("asyncQueue"));
		(asyncQueue).add(asyncContext);
	}

}
