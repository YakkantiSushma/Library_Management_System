package com.capgemini;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.CommandLinePropertySource;
import org.springframework.util.Assert;

import com.capgemini.lms.Dao.AdminDao;
import com.capgemini.lms.Dao.BooksDao;
import com.capgemini.lms.Dao.BooksIssuedDao;
import com.capgemini.lms.Dao.BooksReturnedDao;
import com.capgemini.lms.Dao.FeedbackDao;
import com.capgemini.lms.Dao.PublishersDao;
import com.capgemini.lms.Dao.UsersDao;
import com.capgemini.lms.entities.Admin;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.BooksIssued;
import com.capgemini.lms.entities.BooksReturned;
import com.capgemini.lms.entities.Feedback;
import com.capgemini.lms.entities.Publishers;
import com.capgemini.lms.entities.Users;

@SpringBootApplication
public class AdminApplication implements CommandLineRunner {
//@Autowired
//	AdminDao admindao;
//@Autowired
//    BooksDao booksdao;
//@Autowired
//    UsersDao usersdao;
//@Autowired
//    BooksReturnedDao booksreturneddao;
//@Autowired
//    BooksIssuedDao booksissueddao;
//@Autowired
//    FeedbackDao feedbackdao;
//@Autowired
//    PublishersDao publishersdao;




	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//Admin A1=new Admin("Sushma", "Yakkanti", "ysushma39@gmail.com", "sushma");
	//Books B1=new Books("HarryPotter","Thriller","J.K Rowling","Sushma",1995,"20123",7,200,"4A");
//		Users U1=new Users("Sushm1245","Sushma","Yakkanti","9573457846","ysushma39@gmail.com",LocalDate.of(2021, 4, 12),LocalDate.of(2021, 4, 12),LocalDate.of(2021, 7, 12),"Three more days to go");
//        BooksReturned BR1=new BooksReturned(U1,B1,LocalDate.of(2021, 12, 4),25,4000,"Submit");
//        BooksIssued BI1=new BooksIssued(U1,B1,LocalDate.of(2021,4, 12),5,LocalDate.of(2021, 5, 12));	
//        Feedback F1=new Feedback(U1,LocalDate.of(2021,4,12),"Give your Feedback","5","AddComments");
//        Publishers P1=new Publishers("Sushma","9573457846","ysushma39@gmail.com","XYZ","ABC","Hyderabad","Telangana",500067);
	///    admindao.save(A1);
       // booksdao.save(B1);
//	    usersdao.save(U1);
//	    booksreturneddao.save(BR1);
//	    booksissueddao.save(BI1);
//		feedbackdao.save(F1);
//		publishersdao.save(P1);
	}

	
}
