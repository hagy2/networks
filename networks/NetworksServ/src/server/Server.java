//Made by Hager Wasef and Bassel Khaled
package server;

import java.io.*; 
import java.net.*; 

public class Server { 

    public static void main(String argv[]) throws Exception 
    { 
        String clientSentence; 
        String serverSentence;

        ServerSocket welcomeSocket = new ServerSocket(6789); 

        while(true) { 
            Socket connectionSocket = welcomeSocket.accept(); 
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); 
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream()); 
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("FROM CLIENT: CONNECT");

            while(true) {
                clientSentence = inFromClient.readLine(); 
                if(clientSentence.equals("DISCONNECT")) {
                    return;
                }
                System.out.println("FROM CLIENT: " + clientSentence);
                serverSentence = inFromServer.readLine();
                outToClient.writeBytes("FROM SERVER: " + serverSentence + '\n'); 
            }
        } 
    } 
}
