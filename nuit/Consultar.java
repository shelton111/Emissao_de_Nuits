
package nuit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.Document;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Highlighter;
//import javax.swing.event.DocumentListener;

public class Consultar extends JFrame implements ActionListener {
    private JLabel  jlcpf, jlemail ,jlnome, jlsenha, jlcsenha;
    private JButton consultar, cancelar, ok;
    private JTextField  jtcpf, jtnome, jtemail, jtsenha, cs;
    private JPanel jpconsultar;
    private JMenuBar MB;
    private JMenu M;
    private JMenuItem mi;
    private JTextArea resp;
    private Ficheiro fch = new Ficheiro();
    private Validacao vd = new Validacao();
    private String pasta ="Nuit.txt";
    
    public Consultar(){
         jtcpf = new JTextField();
         jtsenha = new JTextField();
         jtnome = new JTextField();
         jtemail = new JTextField();
         cs = new JTextField();
         
         jpconsultar = new JPanel();
         
         setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	 setSize(624, 575);
	 setLocationRelativeTo(null);
         jpconsultar.setBorder(new LineBorder(Color.darkGray, 1));
         jpconsultar.setBackground(new Color(255, 255, 255));
	 setContentPane(jpconsultar);
	 jpconsultar.setLayout(null);
        
         resp = new JTextArea();
         resp.setBackground(Color.WHITE);
         resp.setFont(new Font("tahoma", Font.PLAIN, 12));
         resp.setBounds(40, 120, 300, 50);
         resp.setForeground(Color.red);
         resp.setFocusable(false);
         jpconsultar.add(resp);
  
         MB = new JMenuBar();
         MB.setBounds(10, 5, 500, 50);
         MB.setBackground(Color.WHITE);
         MB.setRequestFocusEnabled(false);
	 MB.setOpaque(false);
         MB.setVisible(true);
         M = new JMenu("Consulta o seu Nuit!");
         M.setFont(new Font("Harrington", Font.BOLD, 18));
         M.setForeground(Color.BLUE);
         MB.add(M);
         jpconsultar.add(MB);
    }
    
    public  JFrame consultar(){ 
        JFrame  c = new JFrame();
        c.setSize(400, 200);
        c.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        c.setBackground(new Color(255, 255, 255));
        c.setLocationRelativeTo(null);
	c.setLayout(null);
        c.setVisible(true);
        
        JPanel cc = new JPanel();
        cc.setBounds(0, 0, 400, 50);
        cc.setBackground(new Color(255, 255, 255));
        //c.add(cc);
        
        
        jtcpf.setToolTipText("pesquise com o seu Bi");
        jtcpf.setBackground(new Color(255, 255, 255));
         
         jlcpf = new JLabel("introduza o seu cpf");
         jlcpf.setForeground(new Color(0,102,102));
         jlcpf.setFont(new Font("tahoma", Font.PLAIN, 14));
        
         jtcpf.setLayout(new BorderLayout());
         jtcpf.add(jlcpf, BorderLayout.LINE_START);
         jtcpf.setFont(new Font("tahoma", Font.PLAIN, 14));
         jtcpf.setBounds(10, 75, 370, 35);
         jtcpf.getDocument().addDocumentListener(new DocumentListener(){
             @Override
             public void insertUpdate(DocumentEvent e) {
                 jlcpf.setText("");
             }
             @Override
             public void removeUpdate(DocumentEvent e) {
                 jlcpf.setText("");
             }
             @Override
             public void changedUpdate(DocumentEvent e) {
                 jlcpf.setText("");
             }
         });
         c.add(jtcpf);
         
         resp = new JTextArea();
         resp.setBackground(new Color(204,204,255));
         resp.setFont(new Font("tahoma", Font.PLAIN, 12));
         resp.setBounds(10, 60, 300, 20);
         resp.setForeground(Color.red);
         resp.setEditable(false);
         resp.setVisible(false);
         c.add(resp);      
         
         JLabel img = new JLabel();
         img.setIcon( new javax.swing.ImageIcon(getClass().getResource("/imgs/nuitp.png")));
         img.setBounds(10, 10, 50, 50);
         c.add(img);
         
         consultar = new JButton("consultar ");
         consultar.setBackground(Color.MAGENTA);
         consultar.setForeground(Color.GRAY);
         consultar.setBounds(100, 120, 150, 35);
         consultar.setFont(new Font("Segoe UI", Font.BOLD, 16));        
         consultar.setFocusPainted(false);
         consultar.addActionListener(this);
	 consultar.setOpaque(false);
         c.add(consultar);
         
         cancelar = new JButton("voltar");
         cancelar.setBackground(Color.WHITE);
         cancelar.setForeground(Color.GRAY);
         cancelar.setBounds(260, 120, 100, 35);
         cancelar.setFont(new Font("Segoe UI", Font.BOLD, 16));        
         cancelar.setFocusPainted(false);
	 //cancelar.setBorderPainted(false);
	 cancelar.setOpaque(false);
         cancelar.addActionListener(this);
         c.add(cancelar);
         return c;
    }
    
