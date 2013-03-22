package ServerClient;
/**
 *
 * @author Stefan Nhan-Eisenkolb
 */
import java.util.UUID;

public class Client {
    private String clientName;
    public Server mailServer;
    
    public void Client() {
        this.clientName = UUID.randomUUID().toString();
    }
    public void setClientName(String cN) {
        this.clientName = cN;
    }
    public String getClientName() {
        return this.clientName;
    }
    public void setMailServer(Server s) {
        this.mailServer = s;
    }
    public void sendMessage(String message, String receiver) {
        this.mailServer.sendMessage(message, receiver, this);
    }
    public String inbox(String message, String sender) {
        return message+" from: "+sender;
    }
}
