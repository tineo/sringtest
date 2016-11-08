package com.horarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;

@Controller
@SpringBootApplication
public class DemoApplication {

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "<input type='submit' value='meow' /><p>c</p><p>d</p><b><span>a</span><span>b</span></b>";
	}

	@RequestMapping(value="/cosa", method=RequestMethod.GET)
	@ResponseBody
	ArrayList<Elemento> porget(@RequestParam(value="p", defaultValue = "no hay nada") String param ) {
		ArrayList<Elemento> lista = new ArrayList<>();
		for( int i = 0; i < param.length(); i++ ){
			lista.add(new Elemento(i, String.valueOf( param.charAt(i) )));
		}
		return lista;
	}

	@RequestMapping(value="/cosa", method=RequestMethod.POST)
	@ResponseBody
	String otro() {
		return "Hola cosa post!";
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView login(ModelAndView mv) {
		//mv.addObject("currentDate", new Date());
		//mv.addObject("writers", writer.getWriters());

		mv.setViewName("login");
		return mv;
	}

	@RequestMapping(value="/master", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView master(ModelAndView mv) {
		//mv.addObject("currentDate", new Date());
		//mv.addObject("writers", writer.getWriters());

		mv.setViewName("master");
		return mv;
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}