package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet Filter implementation class ExecutionModeFilter
 */
@WebFilter("/ExecutionModeFilter")
public class ExecutionModeFilter implements Filter {
	 private static final Logger logger = LogManager.getLogger(ExecutionModeFilter.class);
	 private static boolean maintenance = true;

    /**
     * Default constructor. 
     */
    public ExecutionModeFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		  HttpServletRequest req = (HttpServletRequest)request;
		  HttpServletResponse res = (HttpServletResponse)response;
		  logger.error("request=" + request);

		  if (maintenance && req.getRequestURI().indexOf("maintenance.html") < 0) {
		   res.sendRedirect("maintenance.html");
		  } else {
		   // pass the request along the filter chain
		   chain.doFilter(request, response);
		  }
	}

	 public static boolean isMaintenance() {
	  return maintenance;
	 }

	 public static void setMaintenance(boolean maintenance) {
	  ExecutionModeFilter.maintenance = maintenance;
	 }
		
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
