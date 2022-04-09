package com.control;

import com.entity.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 斯洪霄
 */
@WebListener
public class MyListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public MyListener() {
    }
    //监听对象
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        int count = 0;
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("OnlineCount",count);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }
    //监听session对象
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        ServletContext sc = se.getSession().getServletContext();

        Integer onlineCount = (Integer) sc.getAttribute("OnlineCount");
        if (onlineCount == null)
        {
            //如果在线人数为0，则设置在线人数为1
            onlineCount = 1;
        } else {
            //在线人数+1
            int count = onlineCount;
            onlineCount = count+1;
        }
        //将在线人数放到servletContext对象中
        sc.setAttribute("OnlineCount",onlineCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        ServletContext sc = se.getSession().getServletContext();

        Integer onlineCount = (Integer) sc.getAttribute("OnlineCount");
        if (onlineCount == null)
        {
            //如果在线人数为0，则设置在线人数为0
            onlineCount = 0;
        } else {
            //在线人数-1
            int count = onlineCount;
            onlineCount = count-1;
        }
        //将在线人数放到servletContext对象中
        sc.setAttribute("OnlineCount",onlineCount);
    }

//    public static List<Admin> onlineAdmin = new ArrayList<>();
    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
/*        String name = sbe.getName();
        Object obj = sbe.getValue();
        if ("admin".equals(name)){
            Admin admin = (Admin) obj;
            onlineAdmin.add(admin);
        }*/
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
/*        String name = sbe.getName();
        Object obj = sbe.getValue();
        if ("admin".equals(name)){
            Admin admin = (Admin) obj;
            onlineAdmin.remove(admin);
        }*/
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}
