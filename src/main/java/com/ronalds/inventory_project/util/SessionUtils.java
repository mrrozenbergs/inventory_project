package com.ronalds.inventory_project.util;

import javax.servlet.http.HttpServletRequest;

public class SessionUtils {

	@SuppressWarnings("unchecked")
	public static <T> T getSessionVariables(HttpServletRequest request, String value) {
		return (T) request.getSession().getAttribute(value);
	}

	public static <T> void setSessionVariables(T obj, HttpServletRequest request,
			String value) {
		request.getSession().setAttribute(value, obj);
	}
}
