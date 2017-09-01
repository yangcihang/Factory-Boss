package boss_android.transparent_factory.network;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import boss_android.transparent_factory.common.Config;
import boss_android.transparent_factory.common.User;
import boss_android.transparent_factory.network.convert.ResponseConverterFactory;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * 网络请求类的封装
 *
 * @author: Vzer.
 * @date: 2017/7/25. 15:04
 * @email: vzer@qq.com
 */

public class NetWork {

    private static NetWork instance;
    private Retrofit retrofit;

    static {
        instance = new NetWork();
    }

    public static NetWork getInstance() {
        return instance;
    }

    /**
     * 封装Retrofit
     *
     * @return Retrofit
     */
    public static Retrofit getRetrofit() {
        if (instance.retrofit != null) return instance.retrofit;

        OkHttpClient client = new OkHttpClient.Builder()
                //在发送和响应时拦截
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        String token = User.getToken();
                        Request request = chain.
                                request().
                                newBuilder().
                                //请求时带入token
                                        addHeader("token", token).
                                        build();
                        Response response = chain.proceed(request);
//                        //获取响应json数据
//                        String json = response.body().string();
//                        try {
//                            JSONObject obj = new JSONObject(json);
//                            if (response.code() != 200) {
//                                // TODO: 17/8/20 网络请求失败时,做全局处理
//                            } else if (obj.get("code") != 0) {
//                                // TODO: 17/8/20 请求响应异常时，做处理
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
                        return response;
                    }
                })
                .connectTimeout(Config.APP_SERVER_CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .build();

        instance.retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .client(client)
                //设置Json解析器
                .addConverterFactory(ResponseConverterFactory.create())
                .build();

        return instance.retrofit;
    }

    /**
     * 返回封装后的网络接口类
     *
     * @return RemoteService
     */
    public static RemoteService getService() {
        return getRetrofit().create(RemoteService.class);
    }
}
