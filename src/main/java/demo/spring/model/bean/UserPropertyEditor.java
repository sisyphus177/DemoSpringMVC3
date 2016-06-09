package demo.spring.model.bean;

import demo.spring.model.entity.Account;

import java.beans.PropertyEditorSupport;

/**
 * Created by raist on 2016/5/31.
 *
 */
public class UserPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text){
        User user = new User();
        String[] attribute = text.split(",");
        user.setUsername(attribute[0]);
        user.setPassword(attribute[1]);
        Account account = new Account();
        account.setId(Integer.valueOf(attribute[2]));
        user.setAccount(account);
        System.out.println(user.hashCode());
        this.setValue(user);
    }

    public static void main(String[] args) {
        UserPropertyEditor u = new UserPropertyEditor();
        u.setAsText("user,pass,1");
        System.out.println(u.getValue());
    }

}
