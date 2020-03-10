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

@WebServlet("/addStudentHomeworkServlet")
public class addStudentHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String id = req.getParameter("sh_id");
        String student_id = req.getParameter("student_id");
        String homework_id = req.getParameter("homework_id");
        String homework_title =req.getParameter("homework_title");
        String homework_content =req.getParameter("homework_content");

        long id_long = Long.valueOf(id);
        long homework_id_long = Long.valueOf(homework_id);
        long student_id_long = Long.valueOf(student_id);

        StudentHomework sh = new StudentHomework(id_long,student_id_long,homework_id_long,homework_title,homework_content);

        studentHomeworkJDBC.addStudentHomework(sh);



        req.getRequestDispatcher("studentOperation.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
