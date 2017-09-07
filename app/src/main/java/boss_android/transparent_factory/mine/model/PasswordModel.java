package boss_android.transparent_factory.mine.model;

import java.io.Serializable;

/**
 * @author YangCihang
 * @since 17/9/6.
 * email yangcihang@hrsoft.net
 */

public class PasswordModel implements Serializable {
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
