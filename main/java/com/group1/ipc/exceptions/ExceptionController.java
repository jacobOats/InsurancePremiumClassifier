package com.group1.ipc.exceptions;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("test")
@RequestMapping("/exceptions")
public class ExceptionController {

	@GetMapping("/exception")
	public void throws_exception() throws Exception {
		throw new Exception();
	}
	
}
