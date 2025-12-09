public class WeatherServiceTestStubbingDemo {

    @Test
    public void testGetWeatherReport_StubbingDemo() {
        // Create a mock WeatherApiClient
        WeatherApiClient mockApiClient = Mockito.mock(WeatherApiClient.class);

        // Stub the getWeather method to return a predefined response
        Mockito.when(apiClient.fetchTemperature("New York"))
               .thenReturn(new WeatherResponse("Sunny", 75));

        // Create an instance of WeatherService with the mocked API client
        WeatherService service = new WeatherService(apiClient);

        // Call the method under test
        String message = service.getWeatherReport("New York");

        assertEquals("The weather in New York is Sunny with a temperature of 75°F.", message);


    }
}
