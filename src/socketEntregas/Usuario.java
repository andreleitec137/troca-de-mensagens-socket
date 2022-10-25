package socketEntregas;


import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Usuario {
	   private Socket socketCli = null;
	   private  BufferedReader recebeDados = null;
	   private  PrintWriter enviaDados = null;
	   private String nome = null;
	   
		public Usuario(Socket s, BufferedReader b, PrintWriter p) {
			this.socketCli = s;
			this.recebeDados = b;
			this.enviaDados = p;	
		}
		
		public void setNome(String s) {
			this.nome = s;
		}
		
		public String getNome() {
			return this.nome;
		}
	   
	   public Socket getSocket() {
		   return this.socketCli;
	   }
	   
	   public BufferedReader getBuffer() {
		   return this.recebeDados;
	   }
	   
	   public PrintWriter getPrint() {
		   return this.enviaDados;
	   }
}
