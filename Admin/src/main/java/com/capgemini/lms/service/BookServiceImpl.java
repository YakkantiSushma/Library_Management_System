package com.capgemini.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lms.Dao.BooksDao;
import com.capgemini.lms.entities.Books;

@Service
public class BookServiceImpl implements BookService  {
	 @Autowired
     BooksDao booksdao;
     
     
	@Override
	public Books addBook(Books book) {
		booksdao.save(book);
		return book;
	}

	@Override
	public Books updateBookDetails(Books book) {
		booksdao.save(book);
		return book;
		
	}

	@Override
	public int removeBook(int bookid) {
		booksdao.deleteById(bookid);
		return bookid;
		
	}


	@Override
	public List<Books> viewAllBooks() {
		return booksdao.findAll();
	}


}
