package hr.wds.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	private static final String MAIN_VIEW = "main";
	@RequestMapping(value = "/main.html", method = RequestMethod.GET)
    public String setupForm() {
        return MAIN_VIEW;
    }
}
