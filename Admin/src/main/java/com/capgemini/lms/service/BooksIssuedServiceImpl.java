package com.capgemini.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lms.Dao.BooksDao;
import com.capgemini.lms.Dao.BooksIssuedDao;
import com.capgemini.lms.Dao.UsersDao;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.BooksIssued;
import com.capgemini.lms.entities.Users;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.exception.UserNotFoundException;

@Service
public class BooksIssuedServiceImpl implements BooksIssuedService {
	
	@Autowired
	BooksIssuedDao booksIssuedDao;
	@Autowired
	BooksDao booksDao;
	@Autowired
	UsersDao usersDao;

	@Override
	public BooksIssued addIssuedBook(BooksIssued issued) {
		
		Optional<Books> book=booksDao.findById(issued.getBooks().getBookid());
		Optional<Users> user=usersDao.findById(issued.getUsers().getUserid());
		
		if(!book.isPresent())
			throw new BookNotFoundException();
		else if(!user.isPresent())
			throw new UserNotFoundException();
		else
			return booksIssuedDao.save(issued);
			
	}

	@Override
	public BooksIssued updateIssuedBookDetails(BooksIssued booksIssued) {
		Optional<Books> book=booksDao.findById(booksIssued.getBooks().getBookid());
		Optional<Users> user=usersDao.findById(booksIssued.getUsers().getUserid());
		
		if(!book.isPresent())
			throw new BookNotFoundException();
		else if(!user.isPresent())
			throw new UserNotFoundException();
		else
			return booksIssuedDao.save(booksIssued);
	}

	@Override
	public void deleteIssuedBookS(int bookid) {
		if(booksIssuedDao.existsById(bookid))
		 booksIssuedDao.deleteById(bookid);
		else throw new BookNotFoundException();
	}

	@Override
	public List<BooksIssued> viewBooksIssuedList() {
		return booksIssuedDao.findAll();
	}

}
