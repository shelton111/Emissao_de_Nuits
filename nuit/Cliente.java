
package nuit;

public class Cliente {
    private int idcliente; 
    private String nome;
    private String cpf;
    
    public Cliente(int idcliente, String nome, String cpf) {
        this.idcliente = idcliente;
        this.nome = nome;
        this.cpf = cpf;
    }

    Cliente() {
    }
    
    public int CodigoCliente(){
       idcliente  = (int) ((int)100 + Math.random()*99999-10000);
        return idcliente;
    }

    public int getIdcliente() {
        return idcliente;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
    public String getNome() {
        return nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    public static void main(String[] args) {
        Cliente c = new Cliente();
        
        int a =c.CodigoCliente();
        System.out.println(a);
    }
    public String toString() {
        return  idcliente +";"+cpf+";"+ nome ;
    }
}
