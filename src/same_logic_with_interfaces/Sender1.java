package same_logic_with_interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sender1 extends JFrame{
    private JPanel panel1;
    private JButton sendButton;
    private JTextArea textArea1;

    public Sender1() {
        super("my sender UI");
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message message = new Message(textArea1.getText(), "queue1");
                try {
                    message.send();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args){
        Sender1 sender=new Sender1();
        sender.setVisible(true);

    }
}
