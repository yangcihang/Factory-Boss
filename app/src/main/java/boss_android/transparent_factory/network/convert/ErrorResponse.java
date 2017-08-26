package boss_android.transparent_factory.network.convert;

/**
 * 解析异常时的Response
 *
 * @author YangCihang
 * @since 17/8/21.
 * email yangcihang@hrsoft.net
 */


public class ErrorResponse {
    private int code;
    private String data;

    public ErrorResponse(int code, String data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
