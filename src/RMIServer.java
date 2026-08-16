import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {

    public static void main(String[] args) {

        try {
            // RMI registry on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            //  remote object
            TemperatureConverter converter =
                    new TemperatureConverterImpl();

            // bind the remote object to the registry
            registry.rebind("TemperatureConverter", converter);

            System.out.println(
                    "Temperature Converter RMI Server is running..."
            );

        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}