package step1;

import java.net.InetSocketAddress;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.network.CoAPEndpoint;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class HelloWorld1 {

    public static void main(String[] args) {

        // binds on UDP port 5683
        CoapServer server = new CoapServer();
        
        server.addEndpoint(new CoAPEndpoint(new InetSocketAddress("10.227.139.198",5683)));

        server.add(new HelloResource());

        server.start();
    }

    public static class HelloResource extends CoapResource {
        public HelloResource() {

            // resource identifier
            super("Hello");

            // set display name
            getAttributes().setTitle("Hello-World Resource");
        }

        @Override
        public void handleGET(CoapExchange exchange) {
            exchange.respond("Hi Samiul from Coap!");
        }
    }

}
