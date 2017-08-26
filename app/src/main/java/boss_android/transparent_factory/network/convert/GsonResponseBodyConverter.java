package boss_android.transparent_factory.network.convert;


import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import boss_android.transparent_factory.network.RspModel;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * 响应时Body解析
 *
 * @author YangCihang
 * @since 17/8/21.
 * email yangcihang@hrsoft.net
 */

class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final Type type;

    public GsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        //将返回的json数据储存在String类型的response中
        String response = value.string();
        //将外层的数据解析到APIResponse类型的httpResult中
        RspModel httpResult = gson.fromJson(response, RspModel.class);
        //服务端设定0为正确的请求，故在此为判断标准
        if (httpResult.getCode() == 0) {
            //直接解析，正确请求不会导致json解析异常
            return gson.fromJson(response, type);
        } else {
            //定义错误响应体，并通过抛出自定义异常传递错误码及错误信息
            ErrorResponse errorResponse = gson.fromJson(response, ErrorResponse.class);
            throw new ResultException(errorResponse.getCode(), errorResponse.getData());
        }
    }
}