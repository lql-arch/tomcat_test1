package com.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//javaWeb三大组件之一(监听器)
@WebListener
public class listener_demo implements ServletContextListener {//对servletContext对象的监听（对web的监听）
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //加载资源
        System.out.println("contextInitialized...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //释放资源

    }
}
