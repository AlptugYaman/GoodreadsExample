package net.GoodReads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.GoodReads.model.Users;
import net.GoodReads.repository.UsersRepository;

@Service
public class UsersService {
	@Autowired
	private UsersRepository UsersRepository;

	public List<Users> listAll() {
		return UsersRepository.findAll();
	}

	public void save(Users user) {
		UsersRepository.save(user);
	}

	public Users get(Integer id) {
		return UsersRepository.findById(id).get();
	}

	public List<Users> searchUser(String keyword) {
		return UsersRepository.findByNameOrSurname(keyword);
	}

}
