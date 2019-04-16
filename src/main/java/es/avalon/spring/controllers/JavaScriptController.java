package es.avalon.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/javascript")
public class JavaScriptController {
	
	@RequestMapping("/lista")
	public String lista() {
		
		
		return "javascript/lista";
	}
 
}
