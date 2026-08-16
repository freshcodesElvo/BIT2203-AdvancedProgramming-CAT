import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {

    public static void main(String[] args) {

        try {
            // connect to the rmi registry
            Registry registry =
                    LocateRegistry.getRegistry("localhost", 1099);

            // look up the remote service
            TemperatureConverter converter =
                    (TemperatureConverter)
                    registry.lookup("TemperatureConverter");

            // convert 25 deg to fahrenheit
            double celsius = 25.0;
            double fahrenheit =
                    converter.celsiusToFahrenheit(celsius);

            System.out.println(
                    celsius + "°C = " + fahrenheit + "°F"
            );

        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}