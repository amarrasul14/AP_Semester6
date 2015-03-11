import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

  
  protected void start() {
    ServerSocket s;

    System.out.println("Webserver starting up on port 8080");
    System.out.println("(press ctrl-c to exit)");
    try {
      // create the main server socket
      s = new ServerSocket(8080);
    } catch (Exception e) {
      System.out.println("Error: " + e);
      return;
    }
    String sentence[]=null;
    System.out.println("Waiting for connection");
    for (;;) {
      try {
        // wait for a connection
        Socket remote = s.accept();
        // remote is now the connected socket
        System.out.println("Connection, sending data.");
        BufferedReader in = new BufferedReader(new InputStreamReader(remote.getInputStream()));
        PrintWriter out = new PrintWriter(remote.getOutputStream());

        // read the data sent. We basically ignore it,
        // stop reading once a blank line is hit. This
        // blank line signals the end of the client HTTP
        // headers.
        
        
        String str = ".";
        boolean req = true;
        boolean len = true;
        boolean http = true;
        
        
        while (!str.equals("")){
        	str = in.readLine();
        	System.out.println(str);

        	if(str.contains("GET")){							//checking for GET method
        		sentence = str.split(" ");						//splitting the string to extract the filename
        		sentence[1]=sentence[1].substring(1);
        			if(sentence[1].length() < 512){				//check for validity of URI length
        			len = false;
        			}
        		System.out.println(sentence[1]);
        		System.out.println(sentence[2]);
        			if(sentence[2].equals("HTTP/1.1")){			//check for supported HTTP version
        			http= false;
        			}
        		req = false;									//check for bad request that is file not found
        	}	
        }
        
        /*PRINTING HTTP RESPONES AND SENDING THE HEADERS*/
        if(req){
        	 sentence[1]="Bad Request";
        	 out.println("HTTP/1.1 400: BadRequest");
             out.println("Content-Type: text/html");
             out.println("Server: Bot");
        }
        else if(len){
        	sentence[1]="URIlong";
        	out.println("HTTP/1.1 414: URI too long");
            out.println("Content-Type: text/html");
            out.println("Server: Bot");
        }
        else if(http){
        	sentence[1]="HTTPversion";
        	out.println("HTTP/1.0 505: HTTP version not supported");
            out.println("Content-Type: text/html");
            out.println("Server: Bot");
        }
        
        
        else{
        out.println("HTTP/1.0 200 OK");
        out.println("Content-Type: text/html");
        out.println("Server: Bot");
        }
        
        // this blank line signals the end of the headers
        out.println("");     
        
        // Send the HTML page
        //out.println("<H1>Welcome to the Ultra Mini-WebServer</H2>");
        BufferedReader reader = null;
        try{ 
        reader = new BufferedReader(new FileReader(sentence[1]));
        }
        
        catch (FileNotFoundException x){}
        String line;
       	while((line=reader.readLine())!=null){
        	out.println(line+"");
        }
       
        out.flush();
        remote.close();
      
      } 
      	catch (Exception e) {
        System.out.println("Error: " + e);
      	}
    }
    
    
  }

  public static void main(String args[]) {
    WebServer ws = new WebServer();
    ws.start();
  }
}
