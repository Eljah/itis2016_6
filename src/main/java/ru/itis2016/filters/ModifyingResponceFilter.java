package ru.itis2016.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by eljah32 on 9/29/2016.
 */

@WebFilter(filterName = "filter5", urlPatterns = {"/filter5"})
public class ModifyingResponceFilter implements Filter {

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

        CharResponseWrapper wrappedResponse = new CharResponseWrapper(
                (HttpServletResponse)response);

        System.out.println("Modifying filter logging its output before");
        chain.doFilter(new FilteredRequest(request), wrappedResponse);
        System.out.println("Modifying logging its output after");
       String out=wrappedResponse.toString();

            System.out.println("Modifying...");
            // DO YOUR REPLACEMENTS HERE
            out = out+" Modifiied";
            response.getOutputStream().write(out.getBytes());

        System.out.println("Modifying done");
    }

}

class FilteredRequest extends HttpServletRequestWrapper {

    /* These are the characters allowed by the Javascript validation */
    static String allowedChars = "+-0123456789#*";

    public FilteredRequest(ServletRequest request) {
        super((HttpServletRequest) request);
    }

    public String sanitize(String input) {
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            if (allowedChars.indexOf(input.charAt(i)) >= 0) {
                result += input.charAt(i);
            }
        }
        System.out.println("Sanizing...");
        return result;
    }

    public String getParameter(String paramName) {
        String value = super.getParameter(paramName);
        if ("echo".equals(paramName)) {
            value = sanitize(value);
        }
        System.out.println("Getting request parameter...");
        return value;
    }

    public String[] getParameterValues(String paramName) {
        String values[] = super.getParameterValues(paramName);
        if ("echo".equals(paramName)) {
            for (int index = 0; index < values.length; index++) {
                values[index] = sanitize(values[index]);
            }
        }
        System.out.println("Getting parameter values");
        return values;
    }
}


class CharResponseWrapper extends HttpServletResponseWrapper {
    private CharArrayWriter output;

    public String toString() {
        return output.toString();
    }

    public CharResponseWrapper(HttpServletResponse response) {
        super(response);
        output = new CharArrayWriter();
    }

    public PrintWriter getWriter() {
        return new PrintWriter(output);
    }
}
