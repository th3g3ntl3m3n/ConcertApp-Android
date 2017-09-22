package th3g3ntl3m3n.concertapp.interfaces;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import th3g3ntl3m3n.concertapp.data.Demo;
import th3g3ntl3m3n.concertapp.data.DemoUser;
import th3g3ntl3m3n.concertapp.data.POJOResponse;
import th3g3ntl3m3n.concertapp.data.Puskesmas;
import th3g3ntl3m3n.concertapp.data.ReportsPOJO;
import th3g3ntl3m3n.concertapp.data.User;

/**
 * Created by th3g3ntl3m3n on 10/8/17.
 */

public interface ConcertAppApi {

    @POST("/concert-webservices/webservices/login.php")
    Call<POJOResponse> getLoginAuth(@Query("name") String email, @Query("password") String pass);

    @POST("/concert-webservices/webservices/sign_up.php")
    Call<POJOResponse> getSignup(@Query("username") String username, @Query("password") String pass, @Query("email") String s3);

    @POST("/concert-webservices/webservices/report.php")
    Call<DemoUser> insertReport(@Body Demo demo);

    @FormUrlEncoded
    @POST("/concert-webservices/webservices/test.php")
    Call<DemoUser> sendData(@FieldMap Map<String, String> data);

    @GET("/concert-webservices/webservices/getusers.php")
    Call<ArrayList<DemoUser>> getAllUsers();

    @POST("/concert-webservices/webservices/adduser.php")
    Call<DemoUser> addUser(@Body User user);

    @GET("/concert-webservices/webservices/areas.php")
    Call<ArrayList<DemoUser>> getAreas();

    @POST("/concert-webservices/webservices/addarea.php")
    Call<ArrayList<DemoUser>> addArea(@Body DemoUser areaName);

    @POST("/concert-webservices/webservices/addpuskesmas.php")
    Call<DemoUser> addPuskesmas(@Body Puskesmas puskesmas);

    @POST("/concert-webservices/webservices/getpuskesmas.php")
    Call<DemoUser> getPuskesmas(@Body Puskesmas puskesmas);

    @GET("/concert-webservices/webservices/getAreaPusk.php")
    Call<ArrayList<DemoUser>> getAllThing();

    @POST("/concert-webservices/webservices/getreports.php")
    Call<ArrayList<ReportsPOJO>> getReports(@Query("area") String area);

    @POST("/concert-webservices/webservices/getreports.php")
    Call<ArrayList<ReportsPOJO>> getReportsWithPusk(@Query("puskesmas") String puskesmas);

    @POST("/concert-webservices/webservices/getreports.php")
    Call<ArrayList<ReportsPOJO>> getEmpReport(@Query("name") String name);

    @POST("/concert-webservices/webservices/addclinictype.php")
    Call<DemoUser> addClinicType(@Body DemoUser demo);

    @GET("/concert-webservices/webservices/addclinictype.php")
    Call<ArrayList<DemoUser>> getAllClinicTypes();
}
