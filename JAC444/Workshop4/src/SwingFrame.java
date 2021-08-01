import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingFrame extends JFrame{
	
	private final JLabel label;//, label1, label2, label3, label4;
	//private final JTextField field1, field2, field3, field4;
	//private final JButton addStudent, showStudent;
	GridBagConstraints labelC = new GridBagConstraints();
	GridBagConstraints ButtonC = new GridBagConstraints();
	GridBagConstraints TextC = new GridBagConstraints();

	
	public SwingFrame(String src){
		super(src);
		JPanel panel = new JPanel();

		//panel.setLayout(new GridBagLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//panel.setBounds(40,80,200,200);    

		
		label = new JLabel("Student ID: ");
		label.setFont(new Font("", Font.BOLD, 13));
		labelC.gridx = 0;
		labelC.gridy = 1;
		labelC.gridwidth = 1;
		labelC.anchor = GridBagConstraints.EAST;
		labelC.insets = new Insets(5, 20, 5, 10);
		panel.add(label, labelC);

		setSize(455, 279);
		panel.setVisible(true);		
	}
	
    public static void main(String args[]) {
    	SwingFrame frame = new SwingFrame("Workshop 5 GUI");
    	frame.setVisible(true);
    }
}
