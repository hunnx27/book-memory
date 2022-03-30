package com.twodollar.bookmemory;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class BookMemoryApplication {

	@GetMapping("/")
	String home() {
		return "Spring is here!";
	}

	@Autowired
	Environment environment;

	@GetMapping("/info")
	String testConnection(){

		String ip = "0.0.0.0";

		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		return ip + ":"+environment.getProperty("local.server.port");      
	}

	public static void main(String[] args) {
		SpringApplication.run(BookMemoryApplication.class, args);
	}
}