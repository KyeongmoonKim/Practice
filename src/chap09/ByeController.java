package chap09;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ByeController {
	@GetMapping("/bye")
	public String bye(Model model, @RequestParam(value = "name", required = false) String name) {
		model.addAttribute("goodbye", "bye, "+name);
		return "bye";
	}
}
