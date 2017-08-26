package boss_android.transparent_factory.network;

/**
 * 响应基类
 *
 * @author: Vzer.
 * @date: 2017/7/25. 16:11
 * @email: vzer@qq.com
 */

public class RspModel<T> {

    private int code; //返回码
    private T data;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
