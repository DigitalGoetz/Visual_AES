
package aes.ui;


import aes.driver.AES128;
import aes.driver.AES192;
import aes.driver.AES256;
import aes.utility.ByteArray;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class AES_Frame extends JFrame{
    JButton button128;
    JButton button192;
    JButton button256;
    JButton codec;
    
    JTextField rand128text;
    JTextField rand192text;
    JTextField rand256text;
    
    JTextArea output;
    JTextField keyField;
    JTextField messageField;
    
    public AES_Frame(){
        
        
        
        
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        
        
        buildUI();
        
        this.pack();
        this.setTitle("CS 4290: Cryptography Presentation");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(new Dimension(800, 600));
        this.setVisible(true);
        
    }
    
    private void buildUI(){
        JPanel rand128 = new JPanel();
        rand128.setLayout(new FlowLayout());
        JLabel rand128label = new JLabel("random 128: ");
        rand128text = new JTextField(45);
        button128 = new JButton("Generate Random");
        button128.addActionListener(new RandomListener());
        
        rand128.add(rand128label);
        rand128.add(rand128text);
        rand128.add(button128);
        
        JPanel rand192 = new JPanel();
        rand192.setLayout(new FlowLayout());
        JLabel rand192label = new JLabel("random 192: ");
        rand192text = new JTextField(45);
        button192 = new JButton("Generate Random");
        button192.addActionListener(new RandomListener());
        rand192.add(rand192label);
        rand192.add(rand192text);
        rand192.add(button192);
        
        JPanel rand256 = new JPanel();
        rand128.setLayout(new FlowLayout());
        JLabel rand256label = new JLabel("random 256: ");
        rand256text = new JTextField(45);
        button256 = new JButton("Generate Random");
        button256.addActionListener(new RandomListener());
        rand256.add(rand256label);
        rand256.add(rand256text);
        rand256.add(button256);
        
        JPanel keyPanel = new JPanel();
        keyPanel.setLayout(new FlowLayout());
        JLabel keyLabel = new JLabel("Key: ");
        keyField = new JTextField(45);
        keyPanel.add(keyLabel);
        keyPanel.add(keyField);
        
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new FlowLayout());
        JLabel messageLabel = new JLabel("Plain / Cipher Text : ");
        messageField = new JTextField(45);
        messagePanel.add(messageLabel);
        messagePanel.add(messageField);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        codec = new JButton("Encrypt and Decrypt");
        codec.addActionListener(new CodecListener());
        buttonPanel.add(codec);
        
        JPanel outputPanel = new JPanel();
        outputPanel.setSize(new Dimension(400, 400));
        outputPanel.setLayout(new BorderLayout());
        output = new JTextArea();
        Font font = new Font("Courier New" , Font.BOLD, 16);
        output.setFont(font);
        JScrollPane sp = new JScrollPane(output);
        sp.setSize(new Dimension(400, 400));
        output.setEditable(false);
        outputPanel.add(sp, BorderLayout.CENTER);
        
        this.add(rand128);
        this.add(rand192);
        this.add(rand256);
        this.add(keyPanel);
        this.add(messagePanel);
        this.add(buttonPanel);
        this.add(outputPanel);
    }
    
    public static void main(String[] args){
        AES_Frame main = new AES_Frame();
        
    }
    
    private class RandomListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(button128)){
                ByteArray b128 = ByteArray.random(ByteArray.SIZE_128);
                rand128text.setText(b128.toString());
            }
            if(e.getSource().equals(button192)){
                ByteArray b192 = ByteArray.random(ByteArray.SIZE_192);
                rand192text.setText(b192.toString());
            }
            if(e.getSource().equals(button256)){
                ByteArray b256 = ByteArray.random(ByteArray.SIZE_256);
                rand256text.setText(b256.toString());
            }
        }
        
    }
    

    
    private class CodecListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            output.setText("");
            String key = keyField.getText();
            String message = messageField.getText();
                
            if(key.length() == ByteArray.SIZE_128 * 2){
                System.out.println("128");
                AES128 aes128 = new AES128(key, message, output);
                aes128.performEncryption();
                aes128.performDecryption();
                output.append("\ninitial message = " + message + "\n");
                output.append("    initial key = " + key + "\n");
                output.append("    cipher text = " + aes128.cipherText.toString() + "\n");
                output.append("     plain text  =" + aes128.plainText.toString() + "\n");
            }
            if(key.length() == ByteArray.SIZE_192 * 2){
                System.out.println("192");
                AES192 aes192 = new AES192(key, message, output);
                aes192.performEncryption();
                aes192.performDecryption();
                output.append("\ninitial message = " + message + "\n");
                output.append("    initial key = " + key + "\n");
                output.append("    cipher text = " + aes192.cipherText.toString() + "\n");
                output.append("     plain text  =" + aes192.plainText.toString() + "\n");
            }
            if(key.length() == ByteArray.SIZE_256 * 2){
                System.out.println("256");
                AES256 aes256 = new AES256(key, message, output);
                aes256.performEncryption();
                aes256.performDecryption();
                output.append("\ninitial message = " + message + "\n");
                output.append("    initial key = " + key + "\n");
                output.append("    cipher text = " + aes256.cipherText.toString() + "\n");
                output.append("     plain text  =" + aes256.plainText.toString() + "\n");
            }
        }
        
    }
}
