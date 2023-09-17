package com.mendev.CharterManager.controller;

import com.mendev.CharterManager.model.Customer;
import com.mendev.CharterManager.model.Reservation;
import com.mendev.CharterManager.model.Yacht;
import com.mendev.CharterManager.repository.CustomerRepository;
import com.mendev.CharterManager.repository.ReservationRepository;
import com.mendev.CharterManager.repository.YachtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//was - @RestController and it was changed to controller - site wasn't display before that
@CrossOrigin( maxAge = 3600, origins = "*", allowedHeaders = "*")
@Controller
@RequestMapping("/api")
public class ReservationController {

    private final ReservationRepository reservationRepository;
    private final YachtRepository yachtRepository;
    private final CustomerRepository customerReposiory;

    ReservationController(final ReservationRepository reservationRepository, CustomerRepository customerRepository, YachtRepository yachtRepository){
        this.reservationRepository = reservationRepository;
        this.customerReposiory = customerRepository;
        this.yachtRepository = yachtRepository;

    }

    //@Autowired TemplateEngine templateEngine
    //@RequestMapping( method = RequestMethod.GET, path = "/getres")
    @GetMapping(path = "/reservations")
    @ResponseBody
    public List< Reservation > getReservations() {
        return this.reservationRepository.findAll();
    }

   /*
    public List< Reservation > getReservations() {


        List<Reservation> list = new ArrayList<>();
        list = reservationRepository.findAll();
        //return reservationRepository.findAll();
        return list;
    }
*/

    @PostMapping(path = "/reservations")
    public void saveReservation(@ModelAttribute("reservation") Reservation reservation, Model model) {

        

    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/reservations/{id} ")
    public void deleteReservation(@PathVariable long id){
        reservationRepository.deleteById(id);

    }


}
