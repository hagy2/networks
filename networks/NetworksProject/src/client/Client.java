//Made by Hager Wasef and Bassel Khaled

package client;
import java.io.*; 
import java.net.*; 
public class Client { 

    public static void main(String argv[]) throws Exception 
    { 
        String sentence; 
        String modifiedSentence; 

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); 

        sentence = inFromUser.readLine();
        if(!sentence.equals("CONNECT")) {

            return;
        }

        Socket clientSocket = new Socket("192.168.1.36", 6789); 
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream()); 
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 

        System.out.println("FROM SERVER: CONNECT");

        while(true) {
            sentence = inFromUser.readLine();
            if(sentence.equals("DISCONNECT")) {
                return;
            }
            outToServer.writeBytes(sentence + '\n');
            modifiedSentence = inFromServer.readLine();
            System.out.println(modifiedSentence);
        }
    } 
}