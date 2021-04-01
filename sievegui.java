/* Course: CS 335
 * Author: William Watkins
 * Project: Exercise 2: Sieve GUI
 * Date: 9/6/2020
 * Purpose: GUI that uses former sieve program to determine if a number is prime
 **/

import java.awt.event.*;
import javax.swing.*;

public class sievegui{

    public static void main(String[] args) {
        int ARRAYLENGTH = 10000;

        // create boolean array
        boolean a[] = new boolean[ARRAYLENGTH];

        // set all values to true
        for (int i = 0; i < ARRAYLENGTH; i++) {
            a[i] = true;
        }

        // set non-prime values to false
        for (int i = 2; i < ARRAYLENGTH; i++) {
            if (a[i]) {
                for (int j = i + 1; j < ARRAYLENGTH; j++) {
                    if (j % i == 0) {
                        a[j] = false;
                    }
                }
            }
        }

        // initialize GUI elements
        JPanel p = new JPanel();
        JFrame f = new JFrame("Sieve GUI");
        JTextField t = new JTextField(15);
        JLabel l = new JLabel("Enter a number from 1 to 9999");
        JButton b = new JButton("Check");

        // add action listener to button
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user_input = t.getText();

                // Source used for syntax
                // https://www.javatpoint.com/java-string-to-int
                int i = Integer.parseInt(user_input);

                // see if number is in bounds and prime
                if (i < 1 | i > 99999){
                    l.setText("Your number is out of bounds");
                }
                else if (a[i]){
                    l.setText("Your number is prime.");
                }
                else{
                    l.setText("Your number is not prime.");
                }
            }
        });

        p.add(t); // add text field to panel
        p.add(b); // add button to panel
        p.add(l); // add label to panel
        f.add(p); // add panel to frame
        // set size
        f.setSize(500, 200);
        // set to visible
        f.setVisible(true);
        // when closed, exit program
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
