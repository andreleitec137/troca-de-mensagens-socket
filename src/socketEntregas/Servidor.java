package socketEntregas;
import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class Servidor {

    public static void main(String[] args) {
    	
        ServerSocket canal = null;
        Socket socketCli = null;
        BufferedReader recebeDados = null;
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        PrintWriter enviaDados = null;

        String txtCli;
        Usuario user2;
        Usuario user1;
        
        try {
            canal= new ServerSocket(4445);
            System.out.println("Servidor Ativo\n");
            
            while(usuarios.size() < 2) {
	            socketCli = canal.accept();
	            enviaDados = new PrintWriter(socketCli.getOutputStream(),true);
	            recebeDados = new BufferedReader(new InputStreamReader(socketCli.getInputStream()));
	            
	            Usuario user = new Usuario(socketCli, recebeDados, enviaDados);
	            usuarios.add(user);	            	           	    		          
            }
            
            txtCli = "";
            
            user1 = usuarios.get(0);
            user1.setNome("André");
            user1.getPrint().println("Bem vindo! Pressione ENTER para começar");            

            user2 =  usuarios.get(1);
            user2.setNome("Edison");
            user2.getPrint().println("Bem vindo! Digite algo para começar");            

            
            while (true){
            	
    			while ((txtCli= user2.getBuffer().readLine()) != null){
    				if(txtCli.length() == 0) {
    					user1.getPrint().println("Mensagem recebida! Pressione ENTER");        
            		}else {
        				user1.getPrint().println(user2.getNome() + " disse:  "+ txtCli );        			
            		}
    				
        			break;
                  }   
            	

            	while ((txtCli= user1.getBuffer().readLine()) != null){
            		if(txtCli.length() == 0) {
                		user2.getPrint().println("Mensagem recebida! Pressione ENTER");       
            		}else {
                		user2.getPrint().println(user1.getNome() + " disse: "+ txtCli );             				
            		}
        			break;
            	}    
            	
            	if(txtCli == "sair")   break;
            		
            	
            }
            System.out.println("Finalizando programa !");
            recebeDados.close();
            enviaDados.close();
            socketCli.close();
            canal.close();
            } 
          catch (IOException e) {
            System.out.println("Falha na comunicação.");
             System.exit(1);
           }

        }
    
}
