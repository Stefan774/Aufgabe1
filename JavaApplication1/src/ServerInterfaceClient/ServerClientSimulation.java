package ServerInterfaceClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Stefan Nhan-Eisenkolb
 */
public class ServerClientSimulation {
    
    protected IServer mailServer;
    private InputStreamReader reader = new InputStreamReader(System.in);
    private BufferedReader  br = new BufferedReader(reader);
    
    public static void main(String[] args)  throws IOException {
        ServerClientSimulation s1 = new ServerClientSimulation();
        s1.startSimpleSimulation();
    }
    
    public void startSimpleSimulation() throws IOException {
// Initialisieren der Clients und des Serverinterfaces
        mailServer = new Server();
        
        Client c1, c2, c3;
        c1 = new Client();
        c2 = new Client();
        c3 = new Client();
        
        c1.setClientName("Client 1");
        c2.setClientName("Client 2");
        c3.setClientName("Frank@gmail.com");
        
        c1.setMailServer(mailServer);
        c2.setMailServer(mailServer);
        c3.setMailServer(mailServer);
        
// Testnachrichten über den Server an Clients
        c1.sendMessage("Hallo Client 2", "Client 2");
        c1.sendMessage("Hallo Client 2 bitte melde dich doch mal bei mir!", "Client 2");

// (Bis END auskommentieren um User Input zu vermeiden) Nachricht durch User-Input an Client 1 senden
//        System.out.println("Schreib eine Nachricht an Client 1\n");
//        String customMessage = br.readLine();
//        c2.sendMessage(customMessage, "Client 1");
// END
        c2.sendMessage("Hallo Client 1 danke fuer deine Nachricht!!", "Client 1");
        
        
        c3.sendMessage("Hallo Ihr da draußen keiner schreibt mir? Was da loss!? ;(", "Client 1;Client 2;Frank@gmail.com");
        
        ArrayList<String> inboxC1 = c1.inbox();
        ArrayList<String> inboxC2 = c2.inbox();
        
        System.out.println("\n::::::::: Start-Inbox-Simulator :::::::::\n");
        
        System.out.println("Inbox Client 1 \n Total Messages : " + inboxC1.size());
        
        for (int i=0; i < inboxC1.size(); i++) {
            System.out.println(" " + inboxC1.get(i));
        }
        
        System.out.println("Inbox Client 2 \n Total Messages : " + inboxC2.size());
        for (int i=0; i < inboxC2.size(); i++) {
            System.out.println(" " + inboxC2.get(i));
        }
        
        System.out.println("\n:::::::::: End-Inbox-Simulator :::::::::\n");
        
    }
    
}
