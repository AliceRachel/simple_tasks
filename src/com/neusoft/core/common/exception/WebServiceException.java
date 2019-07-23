package com.neusoft.core.common.exception;

/**
 * @ClassName: WebServiceException
 * @Description: webservice异常类
 */
public class WebServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public WebServiceException() {
		super();
	}

	public WebServiceException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public WebServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public WebServiceException(String message) {
		super(message);
	}

	public WebServiceException(Throwable cause) {
		super(cause);
	}

}
