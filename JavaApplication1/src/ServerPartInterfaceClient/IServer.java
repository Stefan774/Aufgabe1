package ServerPartInterfaceClient;

import java.util.ArrayList;

/**
 *
 * @author Stefan Nhan-Eisenkolb
 */
public interface IServer {
   public void connect(Client c);
   public boolean sendMessageTo(String message, String receiver, Client sender);
   public ArrayList<String> getMessages(Client c);
}
