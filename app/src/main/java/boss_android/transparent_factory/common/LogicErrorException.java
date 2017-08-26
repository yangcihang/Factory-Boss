package boss_android.transparent_factory.common;

/**
 * @author YangCihang
 * @since 17/8/25.
 * email yangcihang@hrsoft.net
 */

public class LogicErrorException extends Throwable {
    public LogicErrorException() {
        super("逻辑上不可达的代码，请检查！！！");
    }
}
