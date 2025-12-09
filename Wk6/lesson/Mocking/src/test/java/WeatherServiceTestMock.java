import com.raveture.mocking.WeatherApiClient;
import com.raveture.mocking.WeatherService;

public class WeatherServiceTestMock {

    public void testMockDemo(){
        WeatherApiClient apiClient =Mockito.mock(WeatherApiClient.class);
        WeatherService service = new WeatherService(apiClient);
        service.refresh("New York");
        Mokito.verify(apiClient, times)
    }
}
