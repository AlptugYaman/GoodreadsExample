package net.GoodReads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.GoodReads.model.Books;
import net.GoodReads.repository.BooksRepository;


@Service
public class BooksService {
	@Autowired
	private BooksRepository BooksRepository;

	public List<Books> listAll(){
		return BooksRepository.findAll();
	}
	
	public void save(Books books) {
		BooksRepository.save(books);
	}
	
	public Books get(Integer id) {
		return BooksRepository.findById(id).get();
	}
}
