package boss_android.transparent_factory.mine.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author YangCihang
 * @since 17/9/6.
 * email yangcihang@hrsoft.net
 */

public class AddEmployeeRequest implements Serializable {
    private List<EmployeeModel> managers;

    public void setManagers(List<EmployeeModel> managers) {
        this.managers = managers;
    }

    public List<EmployeeModel> getManagers() {
        return managers;
    }
}
