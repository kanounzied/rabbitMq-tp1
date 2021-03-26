package com.graphicInterface;

import javax.swing.*;

public class Player extends JFrame{
    private JPanel idPanel;
    private JPanel textPanel;
    private JTextField textField1;
    private JTextArea textArea1;
    private JPanel panelSender;

    Player(){
        super("my sender UI");
        this.setContentPane(this.panelSender);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    public static void main(String[] args){
        Player player=new Player();
        player.setVisible(true);

    }

}


