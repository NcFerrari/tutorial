package zasobnik;

import java.util.ArrayDeque;
import java.util.Deque;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BackExample {

    /**
     * LIFO
     *
     * @param args
     */
    public static void main(String[] args) {
        Deque<String> stackBack = new ArrayDeque();
        Deque<String> stackForward = new ArrayDeque();
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        JTextField text = new JTextField();
        text.setSize(300, 25);
        panel.add(text);
        JButton button = new JButton("add");
        button.setSize(100, 25);
        button.setLocation(0, 25);
        button.addActionListener(evt -> {
            stackBack.push(text.getText());
            text.setText("");
        });
        panel.add(button);
        JButton button2 = new JButton("back");
        button2.setSize(100, 25);
        button2.setLocation(100, 25);
        button2.addActionListener(evt -> {
            String word = stackBack.poll();
            text.setText(word);
            stackForward.push(word);
        });
        panel.add(button2);
        JButton button3 = new JButton("forward");
        button3.setSize(100, 25);
        button3.setLocation(200, 25);
        button3.addActionListener(evt -> {
            String word = stackForward.poll();
            text.setText(word);
            stackBack.push(word);
        });
        panel.add(button3);
        frame.repaint();
    }
}
