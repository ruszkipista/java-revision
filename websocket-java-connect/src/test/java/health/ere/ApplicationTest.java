package health.ere;

import java.net.URI;
import java.net.URISyntaxException;

import javax.websocket.CloseReason;

import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Application")
public class ApplicationTest {

  @Test
  @DisplayName("/websocket client endpoint test")
  void websocketTest() throws URISyntaxException, InterruptedException {

    WebsocketClientEndpoint.EventHandler eventHandler = new WebsocketClientEndpoint.EventHandler(){
      // for processing OnOpen event create a handler
      @Override
      public void handleOnOpen(){
        System.out.println("Opened websocket connection");
      }
      // for processing responses create OnMessage event handler
      @Override
      public void handleOnMessage(String message) {
        System.out.println(message);
      }
      // for processing OnClose event create a handler
      @Override
      public void handleOnClose(CloseReason reason) {
        System.out.println("Closed websocket connection. "+reason.getReasonPhrase());
      };
    };

    // open web socket connection to localhost:8080/websocket
    WebsocketClientEndpoint wsClientEndpoint = 
      new WebsocketClientEndpoint(new URI("ws://localhost:8080/websocket"), eventHandler);
      
    // example taken from src/test/resources/websocket-messages/RequestSettings.json
    String request = new JSONObject().put("type", "RequestSettings").toString();
    wsClientEndpoint.sendMessage(request);
    Thread.sleep(5000);
    wsClientEndpoint.close();
  }
}
