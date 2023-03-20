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
		return "Public Content.";
	}
	
	@GetMapping("/prospect")
	@PreAuthorize("hasRole('PROSPECT')")
	public String userAccess() {
		return "Prospect Board.";
	}

	@GetMapping("/resource")
	@PreAuthorize("hasRole('RESOURCE')")
	public String moderatorAccess() {
		return "Resource Board.";
	}

	@GetMapping("/customer")
	@PreAuthorize("hasRole('CUSTOMER')")
	public String adminAccess() {
		return "Customer Board.";
	}
}
