package kr.n;

import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class launcher {

	public static void main(String[] args) throws ServletException, LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("temp");
        tomcat.setPort(8090);
        tomcat.setHostname("localhost");
         
        String contextPath = "";     
        String warFilePath = "D:\\eGovFrameDev-3.8.0-64bit\\internExample.war";
        
        System.out.println(tomcat.getConnector().getDomain());
        tomcat.getHost().setAppBase(".");
         
        tomcat.addWebapp(contextPath, warFilePath);
         
        tomcat.start();
        tomcat.getServer().await();
    }
}
