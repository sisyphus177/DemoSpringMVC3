package demo.spring.model.bean;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by raist on 2016/5/30.
 *
 */
public class UserSet {
    private Set<User> set;

    public UserSet() {
        set = new LinkedHashSet<>();
        set.add(new User());
        set.add(new User());
    }

    public Set<User> getSet() {
        return set;
    }

    public void setSet(Set<User> set) {
        this.set = set;
    }
}
