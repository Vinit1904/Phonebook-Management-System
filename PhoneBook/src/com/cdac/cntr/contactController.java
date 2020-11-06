package com.cdac.cntr;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.dto.Contact;
import com.cdac.dto.User;
import com.cdac.service.ContactService;

@Controller
public class contactController {

	@Autowired
	private ContactService contactService; 
	
	@RequestMapping(value="/prep_contact_add_form.htm",method = RequestMethod.GET)
	public String  preContactAddForm(ModelMap map) {
		map.put("contact",new Contact());
		return "contact_add_form";
	}
	
	

	@RequestMapping(value = "/contact_add.htm",method = RequestMethod.POST)
	public String contactAdd(Contact contact,HttpSession session,ModelMap map) {
		User user = (User)session.getAttribute("user");
		contact.setUser(user); 
		contactService.addContact(contact);
		return "home";
	}
	
	@RequestMapping(value="/contact_list.htm",method = RequestMethod.GET)
	public String  allContact(ModelMap map,HttpSession session) {
		int userId=((User)session.getAttribute("user")).getUserId();
		List<Contact> li=contactService.selectAll(userId);
		map.put("contactList", li);
		return "contact_list";
	}
	
	
	@RequestMapping(value = "/contact_delete.htm",method = RequestMethod.GET)
	public String contactDelete(@RequestParam int contactId,ModelMap map,HttpSession session) {
		
		contactService.removeContact(contactId); 
		
		int userId = ((User)session.getAttribute("user")).getUserId();
		List<Contact> li = contactService.selectAll(userId);
		map.put("contactList", li);
		return "contact_list";
	}
	
	@RequestMapping(value="/contact_update_form.htm",method = RequestMethod.GET)
	public String contactUpdateForm(@RequestParam int contactId,ModelMap map,HttpSession session) {
		
		Contact ct= contactService.findContact(contactId);
		map.put("contact", ct);
		return "contact_update_form";		
	}
	
	
	@RequestMapping(value="/contact_update.htm",method = RequestMethod.POST)
	public String contactUpdateForm(Contact contact,ModelMap map,HttpSession session) {
		
		User user=(User)session.getAttribute("user");
		contact.setUser(user);
		contactService.modifyContact(contact);
		
		int userId = ((User)session.getAttribute("user")).getUserId();
		List<Contact> li=contactService.selectAll(userId);
		map.put("contactList", li);
		return "contact_list";		
	}
	
	
	@RequestMapping(value="/ascending_sort_by_name.htm",method = RequestMethod.GET)
	public String  ascendingSortName(ModelMap map,HttpSession session) {
		int userId=((User)session.getAttribute("user")).getUserId();
		List<Contact> li=contactService.selectAllAscName(userId);
		map.put("contactList", li);
		return "contact_list";
	}
	
	@RequestMapping(value="/descending_sort_by_name.htm",method = RequestMethod.GET)
	public String  descendingSortName(ModelMap map,HttpSession session) {
		int userId=((User)session.getAttribute("user")).getUserId();
		List<Contact> li=contactService.selectAllDescName(userId);
		map.put("contactList", li);
		return "contact_list";
	}
	
	@RequestMapping(value="/contact_search.htm",method = RequestMethod.GET)
	public String  searchByName(ModelMap map,HttpSession session,@RequestParam("searchVal") String searchVal) {
		int userId=((User)session.getAttribute("user")).getUserId();
		List<Contact> li=contactService.selectSearchByName(userId,searchVal);
		map.put("contactList", li);
		return "contact_list";
	}
	
}
