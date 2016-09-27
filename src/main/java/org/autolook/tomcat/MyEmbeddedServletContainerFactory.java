package org.autolook.tomcat;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;

/**
 * Created by raoshaoquan on 16/6/16.
 */
@Component()
public class MyEmbeddedServletContainerFactory extends TomcatEmbeddedServletContainerFactory {
    public EmbeddedServletContainer getEmbeddedServletContainer(ServletContextInitializer... initializers) {
        return super.getEmbeddedServletContainer(initializers);
    }

    protected void customizeConnector(Connector connector) {
        super.customizeConnector(connector);
        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
        //设置最大连接数
        protocol.setMaxConnections(20480);
        //设置最大线程数
        protocol.setMaxThreads(10240);
        protocol.setConnectionTimeout(20000);
    }
}