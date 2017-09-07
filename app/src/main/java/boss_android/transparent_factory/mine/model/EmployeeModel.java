package boss_android.transparent_factory.mine.model;

import java.io.Serializable;

/**
 * @author YangCihang
 * @since 17/9/1.
 * email yangcihang@hrsoft.net
 */

public class EmployeeModel implements Serializable {
    //       "id": 5,
//               "name": "杨慈航",
//               "email": null,
//               "mobile": "15028595852",
//               "sex": null,
//               "status": 0,
//               "avatar": null,
//               "createdAt": "2017-09-05 11:20:58",
//               "updatedAt": "2017-09-05 11:20:58"}
    private int id;
    private String name;
    private String email;
    private String mobile;
    private String password;
    private int status;
//    private String avatar;//头像信息


    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
