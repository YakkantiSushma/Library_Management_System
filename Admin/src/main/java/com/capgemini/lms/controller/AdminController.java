package com.capgemini.lms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.capgemini.lms.dto.SuggestedBooksDto;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.BooksOrder;
import com.capgemini.lms.entities.DamagedBooks;
import com.capgemini.lms.entities.Feedback;
import com.capgemini.lms.entities.Publishers;
//import com.capgemini.lms.entities.SuggestedBooks;
import com.capgemini.lms.entities.Users;
import com.capgemini.lms.exception.BookNotFoundException;

import com.capgemini.lms.exception.OrderNotFoundException;
import com.capgemini.lms.exception.PublisherNotFoundException;
import com.capgemini.lms.exception.UserNotFoundException;
import com.capgemini.lms.exception.ValidationException;
import com.capgemini.lms.service.AdminService;
import com.capgemini.lms.service.BooksOrderService;
import com.capgemini.lms.service.FeedbackServiceI;
import com.capgemini.lms.service.PublisherServiceI;
//import com.capgemini.lms.service.SuggestedBooksService;
import com.capgemini.lms.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api("Admin Controller")
@CrossOrigin
@RestController
@RequestMapping("/book")
public class AdminController {
	@Autowired
	AdminService booksService;
	
	@Autowired
	BooksOrderService booksOrderService;
	
	@Autowired
	PublisherServiceI publisherService;
	
	@Autowired
	FeedbackServiceI feedbackService;
	
	
//	@Autowired
//	SuggestedBooksService suggestedBooksService;
//	
	@Autowired
	UserService userService;
//**********************************************************************************************************************	
	/*********************************************************************
	 * 
	 * Method : Books
	 * Description: This class is used to add,modify,delete and view Books
	 * @parse BooksIssued
	 * @return ResponseEntity<String>
	 * Created date: 20 April 2021
	 * 
	 *********************************************************************/
	
	
	@ApiOperation(value ="AddBooks")
	@PostMapping(value ="/AddBooks",consumes="application/json")
	public ResponseEntity<HttpStatus> addBooks(@RequestBody Books books){
		booksService.addBook(books);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		
	}

	@ApiOperation(value ="ModifyBooks")
	@PutMapping(value ="/ModifyBooks",consumes="application/json")
	public ResponseEntity<HttpStatus> modifyBooks(@RequestBody Books book){
		booksService.updateBookDetails(book);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);	
	}
	
	@ApiOperation(value ="DeleteBooks")
    @DeleteMapping(value="/{bookid}")
	public ResponseEntity<HttpStatus> deleteBooks(@PathVariable("bookid")int bookid)
	{
	
		try {
			booksService.removeBook(bookid);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
			}
	
		catch(Exception e)
		{
			throw new BookNotFoundException("No book found with given value "+ bookid); 
		}
		
	}
	
		@ApiOperation(value = "View")
		@GetMapping(value="/viewAllBooks",produces="application/json")
		public  ResponseEntity<List<Books>> viewAllBooks(){
			return new ResponseEntity<List<Books>> (booksService.viewAllBooks(),HttpStatus.OK);
	
		
	}
	

