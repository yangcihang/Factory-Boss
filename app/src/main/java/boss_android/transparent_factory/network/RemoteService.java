package boss_android.transparent_factory.network;


import java.util.ArrayList;
import java.util.List;

import boss_android.transparent_factory.account.model.LoginRequest;
import boss_android.transparent_factory.account.model.LoginResponse;
import boss_android.transparent_factory.detail.model.ProcedureListResponse;
import boss_android.transparent_factory.detail.model.ProcedureNumListResponse;
import boss_android.transparent_factory.mine.model.AddEmployeeRequest;
import boss_android.transparent_factory.mine.model.EmployeeModel;
import boss_android.transparent_factory.mine.model.EmployeeUpdateRequest;
import boss_android.transparent_factory.mine.model.PasswordModel;
import boss_android.transparent_factory.mine.model.UserUpdateRequest;
import boss_android.transparent_factory.order.model.OrderListResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
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

    @GET("procedure/{procedureId}/logs")
    Call<RspModel<ProcedureNumListResponse>> requestProcedureNum(@Path("procedureId") String procedureId);

    @PUT("user/{id}")
    Call<RspModel> updateUserInfo(@Path("id") String id, @Body UserUpdateRequest requestBody);

    /**
     * 修改密码
     */
    @PUT("user/{id}")
    Call<RspModel> updateUserPassword(@Path("id") String id, @Body PasswordModel password);

    @GET("managers")
    Call<RspModel<ArrayList<EmployeeModel>>> requestEmployeeList();

    /**
     * 添加经理账号
     */
    @POST("admin/managers/create")
    Call<RspModel> addManagerInfo(@Body AddEmployeeRequest managers);

    @PUT("user/{id}")
    Call<RspModel> updateEmployeeInfo(@Path("id") String id, @Body EmployeeUpdateRequest requestBody);
}
