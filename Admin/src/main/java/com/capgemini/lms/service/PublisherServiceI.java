package com.capgemini.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.lms.entities.Publishers;
import com.capgemini.lms.exception.PublisherNotFoundException;

@Service
public interface PublisherServiceI {
	public Publishers addPublisher(Publishers publisher);
	public void updatePublisherDetails(int publisherId,Publishers publisher) throws PublisherNotFoundException ;
	public void removePublisher(int publisherId) throws PublisherNotFoundException;
	public List<Publishers> viewPublishersList();
	public Publishers viewPublisherById(int id);
}
