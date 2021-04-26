package com.capgemini.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.lms.entities.BooksIssued;

@Service
public interface BooksIssuedService {
	public BooksIssued addIssuedBook(BooksIssued issued);
	public BooksIssued updateIssuedBookDetails(BooksIssued booksIssued);
	public void deleteIssuedBookS(int bookid);
	public List<BooksIssued> viewBooksIssuedList();
}
