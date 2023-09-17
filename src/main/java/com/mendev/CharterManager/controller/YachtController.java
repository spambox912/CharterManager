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

import javax.management.StringValueExp;
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
public class YachtController {

    private final YachtRepository yachtRepository;

    private final Logger log = LoggerFactory.getLogger(CustomerController.class);

   YachtController(final YachtRepository yachtRepository){

        this.yachtRepository = yachtRepository;


    }

    @ResponseBody
    @PostMapping("/yachts")
    ResponseEntity<Yacht> createYacht(@Valid @RequestBody Yacht yacht) throws URISyntaxException {
        log.info("Request to create yacht: {}", yacht);
        Yacht result = yachtRepository.save(yacht);
        return ResponseEntity.created(new URI("/api/yachts/" + result.getRegistrationNumber()))
                .body(result);
    }



    @GetMapping(path = "/yachts")
    @ResponseBody
    public List<Yacht> getYachts(){
        return this.yachtRepository.findAll();
    }



    /*
    @RequestMapping( method = RequestMethod.GET, path = "/templatetest")
    public String showAllReservations(Reservation reservation, Model model){
        customerReposiory.findAll().stream().collect(Collectors.toList());
        model.addAttribute("reservations", customerReposiory.findAll());
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
        customer = customerReposiory.findById(id);
        customerReposiory.delete(customer);


    }*/

    @DeleteMapping("/yachts/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable long id){
        Yacht yacht = yachtRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("Yacht not exist with id :" + id));

        yachtRepository.delete(yacht);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
