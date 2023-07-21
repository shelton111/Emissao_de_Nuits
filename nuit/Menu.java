
package nuit;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;


public class Menu extends JFrame implements ActionListener{
     private int opc;
     private Validacao vd;
     private JPanel jpCabecalho, jpCadastro,jpCentral,jpSuperior, jpInferior, mb;
     private JLabel png; 
     private JButton lbEmitir, jbConsultar, jbTerminar, m, jbBaixar, jbAjuda, jbVerificar, l, jbLink;
     private int numero=0;
     public Menu(){
         
       
         vd = new Validacao();
         jpSuperior = new JPanel();
         jpInferior = new JPanel();
         jpCadastro = new JPanel();
         jpCentral = new JPanel();
         mb = new JPanel();
         
         mb.setBounds(0, 175, 400,500);
         mb.setBackground(Color.CYAN);
         add(mb); mb.setVisible(false);
          
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 setSize(1000, 700);
	 setLocationRelativeTo(null);
         setBackground(Color.BLUE);
         
         jpSuperior.setBorder(new LineBorder(Color.darkGray, 2));
         jpSuperior.setBackground(new Color(0,102,102));
         jpSuperior.setBounds(0, 175, 1000, 100);jpSuperior.setVisible(true); add(jpSuperior);
         
         jpInferior.setBorder(new LineBorder(Color.darkGray, 2));
         jpInferior.setBackground(Color.WHITE);
         jpInferior.setBounds(0, 600, 1000, 100);
         jpInferior.setVisible(true); add(jpInferior);
         
         jpCadastro.setBorder(new LineBorder(Color.darkGray, 2));
         jpCadastro.setBackground(Color.WHITE);
         jpCadastro.setBounds(00, 250, 1000, 350);
         jpCadastro.setVisible(false); add(jpCadastro);
         
         jpCentral.setBorder(new LineBorder(Color.darkGray, 2));
         jpCentral.setBackground(Color.WHITE);
         jpCentral.setBounds(0, 200, 1000, 720); add(jpCentral);
         
         jpInferior.setLayout(null);
	 jpSuperior.setLayout(null);
         jpCadastro.setLayout(null); 
         jpCentral.setLayout(null);
         mb.setLayout(null);
          
        jpCabecalho = new JPanel();                              
        jpCabecalho.setBackground(Color.BLACK);
        jpCabecalho.setBounds(0, 0, 1000, 150);
        add(jpCabecalho);
        jpCabecalho.setLayout(null); 
         
        JLabel tema = new JLabel();
        tema.setIcon( new javax.swing.ImageIcon(getClass().getResource("/imgs/logo.png")));
        tema.setForeground(Color.YELLOW);
	tema.setFont(new Font("tahoma", Font.PLAIN, 18));
	tema.setHorizontalAlignment(SwingConstants.CENTER);
	tema.setBounds(5, 0, 600, 150);
	jpCabecalho.add(tema);
        
        png = new JLabel("\nSistema de Emissao de Nuits");
        png.setIcon( new javax.swing.ImageIcon(getClass().getResource("/imgs/nuit2.png")));
        png.setFont(new Font("tahoma", Font.PLAIN, 35));
        png.setHorizontalAlignment(SwingConstants.CENTER);
        png.setBounds(220, 150, 500, 100);
        jpCentral.add(png);
         
         
         m = new JButton();
         m.setBackground(Color.GREEN.darker());
         m.setMnemonic('B');
         m.setBorderPainted(false);
         m.setOpaque(false);
         m.setFocusPainted(false);
         m.addActionListener(this);
         m.setBounds(300, 5, 150, 60);
         //menu.add(m);
          
         lbEmitir = new JButton("Emitir Nuit");
         //E.setIcon( new javax.swing.ImageIcon(getClass().getResource("/imgs/nuit++.png")));
         lbEmitir.setFont(new Font("impact", Font.PLAIN, 35));
         lbEmitir.setBackground(Color.GREEN);
         lbEmitir.setBounds(100, 35, 200, 35); 
         lbEmitir.setBorderPainted(false);
         lbEmitir.setFocusPainted(false);
         lbEmitir.addActionListener(this);
	 lbEmitir.setOpaque(false);
         jpSuperior.add(lbEmitir);
        
         
         JLabel jl5 = new JLabel();
         jbConsultar = new JButton("Consultar Nuit");
         //C.setIcon( new javax.swing.ImageIcon(getClass().getResource("/imgs/nuitp2.png")));
         jbConsultar.setFont(new Font("impact", Font.PLAIN, 35));
         jbConsultar.setBackground(Color.YELLOW);
         jbConsultar.setBounds(350, 35, 260, 35);     
         jbConsultar.setFocusPainted(false);
         jbConsultar.setBorderPainted(false);
         jbConsultar.addActionListener(this);
	 jbConsultar.setOpaque(false);
         jpSuperior.add(jbConsultar);
         
         jbBaixar = new JButton("Baixar Nuit"); 
         //m2.setIcon( new javax.swing.ImageIcon(getClass().getResource("/imgs/nuitc.png"))); 
         jbBaixar.setBackground(Color.GREEN.darker());
         jbBaixar.setFont(new Font("impact", Font.BOLD, 35)); 
         jbBaixar.setToolTipText("baixar");
         jbBaixar.setMnemonic('B');
         jbBaixar.setOpaque(false);
         jbBaixar.setBorderPainted(false);
         jbBaixar.setBorderPainted(false);
         jbBaixar.setFocusPainted(false);
         jbBaixar.addActionListener(this);
         jbBaixar.setBounds(660, 35, 200, 35);
         jpSuperior.add(jbBaixar);
         
         
         l = new JButton();
         l.setIcon( new javax.swing.ImageIcon(getClass().getResource("/imgs/login.png")));
         l.setFont(new Font("Segoe UI", Font.BOLD, 14));
         l.setBackground(Color.ORANGE);
         l.setMnemonic('B');
         l.setFocusPainted(false);
         l.addActionListener(this);
         l.setBounds(10, 300, 190, 50);
         jpSuperior.add(l);
         
         jbVerificar = new JButton("visualisar");
         jbVerificar.setIcon( new javax.swing.ImageIcon(getClass().getResource("/imgs/nuitc.png")));
         jbVerificar.setFont(new Font("Segoe UI", Font.BOLD, 20));
         jbVerificar.setBackground(Color.MAGENTA);
         jbVerificar.setMnemonic('m');
         jbVerificar.setOpaque(false);
         jbVerificar.setFocusPainted(false);
         jbVerificar.setBorderPainted(false);
         jbVerificar.addActionListener(this);
         jbVerificar.setBounds(480, 0, 170, 50);
         jpInferior.add(jbVerificar);
         
         
         jbLink = new JButton("navegador");
         jbLink.setIcon( new javax.swing.ImageIcon(getClass().getResource("/imgs/nuitferr.png")));
         jbLink.setBackground(Color.GREEN.darker());
         jbLink.setMnemonic('B');
         jbLink.setFont(new Font("thoma", Font.BOLD, 20));
         jbLink.setBorderPainted(false);
         jbLink.setOpaque(false);
         jbLink.setFocusPainted(false);
         jbLink.addActionListener(this);
         jbLink.setBounds(130, 10, 170, 30);
         jpInferior.add(jbLink);
         
        jbAjuda = new JButton("ajuda");
        jbAjuda.setFont(new Font("Segoe UI", Font.BOLD, 20));
        jbAjuda.setIcon( new javax.swing.ImageIcon(getClass().getResource("/imgs/nuit!!.png")));
        jbAjuda.setFocusPainted(false);
        jbAjuda.addActionListener(this);
        jbAjuda.setBorderPainted(false);
        jbAjuda.setBackground(Color.BLUE);
        jbAjuda.setOpaque(false);
        jbAjuda.setBounds(310 ,10, 150, 30); 
        jpInferior.add(jbAjuda);
         
         JSeparator s = new JSeparator();
         s.setBounds(0, 260, 400, 50);
         s.setBackground(Color.GRAY);
         jpSuperior.add(s);
         
         jbTerminar = new JButton("sair");
         jbTerminar.setIcon( new javax.swing.ImageIcon(getClass().getResource("/imgs/sair.png")));
         jbTerminar.setBackground(Color.GREEN.darker());
         jbTerminar.setFont(new Font("Segoe UI", Font.BOLD, 20));
         jbTerminar.setBounds(680, 0, 100, 50);
         jbTerminar.setForeground(Color.red);
         jbTerminar.setFocusPainted(false);
         jbTerminar.addActionListener(this);
	 jbTerminar.setBorderPainted(false);
	 jbTerminar.setOpaque(false);
         jpInferior.add(jbTerminar);
         
        
        
     }
      private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {  
        JOptionPane.showMessageDialog(null, "Cliente Não Encontrado!!", "Pesquisar Cliente", JOptionPane.ERROR_MESSAGE);
        
          String nr = JOptionPane.showInputDialog("digite o codigo");
          
           numero = Integer.parseInt(nr);
           if (numero>123) {
           JOptionPane.showMessageDialog(null, "nuit invalido, tente novamente");
          }else{    
           JOptionPane.showMessageDialog(null, "nuit pronto para baixar");    
           }
          }                              
               