//*********************************************************************************************************************************	
		/*********************************************************************
		 * 
		 * Method : BooksOrderd
		 * Description: This class is used to getallbooksorder, getBookOrderById, add, modify and delete Books 
		 * @parse BooksIssued
		 * @return ResponseEntity<String>
		 * Created date: 20 April 2021
		 * 
		 *********************************************************************/

		@GetMapping(value="/getallbooksorder",produces="application/json")
		public  ResponseEntity<List<BooksOrder>> getAllBooksOrder(){
			return new ResponseEntity<List<BooksOrder>> (booksOrderService.viewOrdersList(),HttpStatus.OK);
		}

		@GetMapping(value="/getallbooksorder/{orderId}",produces="application/json")
		public ResponseEntity<BooksOrder> getBookOrderById(@PathVariable("orderId") int orderId){
			Optional<BooksOrder> b=booksOrderService.viewOrderById(orderId);
			if(b.isPresent())	
				return new ResponseEntity<BooksOrder>(booksOrderService.viewOrderById(orderId).get(),HttpStatus.OK);
			else
				throw new OrderNotFoundException("No book found with given value "+ orderId);
				
		}
		
	@PostMapping(value="/addBooksOrder",consumes="application/json")
		public ResponseEntity<HttpStatus> addBooksOrder(@RequestBody BooksOrder booksorder){
			booksOrderService.placeBooksOrder(booksorder);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
			
		}

	@PutMapping(value="/modifyBooksOrder",consumes="application/json")
		public ResponseEntity<HttpStatus> modifyBooksOrder(@RequestBody BooksOrder booksorder){
			Optional<BooksOrder> b=booksOrderService.updateOrder(booksorder);
			if(b.isPresent())
				return new ResponseEntity<HttpStatus>(HttpStatus.OK);
			else
				throw new OrderNotFoundException("No book found with given value "+ booksorder);
				
		}
		
	@DeleteMapping(value="/deleteOrder/{orderId}")
		public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("orderId")int orderId)
		{
		Optional<BooksOrder> b= (Optional)booksOrderService.viewOrderById(orderId);
		if(b.isPresent())
		{
			booksOrderService.cancelOrder(orderId);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		else
			throw new PublisherNotFoundException("No book order found with given value "+orderId);
		}
	
	
//****************************************************************************************************************************	
	/****************************************************************************
	 * 
	 * Method: addPublisher
	 * Description: This method adds a new Publisher 
	 * @param publisher
	 * @param bindingResult
	 * @return ResponseEntity<String>
	 * @throws MethodArgumentNotValidException
	 * @PostMapping: 
	 * Created: 20 April 2021
	 * 
	  ****************************************************************************/
	
	@ApiOperation(value = "add new publisher")
	@PostMapping(value = "/addNewPublisher")
	public ResponseEntity<String> addPublisher(@Valid @RequestBody Publishers publisher, BindingResult bindingResult) throws MethodArgumentNotValidException{
		if(bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			System.out.println(errors);
			List<String> errorlist = new ArrayList<String>();
			for(FieldError err: errors) {
				errorlist.add(err.getDefaultMessage());
			}
			throw new ValidationException(errorlist);
		}
		publisherService.addPublisher(publisher);
		return new ResponseEntity<String>("Inserted Successfully",HttpStatus.OK);
	}
	
	
	/****************************************************************************
	 * 
	 * Method: getAllPublishers
	 * Description: Displays all publishers 
	 * @return List<Publishers>
	 * @GetMapping: 
	 * Created: 20 April 2021
	 * 
	 ****************************************************************************/
	
	@ApiOperation(value = "get all publishers")
	@GetMapping(value = "/get all publishers/getAll")
	public List<Publishers> getAllPublishers() {
		return publisherService.viewPublishersList();
	}
	
	/****************************************************************************
	 * 
	 * Method: getPublisherById
	 * Description: Displays publisher by Id
	 * @param id
	 * @GetMapping:
	 * @return ResponseEntity<Publishers>
	 * Created: 20 April 2021
	 * 
	 ****************************************************************************/
	
	@ApiOperation(value = "get publisher by id")
	@GetMapping(value = "/get publisher by id/{id}")
	public ResponseEntity<Publishers> getPublisherById(@PathVariable int id) {
		try {
			return new ResponseEntity<Publishers>(publisherService.viewPublisherById(id),HttpStatus.OK);
		} catch (PublisherNotFoundException e) {
			throw new PublisherNotFoundException("Publisher doesn't exists");
		}
	}
	
	
	/****************************************************************************
	 * 
	 * Method: updatePublisher
	 * Description: Updates Publisher by Id
	 * @param id
	 * @param publisher
	 * @param bindingResult
	 * @PostMapping: 
	 * @return ResponseEntity<Object>
	 * @throws MethodArgumentNotValidException
	 * Created: 20 April 2021
	 * 
	 ****************************************************************************/
	
	@ApiOperation(value = "update publisher")
	@PostMapping(value = "/updatePublisher/{id}")
	public ResponseEntity<Object> updatePublishers(@Valid @PathVariable int id, @RequestBody Publishers publisher, BindingResult bindingResult) throws MethodArgumentNotValidException{
		if(bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			System.out.println(errors);
			List<String> errorlist = new ArrayList<String>();
			for(FieldError err: errors) {
				errorlist.add(err.getDefaultMessage());
			}
			throw new ValidationException(errorlist);
		}
		try {
			publisherService.updatePublisherDetails(id, publisher);
			return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
		}catch(PublisherNotFoundException e) {
			throw new PublisherNotFoundException("Publisher doesn't exists");
		}
	}
	
	/****************************************************************************
	 * 
	 * Method: deletePublisher
	 * Description: Deletes Publisher by Id
	 * @param id
	 * @DeleteMapping: 
	 * @return ResponseEntity<String>
	 * Created: 20 April 2021
	 * 
	 ****************************************************************************/
	
	@ApiOperation(value = "delete publisher")
	@DeleteMapping(value = "/delete publisher/{id}")
	public ResponseEntity<String> deletePublisherById(@PathVariable int id) {
		try {
			publisherService.removePublisher(id);
			return new ResponseEntity<String>("Deleted successfully",HttpStatus.OK);
		} catch (PublisherNotFoundException e) {
			throw new PublisherNotFoundException("Publisher doesn't exists");
		}
	}

	}
