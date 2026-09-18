package banking.exp.controller;

import banking.exp.model.BankAccount;
import banking.exp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/accounts")
    public List<BankAccount>getUsers(){
        return accountService.getUsers();
    }
    // 1. Create account
    @PostMapping("/account/create")
    public String createAccount(@RequestBody BankAccount account) {

        return accountService.createAccount(account);
    }

    // 2. Get account
    @GetMapping("/account/{id}")
    public String getAccount(@PathVariable int id) {

        return accountService.getAccount(id);
    }

    // 3. Deposit
    @PutMapping("/account/deposit/{id}")
    public String deposit(
            @PathVariable int id,
            @RequestParam double amount) {

        return accountService.deposit(id, amount);
    }

    // 4. Delete account
    @DeleteMapping("/account/{id}")
    public String deleteAccount(@PathVariable int id) {

        return accountService.deleteAccount(id);
    }
}