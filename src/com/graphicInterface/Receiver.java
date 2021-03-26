package com.graphicInterface;

import javax.swing.*;

public class Receiver extends JFrame{
    private JTextPane textPane1;
    private JTextPane textPane2;
    private JTextPane textPane3;
    private JTextPane textPane4;
    private JPanel panelReceiver;

    Receiver(){
        super("my receiver UI");
        this.setContentPane(this.panelReceiver);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    public static void main(String[] args){
        Receiver receiver=new Receiver();
        receiver.setVisible(true);

    }

}
