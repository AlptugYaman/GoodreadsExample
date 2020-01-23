package net.GoodReads.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.GoodReads.model.Users;
import net.GoodReads.service.UsersService;

@Controller
public class UserController {
	@Autowired
	private UsersService usersService;

	@RequestMapping("/users")
	public String viewHomePage(Model model) {
		List<Users> listUsers = usersService.listAll();
		model.addAttribute("listUsers", listUsers);

		return "users";
	}

	@RequestMapping("/newUser")
	public String showNewUserForm(Model model) {
		Users user = new Users();
		model.addAttribute("user", user);

		return "newUser";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") Users user) {
		usersService.save(user);

		return "redirect:/users";
	}

	@RequestMapping("/searchUser")
	public ModelAndView search(@RequestParam String keyword) {
		ModelAndView mav = new ModelAndView("searchUser");
		List<Users> result = usersService.searchUser(keyword);
		mav.addObject("result", result);

		return mav;
	}

	@RequestMapping("/details/{id}")
	public ModelAndView userDetails(@PathVariable(name = "id") Integer id) {
		ModelAndView mav = new ModelAndView("details");

		Users user = usersService.get(id);
		mav.addObject("user", user);

		return mav;
	}

}
