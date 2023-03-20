package com.bridge.sme.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content";
	}
	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String userAccess() {
		return "Amin Dashboard";
	}

	@GetMapping("/receptionist")
	@PreAuthorize("hasRole('ADMIN') or hasRole('RECEPTIONIST')")
	public String moderatorAccess() {
		return "Receptionist Dashboard";
	}
}
