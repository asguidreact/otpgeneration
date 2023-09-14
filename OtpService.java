package com.otp.generation.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class OtpService {
	
	  @Value("${twilio.account.sid}")
	    private String twilioAccountSid;

	    @Value("${twilio.auth.token}")
	    private String twilioAuthToken;

	    @Value("${twilio.phone.number}")
	    private String twilioPhoneNumber;
	    
	    
	public void sendOtp(String mobileNumber , String otp)
	{
		Twilio.init(twilioAccountSid, twilioAuthToken);
		
		Message message = Message.creator(new PhoneNumber(mobileNumber), 
				
				new PhoneNumber(twilioPhoneNumber), 
				"Your otp is" + otp).create();
		
		
		System.out.println("OTP sent: " + message.getSid());

	
	}	

}
