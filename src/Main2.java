import java.awt.*;
import java.awt.event.*;
public class Main2 {
    public static void main(String[] args) {
        Frame f=new Frame("Button Example");
        f.setLayout(null);
        final TextField tf=new TextField();
        tf.setBounds(50,50, 300,20);
        Button b=new Button("Click Here");
        b.setBounds(50,100,120,30);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf.setText("Welcome to Javatpoint.");
            }
        });
        f.add(b);f.add(tf);
        f.setSize(400,400);
        f.setVisible(true);
    }
}