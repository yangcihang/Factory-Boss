package boss_android.transparent_factory.detail.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author YangCihang
 * @since 17/9/1.
 * email yangcihang@hrsoft.net
 */

public class ProcedureListResponse implements Serializable {
    private List<ProcedureModel> procedures;

    public void setProcedures(List<ProcedureModel> procedures) {
        this.procedures = procedures;
    }

    public List<ProcedureModel> getProcedures() {
        return procedures;
    }
}
