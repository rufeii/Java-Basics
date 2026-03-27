package com.example.servlet.Listen;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

// 注解不能加路径！
@WebListener
public class AdminListen implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("会话创建：sessionCreated");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("会话销毁：sessionDestroyed");
    }
}