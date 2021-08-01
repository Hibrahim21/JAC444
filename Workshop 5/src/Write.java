import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Write {
	
    public static void writeStdInfo(JPanel pane) {

        pane.removeAll();

        try {
            FileOutputStream fs = new FileOutputStream("output.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fs);

            JLabel[] stdInfoPrompt = {
                    new JLabel("Student ID: "),
                    new JLabel("Student's first name: "),
                    new JLabel("Student's last name: "),
                    new JLabel("Student's course: ")
            };

            ArrayList<JTextField> stdInfoInput = new ArrayList<JTextField>();
            
            stdInfoInput.add(new JTextField("Must be a number"));
            stdInfoInput.add(new JTextField("Must be entered"));
            stdInfoInput.add(new JTextField("Must be entered"));
            stdInfoInput.add(new JTextField("For More than one seperate with ',' "));
            
            GridBagConstraints gridBag = new GridBagConstraints();

            JButton save = new JButton("Save");
            save.setBounds(300, 300, 100, 50);

            JButton refresh = new JButton("Refresh");
            refresh.setBounds(300, 300, 100, 50);

            JButton back = new JButton("Return");
            back.setBounds(300, 300, 100, 50);


            Student std = new Student();

            gridBag.gridx = 0;
            gridBag.gridy = 0;
            gridBag.insets = new Insets(5, 0, 5, 3);

            for (int i = 0; i < stdInfoInput.size(); i++) {
                stdInfoInput.get(i).setColumns(20);
                stdInfoInput.get(i).setEditable(true);

                pane.add(stdInfoPrompt[i], gridBag);
                gridBag.gridx++;

                pane.add(stdInfoInput.get(i), gridBag);

                gridBag.gridx = 0;
                gridBag.gridy++;

            }
            
           
            
            
            
            pane.add(back, gridBag);
            gridBag.gridx++;

            pane.add(refresh, gridBag);
            gridBag.gridx++;
            
            pane.add(save, gridBag);

			
            back.addActionListener(e -> {
                try {
                    oos.flush();
                    fs.close();
                }catch (Throwable e1){
                    JOptionPane.showMessageDialog(null, e1, "***ERROR***", JOptionPane.WARNING_MESSAGE);
                }

                Main.displayMenu(pane);
            });

            refresh.addActionListener(e ->{
                for(JTextField inputField : stdInfoInput){
                    inputField.setText("");
                }
            });

            save.addActionListener(e -> {
                try {
                    std.setStdID(parseInt(stdInfoInput.get(0).getText()));
                    std.setFirstName(stdInfoInput.get(1).getText());
                    std.setLastName(stdInfoInput.get(2).getText());

                    for(int i = 3; i < stdInfoInput.size(); i++) {
                        std.setCourses(stdInfoInput.get(i).getText());
                    }

                    for (JTextField txtField : stdInfoInput) {
                        txtField.setText("");
                    }

                    oos.writeObject(std);
                    oos.flush();
                    oos.close(); 

                } catch (Throwable e1) {
                    JOptionPane.showMessageDialog(null, e1, "***ERROR***", JOptionPane.WARNING_MESSAGE);
                }

            });

            pane.validate();
            pane.repaint();


        } catch (Throwable e) {
            JOptionPane.showMessageDialog(null, e, "***ERROR***", JOptionPane.WARNING_MESSAGE);
        }
    }
}