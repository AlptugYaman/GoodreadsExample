package net.GoodReads.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.GoodReads.model.Books;
import net.GoodReads.model.ReadedBooks;
import net.GoodReads.model.Users;
import net.GoodReads.service.BooksService;
import net.GoodReads.service.ReadedBooksService;
import net.GoodReads.service.UsersService;

@Controller
public class ReadedBooksController {
	@Autowired
	private ReadedBooksService readedBooksService;

	@Autowired
	private BooksService booksService;
	
	@Autowired
	private UsersService usersService;
	
	
	@RequestMapping("/addReadedBook")
	public String ddbBooks(Model model) {
		List<Books> listBooks = booksService.listAll();
		model.addAttribute("listBooks", listBooks);
		
		List<Users> listUsers = usersService.listAll();
		model.addAttribute("listUsers", listUsers);

		ReadedBooks readedBooks = new ReadedBooks();
		model.addAttribute("readedBook", readedBooks);
		return "addReadedBook";
	}

	@RequestMapping(value = "/saveReadedBook", method = RequestMethod.POST)
	public String saveReadedBook(@ModelAttribute("readedBook") ReadedBooks readedBooks) {
		readedBooksService.save(readedBooks);

		return "redirect:/addReadedBook";
	}
	
	@RequestMapping("/searchBook")
	public ModelAndView search(@RequestParam String keyword) {
		ModelAndView mav = new ModelAndView("searchBook");
		List<ReadedBooks> result = readedBooksService.searchBook(keyword);
		mav.addObject("result", result);

		return mav;
	}
	
//	@RequestMapping("/searchWhoRead")
//	public ModelAndView searchWhoRead(@RequestParam String keyword) {
//		ModelAndView mav = new ModelAndView("searchWhoRead");
//		List<ReadedBooks> result = readedBooksService.searchReader(keyword);
//		mav.addObject("result", result);
//
//		return mav;
//	}

}
