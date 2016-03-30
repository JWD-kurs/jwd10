package jwd.wafepa.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("title", "Home");
		return "home";
	}
}
