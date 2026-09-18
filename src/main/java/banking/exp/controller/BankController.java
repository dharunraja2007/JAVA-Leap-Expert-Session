package banking.exp.controller;

import banking.exp.model.Users;
import banking.exp.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class BankController{
    @Autowired
    BankService bankservice;
    @GetMapping("/users")
    public List<Users> getUsers(){

        return bankservice.getUsers();
    }
    @PostMapping("/save")
public String saveUser(@RequestBody Users user){

        return bankservice.addUser(user);
    }

@DeleteMapping("/delete")
    public String delUsers(@RequestBody Users user){

        return bankservice.DelUser(user);
}
@GetMapping("/check/{id}")
    public String getEmail(@PathVariable int id){
        return bankservice.getName(id);
    }

}
