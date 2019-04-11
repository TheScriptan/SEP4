package com.example.legalizeco2.business.data.network;

import com.example.legalizeco2.business.model.Room;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkHelper {

    private String BASE_URL = "https://localhost:5001/v1/";

    private static NetworkHelper sInstance;
    private Retrofit retrofit;
    private APIEndpoints endpoints;

    private MutableLiveData<List<Room>> roomListData;

    private NetworkHelper(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        endpoints = retrofit.create(APIEndpoints.class);

        roomListData = new MutableLiveData<>();
    }

    public static NetworkHelper getInstance() {
        if(sInstance == null){
            synchronized (NetworkHelper.class){
                if(sInstance == null){
                    sInstance = new NetworkHelper();
                }
            }
        }
        return sInstance;
    }

    public LiveData<List<Room>> getRoomList() {return roomListData;}

    public void refreshRoom() {
        Call<List<Room>> call =endpoints.getRoomList();

        CallbackList.getRoomList(call, roomListData);
    }

}