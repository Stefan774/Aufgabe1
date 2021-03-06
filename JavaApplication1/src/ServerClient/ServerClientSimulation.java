package ServerClient;

import java.util.ArrayList;

/**
 *
 * @author Stefan Nhan-Eisenkolb
 */
public class ServerClientSimulation {
    protected Server mailServer;
    
    public static void main(String[] args) {
        ServerClientSimulation s1 = new ServerClientSimulation();
        s1.startSimpleSimulation();
    }
    
    public void startSimpleSimulation() {
        
        mailServer = new Server();
        Client c1 = new Client();
        Client c2 = new Client();
        
        c1.setClientName("Client 1");
        c2.setClientName("Client 2");
        
        c1.setMailServer(mailServer);
        c2.setMailServer(mailServer);
        
        c1.sendMessage("Hallo Client 2", "Client 2");
        c1.sendMessage("Hallo Client 2 bitte melde dich doch mal bei mir!", "Client 3");
        
        c2.sendMessage("Hallo Client 1 danke fuer deine Nachricht!!", "Client 1");
        
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