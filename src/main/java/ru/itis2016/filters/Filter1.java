package ru.itis2016.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by eljah32 on 9/29/2016.
 */
public class Filter1  implements Filter {

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

          //  ((HttpServletRequest) request).getServletContext().getRequestDispatcher("/login.jsp").forward(httpRequest, httpResponse);
        System.out.println("Filter1 logging its output before");
        httpRequest.setAttribute("surprise",new String("Surprise From Filter1!"));
        chain.doFilter(request, response);
        System.out.println("Filter1 logging its output after");
    }
}
