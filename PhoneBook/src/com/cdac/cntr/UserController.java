package com.cdac.cntr;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cdac.dto.Contact;
import com.cdac.dto.User;
import com.cdac.dto.UserLogs;
import com.cdac.service.ContactService;
import com.cdac.service.userLogsServices;
import com.cdac.service.userService;
import com.cdac.valid.UserValidator;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class UserController {

	@Autowired
	private userService userService; 
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private userLogsServices userLogsServices; 
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private UserValidator userValidator;
	
	
	@RequestMapping(value="/prep_reg_form.htm", method=RequestMethod.GET)
	public String prepRegForm(ModelMap map) {	
		map.put("user", new User());
		return "reg_form";		
	}
	
	
	@RequestMapping(value="/reg_form.htm",method=RequestMethod.POST)
	public String Register( User user,BindingResult result,ModelMap map) {
		
		userValidator.validate(user,result);		
		if(result.hasErrors()) {
			return "reg_form";
		}
				
		user.setRoll("user");
		userService.addUser(user);
		return "index";
	}
	
	
	@RequestMapping(value = "/prep_log_form.htm",method = RequestMethod.GET)
	public String prepLogForm(ModelMap map) {
		map.put("user", new User());
		return "login_form";
	}
	
	
	@RequestMapping(value = "/login.htm",method = RequestMethod.POST)
	public String login(User user,BindingResult result,ModelMap map,HttpSession session) {
		userValidator.validate(user,result);		
		
		if(result.hasErrors()) {
			System.out.println(result);
			return "login_form";
		}
		
		System.out.println("ok");
		boolean b = userService.findUser(user);
		System.out.println("ok1");
		if(b) {
			
			session.setAttribute("user", user);
			
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
			String strDate = formatter.format(date);
			
			int userId = ((User)session.getAttribute("user")).getUserId();
						
			UserLogs log=new UserLogs(strDate,userId);
			userLogsServices.insertTimeDateLogs(log);
			
			String userRoll = ((User)session.getAttribute("user")).getRoll();			
			String admin=new String("Admin");
			if(userRoll.equals(admin)) {
				return "admin_home";
			}
			else
				return "home";
		}else {
			map.put("user", new User());
			return "login_form";
		}
	}
	
	
	@RequestMapping(value = "/forgot_password.htm",method = RequestMethod.POST)
	public String forgotPassword(@RequestParam String emailId,ModelMap map) {		
		String pass = userService.forgotPassword(emailId);
		String msg = "you are not registered";
		if(true) {	
			
			SimpleMailMessage message = new SimpleMailMessage();  
	        message.setFrom("vinitsarode86@gmail.com");  
	        message.setTo(emailId);  
	        message.setSubject("Your password");  
	        message.setText(pass);
	        
	               
	        //sending message   
	        mailSender.send(message);
			msg = "check the mail for password";
		}
		map.put("user", new User());
		return "login_form";
	}
	
	
	@RequestMapping(value = "/upload_file.htm", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("file") MultipartFile file,HttpSession session,HttpServletRequest request,ModelMap map) {
		String fileName = "0";

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				
				fileName = file.getOriginalFilename();
				fileName = fileName.substring(fileName.lastIndexOf("."));
				
				User user = (User)session.getAttribute("user");
				
				fileName = user.getUserId()+fileName;
				
				

				// Creating the directory to store file
				String rootPath = request.getServletContext().getRealPath("/");
				File dir = new File(rootPath + File.separator + "images");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				
				
				String filePath = dir.getAbsolutePath()+ File.separator +fileName;
				
				System.out.println("Server File Location= "+ filePath );
				
				File serverFile = new File(filePath);
				
						
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				
				userService.uploadImage(fileName, user.getUserId());
				
				user.setProfilePic(fileName);
				

			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		
		return "home";
	}
	
		
	@RequestMapping(value="/profile.htm",method = RequestMethod.GET)
	public String profileForm(ModelMap map,HttpSession session) {
		
		int userId = ((User)session.getAttribute("user")).getUserId();
			
		User ur= userService.loadUser(userId);
		map.put("user", ur);
		return "profile_update_form";		
	}
	
	
	
	@RequestMapping(value="/profile_show.htm",method = RequestMethod.GET)
	public String profileShow(ModelMap map,HttpSession session) {
		
		int userId = ((User)session.getAttribute("user")).getUserId();
			
		User ur= userService.loadUser(userId);
		map.put("user", ur);
		return "show_profile";		
	}
	
	@RequestMapping(value="/update_user_profile.htm",method = RequestMethod.POST)
	public String UserProfileUpdateForm(User user,BindingResult result,ModelMap map,HttpSession session) {
		
		
		userService.modifyUser(user);
		
		int userId = ((User)session.getAttribute("user")).getUserId();		
		User ur= userService.loadUser(userId);
		map.put("user", ur);	
		return "show_profile";		
	}
	
	
	@RequestMapping(value="/prep_user_list.htm",method = RequestMethod.GET)
	public String  allContact(ModelMap map,HttpSession session) {
		
		List<User> li=userService.selectAll();
		map.put("userList", li);
		return "user_list";
	}
	
	
	@RequestMapping(value = "/user_remove.htm",method = RequestMethod.GET)
	public String removeUser(@RequestParam int userId,ModelMap map,HttpSession session) {
		
		contactService.removeUserData(userId);;
		userService.removeUser(userId);		
		List<User> li=userService.selectAll();
		map.put("userList", li);
		return "user_list";		
	}
	
	
	@RequestMapping(value="/admin_permission.htm",method = RequestMethod.GET)
	public String contactUpdateForm(@RequestParam int userId,ModelMap map,HttpSession session) {
		
		
		userService.modifyPermission(userId);
		//System.out.println(contact);
		List<User> li=userService.selectAll();
		map.put("userList", li);
		return "user_list";		
	}
	
	
	@RequestMapping(value="/user_log_list.htm",method = RequestMethod.GET)
	public String  allUserLogs(ModelMap map,HttpSession session) {
		
		List<UserLogs> li=userLogsServices.selectUserLogs();
		map.put("userLogsList", li);
		return "user_logslist";
	}
	
	
	
	@RequestMapping(value="/logout.htm",method = RequestMethod.GET)
	public String contactUpdateForm(User user,ModelMap map,HttpSession session) {		
		
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String strDate = formatter.format(date);
		
		int userId = ((User)session.getAttribute("user")).getUserId();
		userLogsServices.updatelogout(strDate,userId);
			
		
			session.invalidate();
			
			map.put("user",user);
		return "login_form";		
	}
	
}
