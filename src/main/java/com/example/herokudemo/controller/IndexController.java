package com.example.herokudemo.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.herokudemo.model.Contact;
import com.example.herokudemo.repository.ContactRepository;
import com.example.herokudemo.service.ExcelFileService;
@CrossOrigin
@RestController
public class IndexController {
	
	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private ExcelFileService excelFileService;
	
    @GetMapping("/")
    public String index() {
//    	Contact contact = new Contact("Mandar Nalawade",8989898989L,"printadda owner","mandarnalwade@gmail.com");
//    	contact = contactRepository.save(contact);
    	
    	//    	String name, Long mobile, String message, String email
        return "Hello there! I'm running.";
    }
    
    @GetMapping("/insert")
    public Contact insert( @RequestParam("name")String name,@RequestParam("mobile")Long phone,@RequestParam("message")String message,@RequestParam("email")String email) {
    	Contact  contact = new Contact(name,phone,message,email);
    	contact = this.contactRepository.save(contact);
    	return contact;
    }
    
    @GetMapping("/contacts")
    public List<Contact> getAllContacts(){
    	return (List<Contact>)contactRepository.findAll();
    }
	@GetMapping("/downloadExcelFile")
	public void downloadExcelFile(HttpServletResponse response) throws IOException {
		List<Contact> contacts = (List<Contact>)contactRepository.findAll();
        ByteArrayInputStream byteArrayInputStream = excelFileService.export(contacts);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=contacts.xlsx");
        IOUtils.copy(byteArrayInputStream, response.getOutputStream());
	}
}
