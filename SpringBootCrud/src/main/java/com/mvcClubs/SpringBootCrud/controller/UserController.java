package com.mvcClubs.SpringBootCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvcClubs.SpringBootCrud.model.Address;
import com.mvcClubs.SpringBootCrud.model.Role;
import com.mvcClubs.SpringBootCrud.model.User;
import com.mvcClubs.SpringBootCrud.service.AddressService;
import com.mvcClubs.SpringBootCrud.service.RoleService;
import com.mvcClubs.SpringBootCrud.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService uService;
	
	@Autowired
	private AddressService aService;
	
	@Autowired
	private RoleService rService;
	

	
	@RequestMapping("/user/")
    public String viewAddressPage(Model model) {
    	List<User> listUser=uService.userListAll();
    	model.addAttribute("listUser",listUser);
    	return "user";
    }
	
	@GetMapping("/user/registration")
	public String showRegistrationForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		  List<Address> listAddress=aService.addressListAll();
  		model.addAttribute("listAddress",listAddress);
  	  List<Role> listRole=rService.roleListAll();
		model.addAttribute("listRole",listRole);
		return "registration";

	}

	@RequestMapping(value = "/user/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {
		uService.save(user);

		return "redirect:/login";
	}
	@RequestMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id) {
    	uService.delete(id);
        return "redirect:/";       
    }

}
