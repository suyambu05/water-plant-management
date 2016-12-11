package org.v3.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.v3.webobjects.LoginRequest;
import org.v3.webobjects.LoginResponse;

/**
 * @author Dineshkumar
 * 
 */
@RestController
@RequestMapping("/wpm-services")
public class WPMController {

	/**
	 * Login Operation
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public LoginResponse login(@RequestBody LoginRequest loginRequest) {

		LoginResponse loginResponse = new LoginResponse();
		if (loginRequest.getUserName().equals("dinesh")
				&& loginRequest.getPassword().equals("kumar")) {
			loginResponse.setReturnValue(Boolean.TRUE);
		}else{
			loginResponse.setReturnValue(Boolean.FALSE);
		}
		return loginResponse;
	}
}
