package com.communication.call;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

@SpringBootApplication
@RestController
public class CallTwiMlApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CallTwiMlApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CallTwiMlApplication.class, args);
	}
	
	@PostMapping(value="voice", produces= {MediaType.APPLICATION_XML_VALUE})
	public String getTwiMLData(@RequestBody ObjectNode objNode) {
		LOGGER.info("initiate Restart");
		String message = objNode.get("message").asText();
		String twiMlMessage = 
				"<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?> \n" +
				"<Response>\n" + 
				"<Say voice=\"alice\">"+message+"</Say>\n" + 
				"</Response>";
		return twiMlMessage;
	}
	

}
