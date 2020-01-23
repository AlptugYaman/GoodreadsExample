package net.GoodReads.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.GoodReads.model.Books;
import net.GoodReads.model.ReadedBooks;
import net.GoodReads.model.Users;
import net.GoodReads.service.BooksService;
import net.GoodReads.service.UsersService;

@Controller
public class BooksController<BooksServicervice> {
	@Autowired
	private BooksService booksService;
	
	
	@RequestMapping("/books")
	public String viewBooksPage(Model model) {
		List<Books> listBooks = booksService.listAll();
		model.addAttribute("listBooks", listBooks);
		
		return "books";
	}	


	@RequestMapping("/newBook")
	public String showNewUserForm(Model model) {
		Books book = new Books();
		model.addAttribute("book", book);

		return "newBook";
	}

	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute("readedBook") Books book) {
		booksService.save(book);

		return "redirect:/books";
	}
}
