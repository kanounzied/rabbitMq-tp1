package same_shit_with_interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sender2 extends  JFrame{
    private JPanel panel1;
    private JButton button1;
    private JTextArea textArea1;

    public Sender2() {
        super("my sender UI");
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message message = new Message(textArea1.getText(), "queue2");
                try {
                    message.send();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args){
        Sender2 sender=new Sender2();
        sender.setVisible(true);

    }
}
