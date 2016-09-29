package ru.itis2016.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by eljah32 on 9/29/2016.
 */
//@WebFilter(filterName = "filter3",urlPatterns = {"/filter3"})
public class DispatchingFilter   implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        System.out.println("Dispatching filter logging its output before");
        ((HttpServletRequest) request).getServletContext().getRequestDispatcher("/test").forward(httpRequest, httpResponse);
        //chain.doFilter(request, response);
        System.out.println("Dispatching filter logging its output after");

    }
}