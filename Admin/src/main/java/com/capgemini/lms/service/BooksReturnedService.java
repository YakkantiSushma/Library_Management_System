package com.capgemini.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.lms.entities.BooksReturned;
@Service
public interface BooksReturnedService{
	public BooksReturned returnBooks(BooksReturned returned);
	public BooksReturned updateReturnedBookDetails(BooksReturned booksReturned);
	public List<BooksReturned> viewReturnedBooksList();
	
	
}
