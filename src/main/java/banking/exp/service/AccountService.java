package banking.exp.service;

import banking.exp.model.BankAccount;
//import banking.exp.model.Users;
import banking.exp.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepo accountRepo;

    public List<BankAccount> getUsers(){
        return accountRepo.findAll();
    }
    public String createAccount(BankAccount account) {

        accountRepo.save(account);

        return "Account created successfully";
    }

    public String getAccount(int id) {

        if (accountRepo.existsById(id)) {

            BankAccount account = accountRepo.findById(id).get();

            return "Account Number: " + account.getAccountNumber()
                    + ", Name: " + account.getName()
                    + ", Balance: " + account.getBalance();
        }

        return "Account not found";
    }

    public String deposit(int id, double amount) {

        if (accountRepo.existsById(id)) {

            BankAccount account = accountRepo.findById(id).get();

            account.setBalance(account.getBalance() + amount);

            accountRepo.save(account);

            return "Amount deposited successfully. New balance: "
                    + account.getBalance();
        }

        return "Account not found";
    }

    public String deleteAccount(int id) {

        if (accountRepo.existsById(id)) {

            accountRepo.deleteById(id);

            return "Account deleted successfully";
        }

        return "Account not found";
    }
}