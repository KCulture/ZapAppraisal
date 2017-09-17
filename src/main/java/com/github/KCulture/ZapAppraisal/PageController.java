package com.github.KCulture.ZapAppraisal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/self")
public class PageController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ResponderRepository responderRepository;

	@RequestMapping(value = "/appraisal/{id}")
	public String appraisals(@PathVariable String id,
	    @ModelAttribute("model") ModelMap model) {
		Employee employee = employeeRepository.findOne(id);
		if (employee != null)
			model.addAttribute("employee", employee);
		// might need to do something for error like error page

		if (employee.contacts != null) {
			for (int i = 1; i <= employee.contacts.size(); i++) {
				model.addAttribute("contact".concat(String.valueOf(i)),
				    employee.contacts.get(i - 1));
			}
		}

		return "employeeForm";
	}

	@RequestMapping(value = "/responder/{id}")
	public String responders(@PathVariable String id,
	    @ModelAttribute("model") ModelMap model) {
		Responder responder = responderRepository.findOne(id);
		if (responder != null)
			model.addAttribute("responder", responder);
		// might need to do something for error like error page

		return "respondersForm";
	}

}
