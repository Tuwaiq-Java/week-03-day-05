package com.example.demo6.Controller;

import com.example.demo6.Model.Api;
import com.example.demo6.Model.BankClass;
import com.example.demo6.Service.BankClassService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/BankClassController")
@AllArgsConstructor
public class BankClassController {
    private final BankClassService bankClassService;
    Logger log= LoggerFactory.getLogger(BankClassController.class);



    @GetMapping("/getBank")
    public ResponseEntity <List<BankClass>> getBanks(){
        log.info("get request incoming");
        List<BankClass> banks=bankClassService.getBanks();
        return ResponseEntity.status(HttpStatus.OK).body(banks);

    }
    @PostMapping("/addBank")
    public ResponseEntity <Api> addCustomer(@RequestBody @Valid BankClass bankClass){
        bankClassService.addCustomer(bankClass);
        return ResponseEntity.status(200).body(
                new Api("New Bank added !",201));

    }



    }



