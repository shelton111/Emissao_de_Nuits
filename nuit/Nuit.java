
package nuit;

import java.util.Vector;

public class Nuit {
    
    private static int proximoNumero = 1;
    
    private int numero;
    private Cliente cliente;
    private double valor;
    private int nuit;
    
    public Nuit(Cliente cliente, int nuit) {
        this.numero = proximoNumero++;
        this.cliente = cliente;
        this.valor = valor;
        this.nuit = nuit;
    }

    Nuit() {
    }
    
    public int getNumero() {
        return numero;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public double getValor() {
        return valor;
    }

    public int getNuit() {
        return nuit;
    }
    
     public int gerarNUIT(Cliente cliente) {
        String cpf = cliente.getCpf().substring(6, 10);
        nuit =cpf.hashCode();
        return  nuit;
    }
    public String toString() {
        return  cliente+"; "+ nuit;
    }
    public static void main(String[] args) {
         String cpf ="1101012853b";
        String cpf1 = cpf.substring(6, 10);
        int d =cpf.substring(6, 10).hashCode();
        int c = Integer.parseInt(cpf1.replaceAll(cpf,"[^0-9]"));
        System.out.println(d+" "+ c);
    }
}