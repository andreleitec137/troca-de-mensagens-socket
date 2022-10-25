package socketEntregas;



import java.io.*;
import java.net.*;


public class Cliente2 {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        // TODO code application logic here
        Socket socketServ = null;
        PrintWriter saiServ = null;
        BufferedReader teclado = null;
        BufferedReader entServ = null;
        String ltr;
        String txt;
    
    try {
         socketServ = new Socket("192.168.56.1", 4445);
        System.out.println("Conectado...\n");
        saiServ = new PrintWriter(socketServ.getOutputStream(),true);
        teclado = new BufferedReader(new InputStreamReader(System.in));
        entServ = new BufferedReader(new InputStreamReader(socketServ.getInputStream()));
        while (true){
        	txt= entServ.readLine();
             System.out.println(txt); 
            
			
	    if (txt.equals("sair"))  break; 
            while ((ltr = teclado.readLine()) != null) {
				saiServ.println(ltr);
                break;
            }
			
            
            if (ltr.equals("sair")) break;
           }
            System.out.println("Fechando as conexoes...");
            saiServ.close();
            entServ.close();
            socketServ.close();
       
        } 
        catch (UnknownHostException e) {
            System.out.println("Host desconhecido.");
            System.exit(1);
        } 
        catch (IOException e) {
            System.out.println("Problemas de E/S na Conexão.");
            System.exit(1);
        }
       
    }
     
}
