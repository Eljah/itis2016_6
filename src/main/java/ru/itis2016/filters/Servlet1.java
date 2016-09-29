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

@WebServlet({"/filter","/filter5"})
public class Servlet1 extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String text=req.getParameter("echo");
        String surprise=(String)req.getAttribute("surprise");
        String surprise2=(String)req.getAttribute("surprise2");
        System.out.println("Servlet1 logging its output before");
        resp.getWriter().write(text+" "+surprise+" "+surprise2);
    }
}
