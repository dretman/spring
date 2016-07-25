package com.dataart.retman.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Duplicate message")
public class DublicateSpittleMessageException extends Exception {

}