//***************************************************************************************************************************	
	
//
//	/********************************************************************************
//	 * 
//	 * Method : addSuggestedBooks
//	 * DEscription: method used for adding new Suggested Books
//	 * 
//	 * 
//	 * @param id
//	 * @return ResponseEntity<String>
//	 * @PostMapping Annotation for mapping HTTP DELETE requests onto delete suggested books
//	 * @Created date: 20 April 2021
//	 * 
//	 *  
//	 *********************************************************************************/
//	
//	@PostMapping(value="/suggestBooks")
//	public ResponseEntity<String> suggestBooks(@RequestBody SuggestedBooksDto suggestedBooksDto)
//	{
//		try {
//			suggestedBooksService.suggestBooks(suggestedBooksDto);
//			return new ResponseEntity<String>("Added suggested books sucessfully" ,HttpStatus.OK);
//			}
//			catch(BookNotFoundException e)
//			{
//				throw new BookNotFoundException("Enter Valid Id");
//			}
//	}
//	
//	
//		/********************************************************************************
//		 * 
//		 * Method : deleteSuggestedBooks
//		 * DEscription: method used for deleting Suggested Books by id
//		 * 
//		 * 
//		 * @param id
//		 * @return ResponseEntity<String>
//		 * @PostMapping Annotation for mapping HTTP DELETE requests onto delete suggested books
//		 * @Created date: 20 April 2021
//		 * 
//		 *  
//		 *********************************************************************************/
//		
//		@DeleteMapping(value="/deleteById/{id}")
//		public ResponseEntity<String> deleteSuggestedBooks(@PathVariable int id) 
//		{
//			try {
//			suggestedBooksService.deleteSuggestedBooks(id);
//			return new ResponseEntity<String>("Deleted",HttpStatus.OK);
//			}
//			catch(BookNotFoundException e)
//			{
//				throw new BookNotFoundException("Enter Valid Id");
//			}
//		}
//		
//		/********************************************************************************
//		 * 
//		 * Method : ViewSuggestedBooks
//		 * DEscription: method used for viewing suggested books
//		 * 
//		 * 
//		 * @param 
//		 * @return List<SuggestedBooks>
//		 * @PostMapping Annotation for mapping HTTP GET requests onto view suggested books
//		 * @Created date: 20 April 2021
//		 * 
//		 *  
//		 *********************************************************************************/
//		
//		@GetMapping(value="/ViewSuggestedBooks")
//		public List<SuggestedBooks> getAllSuggestedBooks(){
//			return suggestedBooksService.viewSuggestedBooksList();
//		}
//		
//		/********************************************************************************
//		 * 
//		 * Method : ViewSuggestedBooksById
//		 * DEscription: method used for viewing suggested books when a specific id is given
//		 * 
//		 * 
//		 * @param id
//		 * @return SuggestedBooks
//		 * @PostMapping Annotation for mapping HTTP GET requests onto view suggested books
//		 * @Created date: 20 April 2021
//		 * 
//		 *  
//		 *********************************************************************************/
//		
//		@GetMapping(value="/ViewSuggestedBooksById/{id}")
//		public SuggestedBooks getAllSuggestedBooksById(@PathVariable int id)
//		{
//			try {
//			return suggestedBooksService.viewSuggestedBookDetails(id);
//			}
//			catch(BookNotFoundException e)
//			{
//				throw new BookNotFoundException("Enter Valid Id ");
//			}
//		}
//		
//
//		
//*************************************************************************************************************************************
		
