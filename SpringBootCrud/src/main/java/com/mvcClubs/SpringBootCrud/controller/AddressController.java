package com.mvcClubs.SpringBootCrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mvcClubs.SpringBootCrud.model.Address;
import com.mvcClubs.SpringBootCrud.service.AddressService;

@Controller
public class AddressController {

	@Autowired
	private AddressService aService;

	@RequestMapping("/address/")
	public String viewAddressPage(Model model) {
		List<Address> listAddress = aService.addressListAll();
		model.addAttribute("listAddress", listAddress);
		return "address";
	}

	@RequestMapping("/address/new")
	public String showNewAddressPage(Model model) {
		Address address = new Address();
		model.addAttribute("address", address);

		return "new_address";
	}

	@RequestMapping("/address/edit/{id}")
	public ModelAndView showEditPersonPage(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_address");
		Optional<Address> address = aService.findById(id);
		mav.addObject("address", address);

		return mav;
	}

	@PostMapping("/address/save")
	public String saveAddress(@ModelAttribute("address") Address address) {
		aService.save(address);

		return "redirect:/address/";
	}

	@RequestMapping("/address/delete/{id}")
	public String deleteAddress(@PathVariable(name = "id") Long id) {
		aService.delete(id);
		return "redirect:/address/";
	}
}
