package com.capgemini.lms.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Flow.Publisher;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.lms.Dao.AdminDao;
import com.capgemini.lms.Dao.BooksDao;
import com.capgemini.lms.Dao.BooksIssuedDao;
import com.capgemini.lms.Dao.BooksOrderDao;
import com.capgemini.lms.Dao.BooksReturnedDao;
import com.capgemini.lms.Dao.DamagedBooksDao;
import com.capgemini.lms.Dao.FeedbackDao;
import com.capgemini.lms.Dao.PublishersDao;
//import com.capgemini.lms.Dao.SuggestedBooksDao;
import com.capgemini.lms.Dao.UsersDao;
import com.capgemini.lms.entities.Admin;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.BooksOrder;
import com.capgemini.lms.entities.DamagedBooks;
import com.capgemini.lms.entities.Feedback;
import com.capgemini.lms.entities.Publishers;
//import com.capgemini.lms.entities.SuggestedBooks;
import com.capgemini.lms.entities.Users;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.exception.FeedbackNotFoundException;
import com.capgemini.lms.exception.UserNotFoundException;

@Transactional
@Service
public class AdminServiceImpl implements AdminService {
    
	@Autowired
	AdminDao admindao;
	@Autowired
	BooksDao booksdao;
	
	@Autowired
	BooksReturnedDao booksreturneddao;
	
	@Autowired
	BooksIssuedDao booksissueddao;
	
	@Autowired
	PublishersDao publishersdao;
	
	@Autowired
	DamagedBooksDao damagedbooksdao;
	
	@Autowired
	UsersDao usersdao;
	
	@Autowired
	FeedbackDao feedbackdao;
	
	@Autowired
	BooksOrderDao booksorderdao;
	
//	@Autowired
//	SuggestedBooksDao suggestedbooksdao;
//	
//*******************************************************************************************	
	/******************************************************************************************
	 * 
	 * Method: addBooks
	 * Description: This method is used to add books
	 * 
	 * @param addBooks
	 * @return Book
	 * Created date: 20 April 2021
	 * 
	 ********************************************************************************************/

	@Override
	public Books addBook(Books book) {
		booksdao.save(book);
		return book;
	}
    
	/******************************************************************************************
	 * 
	 * Method: updateBookDetails
	 * Description: This method is used to update books
	 * 
	 * @param updateBooks
	 * @return Book
	 * Created date: 20 April 2021
	 * 
	 ********************************************************************************************/

	@Override
	public Books updateBookDetails(Books book) {
		booksdao.save(book);
		return book;
		
	}
    

	/******************************************************************************************
	 * 
	 * Method: removeBook
	 * Description: This method is used to remove books
	 * 
	 * @param removeBooks
	 * @return bookid
	 * Created date: 20 April 2021
	 * 
	 ********************************************************************************************/

	@Override
	public int removeBook(int bookid) {
		booksdao.deleteById(bookid);
		return bookid;
	}
	
	/******************************************************************************************
	 * 
	 * Method: viewAllBooks
	 * Description: This method is used to view all books
	 * 
	 * @param viewBooks
	
	 * Created date: 20 April 2021
	 * 
	 ********************************************************************************************/

	@Override
	public List<Books> viewAllBooks() {
		return booksdao.findAll();
	}
//************************************************************************************************************************************

	/******************************************************************************************
	 * 
	 * Method: addDamagedBooks
	 * Description: This method is used to add damaged books
	 * 
	 * @param addDamagedBooks
	 * @return DamagedBooks
	 * Created date: 20 April 2021
	 * 
	 ********************************************************************************************/
		    
			@Override
			public DamagedBooks addDamagedBooks(DamagedBooks damagedBooks) 
			{
				Optional<Books> book=booksdao.findById(damagedBooks.getBook().getBookid());
				if(!book.isPresent())
					throw new BookNotFoundException();
				else
				    return damagedbooksdao.save(damagedBooks);
			}

