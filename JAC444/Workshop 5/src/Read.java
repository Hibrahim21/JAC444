import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Read {
	public static void readStdInfo(JPanel pane){

        pane.removeAll();

        GridBagConstraints gridBag = new GridBagConstraints();
        JTextArea txtArea = new JTextArea();
        boolean read = true;
        int stdCounter = 1;


        JButton back = new JButton("Return");
        back.setBounds(300, 300, 100, 50);

        try {
            FileInputStream fis = new FileInputStream("output.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            while(read) {
                Student std = (Student) ois.readObject();

                if(std != null) {

                    txtArea.append(
                            "Student " + stdCounter++ + '\n'
                            + "-----------------------------------\n"
                            + "Student Number: " + std.getStdID() + '\n'
                            + "Student Name: " + std.getFullName() + '\n'
                            + "Student Course(s): " + std.getCourses() + "\n\n"
                    );

                    txtArea.setMinimumSize(new Dimension(350, 350));


                    txtArea.setBackground(Color.gray);
                    txtArea.setFont(txtArea.getFont().deriveFont(12.0f));

                    gridBag.gridx = 0;
                    gridBag.gridy = 0;

                } else{
                    read = false;
                }
            }

            fis.close();

        }catch(EOFException e){
            txtArea.append("End of file reached!\n");
        } catch(Throwable e){
            System.err.println(e);
        }

        gridBag.gridx = 0;
        gridBag.gridy = 0;

        pane.add(txtArea, gridBag);
        gridBag.gridy++;
        pane.add(back, gridBag);

        back.addActionListener(e ->{
            Main.displayMenu(pane);
        });

        pane.validate();
        pane.repaint();

    }
}
