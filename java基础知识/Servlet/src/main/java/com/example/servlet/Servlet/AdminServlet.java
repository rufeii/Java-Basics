package com.example.servlet.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Admin", value = "/admin")
public class AdminServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("AdminServlet init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AdminServlet doGet");
    }

    @Override
    public void destroy() {
        System.out.println("AdminServlet destroy");
    }
}
