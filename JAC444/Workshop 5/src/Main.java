import javax.swing.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		JFrame frame = new JFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setTitle("Workshop 5");
	    frame.setSize(new Dimension(455, 279));
	    
	    JPanel pane = new JPanel(new GridBagLayout());
	    pane.setBackground(Color.GREEN);
	    
	    displayMenu(pane);
  
	    frame.add(pane);
	    frame.setVisible(true);
	}
	
	 public static void displayMenu(JPanel pane){
	        pane.removeAll();

	        GridBagConstraints gridBag = new GridBagConstraints();

	        JLabel title = new JLabel("Main Menu");
	        title.setFont(title.getFont().deriveFont(15.0f));
	        
	        JButton[] menuButtons = {
	                new JButton("Add New Student"),
	                new JButton("Display Students"),
	        };

	        menuButtons[0].addActionListener(e -> {
	            Write.writeStdInfo(pane);
	       });

	        menuButtons[1].addActionListener(e -> {
	            Read.readStdInfo(pane);
	        });


	        gridBag.gridx = 0;
	        gridBag.gridy = 0;

	        gridBag.insets = new Insets(5, 0, 10, 0);
	        pane.add(title, gridBag);
	        gridBag.gridy++;

	        gridBag.insets = new Insets(5, 0, 5, 0);
	        for(JButton button : menuButtons){
	            button.setFont(button.getFont().deriveFont(15.0f));
	            button.setPreferredSize(new Dimension(350, 27));
	            pane.add(button, gridBag);
	            gridBag.gridy++;
	        }

	        pane.validate();
	        pane.repaint();
	    }
}
