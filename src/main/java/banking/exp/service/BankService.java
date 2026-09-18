package banking.exp.service;

import banking.exp.model.Users;
import banking.exp.repository.Bankrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import java.util.List;
//import java.util.ArrayList;
@Service
public class BankService {
    @Autowired
    Bankrepo bankRepo;
//    static  List<Users> list=new ArrayList<>();

    public List<Users> getUsers(){

        return bankRepo.findAll();
    }
    public String addUser(Users user){
        bankRepo.save(user);
        return "User with ID " + user.getId() + " saved";
    }
    public String DelUser(Users user) {
        if (bankRepo.existsById(user.getId())) {
            bankRepo.deleteById(user.getId());
            return "User deleted successfully";
        }

        return "User not found";
    }

    public String getName(int id){

        if (bankRepo.existsById(id)) {
            Users user = bankRepo.findById(id).get();
            return "User name is: " + user.getName();
        }
        return "User is not present";
    }
}
