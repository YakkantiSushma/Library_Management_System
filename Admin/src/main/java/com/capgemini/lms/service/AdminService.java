package com.capgemini.lms.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Flow.Publisher;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import com.capgemini.lms.entities.Admin;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.BooksOrder;
import com.capgemini.lms.entities.DamagedBooks;
import com.capgemini.lms.entities.Feedback;
import com.capgemini.lms.entities.Publishers;
//import com.capgemini.lms.entities.SuggestedBooks;
import com.capgemini.lms.entities.Users;

@Service
public interface AdminService {

	public Books addBook(Books book);
	public Books updateBookDetails(Books book);
	public int removeBook(int bookid);
//  public List<Books> searchBookByTitle(String keyword);
//	public List<Books> searchBookBySubject(String keyword);
    public List<Books> viewAllBooks();

	
	
	
	public BooksOrder placeBooksOrder(BooksOrder order);
	public int cancelOrder(int orderId);
	public Optional<BooksOrder> updateOrder(BooksOrder order);
	public List<BooksOrder> viewOrdersList();
	public Optional<BooksOrder> viewOrderById(int orderId);
	
	
	
		public Publishers addPublisher(Publishers publisher);
		public Optional<Publishers> updatePublisherDetails(Publishers publisher);
		public void removePublisher(int publisherId);
		public List<Publishers> viewPublishersList();
		public Optional<Publishers> viewPublisherById(int id);
		
		
		public DamagedBooks addDamagedBooks(DamagedBooks damagedBooks);
		public DamagedBooks updateDamagedBookDetails(DamagedBooks books);
		public List<DamagedBooks> viewDamagedBooksList();
		public DamagedBooks viewDamagedBookById(int id);
		
		
//		public SuggestedBooks suggestBooks(SuggestedBooks book); 
//		public SuggestedBooks updateSuggestedBookStatus(SuggestedBooks suggestedbooks);
//		public void deleteSuggestedBooks(int id);
//		public SuggestedBooks viewSuggestedBookDetails(int id);
//		public List<SuggestedBooks> viewSuggestedBooksList();
//		
		public Feedback writeFeedback(int userid, Feedback feedback);
		public void updateFeedbackbyId(int id, Feedback feedback); 
		public List<Feedback> viewFeedbackList();
		public Feedback viewFeedBackByUser(int userid);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


	
	
	
