package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;

@Controller
@SpringBootApplication
public class DemoApplication {

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hola prros!";
	}

	@RequestMapping(value="/cosa", method=RequestMethod.GET)
	@ResponseBody
	String porget(@RequestParam(value="p", defaultValue = "no hay nada") String param ) {
		return "Obtuve : "+param;
	}

	@RequestMapping(value="/cosa", method=RequestMethod.POST)
	@ResponseBody
	String otro() {
		return "Hola cosa post!";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}