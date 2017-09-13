package th3g3ntl3m3n.concertapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import th3g3ntl3m3n.concertapp.interfaces.ConcertAppApi;

/**
 * Created by th3g3ntl3m3n on 10/8/17.
 */

public class RestClient {

    private static final String BASE_URL = "http://www.agrasentechnical.com/";
    private ConcertAppApi apiService;

    public RestClient() {

        Retrofit restAdapter = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        apiService = restAdapter.create(ConcertAppApi.class);
    }

    public ConcertAppApi getApiService() {
        return apiService;
    }
}
