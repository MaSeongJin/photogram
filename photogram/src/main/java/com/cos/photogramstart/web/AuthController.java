package com.cos.photogramstart.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDTO;

//import ch.qos.logback.classic.Logger;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final 필드를 DI할 때 사용
@Controller // 1. IoC 2. 파일을 리턴하는 컨트롤러
public class AuthController {

//	private static final Logger log = (Logger) LoggerFactory.getLogger(AuthController.class);

	private final AuthService authService;

	@GetMapping("/auth/signin")
	public String signinForm() {
		return "auth/signin";
	}

	@GetMapping("/auth/signup")
	public String signupForm() {
		return "auth/signup";
	}

	// 회원가입버튼 -> /auth/signup -> /auth/signin
	@PostMapping("/auth/signup")
	public String signup(@Valid SignupDTO signupDTO, BindingResult bindingResult) { // key=value(x-www-form-urlencoded)
		// log.info(signupDTO.toString());
		// User -> SignupDTO

		User user = signupDTO.toEntity();
		// log.info(user.toString());
		User userEntity = authService.join(user);
		System.out.println(userEntity);
		return "auth/signin";

	}

}
