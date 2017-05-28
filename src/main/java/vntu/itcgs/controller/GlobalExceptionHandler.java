package vntu.itcgs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Exception> defaultErrorHandler(Exception e) {
		logger.error("Exception handler executed, error: ", e);
		return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
