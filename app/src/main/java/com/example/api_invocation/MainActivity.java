package com.example.api_invocation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.widget.Toast;


import java.util.List;

import ApiResponses.Responses;
import ApiResponses.Results;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import utils.RetrofitClient;

public class MainActivity extends AppCompatActivity {


    ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.listCharacters);

        getCharacters();

    }

    private void getCharacters() {

        Call<Responses> call = RetrofitClient.getInstance().getInvoke().getCharacters();

        call.enqueue(new Callback<Responses>() {


            @Override
            public void onResponse(Call<Responses> call, Response<Responses> response) {

                if (response.isSuccessful()) {

                    List<Results> personas = response.body().getResults();
                    if (personas.size() > 0) {
                        String[] oneCharacter = new String[personas.size()];

                        for (int i = 0; i < personas.size(); i++) {
                            oneCharacter[i] = personas.get(i).getName();
                            System.out.println(oneCharacter[i].toString());
                        }
                        list.setAdapter(new ArrayAdapter<String>(getApplicationContext(), R.layout.list_black_text,R.id.list_content,oneCharacter));

                    }

                }

            }

            @Override
            public void onFailure(Call<Responses> call, Throwable t) {
                System.out.println("MI PITO SE LLAMA CHUCKY:  ----> " + t.getMessage());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }


}