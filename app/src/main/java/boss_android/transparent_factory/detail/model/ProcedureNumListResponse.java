package boss_android.transparent_factory.detail.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author YangCihang
 * @since 17/9/4.
 * email yangcihang@hrsoft.net
 */

public class ProcedureNumListResponse implements Serializable {
    private List<ProcedureNumModel> logs;

    public void setLogs(List<ProcedureNumModel> logs) {
        this.logs = logs;
    }

    public List<ProcedureNumModel> getLogs() {
        return logs;
    }
}
