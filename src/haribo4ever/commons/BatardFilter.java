package haribo4ever.commons;

import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.apachecommons.CommonsLog;

//@WebFilter(filterName = "batardFilter", urlPatterns = "/*")
@CommonsLog
public class BatardFilter implements Filter {

	private Lock locker = new ReentrantLock();

	private boolean flag;

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {

		try {
			locker.lock();

			if (flag) {
				log.info("Propagation de la requête");
				arg2.doFilter(arg0, arg1);
			} else {
				log.info("Je bloque la requête");
				((HttpServletResponse) arg1).sendError(418);
			}

			// inversion threadsafe de l'état partagé
			flag = !flag;

		} finally {

			locker.unlock();
		}

	}

}
