package com.example.myapiapplication;

import android.graphics.Bitmap;

public class WeatherObject
{

    private String ID;
    private String weatherStateName;
    private String weatherstateAbbr;
    private String WindDirectionCompas;
    private String created;
    private String Date;
    private String min_temp;
    private String max_temp;
    private String the_temp;
    private String windSpeed;
    private String windDirection;
    private String air_presure;
    private String humidity;
    private String visibility;
    private String predictability;
    private Bitmap bitmap;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public WeatherObject(String min_temp, String max_temp, String Date, Bitmap bitmap) {
        this.min_temp = min_temp;
        this.max_temp = max_temp;
        this.Date = Date;
        this.bitmap = bitmap;
    }

    public WeatherObject()
    {

    }
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getWeatherStateName() {
        return weatherStateName;
    }

    public void setWeatherStateName(String weatherStateName) {
        this.weatherStateName = weatherStateName;
    }

    public String getWeatherstateAbbr() {
        return weatherstateAbbr;
    }

    public void setWeatherstateAbbr(String weatherstateAbbr) {
        this.weatherstateAbbr = weatherstateAbbr;
    }

    public String getWindDirectionCompas() {
        return WindDirectionCompas;
    }

    public void setWindDirectionCompas(String windDirectionCompas) {
        WindDirectionCompas = windDirectionCompas;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getMin_temp() {
        return min_temp;
    }

    public void setMin_temp(String min_temp) {
        this.min_temp = min_temp;
    }

    public String getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(String max_temp) {
        this.max_temp = max_temp;
    }

    public String getThe_temp() {
        return the_temp;
    }

    public void setThe_temp(String the_temp) {
        this.the_temp = the_temp;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getAir_presure() {
        return air_presure;
    }

    public void setAir_presure(String air_presure) {
        this.air_presure = air_presure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getPredictability() {
        return predictability;
    }

    public void setPredictability(String predictability) {
        this.predictability = predictability;
    }

}
