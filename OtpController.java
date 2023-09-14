package com.otp.generation.Controller;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.otp.generation.Service.OtpService;
import com.otp.generation.model.OtpRequest;



@RestController
public class OtpController {
	
	@Autowired
	private OtpService otpservice;
	
	@PostMapping("/send-otp")
	private ResponseEntity<String> sendOtp(@RequestBody OtpRequest otpRequest)
	{
		String mobileNumber = otpRequest.getMobileNumber();
		
		//String otp = generateRandomOtp();
		
		String otp =" Your bank account has debited Rs. 25000 only";
		
		otpservice.sendOtp(mobileNumber, otp);
		return ResponseEntity.ok("Otp sent successfully");
		
	}
	
	

	private String generateRandomOtp()
	{
		String characters = "0123456789";
		int otpLength = 4;
		
		SecureRandom secure = new SecureRandom();
		StringBuilder generatedOtp = new StringBuilder();
		
		for(int i = 0; i < otpLength; i ++)
		{
			int randomIndex = secure.nextInt(characters.length());
			char randomChar = characters.charAt(randomIndex);
			generatedOtp.append(randomChar);
			
		}
		
			return generatedOtp.toString();
	}


}



