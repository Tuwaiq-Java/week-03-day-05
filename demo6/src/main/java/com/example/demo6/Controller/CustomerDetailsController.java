package com.example.demo6.Controller;

import com.example.demo6.Model.Api;
import com.example.demo6.Model.CustomerDetails;
import com.example.demo6.Service.CustomerDetailsService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("api/v1/CustomerDetailsController")
@AllArgsConstructor
public class CustomerDetailsController {

    private final CustomerDetailsService customerDetailsService;
    Logger log= LoggerFactory.getLogger(CustomerDetailsController.class);



    @GetMapping("/getDetails")
    public ResponseEntity<List<CustomerDetails>> getBanks() {
        log.info("get request incoming");
        List<CustomerDetails> Details = customerDetailsService.getDetails();
        return ResponseEntity.status(HttpStatus.OK).body(Details);

    }

    @PostMapping("/addDetails")
    public ResponseEntity <Api> addCustomer(@RequestBody @Valid CustomerDetails customerDetails){
        customerDetailsService.addDetails(customerDetails);
        return ResponseEntity.status(200).body(
                new Api("New Bank added !",201));

    }


    @PostMapping("/withDraws{customerId}/{amount}")
    public ResponseEntity withdraws(@PathVariable Integer customerId, @PathVariable Integer amount) {
        if(customerDetailsService.withDrow(customerId,amount)) {
            return ResponseEntity.status(200).body(
                    new Api("New Bank added !", 201));
        }
        return ResponseEntity.status(400).body(
                new Api("No enough money !", 400));

    }
    @PostMapping("/depositAmount{customerId}/{amount}")
    public ResponseEntity depositAmount(@PathVariable Integer customerId, @PathVariable Integer amount) {
        customerDetailsService.withDrow(customerId,amount);
        return ResponseEntity.status(200).body(
                new Api("New Bank added !",201));


    }
}
