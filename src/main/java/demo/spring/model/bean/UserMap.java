package demo.spring.model.bean;

import java.util.Map;

/**
 * Created by raist on 2016/5/30.
 *
 */
public class UserMap {
    private Map<String,User> map;

    public Map<String, User> getMap() {
        return map;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }
}
