package chap09;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
	@GetMapping("/hello")
	public String hello(Model model, @RequestParam(value = "name", required = false) String name) {
		model.addAttribute("greeting", "æ»≥Á«œººø‰, "+name);
		return "hello";
	}
	@GetMapping("/hello2")
	public String hello2(Model model, @RequestParam(value = "name", required = false) String name, 
			@RequestParam(value = "name2", required = false) String name2) {
		model.addAttribute("goodbye", name + " " + name2);
		return "bye";
	}
}
