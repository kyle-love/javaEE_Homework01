package com.java.code.class2.servlet;

import com.java.code.class2.jdbc.studentHomeworkJDBC;
import com.java.code.class2.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class StudentHomeworkServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<StudentHomework> list = studentHomeworkJDBC.selectAll();
        req.setAttribute("list",list);
        req.getRequestDispatcher("showAllStudentHomework.jsp").forward(req,resp);
    }
}
