package com.java.code.class2.servlet;

import com.java.code.class2.jdbc.studentHomeworkJDBC;
import com.java.code.class2.model.Homework;
import com.java.code.class2.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/submitHomeworkPage")
public class AddStudentHomeworkPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        StudentHomework sh = new StudentHomework();
        /**
         * 初始化，赋值
         * 前面判断是否为空
         */
//        sh.setStudentId(Long.getLong(req.getParameter("student_id")));
//        studentHomeworkJDBC.addStudentHomework();
//
//        resp.sendRedirect("list");
        List<Homework> list = studentHomeworkJDBC.selectAllHomework();
        req.setAttribute("list",list);
        req.getRequestDispatcher("submitHomework.jsp").forward(req,resp);
    }
}
