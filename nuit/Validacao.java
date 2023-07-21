package nuit;


import java.awt.Component;
import static java.awt.image.ImageObserver.HEIGHT;
import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class Validacao {
    private BufferedReader bt;
    private int contcod=0;
	public Validacao() {
		// TODO Auto-generated constructor stub
		bt= new BufferedReader(new InputStreamReader(System.in));
                //JOptionPane.showInputDialog();
                //JOptionPane.showMessageDialog(null,
	}
// validacao de parametros para  cada tipoos de dados;
        public void validar(){
     
        JOptionPane.showMessageDialog(null,"Nuit Emitido Com sucesso\n"+" seu codigo e "+contcod++, "Sistema de emissao de nuits", HEIGHT);

        }
                
	public String validarString(String mensagem, byte min, byte max) throws IOException{
	        String m="", s;
	        do{
	        try{
                s= JOptionPane.showInputDialog(mensagem); m=s;    
	    	//m = JOptionPane.showInputDialog(mensagem);
	        }catch (StringIndexOutOfBoundsException in){
	        JOptionPane.showMessageDialog(null,"O texto nao pode ser vazio");
	        JOptionPane.showMessageDialog(null,in.getMessage());
	        }
	        if (m.length()<min || m.length()>max)
	        JOptionPane.showMessageDialog(null,"Dado Invalido. Tentar novamente");}
	        while (m.length()<min ||m.length()>max);
	        return m;
        }
	public int validarInt(String saida,int a, int b)throws IOException {
		int i=0;
		do
                {JOptionPane.showMessageDialog(null,saida);
	        try {
	        i=Integer.parseInt(bt.readLine());
	        }catch (NumberFormatException in) {
		System.out.println(in);
	        }catch (IOException in){
		JOptionPane.showMessageDialog(null,in.getMessage());}	        
	        if (i<a || i>b)
		JOptionPane.showMessageDialog(null,"Dado invalido. Tentar novamente!");}
		while (i<a || i>b);
		return i;  
		
	}
        public String validarBi(String mng) throws IOException {
		String bi;
		do
                {bi = JOptionPane.showInputDialog("Introduza o seu Bi. formato: 0000000000(A-Z)");
	        if (bi.length()!=11)
	        JOptionPane.showMessageDialog(null,"Bi invalido! deve ser escrita obedecendo o seguinte formato: 0000000000(A-Z)"+"\n"+ "Tentar novamente");
		}
	        while (bi.length()!=11);
		return bi;
	}
        public String validarcpf(String msg,  int max) throws IOException{
	        String cpf="", aux;
                char cont='a', caracter = ' ';
                int e=0;
                String d =" ";
        
	        
	        try{    
	    	cpf = msg;
                caracter = cpf.charAt(3);
                char[] v = new char[26];
                int i=0;
                while(i!=26 && cont!='z'){
                v[i]=cont;//}
                cont++;
                if (v[i]==caracter) {
                d = "ok";
                }}
	        }catch (StringIndexOutOfBoundsException in){
	        JOptionPane.showMessageDialog(null,"O texto nao pode ser vazio");
	        JOptionPane.showMessageDialog(null,in.getMessage());
	        } if (cpf.length()!=max ){
	        JOptionPane.showMessageDialog(null,"O nome deve ter 4 letras no minimo");}
                else if (d!="ok"){
	        JOptionPane.showMessageDialog(null,"O nome deve comecar com letra maiuscula");}
               
              //  }while (cpf.length()!=max || d!="ok" );
	        return cpf;
        }
         public static void main(String[] args) throws IOException {
        Validacao vd = new Validacao();
        vd.validar();
        //String emai = vd.validarEmail("Digite o seu email", 14, 30);
        //String cpf = vd.validarcpf("Digite o cpf:", (byte)4);
        //String nome = vd.validarNome("Digite o Nome do cliente:", (byte)4, (byte)20);

       }
        public String validarEmail(String mensagem, int min, int max) throws IOException{
	        String email="", msg, d ="falha"; int cont =0;
	        do{
	        try{
                msg = JOptionPane.showInputDialog(mensagem); email=msg;
                String mail = "@gmail.com";
                int a= email.length();
                int e = email.length()- mail.length();
                String b ="" ; int f = mail.length();
                int v = email.length() - 10;
       
                b = email.substring(v, a);
                System.out.println(b+"\n"+mail);
                if (b.equals(mail)){
                d ="ok";
        }
                }catch (StringIndexOutOfBoundsException in){
	        System.out.println("O texto nao pode ser vazio");
	        System.out.println(in.getMessage());
	        }
                
	        if (email.length()<min || email.length()>max || d!="ok" || cont>=10)
	        JOptionPane.showMessageDialog(null,"Dado Invalido. Tentar novamente\n"+"email so aceita no formato: ****@gmail.com");}
	        while (email.length()<min ||email.length()>max || d!="ok" || cont>=10);
	        return email;
        }
        public String validarNome(String txt, int min, int max) throws IOException{
	        String m="", s = null, d =" ";
                char caracter = ' ';
                int cont=0;
	        try{
                s= txt;
                caracter = s.charAt(0);
	    	char[] v = new char[26];
                int i=0; char k='A';
                for (int j = 0; j < 26; j++) {
                v[j]=k;    
                System.out.print(v[j]+" ");
                k++;
                }for (int j = 0; j < 26; j++) {
                if (v[j] == caracter){
                cont++;
                }  
                }
                   
	        }catch (StringIndexOutOfBoundsException in){
	        JOptionPane.showMessageDialog(null,"O texto nao pode ser vazio");
	        JOptionPane.showMessageDialog(null,in.getMessage());
	        }
	       if (s.length()<min || s.length()>max ){
	        JOptionPane.showMessageDialog(null,"O nome deve ter 4 letras no minimo");}
                else if (cont!=1){
	        JOptionPane.showMessageDialog(null,"O nome deve comecar com letra maiuscula");}
               
	        return s;
        }
}
