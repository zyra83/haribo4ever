package haribo4ever.commons;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.apachecommons.CommonsLog;

@WebFilter(filterName = "chronoFilter", urlPatterns = "*.xhtml")
@CommonsLog
public class ChronoFilter implements Filter {
	
	/**
	 * /!\ /!\ /!\ /!\ /!\ /!\ /!\ /!\ /!\ /!\ /!\ /!\ /!\ /!\ 
	 * Cette map est partagée donc mef aux accès concurrents.
	 * Il y a une seule instance du filter.
	 * /!\ /!\ /!\ /!\ /!\ /!\ /!\ /!\ /!\ /!\ /!\ /!\ /!\ /!\  
	 */
	private Map <String, Long> stats = Collections.synchronizedMap(new HashMap<String, Long>());
	
	// autre soluce
	//private ConcurrentHashMap<K, V>
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		Chronometre.start();
		arg2.doFilter(arg0, arg1);
		Chronometre.stop();
		log.info(String.format("Requête %s (%sms)%n", ((HttpServletRequest)arg0).getRequestURI(), Chronometre.getTemps()));
	}

}
