package boss_android.transparent_factory.mine.model;

import java.io.Serializable;

/**
 * @author YangCihang
 * @since 17/9/7.
 * email yangcihang@hrsoft.net
 */

public class EmployeeUpdateRequest implements Serializable {
    private String name;
    private String mobile;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public String getMobile() {
        return mobile;
    }

    public String getName() {
        return name;
    }
}
