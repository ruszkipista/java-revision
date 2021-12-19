package health.ere;

import java.io.IOException;
import java.net.URI;
 
import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import org.glassfish.tyrus.client.ClientManager;
 
/**
 * ChatServer Client
 * 
 * @author Jiji_Sasidharan
 */
@ClientEndpoint
public class WebsocketClientEndpoint {
    Session userSession = null;
    private EventHandler eventHandler;
 
    public WebsocketClientEndpoint(URI endpointURI, 
                                   EventHandler eventHandler) {
        this.eventHandler = eventHandler;
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, endpointURI);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
 
    /**
     * Callback hook for Connection open events.
     * 
     * @param userSession
     *            the userSession which is opened.
     */
    @OnOpen
    public void onOpen(Session userSession) {
        if (this.eventHandler != null)
            this.eventHandler.handleOnOpen();
        this.userSession = userSession;
    }
 
    /**
     * Callback hook for Connection close events.
     * 
     * @param userSession
     *            the userSession which is getting closed.
     * @param reason
     *            the reason for connection close
     */
    @OnClose
    public void onClose(Session userSession, CloseReason reason) {
        if (this.eventHandler != null)
            this.eventHandler.handleOnClose(reason);
        this.userSession = null;
    }
 
    /**
     * Callback hook for Message Events. This method will be invoked when a
     * client send a message.
     * 
     * @param message
     *            The text message
     * @throws IOException
     */
    @OnMessage
    public void onMessage(String message) throws IOException {
        if (this.eventHandler != null){
            this.eventHandler.handleOnMessage(message);
        }
    }
 
    /**
     * Send a message.
     * 
     * @param message
     */
    public void sendMessage(String message) {
        this.userSession.getAsyncRemote().sendText(message);
    }

    public void close() {
        try {
            this.userSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Event handler.
     * 
     * Handle events: OnOpen, OnMessage, OnClose
     */
    public static interface EventHandler {
        public void handleOnOpen();
        public void handleOnMessage(String message);
        public void handleOnClose(CloseReason reason);
    }
}
