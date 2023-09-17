package com.mendev.CharterManager.controller;

import com.mendev.CharterManager.model.Customer;
import com.mendev.CharterManager.model.Reservation;
import com.mendev.CharterManager.model.Yacht;
import com.mendev.CharterManager.repository.CustomerRepository;
import com.mendev.CharterManager.repository.ReservationRepository;
import com.mendev.CharterManager.repository.YachtRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//was - @RestController and it was changed to controller - site wasn't display before that
@CrossOrigin( maxAge = 3600, origins = "*", allowedHeaders = "*")
@Controller
@RequestMapping("/api")
public class CustomerController {

    private final CustomerRepository customerRepository;

    private final Logger log = LoggerFactory.getLogger(CustomerController.class);

    CustomerController(final CustomerRepository customerRepository){

        this.customerRepository = customerRepository;


    }

    @ResponseBody
    @PostMapping("/customers")
    ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) throws URISyntaxException {
        log.info("Request to create customer: {}", customer);
        Customer result = customerRepository.save(customer);
        return ResponseEntity.created(new URI("/api/group/" + result.getId()))
                .body(result);
    }



    @GetMapping(path = "/customers")
    @ResponseBody
    public List<Customer> getCustomers(){
        return this.customerRepository.findAll();
    }



    /*
    @RequestMapping( method = RequestMethod.GET, path = "/templatetest")
    public String showAllReservations(Reservation reservation, Model model){
        customerRepository.findAll().stream().collect(Collectors.toList());
        model.addAttribute("reservations", customerRepository.findAll());
        //logger.warn("Exposing all the Customers");

        return "templatetest";
    }
    */

/*
    @RequestMapping(method = RequestMethod.POST, path = "/customers")
    public void saveCustomer(@ModelAttribute("customer") Customer customer, Model model) {



    }*/
/*
    @RequestMapping(method = RequestMethod.DELETE, path = "/customers/{id}")
    public void deleteCustomer(@PathVariable Integer id){
        Customer customer;
        customer = customerRepository.findById(id);
        customerRepository.delete(customer);


    }*/

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable long id){
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id :" + id));

        customerRepository.delete(customer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
