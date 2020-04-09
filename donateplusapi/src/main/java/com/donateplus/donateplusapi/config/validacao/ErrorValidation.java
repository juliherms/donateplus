package com.donateplus.donateplusapi.config.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * This class responsible to intercept exception handler
 * 
 * @author j.a.vasconcelos
 *
 */
@RestControllerAdvice
public class ErrorValidation {

	@Autowired
	private MessageSource messageSource;

	/**
	 * Responsible to check error, return default BAD REQUEST
	 * 
	 * @param exception
	 */
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErrorMessage> handle(MethodArgumentNotValidException exception) {

		List<ErrorMessage> dtoErrors = new ArrayList<>();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

		fieldErrors.forEach(e -> {
			//capture context locale
			String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErrorMessage error = new ErrorMessage(e.getField(), message);
			dtoErrors.add(error);
		});

		return dtoErrors;
	}

}
