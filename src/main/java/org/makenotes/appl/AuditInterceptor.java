package org.makenotes.appl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuditInterceptor extends HandlerInterceptorAdapter {
	private final static Logger LOG = LoggerFactory.getLogger(AuditInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LOG.debug("Request received [{}]", request);
		return true;
	}
}
