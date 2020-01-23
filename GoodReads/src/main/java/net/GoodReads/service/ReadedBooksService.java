package net.GoodReads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.GoodReads.model.ReadedBooks;
import net.GoodReads.repository.ReadedBooksRepository;

@Service
public class ReadedBooksService {
	@Autowired
	private ReadedBooksRepository ReadedBooksRepository; 
	
	public List<ReadedBooks> listAll(){
		return ReadedBooksRepository.findAll();
	}
	
	public void save(ReadedBooks readedBooks) {
		ReadedBooksRepository.save(readedBooks);
	}

	public List<ReadedBooks> searchBook(String keyword){
		return ReadedBooksRepository.findByName(keyword);
	}
	
//	public List<ReadedBooks> searchReader(String keyword){
//		return ReadedBooksRepository.findWhoRead(keyword);
//	}
}
