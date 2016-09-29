package ru.itis2016.filters;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by eljah32 on 9/29/2016.
 */
@WebServlet({"/filter2"})
public class Servlet2 extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String text=req.getParameter("echo");
        System.out.println("Servlet2 logging its output before");
        resp.getWriter().write(text);
    }
}
