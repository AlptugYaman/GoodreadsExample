package net.GoodReads.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.GoodReads.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

	@Query(value = "SELECT * FROM users u WHERE u.name = :keyword", nativeQuery = true)
	public List<Users> findByNameOrSurname(@Param("keyword") String keyword);
	
	
	
}
