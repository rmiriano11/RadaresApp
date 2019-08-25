package com.example.radaresapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.radaresapp.webservice.Api;
import com.example.radaresapp.webservice.RequestHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

public class ViagensPendentes extends AppCompatActivity {

    private static final int CODE_GET_REQUEST = 1020;
    private static final int CODE_POST_REQUEST = 1025;

    List<RadaresApp> radaresappList;
    @Override
    protected void onCreate (Bundle savedIntanceSatate){
        super.onCreate(savedIntanceSatate);
        setContentView(R.layout.activity_pendentes);

        Button homePendentes = (Button)findViewById(R.id.voltarPendentes);
        homePendentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent that = new Intent(ViagensPendentes.this, MainActivity.class);
                startActivity(that);
            }
        });
    }

    private void readRadaresApp(){
        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_READ_RADARES, null, CODE_GET_REQUEST);
        request.execute();
    }

    private void refreshRadaresAppList(JSONArray radaresapp) throws JSONException{
        radaresappList.clear();

        for (int i = 0; i < radaresapp.length(); i++){
            JSONObject obj = radaresapp.getJSONObject(i);

            radaresappList.add(new RadaresApp(
                    obj.getInt(""),
                    obj.getString(""),
                    obj.getString(""),
                    obj.getString(""),
                    obj.getString(""),
            ));
        }
        RadaresAppAdapter adapter = new RadaresAppAdapter(radaresappList);
        listView.setAdapter(adapter);
    }

    private class PerformNetworkRequest extends AsyncTask<Void, Void, String>{
        String url;
        HashMap<String, String> params;
        int requestCode;

        PerformNetworkRequest(String url, HashMap<String, String> params, int requestCode){
            this.url = url;
            this.params = params;
            this.requestCode = requestCode;
        }

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);
            try{
                JSONObject object = new JSONObject(s);
                if (!object.getBoolean("error")){
                    Toast.makeText(getApplicationContext(),object.getString("message"), Toast.LENGTH_LONG).show();
                    refreshRadaresAppList(object.getJSONArray("radaresapp"));
                }
            }catch (JSONException e){
                e.printStackTrace();
            }
        }

        @Override
        protected void doInBackgroud(Void... voids){
            RequestHandler requestHandler = new RequestHandler();

            if (requestCode == CODE_POST_REQUEST){
                return requestHandler.sendPostRequest(url, params);
            }

            if (requestCode == CODE_GET_REQUEST){
                return requestHandler.sendGetRequest(url);
            }
            return null;
        }
    }

    class RadaresAppAdapter extends ArrayAdapter<RadaresApp>{
        List<RadaresApp> radaresAppList;

        public RadaresAppAdapter(List<RadaresApp> radaresAppList){
            super(ViagensPendentes.this, R.layout.layout_radaresapp, radaresAppList);
            this.radaresAppList = radaresAppList;
        }

    }
}
