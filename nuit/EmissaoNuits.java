
package nuit;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class EmissaoNuits extends JFrame {
    
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;
    
    private JTextField nomeField;
    private JTextField cpfField,idField ;
    private JTextField valorField;
    private JButton emitirButton;
    private JTextArea resultadoArea;
    private  Nuit nuit = new Nuit();
    
    public EmissaoNuits() {
        super("Emissão de NUITS");
        
        // Cria o menu
        menuBar = new JMenuBar();
        menu = new JMenu("Opções");
        menuItem = new JMenuItem("Sair");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(menuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);
        
        // Cria os componentes da interface gráfica
        nomeField = new JTextField(20);
        nomeField.setBounds(10, 1, 200, 50);
        cpfField = new JTextField(11);
        idField = new JTextField(11);
        int idcliente = Integer.parseInt(idField.getText());
        //cpfField.setToolTipText("bi");
        valorField = new JTextField(10);
        emitirButton = new JButton("Emitir");
        emitirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cliente cliente = new Cliente(idcliente,nomeField.getText(), cpfField.getText());
                nuit = new Nuit(cliente, nuit.gerarNUIT(cliente) );
                resultadoArea.setText(nuit.toString());
            }
        });
        resultadoArea = new JTextArea(5, 20);
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        
        // Adiciona os componentes à interface gráfica
        JPanel panel = new JPanel();
        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("CPF:"));
        panel.add(cpfField);
        panel.add(new JLabel("Valor:"));
        panel.add(valorField);
        panel.add(emitirButton);
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        
        // Configura a janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        Vector v = new Vector();
        
        new EmissaoNuits();
    }
}