			/******************************************************************************************
			 * 
			 * Method: updateDamagedBooks
			 * Description: This method is used to update damaged books
			 * 
			 * @param damagedBooks
			 * @return DamagedBooks
			 * Created date: 18 April 2021
			 * 
			 ********************************************************************************************/
			
			@Transactional(readOnly = true)
			@Override
			public DamagedBooks updateDamagedBookDetails(DamagedBooks damagedBooks) 
			{
				Optional<Books> book=booksdao.findById(damagedBooks.getBook().getBookid());
				if(!book.isPresent())
					throw new BookNotFoundException();
				else
			        return damagedbooksdao.save(damagedBooks);
			  
			}

			/******************************************************************************************
			 * 
			 * Method: viewDamagedBooks
			 * Description: This method is used to view damaged books list
			 * 
			 * @param 
			 * @return List<DamagedBooks>
			 * Created date: 18 April 2021
			 * 
			 ********************************************************************************************/
			@Override
			public List<DamagedBooks> viewDamagedBooksList() {
				
				return damagedbooksdao.findAll();
			}

			/******************************************************************************************
			 * 
			 * Method: viewDamagedBooksById
			 * Description: This method is used to view damaged book when specific id is given
			 * 
			 * @param id
			 * @return DamagedBooks
			 * Created date: 18 April 2021
			 * 
			 ********************************************************************************************/
                @Override
                public DamagedBooks viewDamagedBookById(int id) {			
				return damagedbooksdao.findById(id).get();
			}
//**************************************************************************************************************************************	
                /********************************************************************************
            	 * 
            	 * Method: placeBooksOrder
            	 * Description: This method is used to place books order
            	 * @param BooksOrder 
            	 * @return order
            	 * Created: 20 April 2021
            	 * 
            	 ********************************************************************************/

      
	@Override
	public BooksOrder placeBooksOrder(BooksOrder order) {
		booksorderdao.save(order);
		return order;
	}

	/********************************************************************************
	 * 
	 * Method: cancleBooksOrder
	 * Description: This method is used to cancle books order
	 * @param cancleBooksOrder 
	 * @return orderId
	 * Created: 20 April 2021
	 * 
	 ********************************************************************************/
	
	@Override
	public int cancelOrder(int orderId) {
		booksorderdao.deleteById(orderId);
		return orderId;
	}

	/********************************************************************************
	 * 
	 * Method: updatesOrder
	 * Description: This method is used to update books order
	 * @param updateOrder 
	 * @return order
	 * Created: 20 April 2021
	 * 
	 ********************************************************************************/
	@Override
	public Optional<BooksOrder> updateOrder(BooksOrder order) {
		booksorderdao.save(order);
		return Optional.of(order);
	}

	/********************************************************************************
	 * 
	 * Method: booksOrderList
	 * Description: This method is used to view books order list
	 * @param viewBooksOrderList 
	 * @return void
	 * Created: 20 April 2021
	 * 
	 ********************************************************************************/
	@Override
		public List<BooksOrder> viewOrdersList() {
			return booksorderdao.findAll();
	}

	/********************************************************************************
	 * 
	 * Method: viewOrderById
	 * Description: This method is used to view books order by Id
	 * @param orderId 
	 * @return booksorder
	 * Created: 20 April 2021
	 * 
	 ********************************************************************************/
	
	@Override
	public Optional<BooksOrder> viewOrderById(int orderId) {
		return booksorderdao.findById(orderId);
	}
//***********************************************************************************************************************************
	/********************************************************************************
	 * 
	 * Method: addPublisher
	 * Description: This method adds a new Publisher 
	 * @param publisher
	 * @return Publishers
	 * Created: 20 April 2021
	 * 
	 ********************************************************************************/
	
	@Override
	public Publishers addPublisher(Publishers publisher) {
		publishersdao.save(publisher);
		return publisher;
	}

