package com.bridge.sme.controller;

import com.bridge.sme.config.jwt.JwtUtils;
import com.bridge.sme.entity.ERole;
import com.bridge.sme.entity.Role;
import com.bridge.sme.entity.User;
import com.bridge.sme.payload.request.LoginRequest;
import com.bridge.sme.payload.request.SignupRequest;
import com.bridge.sme.payload.response.JwtResponse;
import com.bridge.sme.payload.response.MessageResponse;
import com.bridge.sme.repository.RoleRepository;
import com.bridge.sme.repository.UserRepository;
import com.bridge.sme.service.UserDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt,
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<MessageResponse> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(),
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));

		String strRole = signUpRequest.getRole();
		String role;

		if (strRole == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_RECEPTIONIST)
					.orElseThrow(() -> new RuntimeException("Error: Prospect Role is not found."));
			user.setRole(userRole);
		} else {
			switch (strRole) {
				case "ADMIN":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Customer Role is not found."));
					user.setRole(adminRole);
					break;
				case "RECEPTIONIST":
					Role receptionistRole = roleRepository.findByName(ERole.ROLE_RECEPTIONIST)
							.orElseThrow(() -> new RuntimeException("Error: Resource Role is not found."));
					user.setRole(receptionistRole);
					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_RECEPTIONIST)
							.orElseThrow(() -> new RuntimeException("Error: No Role found."));
					user.setRole(userRole);
				}
		}

		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
