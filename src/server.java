import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lbren
 */
public class server {
     
public static void main(String[] args) {
    try {
    DataOutputStream out;
    BufferedReader in ;
    
    ServerSocket serverSocket=new ServerSocket(2000);
    System.out.println("server avviato correttamente");
    Socket socket = serverSocket.accept();

    
    serverSocket.close();
        out = new DataOutputStream(socket.getOutputStream());
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    
    
    
    String messaggio="ciao";
    out.writeBytes(messaggio+"\r\n");
    System.out.println("messaggio iniziale");
    out.flush();
    
    String stringaRicevuta;
    stringaRicevuta=in.readLine();
    System.out.println("richiesta: " +stringaRicevuta+"\n");
    //data                  
    SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
    String timeStamp = date.format(new Date());
                   
    out.writeBytes(timeStamp+"\r\n");
    System.out.println("data e ora\n");
    out.flush();
              
    socket.close();
    System.out.println("fine connessione \n");
    
} catch(BindException ex){
    System.err.println("porta occupata");
}   catch (IOException ex) {    
        Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
    }    
    }
}

