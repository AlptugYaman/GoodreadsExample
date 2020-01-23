package net.GoodReads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.GoodReads.model.Books;

@Repository
public interface BooksRepository  extends JpaRepository<Books, Integer> {

}
