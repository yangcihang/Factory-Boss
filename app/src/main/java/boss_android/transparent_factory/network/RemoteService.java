package boss_android.transparent_factory.network;


import boss_android.transparent_factory.account.model.LoginRequest;
import boss_android.transparent_factory.account.model.LoginResponse;
import boss_android.transparent_factory.detail.model.ProcedureListResponse;
import boss_android.transparent_factory.order.model.OrderListResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 网络接口请求类
 *
 * @author: Vzer.
 * @date: 2017/7/25. 15:54
 * @email: vzer@qq.com
 */

public interface RemoteService {
    @GET("order/unstart")
    Call<RspModel<OrderListResponse>> requestUnstartList(@Query("page") String page, @Query("size") String size);

    @GET("order/past")
    Call<RspModel<OrderListResponse>> requestFinishedList(@Query("page") String page, @Query("size") String size);

    @GET("order/current")
    Call<RspModel<OrderListResponse>> requestProcessingList(@Query("page") String page, @Query("size") String size);

    @POST("user/login")
    Call<RspModel<LoginResponse>> login(@Body LoginRequest request);

    @GET("order/{orderId}/procedures")
    Call<RspModel<ProcedureListResponse>> requestProcedureList(@Path("orderId") String orderId);
}
