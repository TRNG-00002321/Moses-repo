public class WeatherServiceTestStubAndMock {

    @Test
    public void testWeatherServiceTestWithStunAndMock() {

        // Create a mock WeatherApiClient
        WeatherApiClient apiClient = Mockito.mock(WeatherApiClient.class);

        // Stub the getWeather method to return a predefined response
        Mockito.when(apiClient.fetchTemperature("New York"))
                .thenReturn(new WeatherResponse("Sunny", 75));

        // Create an instance of WeatherService with the mocked API client
        WeatherService service = new WeatherService(apiClient);

        // Call the method under test
        String message = service.getWeatherReport("New York");
        // Verify the result
        assertEquals("The weather in New York is Sunny with a temperature of 75°F.", message);

        // Verify that the fetchTemperature method was called once with "New York"
        Mockito.verify(apiClient, times(2)).fetchTemperature("New York");




    }

}
