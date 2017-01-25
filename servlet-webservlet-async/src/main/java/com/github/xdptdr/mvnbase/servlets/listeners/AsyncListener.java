package com.github.xdptdr.mvnbase.servlets.listeners;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.servlet.AsyncContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AsyncListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {

		Queue<AsyncContext> asyncQueue = new ConcurrentLinkedQueue<AsyncContext>();
		servletContextEvent.getServletContext().setAttribute("asyncQueue", asyncQueue);

		Executor executor = Executors.newFixedThreadPool(1);

		executor.execute(new Runnable() {
			public void run() {
				while (true) {
					if (!asyncQueue.isEmpty()) {
						final AsyncContext asyncContext = asyncQueue.poll();
						System.out.println("Executing an async action");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
						}
						String query = asyncContext.getRequest().getParameter("query");
						String responseToQuery = null;
						if (query == null) {
							responseToQuery = "Please specify a query parameter";
						} else {
							responseToQuery = "response to " + query;
						}
						asyncContext.getRequest().setAttribute("response", responseToQuery);
						asyncContext.dispatch("/done");
						Thread.yield();
					}
				}
			}
		});
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
