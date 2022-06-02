package com.example.demo6.Controller;

import com.example.demo6.Model.Api;
import com.example.demo6.Model.CustomerClass;
import com.example.demo6.Service.CustomersClassService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/CustomersClassController")
public class CustomersClassController {

    Logger log= LoggerFactory.getLogger(CustomersClassController.class);

    private final CustomersClassService customersClassService;

    @GetMapping("/getClass")
    public ResponseEntity<List<CustomerClass>> getBanks() {
        log.info("get request incoming");
        List<CustomerClass> classes= customersClassService.getClasses();
        return ResponseEntity.status(HttpStatus.OK).body(classes);

    }

    @PostMapping("/addClass")
    public ResponseEntity <Api> addClasses(@RequestBody @Valid CustomerClass customerClass){
        customersClassService.addClasses(customerClass);
        return ResponseEntity.status(200).body(
                new Api("New Bank added !",201));

    }



}