	/********************************************************************************
	 * 
	 * Method: updatePublisherDetails
	 * Description: This method updates the publisher using Id
	 * @param publisherId
	 * @param publisher
	 * @return void
	 * Created: 20 April 2021
	 * 
	 ********************************************************************************/
	
	@Override
	public Optional<Publishers> updatePublisherDetails(Publishers publisher) {
		publishersdao.save(publisher);
		return Optional.of(publisher);
	}
	/********************************************************************************
	 * 
	 * Method: removePublisher
	 * Description: This method is used to remove the publisher using Id
	 * @param publisherId
	 * @return void
	 * Created: 20 April 2021
	 * 
	 ********************************************************************************/
	@Override
	public void removePublisher(int publisherId) {
		publishersdao.deleteById(publisherId);
	}
	
	/********************************************************************************
	 * 
	 * Method: viewPublishersList
	 * Description: This method returns List of Publishers present in the database
	 * @param publisherId
	 * @return List<Publishers>
	 * Created: 20 April 2021
	 * 
	 ********************************************************************************/
	
	@Override
	public List<Publishers> viewPublishersList() {
		return publishersdao.findAll();
	}

	/********************************************************************************
	 * 
	 * Method: viewPublisherById
	 * Description: This method is used to view the publisher by Id
	 * @param id
	 * @return Publishers
	 * Created: 20 April 2021
	 * 
	 ********************************************************************************/
	
	@Override
	public Optional<Publishers> viewPublisherById(int id) {
		return publishersdao.findById(id);
	}


//	@Override
//	public SuggestedBooks suggestBooks(SuggestedBooks suggestedbooks) {
//		Optional<Books> books=booksdao.findById(suggestedbooks.getBooks().getBookid());
//		if(!books.isPresent())
//			throw new BookNotFoundException();
//		else
//	        return suggestedbooksdao.save(suggestedbooks);
//	}
//
//	@Override
//	public SuggestedBooks updateSuggestedBookStatus(SuggestedBooks suggestedbooks) {
//		Optional<Books> books=booksdao.findById(suggestedbooks.getBooks().getBookid());
//		if(!books.isPresent())
//			throw new BookNotFoundException();
//		else
//		    return suggestedbooksdao.save(suggestedbooks);
//	}
//
//	@Override
//	public void deleteSuggestedBooks(int id) {
//		if(suggestedbooksdao.existsById(id))
//			 suggestedbooksdao.deleteById(id);
//	    else
//           throw new BookNotFoundException();
//	}
//
//	@Override
//	public SuggestedBooks viewSuggestedBookDetails(int id) {
//		if(suggestedbooksdao.existsById(id))
//			return  suggestedbooksdao.findById(id).get();
//		else 
//			throw new BookNotFoundException();
//	}
//
//	@Override
//	public List<SuggestedBooks> viewSuggestedBooksList() {
//		return suggestedbooksdao.findAll();
//	}

	@Override
	public Feedback writeFeedback(int userid, Feedback feedback) {
		if(usersdao.existsById(userid)) {
			Users users = usersdao.findById(userid).get();
			feedback.setUser(users);
			return feedbackdao.save(feedback);
		} else throw new UserNotFoundException();
	}
	
	@Override
	public void updateFeedbackbyId(int id, Feedback feedback) {
		if(feedbackdao.existsById(id)) {
			feedback.setId(id);
			feedbackdao.save(feedback);
		} else throw new FeedbackNotFoundException();
	}
	
	@Override
	public List<Feedback> viewFeedbackList() {
		return feedbackdao.findAll();
	}

	@Override
	public Feedback viewFeedBackByUser(int userid) {
		if(usersdao.existsById(userid)) {
			Users user = usersdao.findById(userid).get();
			return feedbackdao.findByUser(user);
		}else throw new UserNotFoundException();
	
	}
}	
	

