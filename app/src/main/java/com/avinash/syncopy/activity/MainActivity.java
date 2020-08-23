package com.avinash.syncopy.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.avinash.syncopy.R;
import com.avinash.syncopy.model.Clip;
import com.avinash.syncopy.model.ClipList;
import com.avinash.syncopy.model.ClipPUT;
import com.avinash.syncopy.model.ConnectionList;
import com.avinash.syncopy.model.Key;
import com.avinash.syncopy.network.RetrofitInstance;

import java.util.Calendar;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    TextView clipList;
    Button getB;
    Button clearB;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        clipList = findViewById(R.id.clipListT);
        getB = findViewById(R.id.getB);
        clearB = findViewById(R.id.clearB);

        /*Create handle for the RetrofitInstance interface*/

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    getB.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            final RetrofitInstance.GenerateKey service = RetrofitInstance.getRetrofitInstance().create(RetrofitInstance.GenerateKey.class);
                            generateKey(service);
                        }
                    });
                }
                if(position == 1){

                    getB.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            final RetrofitInstance.AddConnection service = RetrofitInstance.getRetrofitInstance().create(RetrofitInstance.AddConnection.class);
                            addConnection(service);

                        }
                    });

                }

                if(position == 2) {

                    getB.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            final RetrofitInstance.GetConnections service = RetrofitInstance.getRetrofitInstance().create(RetrofitInstance.GetConnections.class);
                            getConnections(service);

                        }
                    });

                }

                if(position == 3) {

                    getB.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            final RetrofitInstance.SendClip service = RetrofitInstance.getRetrofitInstance().create(RetrofitInstance.SendClip.class);
                            sendClip(service);

                        }
                    });

                }

                if(position == 4) {

                    getB.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            final RetrofitInstance.GetRecievedClips service = RetrofitInstance.getRetrofitInstance().create(RetrofitInstance.GetRecievedClips.class);
                            getRecieverClip(service);

                        }
                    });

                }

                if(position == 5) {

                    getB.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            final RetrofitInstance.PutCheckedClip service = RetrofitInstance.getRetrofitInstance().create(RetrofitInstance.PutCheckedClip.class);
                            putCheckedClip(service);

                        }
                    });

                }

                if (position == 6) {

                    getB.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            final RetrofitInstance.GetSenderClips service = RetrofitInstance.getRetrofitInstance().create(RetrofitInstance.GetSenderClips.class);
                            getSentClips(service);
                        }
                    });

                }
                if (position == 7) {

                    getB.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            final RetrofitInstance.GetAllSenderClips service = RetrofitInstance.getRetrofitInstance().create(RetrofitInstance.GetAllSenderClips.class);
                            getAllSentClips(service);
                        }
                    });

                }

                if(position == 8) {

                    getB.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            final RetrofitInstance.DeleteAllSenderClips service = RetrofitInstance.getRetrofitInstance().create(RetrofitInstance.DeleteAllSenderClips.class);
                            deleteAllSenderClips(service);

                        }
                    });

                }

                if(position == 9) {

                    getB.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            final RetrofitInstance.GetAllRecievedClips service = RetrofitInstance.getRetrofitInstance().create(RetrofitInstance.GetAllRecievedClips.class);
                            getAllRecieverClip(service);

                        }
                    });


                }

                if (position == 10) {

                    getB.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            final RetrofitInstance.GetKey service = RetrofitInstance.getRetrofitInstance().create(RetrofitInstance.GetKey.class);
                            getKey(service);

                        }
                    });

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        clearB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clipList.setText("");

            }
        });




    }



    private void getKey(RetrofitInstance.GetKey service){

        Call<Key> call = service.getKey("avinash");
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<Key>() {
            @Override
            public void onResponse(Call<Key> call, Response<Key> response) {

                if(response.isSuccessful()) {
                    String data = response.body().toString();
                    clipList.setText(data);
                    Log.i(TAG, "onResponse: "+data);
                }
                else{
                    Log.i(TAG, "onResponse: FAILED");
                }
            }

            @Override
            public void onFailure(Call<Key> call, Throwable t) {

            }
        });
    }

    private void putCheckedClip(RetrofitInstance.PutCheckedClip service) {

        Call<ClipPUT> call = service.putCheckedClip("w32a2w");
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<ClipPUT>() {
            @Override
            public void onResponse(Call<ClipPUT> call, Response<ClipPUT> response) {

                if(response.isSuccessful()) {

                    String data = response.body().toString();
                    clipList.setText(data);
                    Log.i(TAG, "onResponse: "+data);

                }
                else{
                    Log.i(TAG, "onResponse: FAILED");
                }

            }

            @Override
            public void onFailure(Call<ClipPUT> call, Throwable t) {

            }
        });

    }

    private void getRecieverClip(RetrofitInstance.GetRecievedClips service) {

        Call<ClipList> call = service.getRecievedClips("w32a2w", 4);
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<ClipList>() {
            @Override
            public void onResponse(Call<ClipList> call, Response<ClipList> response) {

                if(response.isSuccessful()){

                    String data = response.body().toString();
                    clipList.setText(data);
                    Log.i(TAG, "onResponse: "+data);

                }

            }

            @Override
            public void onFailure(Call<ClipList> call, Throwable t) {

            }
        });

    }

    private void getAllRecieverClip(RetrofitInstance.GetAllRecievedClips service) {

        Call<ClipList> call = service.getAllRecievedClips("w32a2w");
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<ClipList>() {
            @Override
            public void onResponse(Call<ClipList> call, Response<ClipList> response) {

                if(response.isSuccessful()){

                    String data = response.body().toString();
                    clipList.setText(data);
                    Log.i(TAG, "onResponse: "+data);

                }
                else {
                    Log.i(TAG, "onResponse: FAILED");
                }
            }

            @Override
            public void onFailure(Call<ClipList> call, Throwable t) {

            }
        });

    }

    private void sendClip(RetrofitInstance.SendClip service) {

        String time = Long.toString(Calendar.getInstance().getTimeInMillis());
        Log.i(TAG, "sendClip: "+time);
        Call<com.avinash.syncopy.model.Response> call = service.sendClip(new Clip("avinash", "raven", "332a1w", "w32a2w", "Hello this is avinash from android", false, time));
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<com.avinash.syncopy.model.Response>() {
            @Override
            public void onResponse(Call<com.avinash.syncopy.model.Response> call, Response<com.avinash.syncopy.model.Response> response) {
                
                if(response.isSuccessful()){
                    
                    String data = response.body().toString();
                    clipList.setText(data);
                    Log.i(TAG, "onResponse: data "+data);
                }
                else {

                    Log.i(TAG, "onResponse: FAILED");
                    
                }
                
            }

            @Override
            public void onFailure(Call<com.avinash.syncopy.model.Response> call, Throwable t) {

            }
        });

    }

    private void getConnections(RetrofitInstance.GetConnections service){

        Call<ConnectionList> call = service.getConnections("w32d1d");

        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<ConnectionList>() {
            @Override
            public void onResponse(Call<ConnectionList> call, Response<ConnectionList> response) {

                if (response.isSuccessful()) {

                    String data = response.body().toString();
                    clipList.setText(data);
                    Log.i(TAG, "onResponse: " + data);
                } else {
                    Log.i(TAG, "onResponse: FAILED");

                }
            }

            @Override
            public void onFailure(Call<ConnectionList> call, Throwable t) {

            }
        });

    }

    private void addConnection(RetrofitInstance.AddConnection service) {

        HashMap<String, Object> body = new HashMap<>();
        body.put("uuid_sender", "w32d1d");
        body.put("uuid_reciever", "wwdd2w");

        Call<com.avinash.syncopy.model.Response> call = service.addConnection(body);

        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<com.avinash.syncopy.model.Response>() {
            @Override
            public void onResponse(Call<com.avinash.syncopy.model.Response> call, Response<com.avinash.syncopy.model.Response> response) {
                if(response.isSuccessful()) {

                    String data = response.body().toString();
                    Log.i(TAG, "onResponse: "+data);
                    clipList.setText(data);
                }
                else {
                    clipList.setText("Connection already present");
                    Log.i(TAG, "FAILED");

                }
            }

            @Override
            public void onFailure(Call<com.avinash.syncopy.model.Response> call, Throwable t) {

            }
        });

    }

    private void generateKey(RetrofitInstance.GenerateKey service){

        HashMap<String, Object> body = new HashMap<>();
        body.put("unique_str", "y2y13y123y12y3y12");
        body.put("username", "pranav");
        body.put("isPc", false);
        Call<Key> call = service.generateKey(body);

        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<Key>() {
            @Override
            public void onResponse(Call<Key> call, Response<Key> response) {
                if(response.isSuccessful()){

                    String data = response.body().toString();
                    Log.i(TAG, "onResponse: "+data);
                    clipList.setText(data);

                }
                else {
                    Log.i(TAG, "onResponse:" + response.errorBody().toString());
                    clipList.setText("{\"message\": UUID already generated for this username}");
                }
            }

            @Override
            public void onFailure(Call<Key> call, Throwable t) {
                Log.i(TAG, "onFailure: "+t.getMessage());
            }
        });

    }

    private void getSentClips(RetrofitInstance.GetSenderClips service) {

        /*Call the method with parameter in the interface to get the employee data*/
        Call<ClipList> call = service.getSenderClips("332a1w", 1);

        /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<ClipList>() {
            @Override
            public void onResponse(Call<ClipList> call, Response<ClipList> response) {
                if(response.isSuccessful()) {
                    String data = response.body().toString();
                    Log.i(TAG, "onResponse: " + data);
                    clipList.setText(data);
                }
                else{
                    Log.i(TAG, "onResponse: ");
                }
            }

            @Override
            public void onFailure(Call<ClipList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void getAllSentClips(RetrofitInstance.GetAllSenderClips service) {

        /*Call the method with parameter in the interface to get the employee data*/
        Call<ClipList> call = service.getAllSenderClips("332a1w");

        /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<ClipList>() {
            @Override
            public void onResponse(Call<ClipList> call, Response<ClipList> response) {
                if(response.isSuccessful()) {
                    String data = response.body().toString();
                    Log.i(TAG, "onResponse: " + data);
                    clipList.setText(data);
                }
                else{
                    Log.i(TAG, "onResponse: ");
                }
            }

            @Override
            public void onFailure(Call<ClipList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();

            }
        });

    }
    private void deleteAllSenderClips(RetrofitInstance.DeleteAllSenderClips service) {

        /*Call the method with parameter in the interface to get the employee data*/
        Call<com.avinash.syncopy.model.Response> call = service.deleteAllSenderClips("332a1w");

        /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<com.avinash.syncopy.model.Response>() {
            @Override
            public void onResponse(Call<com.avinash.syncopy.model.Response> call, Response<com.avinash.syncopy.model.Response> response) {
                if(response.isSuccessful()) {
                    String data = response.body().toString();
                    Log.i(TAG, "onResponse: " + data);
                    clipList.setText(data);
                }
                else{
                    Log.i(TAG, "onResponse: ");
                }
            }

            @Override
            public void onFailure(Call<com.avinash.syncopy.model.Response> call, Throwable t) {

            }
        });

    }
}