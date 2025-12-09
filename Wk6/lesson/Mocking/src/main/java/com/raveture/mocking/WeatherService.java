package com.raveture.mocking;

public class WeatherService {




    public void refresh(String city){
        weatherApiClient.fetchTemperature(city);
    }
}
