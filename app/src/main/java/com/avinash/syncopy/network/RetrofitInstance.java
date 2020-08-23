package com.avinash.syncopy.network;

import com.avinash.syncopy.model.Clip;
import com.avinash.syncopy.model.ClipList;
import com.avinash.syncopy.model.ClipPUT;
import com.avinash.syncopy.model.ConnectionList;
import com.avinash.syncopy.model.Key;
import com.avinash.syncopy.model.Response;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public class RetrofitInstance {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://syncopy-api.herokuapp.com";//http://127.0.0.1:5000
//    private static final String BASE_URL = "http://127.0.0.1:5000";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public interface GetAllSenderClips {

        @GET("/sent/{id}")
        Call<ClipList> getAllSenderClips(@Path("id") String id);

    }

    public interface DeleteAllSenderClips {

        @DELETE("/sent/{id}")
        Call<Response> deleteAllSenderClips(@Path("id") String id);

    }

    public interface GetSenderClips {

        @GET("/sent/{id}/{n}")
        Call<ClipList> getSenderClips(@Path("id") String id, @Path("n") int n);

    }

    public interface GenerateKey {

        @POST("/generate_key")
        Call<Key> generateKey(@Body HashMap<String, Object> body);
    }

    public interface AddConnection {

        @POST("/add_connection")
        Call<Response> addConnection(@Body HashMap<String, Object> body);

    }

    public interface GetConnections {

        @GET("/connections/{UUID}")
        Call<ConnectionList> getConnections(@Path("UUID") String uuid);

    }

    public interface SendClip {

        @POST("/clip")
        Call<Response> sendClip(@Body Clip clip);

    }

    public interface GetRecievedClips {

        @GET("/recieved/{UUID}/{n}")
        Call<ClipList> getRecievedClips(@Path("UUID") String uuid, @Path("n") int n);

    }

    public interface GetAllRecievedClips {

        @GET("/recieved/{UUID}")
        Call<ClipList> getAllRecievedClips(@Path("UUID") String uuid);

    }

    public interface PutCheckedClip {

        @PUT("/recieved/{UUID}/1")
        Call<ClipPUT> putCheckedClip(@Path("UUID") String uuid);

    }

    public interface GetKey {

        @GET("/key/{username}")
        Call<Key> getKey(@Path("username") String name);

    }

}
