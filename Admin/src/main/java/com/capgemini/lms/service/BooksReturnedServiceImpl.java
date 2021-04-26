package com.capgemini.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lms.Dao.BooksDao;
import com.capgemini.lms.Dao.BooksReturnedDao;
import com.capgemini.lms.Dao.UsersDao;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.BooksReturned;
import com.capgemini.lms.entities.Users;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.exception.UserNotFoundException;
@Service

public class BooksReturnedServiceImpl implements BooksReturnedService {
	
	@Autowired
	BooksReturnedDao booksReturnedDao;
	@Autowired
	BooksDao booksDao;
	@Autowired
	UsersDao usersDao;

	@Override
	public BooksReturned returnBooks(BooksReturned returned) {
		Optional<Books> book=booksDao.findById(returned.getBooks().getBookid());
		Optional<Users> user=usersDao.findById(returned.getUsers().getUserid());
		
		if(!book.isPresent())
			throw new BookNotFoundException();
		else if(!user.isPresent())
			throw new UserNotFoundException();
		else
			return booksReturnedDao.save(returned);
	}

	@Override
	public BooksReturned updateReturnedBookDetails(BooksReturned booksReturned) {
	
		Optional<Books> book=booksDao.findById(booksReturned.getBooks().getBookid());
		Optional<Users> user=usersDao.findById(booksReturned.getUsers().getUserid());
		
		if(!book.isPresent())
			throw new BookNotFoundException();
		else if(!user.isPresent())
			throw new UserNotFoundException();
		else
			return booksReturnedDao.save(booksReturned);
	}

	@Override
	public List<BooksReturned> viewReturnedBooksList() {
		return booksReturnedDao.findAll();
	}

	
}
