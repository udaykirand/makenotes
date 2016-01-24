package org.makenotes.appl.controller;

import org.makenotes.appl.model.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;


@ControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result fieldValidation(Exception exception)
			throws JsonProcessingException {
		return new Result("failure", exception.getMessage(), null);
	}
	
}
