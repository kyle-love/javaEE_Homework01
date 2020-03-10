package com.java.code.class2.servlet;

import com.java.code.class2.jdbc.studentHomeworkJDBC;
import com.java.code.class2.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/showAllStudentServlet")
public class showAllStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> list = studentHomeworkJDBC.selectAllStudent();
        req.setAttribute("list",list);
        req.getRequestDispatcher("showAllStudent.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
