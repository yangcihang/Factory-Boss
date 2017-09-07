package boss_android.transparent_factory.mine.model;

import java.io.Serializable;

/**
 * @author YangCihang
 * @since 17/9/6.
 * email yangcihang@hrsoft.net
 */

public class UserUpdateRequest implements Serializable {
    //    "name": "留暗号",
//            "password": "123457",
//            "mobile": "15076051320",
//            "email": "mm@3m.com"
    private String name;
    private String mobile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
