package rmontag.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CSPFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, 
                         FilterChain chain) throws IOException, ServletException {

        HttpServletResponse httpResponse = (HttpServletResponse) response;
        //httpResponse.setHeader("Content-Security-Policy", "default-src 'self'");
        httpResponse.setHeader("X-Content-Security-Policy", "default-src 'self'");

        // Content-Security-Policy: default-src 'none'; script-src 'self'; img-src 'self'; style-src 'self'; object-src 'none'; media-src 'none'; frame-src 'none'; font-src 'none'; connect-src 'none';
        httpResponse.setHeader("Content-Security-Policy", "default-src 'none'; script-src 'self'; img-src 'self'; style-src 'self'; object-src 'none'; media-src 'none'; frame-src 'none'; font-src 'none'; connect-src 'none';");
        
        //httpResponse.setHeader("Content-Security-Policy-Report-Only", "default-src 'self'; script-src 'self' 'unsafe-inline'; object-src 'none'; style-src 'self' 'unsafe-inline'; img-src 'self'; media-src 'none'; frame-src 'none'; font-src 'self'; connect-src 'self'; report-uri REDACTED");
        //httpResponse.setHeader("X-Content-Security-Policy-Report-Only", "default-src 'self'; script-src 'self' 'unsafe-inline'; object-src 'none'; style-src 'self' 'unsafe-inline'; img-src 'self'; media-src 'none'; frame-src 'none'; font-src 'self'; connect-src 'self'; report-uri REDACTED");
      
        chain.doFilter(request, response);
    }

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {
	}
}
