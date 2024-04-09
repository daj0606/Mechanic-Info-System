package dmacc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Appointment;
import dmacc.beans.Customer;
import dmacc.beans.Vehicle;
import dmacc.repository.AppointmentRepository;
import dmacc.repository.CustomerRepository;
import dmacc.repository.VehicleRepository;

/**
 * @author Phuoc Tran - ptran9@dmacc.edu CIS175 - Spring 2024 Apr 9, 2024
 */

@Controller
public class WebController {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private AppointmentRepository appointmentRepository;

	@GetMapping("/viewAllCustomers")
	public String viewAllCustomers(Model model) {
		if (customerRepository.findAll().isEmpty()) {
			return addNewCustomer(model);
		}
		model.addAttribute("customer", customerRepository.findAll());
		return "results";
	}

	@GetMapping("/inputCustomer")
	public String addNewCustomer(Model model) {
		Customer c = new Customer();
		model.addAttribute("newCustomer", c);
		return "input";
	}

	@PostMapping("/inputCustomer")
	public String addNewCustomer(@ModelAttribute Customer c, Model model) {
		customerRepository.save(c);
		return viewAllCustomers(model);
	}

	@GetMapping("/edit/{id}")
	public String showUpdateCustomer(@PathVariable("id") long id, Model model) {
		Customer c = customerRepository.findById(id).orElse(null);
		model.addAttribute("newCustomer", c);
		return "input";
	}

	@PostMapping("/update/{id}")
	public String reviseCustomer(Customer c, Model model) {
		customerRepository.save(c);
		return viewAllCustomers(model);
	}

	@GetMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable("id") long id, Model model) {
		Customer c = customerRepository.findById(id).orElse(null);
		customerRepository.delete(c);
		return viewAllCustomers(model);
	}
	
	@GetMapping("/inputVehicle")
	public String addNewVehicle(Model model) {
		Vehicle v = new Vehicle();
		model.addAttribute("newVehicle", v);
		return "input";
	}

	@PostMapping("/inputVehicle")
	public String addNewVehicle(@ModelAttribute Vehicle v, Model model) {
		vehicleRepository.save(v);
		return viewAllCustomers(model);
	}

	@GetMapping("/edit/{id}")
	public String showUpdateVehicle(@PathVariable("id") long id, Model model) {
		Vehicle v = vehicleRepository.findById(id).orElse(null);
		model.addAttribute("newVehicle", v);
		return "input";
	}

	@PostMapping("/update/{id}")
	public String reviseVehicle(Vehicle v, Model model) {
		vehicleRepository.save(v);
		return viewAllCustomers(model);
	}

	@GetMapping("/delete/{id}")
	public String deleteVehicle(@PathVariable("id") long id, Model model) {
		Vehicle v = vehicleRepository.findById(id).orElse(null);
		vehicleRepository.delete(v);
		return viewAllCustomers(model);
	}
	
	@GetMapping("/viewAllAppointments")
	public String viewAllAppointments(Model model) {
		if (customerRepository.findAll().isEmpty()) {
			return addNewCustomer(model);
		}
		model.addAttribute("customer", customerRepository.findAll());
		return "results";
	}

	@GetMapping("/inputCustomer")
	public String addNewAppointment(Model model) {
		Appointment a = new Appointment();
		model.addAttribute("newCustomer", a);
		return "input";
	}

	@PostMapping("/inputAppointment")
	public String addNewAppointment(@ModelAttribute Appointment a, Model model) {
		appointmentRepository.save(a);
		return viewAllAppointments(model);
	}

	@GetMapping("/edit/{id}")
	public String showUpdateAppointment(@PathVariable("id") long id, Model model) {
		Appointment a = appointmentRepository.findById(id).orElse(null);
		model.addAttribute("newAppointment", a);
		return "input";
	}

	@PostMapping("/update/{id}")
	public String reviseAppointment(Appointment a, Model model) {
		appointmentRepository.save(a);
		return viewAllAppointments(model);
	}

	@GetMapping("/delete/{id}")
	public String deleteAppointment(@PathVariable("id") long id, Model model) {
		Appointment a = appointmentRepository.findById(id).orElse(null);
		appointmentRepository.delete(a);
		return viewAllAppointments(model);
	}
}
