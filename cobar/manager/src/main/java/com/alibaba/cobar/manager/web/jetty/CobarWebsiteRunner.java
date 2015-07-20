package com.alibaba.cobar.manager.web.jetty;

import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.mortbay.jetty.webapp.WebAppContext;
import org.mortbay.thread.QueuedThreadPool;


public class CobarWebsiteRunner  {
	private static Server server = new Server();

	public static void main(String[] args) throws Exception {
		QueuedThreadPool boundedThreadPool = new QueuedThreadPool();
		boundedThreadPool.setMaxThreads(5);
		server.setThreadPool(boundedThreadPool);

		Connector connector = new SelectChannelConnector();
		connector.setPort(80);
		server.addConnector(connector);


		WebAppContext context = new WebAppContext("src/main/webapp", "/cobar");
		context.setDescriptor("src/main/webapp/WEB-INF/web.xml");
//		context.setConfigurationClasses(new String[] { "org.mortbay.jetty.webapp.WebInfConfiguration",
//	            "org.mortbay.jetty.plus.webapp.EnvConfiguration", "org.mortbay.jetty.plus.webapp.Configuration",
//	            "org.mortbay.jetty.webapp.JettyWebXmlConfiguration", "org.mortbay.jetty.webapp.TagLibConfiguration" });
		server.setHandler(context);
		server.setStopAtShutdown(true);
		server.setSendServerVersion(true);
		server.start();
		server.join();
	}




}
