package com.prowings.interceptor;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingRequestWrapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class LoggingInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		log.info(">>>>>>>>>>>>> Pre Handle method is Calling");
		if (!(request instanceof ContentCachingRequestWrapper)) {
			request = new ContentCachingRequestWrapper(request); // Wrap request
		}

		log.info("📥 Incoming Request: " + request.getMethod() + " " + request.getRequestURI());

		// Read Request Body (Only for POST/PUT)
		if ("POST".equalsIgnoreCase(request.getMethod()) || "PUT".equalsIgnoreCase(request.getMethod())) {
			String requestBody = getRequestBody((ContentCachingRequestWrapper) request);
			log.info("Request Body: " + requestBody);
		}

		return true;
	}

	private String getRequestBody(ContentCachingRequestWrapper request) {
        request.getParameterMap(); // Force request to cache body
        byte[] content = request.getContentAsByteArray();
        return content.length > 0 ? new String(content, StandardCharsets.UTF_8) : "";
    }
}
