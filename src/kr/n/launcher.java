package kr.n;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class launcher {

	public static void main(String[] args) throws ServletException, LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("temp");
        tomcat.setPort(8090);
        tomcat.setHostname("localhost");
        
        Path relativePath = Paths.get("");
        String path = relativePath.toAbsolutePath().toString();
        System.out.println("Working Directory [" + path + "]");
        
        String contextPath = "";     
        String warFilePath = path + "\\war\\ROOT.war";
        
        System.out.println(tomcat.getConnector().getDomain());
        tomcat.getHost().setAppBase(".");
         
        tomcat.addWebapp(contextPath, warFilePath);
         
        tomcat.start();
        tomcat.getServer().await();
    }
}
