package demo.spring.model.bean;

import demo.spring.model.entity.Account;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by raist on 2016/5/30.
 *
 */
public class User {
    private String username;
    private String password;
    private Account account;

    public User() {
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof User)) return false;
//
//        User user = (User) o;
//
//        if (!getUsername().equals(user.getUsername())) return false;
//        return getPassword().equals(user.getPassword());
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = getUsername().hashCode();
//        result = 31 * result + getPassword().hashCode();
//        return result;
//    }
//
//    public static void main(String[] args){
//        Set<User> set = new HashSet<>();
//        User u1 = new User();
//        u1.setUsername("aaa");
//        u1.setPassword("aaa");
//        User u2 = new User();
//        u2.setUsername("bbb");
//        u2.setPassword("bbb");
//        set.add(u1);
//        set.add(u2);
//        System.out.println(set);
//        System.out.println(set.size());
//    }
}
