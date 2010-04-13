package hr.wds.web.kontakt;

import hr.wds.model.Kontakt;
import hr.wds.utils.ValidationUtils;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/kontakt.html")
public class KontaktController {

	private final static String ODUSTANI = "Odustani";
	private final static String FORM_VIEW = "kontakt/kontakt";
	private final static String CANCEL_VIEW = "main";

	private MailSender mailSender;
	private SimpleMailMessage simpleMailMessage;

	@ModelAttribute("kontakt")
	public Kontakt createModel() {
		return new Kontakt();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		return FORM_VIEW;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitFrom(@RequestParam("button") String button, Model model, @ModelAttribute("kontakt") Kontakt kontakt, BindingResult result) {

		if (ODUSTANI.equals(button)) {
			return CANCEL_VIEW;
		}

		if (StringUtils.isBlank(kontakt.getKontaktOsoba()) || StringUtils.isBlank(kontakt.getKontaktOsoba()) || StringUtils.isBlank(kontakt.getKontaktOsoba())) {
			result.reject("obavezan.unos");
			return FORM_VIEW;
		}

		if (!ValidationUtils.isValidEmailAdress(kontakt.getEmail().trim())) {
			result.reject("email.format");
			return FORM_VIEW;
		}

		// email
		SimpleMailMessage msg = new SimpleMailMessage(this.simpleMailMessage);
		msg.setTo(kontakt.getKontaktOsoba());
		msg.setText("Poruka: " + StringUtils.trim(kontakt.getTekstPoruke()) + "\n" + "Email stigao od: " + kontakt.getEmail());

		try {

			this.mailSender.send(msg);
			model.addAttribute("poruka", "Uspješno ste poslali email poruku");
			model.addAttribute("kontakt", createModel());
			return FORM_VIEW;

		} catch (MailException e) {
			System.out.println(e.getMessage());
		}

		result.reject("pogreska.email");
		return FORM_VIEW;

	}

	@Autowired
	@Required
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Autowired
	@Required
	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}
}
