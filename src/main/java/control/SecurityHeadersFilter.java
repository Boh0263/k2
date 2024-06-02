package control;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityHeadersFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (response instanceof HttpServletResponse) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            
            httpResponse.setHeader("Content-Security-Policy", "default-src 'self'; script-src 'self' 'unsafe-inline' https://code.jquery.com/jquery-3.2.1.js; object-src 'none'; frame-ancestors 'none';font-src 'self' https://fonts.gstatic.com/s/poppins/v21/ https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/webfonts/ ; style-src 'self' 'unsafe-inline' https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css https://fonts.googleapis.com/css2");
            httpResponse.setHeader("X-Frame-Options", "DENY");
        }

        // Proceed with the next filter or the target resource
        chain.doFilter(request, response);
    }

    public void destroy() {
        // Cleanup code, if needed
    }
} 
