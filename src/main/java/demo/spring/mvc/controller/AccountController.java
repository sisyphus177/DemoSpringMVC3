package demo.spring.mvc.controller;

import demo.spring.model.entity.Account;
import demo.spring.model.pojo.Transaction;
import demo.spring.model.service.interf.AccountService;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by raist on 2016/5/24.
 *
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;

    @Resource(name = "accountServiceImpl")
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping("/view")
    public String viewAccount(@RequestParam(name = "id", required = false) Integer accountId, Model model) {
        Account account;
        if(accountId==null){
            System.out.println("no id provided");
            return "error";
        }else{
            //accountService.showMoneyById(id.intValue());//unnecessary unboxing
            account = accountService.showMoneyById(accountId);
            model.addAttribute(account);
            return "account";
        }
    }

    @RequestMapping("/view/{accountId}")
    public String viewAccount(@PathVariable("accountId") Integer accountId, Map<String,Object> model) {
        Account account;
        if(accountId==null){
            System.out.println("no id provided");
            return "error";
        }else{
            //accountService.showMoneyById(id.intValue());//unnecessary unboxing
            account = accountService.showMoneyById(accountId);
            model.put("account",account);
            return "account";
        }
    }

    @RequestMapping("/view_account")
    public String viewAccount(HttpServletRequest request) {
        Integer accountId = null;
        try{
            accountId = Integer.valueOf(request.getParameter("id"));
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
        Account account;
        if(accountId==null){
            System.out.println("no id provided");
            return "error";
        }else{
            //accountService.showMoneyById(id.intValue());//unnecessary unboxing
            account = accountService.showMoneyById(accountId);
            request.setAttribute("account",account);
            return "account";
        }
    }

    @RequestMapping(value = "/transfer",method = RequestMethod.GET)
    public String transfer() {
        return "transfer";
    }

    @RequestMapping(value = "/doTransfer",method = RequestMethod.POST)
    public String transferMoney(@ModelAttribute Transaction transaction, Model model) {
        try{
            System.out.println(ReflectionToStringBuilder.toString(transaction));
            if(accountService.showMoneyById(transaction.getFromAccount())==null||accountService.showMoneyById(transaction.getToAccount())==null){
                throw new Exception("Invalid account id.");
            }
            accountService.transfer(transaction.getFromAccount(),transaction.getToAccount(),transaction.getTransferMoney());
            Account fromAccount = accountService.showMoneyById(transaction.getFromAccount());
            Account toAccount = accountService.showMoneyById(transaction.getToAccount());
            model.addAttribute("fromAccount",fromAccount);
            model.addAttribute("toAccount",toAccount);
            return "result";
        }catch(Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping(value = "/json/{id}", method = RequestMethod.GET)
    public @ResponseBody Account getAccountJson(@PathVariable("id") Integer id){
//        Account account;
//        if(id==null){
//            return null;
//        }else{
//            account = accountService.showMoneyById(id);
//            return account;
//        }
        return accountService.showMoneyById(id);
    }

    @RequestMapping(value = "/json2/{id}", method = RequestMethod.GET)
    public ResponseEntity<Account> getAccountJson2(@PathVariable("id") Integer id){
//        Account account;
//        if(id==null){
//            return null;
//        }else{
//            account = accountService.showMoneyById(id);
//            return account;
//        }
        return new ResponseEntity<>(accountService.showMoneyById(id), HttpStatus.OK);
    }

}
