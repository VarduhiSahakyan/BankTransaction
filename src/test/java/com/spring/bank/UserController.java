package com.spring.bank;

import com.spring.bank.entity.BankAccount;
import com.spring.bank.entity.Transaction;
import com.spring.bank.entity.User;
import com.spring.bank.entity.enums.Role;
import com.spring.bank.repository.BankAccountRepository;
import com.spring.bank.repository.TransactionRepository;
import com.spring.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class UserController {


    @Autowired
    UserRepository userRepository;
    @Autowired
    BankAccountRepository bankAccountRepository;
    @Autowired
    TransactionRepository transactionRepository;


    @GetMapping("/")
    public String welcomePage(ModelMap model){
        User user = new User();
        model.addAttribute("user", user);
        return "/welcome";
    }

    @GetMapping("/sign_in")
    public String signInGet(ModelMap model){
        User user = new User();
        model.addAttribute("user", user);
        return "/user_sign_in";
    }

    @PostMapping("/sign_in")
    public String signInPost(ModelMap model,
                             @ModelAttribute("user") User user){

        if (user.getUsername() == null || user.getUsername().trim().equals("")){
            //some error text
            return "user_sign_in";
        }
        else if(user.getFirstName() == null || user.getFirstName().trim().equals("")){
            //some error text
            return "user_sign_in";
        }
        else if(user.getLastName() == null || user.getLastName().trim().equals("")){
            //some error text
            return "user_sign_in";
        }
        else if(user.getPassword() == null || user.getPassword().trim().equals("")){
            //some error text
            return "user_sign_in";
        }
        else if(userRepository.findByUsername(user.getUsername()) != null){
            //some error text (user with such username already exists)
            return "user_sign_in";
        }
        else{
            LocalDate date = LocalDate.now();
            user.setCreatedAt(date);
            user.setRole(Role.USER);
            userRepository.save(user);
            return "/welcome";
        }
    }

    @GetMapping("/login")
    public String loginGet(ModelMap model){
        User user = new User();
        model.addAttribute("user", user);
        return "/login";
    }

    @PostMapping("/login")
    public String loginPost(ModelMap model,
                             @ModelAttribute("user") User user){

        User logUser = userRepository.findByUsername(user.getUsername());
        if (logUser != null){
            if (user.getPassword().equals(logUser.getPassword())){
                //sucsess
                model.addAttribute("user", logUser);
//                return "/user_page";
                return "redirect:/user_page/" + logUser.getId();
            }
            else {
                //no such user exists, try again
                return "login";
            }
        }
        else {
            //no such user exists, try again
            return "login";
        }
    }

    @GetMapping("/user_page/{id}")
    public String userPageGet(ModelMap model, @PathVariable Integer id){
        User user = userRepository.findByUserId(id);
        model.addAttribute("user", user);
        return "/user_page";
    }

    @GetMapping("/create_bank_account/{id}")
    public String createBankAccGet(ModelMap model, @PathVariable Integer id,
                                   @RequestParam(name="username", required=false) String username,
                                   @RequestParam(name="user_id", required=false) String userID){

        User user = userRepository.findByUserId(id);
        model.addAttribute("user", user);

        return "/create_bank_account";
    }

    @PostMapping("/create_bank_account/{id}")
    public String createBankAccPost(ModelMap model, @PathVariable Integer id,
                                    @RequestParam(name="username", required=false) String username,
                                    @RequestParam(name="user_id", required=false) String userID){


        User userToEdit = userRepository.findByUsername(username);
        if (userToEdit == null){
            //no user with this username
            return "redirect:/create_bank_account/" + id;
        }
        if (userToEdit.getBankAccount() == null) {
            BankAccount bankAccount = new BankAccount();
            LocalDate date = LocalDate.now();
            bankAccount.setCreatedAt(date);
            bankAccount.setBalance(0);
            bankAccount.setUser(userToEdit);
            bankAccountRepository.save(bankAccount);
            userToEdit.setBankAccount(bankAccount);
            userRepository.save(userToEdit);
            System.out.println("hello");
        }
        else{
            //some error that bank account already exists
        }

        return "redirect:/create_bank_account/" + id;
    }

    @GetMapping("/deposit/{id}")
    public String depositGet(ModelMap model, @PathVariable Integer id){

        User user = userRepository.findByUserId(id);
        model.addAttribute("user", user);
        return "/deposit";
    }

    @PostMapping("/deposit/{id}")
    public String depositPost(ModelMap model, @PathVariable Integer id,
                              @RequestParam(name="deposit_sum", required=false) Double depositSum,
                              @RequestParam(name="user_id", required=false) String userID){

        User user = userRepository.findByUserId(id);
        Transaction transaction = new Transaction();
        LocalDate date = LocalDate.now();
        transaction.setCreatedAt(date);
        transaction.setTransactionType("deposit");
        transaction.setUser(user);
        transaction.setTransactionStatus("pending");
        transaction.setTransactionSum(depositSum);
        transactionRepository.save(transaction);

        model.addAttribute("user", user);
        return "redirect:/user_page/" + id;
    }

}
