
package nuit;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;

public class Cadastrar extends JInternalFrame implements ActionListener{
    private JLabel jlnome, jlcpf, menu, jlapelido, jldata;
    private JButton jbaqui, cancelar, jbemitir;
    private JTextField jtnome, jtcpf,jtapelido,jtdata;
    private JSpinner jsData;
    private JPanel jpcadastrar;
    private JMenuBar MB;
    private JComboBox tipodoc;
    private Cliente cliente;
    private Nuit nuit;
    private Ficheiro fch;
    private JTextArea resp, resp2, resp3;
    private String pasta ="Nuit.txt", arquivo ="cliente.txt" ;
    private static int contcod=1;
    private String[] tipo_doc ={"Bi", "Passaporte", "cartoa de elitor", "carta de conducao" };
    private JFormattedTextField mcpf; MaskFormatter cpf;
    
    
   public Cadastrar() throws ParseException{ 
         nuit = new Nuit(); fch = new Ficheiro();cliente = new Cliente();
         
         jpcadastrar = new JPanel();
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 setSize( 1000, 350);
         jpcadastrar.setBorder(new LineBorder(Color.darkGray, 1));
         jpcadastrar.setBackground(new Color(255, 255, 255));
	 setContentPane(jpcadastrar);
	 jpcadastrar.setLayout(null);
         
         JPanel mb = new JPanel();
         mb.setBounds(0, 0, 390,350);
         mb.setBackground(Color.CYAN);
         mb.setLayout(null);
         //cdt.add(mb); //mb.setVisible(false);
         
         //criando os butoes e os espacos de preenchimento
         jbemitir = new JButton("cadastrar");
         jbemitir.setBackground(new Color(0,102,102));
         jbemitir.setForeground(Color.DARK_GRAY);
         jbemitir.setBounds(450, 270, 120, 35);
         jbemitir.setFont(new Font("Segoe UI", Font.BOLD, 16)); 
         jbemitir.addActionListener(this);
         jbemitir.setFocusPainted(false);
	 jbemitir.setOpaque(false);
         jbemitir.setMnemonic('i');
         jpcadastrar.add(jbemitir);
         
         jlnome = new JLabel("Insira seu Nome");
         jlnome.setFont(new Font("tahoma", Font.PLAIN, 14));
         jlnome.setForeground(new Color(0,102,102));
        
         MaskFormatter nm = new MaskFormatter("ULLLLLLLLLL");
         MaskFormatter no = new MaskFormatter("U");
         jtnome = new JTextField();
         jtnome.setLayout(new BorderLayout());
         jtnome.add(jlnome, BorderLayout.LINE_START);
         jtnome.setRequestFocusEnabled(true);
         jtnome.setBackground(new Color(255, 255, 255));
         jtnome.setFont(new Font("tahoma", Font.PLAIN, 14));
         jtnome.setBounds(250, 90, 250, 35);
         jtnome.getDocument().addDocumentListener(new DocumentListener(){
             @Override
             public void insertUpdate(DocumentEvent e) {
                 jlnome.setText("");
             }
             @Override
             public void removeUpdate(DocumentEvent e) {
                 jlnome.setText("");
             }
             @Override
             public void changedUpdate(DocumentEvent e) {
                 jlnome.setText("");
             }
         });
       
         jlapelido = new JLabel("Insira o seu Apelido");
         jlapelido.setFont(new Font("impato", Font.PLAIN, 14));
         jlapelido.setForeground(new Color(0,102,102));
         
         jtapelido = new JTextField();
         jtapelido.setLayout(new BorderLayout());
         jtapelido.add(jlapelido, BorderLayout.LINE_START);
         jtapelido.setBackground(new Color(255, 255, 255));
         jtapelido.setFont(new Font("tahoma", Font.PLAIN, 14));
         jtapelido.setBounds(520, 90, 250, 35);
         jtapelido.getDocument().addDocumentListener(new DocumentListener(){
             @Override
             public void insertUpdate(DocumentEvent e) {
                 jlapelido.setText("");
             }
             @Override
             public void removeUpdate(DocumentEvent e) {
                 jlapelido.setText("");
             }
             @Override
             public void changedUpdate(DocumentEvent e) {
                 jlapelido.setText("");
             }
         });
         jpcadastrar.add(jtapelido);
         jpcadastrar.add(jtnome);
         
        tipodoc = new JComboBox<String>();
        tipodoc.setToolTipText("Escolha o tipo de documento");
	tipodoc.setModel(new DefaultComboBoxModel<String>(tipo_doc));
	tipodoc.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
	tipodoc.setBackground(Color.WHITE);
	tipodoc.addActionListener(this);           
	tipodoc.setBounds(250, 140, 160, 30);
	tipodoc.setFocusable(false);
        jpcadastrar.add(tipodoc);
         
         Icon ic = new ImageIcon("ajuda.png");
         jldata = new JLabel("Data de nascimento");
         jldata.setFont(new Font("Segoi UI Historic", Font.PLAIN, 16));
         jldata.setForeground(new Color(0,102,102));
         jldata.setBounds(250, 180, 200, 30);
         //MaskFormatter dat = new MaskFormatter("##-##-####");
         jsData = new  JSpinner();
         jsData.setFont(new Font("tahoma", Font.PLAIN, 14));
         jsData.setBounds(250, 210, 137, 30);
         jsData.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    jsData.setFocusable(false);}  }   });
        
        jsData.setFont(new Font ("Segoi UI Historic", Font.PLAIN, 16));
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        jsData.setModel(new SpinnerDateModel());
        jsData.setEditor(new JSpinner.DateEditor(jsData, f.toPattern()));
         
         JLabel jlcpf = new JLabel("Insira o seu Apelido");
         jlcpf.setFont(new Font("impato", Font.PLAIN, 14));
         jlcpf.setForeground(new Color(0,102,102));
        
         MaskFormatter cpf = new MaskFormatter("##########L");
         mcpf = new JFormattedTextField(cpf);
         mcpf.add(jlcpf, BorderLayout.LINE_START);
         mcpf.setFont(new Font("tahoma", Font.PLAIN, 14));
         mcpf.setToolTipText("introduza o seu nr de identificacao");
         mcpf.setBounds(430, 140, 300, 30);
         jpcadastrar.add(jldata);
         jpcadastrar.add(jsData);
         jpcadastrar.add(mcpf);
         
         cancelar = new JButton("voltar");
         cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/voltar_1.png")));
         cancelar.setBackground(Color.WHITE);
         cancelar.setForeground(Color.DARK_GRAY);
         cancelar.setBounds(600, 270, 130, 35);
         cancelar.setFont(new Font("Segoe UI", Font.BOLD, 16));        
         cancelar.setFocusPainted(false);
	 cancelar.setOpaque(false);
         cancelar.addActionListener(this);
         jpcadastrar.add(cancelar);
         
         MB = new JMenuBar();
         MB.setBounds(250, 20, 500, 30);
         MB.setRequestFocusEnabled(false);
	 //MB.setBorderPainted(false);
	 MB.setOpaque(false);
         MB.setVisible(true);            
         menu = new JLabel("Clique aqui para emitir o seu nuit!");
         menu.setFont(new Font("Harrington", Font.BOLD, 14));
         menu.setForeground(Color.red);
         jbaqui= new JButton("Aqui");
         jbaqui.setFont(new Font("tahoma", Font.PLAIN, 18));
         jbaqui.setForeground(Color.BLACK); 
         jbaqui.setBackground(Color.WHITE);
         jbaqui.setBounds(410, 200, 500, 30);
         jbaqui.setFocusPainted(false);
	 jbaqui.setBorderPainted(false);
	 jbaqui.setOpaque(false);
         jbaqui.setEnabled(false);
         jbaqui.addActionListener(this);
         MB.add(menu);
         MB.add(jbaqui);
         jpcadastrar.add(MB);
         
         resp = new JTextArea();
         resp.setBackground(new Color(204,204,255));
         resp.setFont(new Font("tahoma", Font.PLAIN, 12));
         resp.setBounds(250, 60, 505, 25);
         resp.setForeground(Color.red);
         resp.setEditable(false);
         resp.setVisible(false);
         jpcadastrar.add(resp);
         jpcadastrar.add(mcpf);
         
         resp2 = new JTextArea();
         resp2.setBackground(new Color(204,204,255));
         resp2.setFont(new Font("tahoma", Font.PLAIN, 16));
         resp2.setBounds(20, 75, 350, 150);
         resp2.setForeground(Color.red);
         resp2.setEditable(false);
         resp2.setVisible(false);
         mb.add(resp2);
   
   }public static void main(String[] args) throws ParseException {
       Cadastrar m = new Cadastrar();
       m.setVisible(true);
       
    } private void bKeyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                jtcpf.setRequestFocusEnabled(true);
            }
    }
      
    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = jtnome.getText() +" "+ jtapelido.getText();
        int id = cliente.CodigoCliente();
        cliente = new Cliente(id,nome, mcpf.getText());
        int n = nuit.gerarNUIT(cliente);
        
         if(e.getSource() == jbaqui){
         Menu mn = new Menu();
         if (fch.Testar(pasta, mcpf.getText())) {
         JOptionPane.showMessageDialog(null, "O seu Codigo de indentificao ja foi usado");
         jtnome.setEditable(true);
         jtapelido.setEditable(true);
         mcpf.setEditable(true); 
         jbaqui.setEnabled(true);
            }else{
            nuit = new Nuit(cliente, n );
            System.out.println(mcpf+ " "+nuit.toString());
            resp2.setVisible(true);
            JOptionPane.showMessageDialog(null, "Nuit emitido com sucesso\n"+"\t codigo do cliente numero: "+id); 
            try {
            fch.escreverFicheiro(pasta, mcpf.getText()+"; Nome: "+jtnome.getText()+"; Nuit: "+n);
            }catch (IOException ex) {
            Logger.getLogger(Cadastrar.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
         }
        if(e.getSource() == cancelar){
            Menu pc = new Menu();
            this.setVisible(false);
            pc.setLocationRelativeTo(null);
            pc.setVisible(true);}
         
         
          if(e.getSource() == jbemitir){ 
              System.out.println(mcpf.getText());
              if ("           ".equals(mcpf.getText()) || jtnome.getText().isEmpty() || jtnome.getText().length()<4 || jtnome.getText().length()>50) {
              resp.setVisible(true);   
              resp.setText("erro!. Por favor preenche o formulario correctemente");
              }
              else{
              if(JOptionPane.showConfirmDialog(this, "Confirme os seus dados antes de Prosseguir\n"+cliente.toString(), "confirme os seus dados", JOptionPane.YES_NO_OPTION)
              == JOptionPane.YES_OPTION){            
                    jtnome.setEditable(false);
                    jtapelido.setEditable(false);
                    mcpf.setEditable(false); 
                    jbaqui.setEnabled(true);
                    try {
            fch.escreverFicheiro(arquivo, cliente.toString());
            }catch (IOException ex) {
            Logger.getLogger(Cadastrar.class.getName()).log(Level.SEVERE, null, ex);
            }
                    resp.setText("");  }
                    else{
                       
                   }
               }
          }
    }
    }
        
    

