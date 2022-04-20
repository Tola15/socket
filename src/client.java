import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lbren
 */
public class client {

 public static void main(String[] args){
        
        try {
        DataOutputStream out;
        BufferedReader in;
            
                         
        Socket client = new Socket(InetAddress.getLocalHost(),2000);
        System.out.println("richiesta connessione al server\n");

        out= new DataOutputStream(client.getOutputStream());
             
        in= new BufferedReader(new InputStreamReader(client.getInputStream()));
            
        String stringaRicevuta;
        stringaRicevuta=in.readLine();
        System.out.println("messaggio server: " +stringaRicevuta+"\n");
                      
        String messaggioBenevnuto="inserisci data e ora";
        out.writeBytes(messaggioBenevnuto+"\r\n");
        System.out.println("mandami data e ora\n");
        out.flush();
            
        stringaRicevuta=in.readLine();
        System.out.println("data: " +stringaRicevuta+"\n");
              
        client.close();
        System.out.println("connessione terminata\n");
        }
        catch (UnknownHostException ex) {
            System.out.println("host non riconosciuto\n");
        }
        catch (Exception ex) {
          System.out.println("errore di connessione\n");
        }
    }
    
}  
