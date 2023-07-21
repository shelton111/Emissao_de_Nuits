package nuit;

import java.io.*; 
import java.nio.file.Files;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;

public class Ficheiro {
  private Cliente cliente;
  private Nuit nuit;  
  private Vector vt = new Vector();
  private int cont =0;

 public void escreverFicheiro (String nF, String Fch) throws IOException {
 try { 
 FileWriter fw = new FileWriter(nF, true);
 
 PrintWriter pw = new PrintWriter(fw); 
 BufferedWriter fichOut = new BufferedWriter(fw);
 fichOut.write(Fch); 
 fichOut.newLine(); 
 fichOut.close(); 
 } catch (IOException ex){ 
 System.out.println(ex.getMessage()); } 
 } 

public void lerDoFicheiro(String nf) throws IOException { 
StringTokenizer str; //uma porção de informacao a ser dividia por Str.Tokenizer
String umaLinha="";

 try { 
 FileReader fr = new FileReader(nf); 
 BufferedReader fichIn = new BufferedReader(fr); 
 umaLinha = fichIn.readLine();
 while (umaLinha != null) { // enquanto não atingir o fim de ficheiro
 str = new StringTokenizer(umaLinha,"; ");
 int id = Integer.parseInt(str.nextToken());
 String nome = str.nextToken(); //extrai nome de artigo
 String numero = str.nextToken();
 int nui = Integer.parseInt(str.nextToken()); //extrai o código
 cliente = new Cliente(id,numero, nome);
 nuit = new Nuit(cliente, nui);
 vt.addElement(cliente);
 
 System.out.println(nuit.toString());
 umaLinha = fichIn.readLine();
 cont++;}
 fichIn.close(); 
 } catch (FileNotFoundException a) { 
 System.out.println("Ficheiro nao encontrado!"); 
 }catch (NumberFormatException nn){ 
 System.out.println(nn.getMessage()); 
 }catch (IOException b) { System.out.println(b); }} 

 public void gravarFichObj(String nfobj) {
 try {
 FileOutputStream ff = new FileOutputStream (nfobj);
 ObjectOutputStream ss = new ObjectOutputStream(ff);
 ss.writeObject(cliente.toString());
 ss.close();
 } catch (IOException xx) {
 System.out.println(xx.getMessage());
 }}
 
public String LerVisualizar(String fic2, String nn) throws IOException{
String linha="", Fich=" " , resp="";
StringTokenizer str;	  
try{
 BufferedReader br = new BufferedReader(new FileReader(fic2));
 linha=br.readLine();
while (linha!=null){
 str = new StringTokenizer(linha,";");
 Fich=str.nextToken();
 if(Fich.equals(nn))
 resp =linha;
 linha= br.readLine();}
 br.close();  
}catch(FileNotFoundException f){System.out.println("Ficheiro nao encontrado");}
catch(IOException i){System.out.println(i.getMessage());}
      return resp;
}

 public boolean Testar(String nfch, String nr){
 int b, aux;
 StringTokenizer str;
 boolean status=false;
 String matrFich= " ";
 String umaLinha="";   
		          
try{          	  
 BufferedReader br = new BufferedReader(new FileReader(nfch));
 umaLinha=br.readLine();
 while (umaLinha!=null){
 str = new StringTokenizer(umaLinha,";");
// b=Integer.parseInt(str.nextToken());
 matrFich=str.nextToken();
 if(matrFich.equals(nr)) status=true;
 umaLinha= br.readLine();}
 br.close();  
}catch (FileNotFoundException fnf) {
    System.out.println("Ficheiro nao encontrado");
}catch(NumberFormatException n){System.out.println(n.getMessage());	
}catch (IOException io){
    System.out.println(io.getMessage());// gravarFich(nomeFich,conteudo);
}return status;}
 
    public static void main(String[] args) throws IOException {
      Ficheiro f = new Ficheiro(); 
      f.lerDoFicheiro("nuit.txt");
     // f.Testar("nuit.txt","1111");
      //System.out.println(f.Testar("nuit.txt","123a"));
    }
} 