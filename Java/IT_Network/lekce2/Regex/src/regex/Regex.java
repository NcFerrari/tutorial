package regex;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.swing.*;

public class Regex {

    private static JTextField regex, text;
    private static JLabel label;
    private static File file = new File("log.txt");
    private static boolean saveRecordToFile = false;
    private static String lastRegex = "";
    private static JComboBox<String> comboBox;

    public static void main(String[] args) {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
            }
        }
        JFrame frame = new JFrame();
        frame.setSize(500, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.gray);

        regex = new JTextField();
        regex.setSize(500, 25);
        panel.add(regex);

        text = new JTextField();
        text.setSize(500, 25);
        text.setLocation(0, 25);
        panel.add(text);

        label = new JLabel();
        label.setSize(500, 25);
        label.setLocation(0, 50);
        panel.add(label);

        comboBox = new JComboBox<>();
        comboBox.setSize(485, 25);
        comboBox.setLocation(0, 75);
        panel.add(comboBox);
        comboBox.setEditable(true);

        text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                checkRegex();
                if (saveRecordToFile) {
                    saveToFile(regex.getText());
                    lastRegex = regex.getText();
                    saveRecordToFile = false;
                }
            }
        });

        regex.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                checkRegex();
            }
        });

        panel.repaint();
    }

    public static void checkRegex() {
        try {
            comboBox.removeAllItems();
            regex.setForeground(Color.black);
            Pattern pat = Pattern.compile(regex.getText());
            Matcher mat = pat.matcher(text.getText());
            if (mat.find()) {
                label.setForeground(Color.green);
                label.setText("OK");
                List<String> allMatches = new ArrayList<>();
                Matcher m = Pattern.compile(regex.getText()).matcher(text.getText());
                while (m.find()) {
                    allMatches.add(m.group());
                }
                comboBox.removeAllItems();
                allMatches.forEach(evt -> {
                    comboBox.addItem(evt);
                });
            } else {
                label.setForeground(Color.red);
                label.setText("negative");
                if (!lastRegex.equals(regex.getText())) {
                    saveRecordToFile = true;
                }
            }
        } catch (PatternSyntaxException exp) {
            regex.setForeground(Color.red);
        }
    }

    public static void saveToFile(String regex) {
        if (!regex.trim().isEmpty()) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                writer.append(regex.trim());
                writer.newLine();
                writer.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Regex.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Regex.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
