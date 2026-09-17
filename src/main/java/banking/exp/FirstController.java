package banking.exp;

import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

    @GetMapping("/balance")
    public String getBalance() {
        return "Balance: ₹5000";}

    @PostMapping("/deposit")
    public String deposit() {
        return "Money deposited";}

    @PutMapping("/withdraw")
    public String withdraw() {
        return "Money withdrawn";}

    @DeleteMapping("/account")
    public String deleteAccount() {
        return "Account deleted";
    }
}