     public  JFrame erronuit(String msg){ 
        JFrame  e = new JFrame();
        e.setSize(360, 160);
        e.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        e.setBackground(new Color(255, 255, 255));
        e.setLocationRelativeTo(null);
	e.setLayout(null);
        e.setVisible(true);
        
        JTextPane cc = new JTextPane();
        cc.setBounds(0, 0, 360, 160);
        cc.setBackground(new Color(200, 200, 200));
        cc.setLayout(null);
        cc.setEditable(false);
        e.add(cc);
        
         JLabel img = new JLabel();
         img.setIcon( new javax.swing.ImageIcon(getClass().getResource("/imgs/nuitx.png")));
         img.setBounds(160, 12, 50, 50);
         cc.add(img);
         cc.setFont(new Font("Segoe UI", Font.BOLD, 16));  
         cc.setText("\n\n\t      "+msg);
         
         ok = new JButton("0k");
         ok.setBorder(new LineBorder(Color.RED.darker(), 3));
         ok.setForeground(Color.GRAY);
         ok.setBounds(145, 85, 70, 24);
         ok.setFont(new Font("Segoe UI", Font.BOLD, 16));        
         ok.setFocusPainted(false);
         ok.addActionListener(this);
         cc.add(ok);
        
    return e;
     }
      public static void main(String[] args) {
       Consultar m = new Consultar();
       m.consultar().setVisible(true);
       
    }
    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == consultar){
       
               if ("".equals(jtcpf.getText())) {
                resp.setVisible(true);   
                resp.setText("Introduza o sua identificacao");
               }
               else {
                char caracter = jtcpf.getText().charAt(jtcpf.getText().length()-1);
                char[] v = new char[26];
                int i=0; char cont='a'; String d =" ";
                while(i!=26 && cont!='z'){
                v[i]=cont;
                cont++;
                if (v[i]==caracter) {
                d = "ok";
                }}  
                if (jtcpf.getText().length()!=11 || d!="ok") {resp.setVisible(true);
                resp.setText("codigo invalido, tente no formato: 0000000000(a-z)");
               }else{ 
                    if (fch.Testar(pasta, jtcpf.getText())) {
                    try {
                    JOptionPane.showMessageDialog(null, fch.LerVisualizar(pasta, jtcpf.getText()));
                    }catch (IOException ex) {
                    Logger.getLogger(Consultar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }else 
                        
                    erronuit("Nuit nao encontado!").setVisible(true);  
  // JOptionPane.showMessageDialog(this, "codigo de Indetificao nao encontrado" ,"codigo invalido", JOptionPane.ERROR_MESSAGE);
                    }
                    }
         }
        
        if(e.getSource() == cancelar){
            Menu pc = new Menu();
            this.setVisible(false);
            pc.setLocationRelativeTo(null);
            pc.setVisible(true);}
        
         if(e.getSource() == ok){
            consultar().setVisible(true);
            jtcpf.setText("");
            this.setVisible(false);}
        
         if(e.getSource() == jtcpf){
             jtcpf.setRequestFocusEnabled(true);
             jtcpf.setText("");
         
     }
    
    }
    
}
