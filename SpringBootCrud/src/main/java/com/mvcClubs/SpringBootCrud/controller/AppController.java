package com.mvcClubs.SpringBootCrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mvcClubs.SpringBootCrud.model.Address;
import com.mvcClubs.SpringBootCrud.model.Person;
import com.mvcClubs.SpringBootCrud.model.Role;
import com.mvcClubs.SpringBootCrud.service.AddressService;
import com.mvcClubs.SpringBootCrud.service.PersonService;
import com.mvcClubs.SpringBootCrud.service.RoleService;

@Controller
public class AppController {

	@Autowired
	private PersonService pService;
	@Autowired
	private AddressService aService;
	@Autowired
	private RoleService rService;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Person> listPeople = pService.peopleListAll();
		model.addAttribute("listPeople", listPeople);

		return "index";
	}

	@RequestMapping("/new")
	public String showNewPersonPage(Model model) {
		Person person = new Person();
		model.addAttribute("person", person);

		List<Address> listAddress = aService.addressListAll();
		model.addAttribute("listAddress", listAddress);

		List<Role> listRole = rService.roleListAll();
		model.addAttribute("listRole" , listRole);
		return "new_person";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savePerson(@ModelAttribute("person") Person person) {
		pService.save(person);

		return "redirect:/";
	}

	@GetMapping(value="/edit/{id}")
	public ModelAndView showEditPersonPage(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_person");
		Optional<Person> person = pService.findById(id);
		mav.addObject("person", person);

//		Address address = aService.get(id);
//		mav.addObject("address", address);
//		List<Address> listAddress = aService.addressListAll();
//		mav.addObject("listAddress", listAddress);
//		
		Optional<Address> address = aService.findById(id);
		mav.addObject("address", address);
		List<Address> listAddress = aService.addressListAll();
		mav.addObject("listAddress", listAddress);
		
//		Role role = rService.get(id);
//		mav.addObject("role", role);
//		List<Role> listRole = rService.roleListAll();
//		mav.addObject("listRole", listRole);

		Optional<Role> role=rService.findById(id);
		mav.addObject("role",role);
		List<Role> listRole = rService.roleListAll();
		mav.addObject("listRole", listRole);

		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String deletePerson(@PathVariable(name = "id") Long id) {
		pService.delete(id);
		return "redirect:/";
	}

}
