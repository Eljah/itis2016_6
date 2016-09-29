package ru.itis2016.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by eljah32 on 9/29/2016.
 */
@WebFilter(filterName = "filter2",urlPatterns = {"/filter","/users","/users/*","/excursionPlans","/excursionTrips","/deleteExcursion"})
public class Filter2  implements Filter {

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
        String surprise="Initially empty surpise";
        if (((HttpServletRequest) request).getAttribute("surprise") != null) {
            surprise=(String)((HttpServletRequest) request).getAttribute("surprise");
        }
        System.out.println("Filter2 logging its output before");
        System.out.println("Surprise attribute value: "+surprise);
        request.setAttribute("surprise2",new String("Surprise from filter2"));
        chain.doFilter(request, response);
        System.out.println("Filter2 logging its output after");

    }
}
