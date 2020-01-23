package net.GoodReads.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.GoodReads.model.ReadedBooks;

@Repository
public interface ReadedBooksRepository extends JpaRepository<ReadedBooks, Integer> {

	@Query(value = "select b.*,u.*,rb.*, count(b.name) as count, avg(rb.rate) as avgrate "
			+ "from readed_books as rb, users as u, books as b "
			+ "where rb.user_id = u.id and rb.book_id = b.id and b.name =:keyword", nativeQuery = true)
	public List<ReadedBooks> findByName(@Param("keyword") String keyword);
//
//	@Query(value = "select b.*,u.name as user_name,u.surname,rb.*, count(b.name) as count, avg(rb.rate) as avgrate from readed_books as rb, users as u, books as b "
//			+ "where rb.user_id = u.id and rb.book_id = b.id and b.name =:keyword", nativeQuery = true)
//	public List<ReadedBooks> findWhoRead(@Param("keyword") String keyword);

}
