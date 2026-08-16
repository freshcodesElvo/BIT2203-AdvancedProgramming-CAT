import java.net.URL;

public class URLParser {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://api.techstore.com:8443/products/category/electronics?sort=price&limit=20#reviews");
            //get protocol
            System.out.println("Protocol-> " + url.getProtocol());
            //get host
            System.out.println("Host-> " + url.getHost());
            //get port
            System.out.println("Port-> " + url.getPort());
            //get path
            System.out.println("Path-> " + url.getPath());
            //get query params
            String query = url.getQuery();
            System.out.println("Query Parameters:");

            String[] parameters = query.split("&");

            for (String param : parameters) {
                String[] keyValue = param.split("=");
                System.out.println("  " + keyValue[0] + " -> " + keyValue[1]);
            }
            
            //get fragment
            System.out.println("Fragment-> " + url.getRef());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}