       public static void main(String[] args) {
       Menu m = new Menu();
       m.setVisible(true);
       }
       

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == lbEmitir){
             try {
                Cadastrar cd = new Cadastrar();
                 jpCadastro.add(cd);
                 cd.setVisible(true);
                 jpCadastro.setVisible(true);
                 jpCentral.setVisible(false);
                 } catch (ParseException ex) {
                 Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
             }
         }      
        Icon n = new ImageIcon("/imgs/nuit2.png");
        if(e.getSource() == jbConsultar){
         Consultar pc = new Consultar();
         pc.consultar().setVisible(true);
        }
        
        if (e.getSource() == jbLink) {
             try {
                 URI link = new URI("https://nuit.at.gov.mz/nuit/bootstrap/theme/work/Impressao_Carta.aspx");
                 Desktop.getDesktop().browse(link);
             } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex);
             }
            jpInferior.setVisible(true);
           
        }
        
        
        if (e.getSource() == jbVerificar) {
         
            Consultar pc = new Consultar();
           ; 
            jpInferior.setVisible(true);
            jpSuperior.setVisible(false);
        }
        
          if(e.getSource() == jbTerminar){
            dispose();}
        
          
      if(e.getSource() == jbAjuda){
           String nr = JOptionPane.showInputDialog(this.rootPane,"digite o codigo");
           numero = Integer.parseInt(nr);
           if (numero>123) {
           JOptionPane.showMessageDialog(this, "nuit invalido ", "Pesquisar nuit",JOptionPane.ERROR_MESSAGE);
          }else{    
           JOptionPane.showMessageDialog(this, "nuit pronto para baixar", "Pesquisar nuit", JOptionPane.INFORMATION_MESSAGE);    
           }
          }                  
   
}
}
