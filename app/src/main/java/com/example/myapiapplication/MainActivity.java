package com.example.myapiapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    Button btnSingle;
    List<String> lDate = new ArrayList<String>();
    List<WeatherObject> lWeather = new ArrayList<WeatherObject>();
    EditText city;
    TextView txtWeather;
    String strApiKey = "6bac8e0bb36db85cb143db95b8c254b9";
    Bitmap imgResLRain,imgResSunny,imgResCast,imgResMod,imgResRain, img;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSingle = (Button) findViewById(R.id.btnSingle);
        city = findViewById(R.id.txtCity);


    }

    public void Forecast(View v) {
        lWeather.clear();
        int cnt = 40;
        String C = city.getText().toString();

        String url = "https://api.openweathermap.org/data/2.5/forecast?q=" + C + "&units=metric&cnt=" + cnt + "&appid=" + strApiKey;
        //RequestQueue que = Volley.newRequestQueue(this);
        imgResLRain = BitmapFactory.decodeResource(getResources(),R.drawable.light_rain);
        imgResSunny = BitmapFactory.decodeResource(getResources(),R.drawable.sunny);
        imgResCast = BitmapFactory.decodeResource(getResources(),R.drawable.overcast_clouds);
        imgResMod = BitmapFactory.decodeResource(getResources(),R.drawable.moderate_clouds);
        imgResRain = BitmapFactory.decodeResource(getResources(),R.drawable.rain);
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jaWeather = response.getJSONArray("list");
                    int a = 0;
                    for(int x = 0; x < jaWeather.length(); x = x + 8)
                    {
                        JSONObject joWeather = jaWeather.getJSONObject(x);
                        JSONObject joTempWeather = joWeather.getJSONObject("main");
                        JSONArray jaTypeWeather = joWeather.getJSONArray("weather");
                        JSONObject joTypeWeather = jaTypeWeather.getJSONObject(0);
                        String strMin = joTempWeather.getString("temp_min");
                        String strMax = joTempWeather.getString("temp_max");
                        String strType = joTypeWeather.getString("description");
                        String strDate = joWeather.getString("dt_txt");
                        String[] strDates = strDate.split(" ");
                        strDate = strDates[0];
                        Log.d("strType", "strType:  " + strType);
                        switch(strType)
                        {
                            case "light rain":
                                img = imgResLRain;
                                break;
                            case "overcast clouds":
                                img = imgResCast;
                                break;
                            case "broken clouds":
                                img = imgResMod;
                                break;
                            case "few clouds":
                                img = imgResMod;
                                break;
                            case "scattered clouds":
                                img = imgResMod;
                                break;
                            case "clear sky":
                                img = imgResSunny;
                                break;
                        }
                        Log.d("image", "image" + img);

                        lWeather.add(new WeatherObject(strMin, strMax, strDate, img));
                        RecyclerView myRecycleView = (RecyclerView) findViewById(R.id.recycleweather);
                        RecycleAdapter myAdapter = new RecycleAdapter(MainActivity.this, lWeather);
                        myRecycleView.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
                        myRecycleView.setAdapter(myAdapter);
                    }
                } catch (Exception e) {
                    Log.d("JSON", "Json error:" + e.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Volley", "error with:" + error.toString());
            }

        });
        //que.add(req);
    }

    public void Today(View v)
    {
        String C = city.getText().toString();
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + C + "&units=metric&appid=" + strApiKey;
        txtWeather.setText("");

        RequestQueue que = Volley.newRequestQueue(this);

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>()
        {
            @Override
            public void onResponse(JSONObject response)
            {
                try
                {
                    String CurrentLine = "";
                    //JSONArray Weather = response.getJSONArray("weather");//the "" part is the name of the array that is in [] brackets

                    JSONObject Weather = response.getJSONObject("main");//it will have :

                    txtWeather.setText
                            (
                                    "Maximum temp: " + Weather.getString("temp_max") + "\n" +
                                    "Minimum temp: " + Weather.getString("temp_min") + "\n" +
                                    "Humidity: " + Weather.getString("humidity") + "%" + "\n" +
                                    "Temp feels like: " + Weather.getString("feels_like") + "\n"
                            );
                }
                catch (JSONException e)
                {
                    Log.d("JSON","Json error:" + e.toString());
                }
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.d("Volley", "error with:" + error.toString());
            }
        });
        MySingleton.getInstance(this).addToRequestQueue(req);
        //que.add(req);
    }

}