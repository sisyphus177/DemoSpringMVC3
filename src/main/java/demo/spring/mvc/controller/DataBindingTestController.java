package demo.spring.mvc.controller;

import demo.spring.model.bean.*;
import demo.spring.model.entity.Account;
import demo.spring.model.service.interf.AccountService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.List;

/**
 * Created by raist on 2016/5/30.
 *
 */
@Controller
@RequestMapping("/acct")
public class DataBindingTestController {

    private AccountService accountService;

    @Resource(name = "accountServiceImpl")
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping("/view/{accountId}")
    public @ResponseBody Account viewAccount(@PathVariable("accountId") Integer accountId) {
        Account account;
        if(accountId==null){
            return null;
        }else{
            account = accountService.showMoneyById(accountId);
            return account;
        }
    }

//    @RequestMapping("/v/{accountId}")
//    public @ResponseBody Account viewAccount(@PathVariable("accountId") int accountId) {
//        return accountService.showMoneyById(accountId);
//    }

    @RequestMapping("/show")
    public @ResponseBody Account showAccount(@RequestParam(name = "id", required = false) Integer accountId) {
        if(accountId==null)return null;
        return accountService.showMoneyById(accountId);
    }

    @RequestMapping("/list")
    public @ResponseBody String[] listAccount(@RequestParam(name = "name", required = false) String[] accountName) {
        return accountName;
    }

    @RequestMapping("/detail")
    public @ResponseBody Account detailAccount(@ModelAttribute("user")Account account) {
        if(account==null)return null;
        return accountService.showMoneyById(account.getId());
    }

    @RequestMapping("/user")
    public @ResponseBody User userCheck(@ModelAttribute("currentUser") User user) {
        if(user==null)return null;
        if(user.getAccount()==null)return user;
        user.setAccount(accountService.showMoneyById(user.getAccount().getId()));
        return user;
    }

    @InitBinder("currentUser")
    public void initUser(WebDataBinder binder){
        binder.setFieldDefaultPrefix("user.");
    }

    @RequestMapping("/userList")
    public @ResponseBody
    UserList userListCheck(@ModelAttribute("list") UserList userList) {
        if(userList==null)return null;
        if(userList.getList().size()==0)return null;
        for(User user:userList.getList()){
            if(user.getAccount()==null)continue;
            user.setAccount(accountService.showMoneyById(user.getAccount().getId()));
        }
        return userList;
    }

    @RequestMapping("/userSet")
    public @ResponseBody
    UserSet userSetCheck(@ModelAttribute("set") UserSet userSet) {
        if(userSet==null)return null;
        if(userSet.getSet().size()==0)return null;
        for(User user:userSet.getSet()){
            if(user.getAccount()==null)continue;
            user.setAccount(accountService.showMoneyById(user.getAccount().getId()));
        }
        return userSet;
    }

    @RequestMapping("/userMap")
    public @ResponseBody
    UserMap userMapCheck(@ModelAttribute("map") UserMap userMap) {
        if(userMap==null)return null;
        if(userMap.getMap().size()==0)return null;
        for(User user:userMap.getMap().values()){
            if(user.getAccount()==null)continue;
            user.setAccount(accountService.showMoneyById(user.getAccount().getId()));
        }
        return userMap;
    }

    @RequestMapping("/json")
    public @ResponseBody
    Account showAccountJson(@RequestBody Account account) {
        if(account==null)return null;
        return accountService.showMoneyById(account.getId());
    }

    @RequestMapping("/xml")
    public @ResponseBody
    Account showAccountXml(@RequestBody Account account) {
        if(account==null)return null;
        return accountService.showMoneyById(account.getId());
    }

    @RequestMapping("/returnDate")
    public @ResponseBody
    String returnDate(@RequestParam(name = "inputDate") Date inputDate) {
        return inputDate.toString();
    }

    @InitBinder("inputDate")
    public void initInputDate(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),Boolean.TRUE));
    }

    @RequestMapping("/returnUser")
    public @ResponseBody
    User returnUser(@RequestParam(name = "inputUser") User user) {
        if(user==null)return null;
        if(user.getAccount()==null)return user;
        user.setAccount(accountService.showMoneyById(user.getAccount().getId()));
        return user;
    }

    @InitBinder("inputUser")
    public void initInputUser(WebDataBinder binder){
        binder.registerCustomEditor(User.class,new UserPropertyEditor());
    }

    @RequestMapping("/returnNewDate")
    public @ResponseBody
    String returnNewDate(@RequestParam(name = "date") Date date) {
        return date.toString();
    }

    @RequestMapping("/boolean")
    public @ResponseBody
    String getBoolean(@RequestParam(name = "input", required = false) Boolean input) {
        return input.toString();
    }

}