//		/****************************************************************************
//		 * 
//		 * Method: getAllFeedback
//		 * Description: This method is used to get all Feedback
//		 * 
//		 * 
//		 * @return List<Feedback>
//		 * Created 20 April 2021
//		 * 
//		 ****************************************************************************/
//
//		@ApiOperation(value = "get all feedback")
//		@GetMapping(value = "/getAllFeedback")
//		public List<Feedback> getAllFeedback1() {
//			return feedbackService.viewFeedbackList();
//		}
//		
//		/****************************************************************************
//		 * 
//		 * Method: getFeedbackById
//		 * Description: This method is used to get Feedback by Id
//		 * 
//		 * 
//		 * @param userid
//		 * @return ResponseEntity<Feedback>
//		 * Created 20 April 2021
//		 * 
//		 ****************************************************************************/
//		
//		@ApiOperation(value = "get feedback by userid")
//		@GetMapping(value = "/getById/{userid}")
//		public ResponseEntity<Feedback> getFeedbackById1(@PathVariable int userid) {
//			try {
//				return new ResponseEntity<Feedback>(feedbackService.viewFeedBackByUser(userid),HttpStatus.OK);
//			}catch(UserNotFoundException e) {
//				throw new UserNotFoundException("No user Found");
//			}
//		}
//		
//		/****************************************************************************
//		 * 
//		 * Method: addFeedback
//		 * Description: This method is used to add new Feedback
//		 * 
//		 * 
//		 * @param id
//		 * @param feedback
//		 * @param bindingResult
//		 * @PostMapping: 
//		 * @return ResponseEntity<String>
//		 * @throws MethodArgumentNotValidException
//		 * Created 20 April 2021
//		 * 
//		 ****************************************************************************/
//		
//		@ApiOperation(value = "add feedback")
//		@PostMapping(value = "/addNewFeedback/{id}")
//		public ResponseEntity<String> addFeedback(@Valid @PathVariable int id, @RequestBody Feedback feedback, BindingResult bindingResult) throws MethodArgumentNotValidException{
//			if(bindingResult.hasErrors()) {
//				List<FieldError> errors = bindingResult.getFieldErrors();
//				System.out.println(errors);
//				List<String> errorlist = new ArrayList<String>();
//				for(FieldError err: errors) {
//					errorlist.add(err.getDefaultMessage());
//				}
//				throw new ValidationException(errorlist);
//			}
//			try {
//				feedbackService.writeFeedback(id,feedback);
//			}catch(UserNotFoundException e) {
//				throw new UserNotFoundException("No such user found");
//			}
//			return new ResponseEntity<String>("Inserted", HttpStatus.OK);
//		}
//		
//		
//		
////***************************************************************************************************************************************		
//		/****************************************************************************
//		 * 
//		 * Method: getAlluser
//		 * Description: This method is used to get all users
//		 * @param List<Users>
//		 * @return ResponseEntity<Users>
//		 * Created 20 April 2021
//		 * 
//		 ****************************************************************************/
//		
//		@GetMapping(value="/ViewUsers")
//		public List<Users> getAlluser(){
//			return userService.viewAllUsers();
//		}
//		
//		
//	}
//	
//	
