import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingStudent {
	private final JFrame container = new JFrame("Student Information Form");
	private final JPanel panel1 = new JPanel();// used to hold all JPanels // parent panel
	private final JTextField studentNumbertf = new JTextField(10);// student number text field
	private final JTextField firstNametf = new JTextField(10);// first name text field
	private final JTextField lastNametf = new JTextField(10);;// last name tect field
	private final JTextArea courseta = new JTextArea(5, 10); // length - width; courses text area
	private final JPanel buttonPanel = new JPanel();// set up button panel
	private final JFrame outputContainer = new JFrame("Student Information");// output frame
	private final JTextArea output = new JTextArea(5, 10);// Text area for deserialized object
	private Student obj = new Student();
	private File file;// used to serialize and deserialize object

	public SwingStudent(File file) throws FileReadException {
		if (file.exists()) {
			this.file = file;
		} else {
			throw new FileReadException("File could not be found");
		}

	}

	public void createGUI() {
		//
		// close, release all resources and set size of frame
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.setSize(400, 300);// width - length
		//
		// setting up layout and frame to hold all components
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));// set layout for each panel to be set on new line
		//
		// component for student number
		createStudentNumberPanel();
		//
		// component for first name
		createFirstNamePanel();
		//
		// component for last name
		createLastNamePanel();
		//
		// component for courses
		createCoursesPanel();	
		//
		//setting layout for button panel
		buttonPanel.setLayout(new FlowLayout());// flow layout for submit and read button to be side by side		
		//
		// component for submit button
		createSubmitButton();
		//
		// component for read button
		createReadButton();	
		//
		// add all components to JFrame container
		panel1.add(buttonPanel);//add button panel to parent panel
		container.add(panel1);//added parent panel to JFrame container
		container.setLocationRelativeTo(null);//set to open in middle of screen
		container.setVisible(true);
	}
	
	//
	//Student Number JPanel
	public void createStudentNumberPanel() {
		JPanel studentNumberPanel = new JPanel();// set up panel to hold label and textField of student number
		studentNumberPanel.setLayout(new FlowLayout());// Flowlayout for label and textfield to be side by side
		JLabel studentNumberlabel = new JLabel("Student Number:     ");// space to align box area
		studentNumberPanel.add(studentNumberlabel);
		studentNumberPanel.add(studentNumbertf);
		panel1.add(studentNumberPanel);// add student number panel to parent panel
	}
	//
	//First Name JPanel
	public void createFirstNamePanel() {
		JPanel firstNamePanel = new JPanel();// set up first name panel
		firstNamePanel.setLayout(new FlowLayout());// Flowlayout for label and textfield to be side by side
		JLabel firstNamelabel = new JLabel("First Name:              ");// space to align box area
		firstNamePanel.add(firstNamelabel);
		firstNamePanel.add(firstNametf);
		panel1.add(firstNamePanel);// add firstname panel to parent panel
	}
	
	//
	//Last Name JPanel
	public void createLastNamePanel() {
		JPanel lastNamePanel = new JPanel();// set up last name panel
		lastNamePanel.setLayout(new FlowLayout());// Flowlayout for label and textfield to be side by side
		JLabel lastNamelabel = new JLabel("Last Name:               ");// space to align box area
		lastNamePanel.add(lastNamelabel);
		lastNamePanel.add(lastNametf);
		panel1.add(lastNamePanel);// add last name panel to parent panel
	}
	
	//
	//Courses JPanel
	public void createCoursesPanel() {
		JPanel coursePanel = new JPanel();// set up courses panel
		coursePanel.setLayout(new FlowLayout());// Flowlayout for label and textfield to be side by side
		JLabel courseLabel = new JLabel("Courses:                  ");// space to align box area
		coursePanel.add(courseLabel);
		coursePanel.add(courseta);
		panel1.add(coursePanel);// add course panel to parent panel
	}
	
	//
	//Submit button creation and add to button JPanel
	public void createSubmitButton() {
		JButton button = new JButton("Submit");
		buttonPanel.add(button);// added submit button to button panel
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {// on event trigger

				try {

					ArrayList<String> courses = new ArrayList<String>();// create new array
					String[] course = null;// new String class
					//
					// store use input into Student object
					obj.setStdID(Integer.parseInt(studentNumbertf.getText()));// set student ID for Student object
					obj.setFirstName(firstNametf.getText());// set first name for Student Object
					obj.setLastName(lastNametf.getText());// set last name for Student object
					if (courseta.getText().indexOf(" ") >= 0) {// find delimiter
						course = courseta.getText().split("\\ ");// split string with space as delimiter into array
					} else if (courseta.getText().indexOf("\n") >= 0) {// find delimiter
						course = courseta.getText().split("\\\n");// split string with new line as delimiter into array
						for (String i : course) {
							courses.add(i);// add string array to ArrayList one by one
						}
						obj.setCourses(courses);// set courses for Student object
					}
					JOptionPane.showMessageDialog(buttonPanel, String.format(
				            "You pressed %s and submitted student information", event.getActionCommand()));
					//
					// write object to file
					try {
						writeFile(file, obj);// call writefile
					} catch (IOException | FileWriteException e1) {
						e1.printStackTrace();
					}
					

				} catch (StudentException message) {
					System.out.println(message.getMessage());
				}

			}// end of actionPerformed function
		});// end of anonymous class
		
	}
	
	//
	//Read button creation and add to JPanel
	public void createReadButton() {
		JButton button2 = new JButton("Read");
		buttonPanel.add(button2);//add read button to button panel
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					readFile(file);//read Student object

				} catch (ClassNotFoundException | FileReadException | IOException e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(outputContainer, String.format(
			            "You pressed %s to display student information", event.getActionCommand() ));
			}
		});
	}
	
	//
	// write to file
	public void writeFile(File file, Student obj) throws FileNotFoundException, IOException, FileWriteException {
		FileWrite fw = new FileWrite(file);
		fw.serializeObject(obj);// serialize object into a file
	}

	//
	// read from file
	public void readFile(File file)
			throws FileReadException, StreamCorruptedException, ClassNotFoundException, IOException {
		FileRead fr = new FileRead(file);
		outputContainer.setSize(400, 300);//set size of output frame
		output.setEditable(false);
		output.setText(Integer.toString(fr.deserializeObject().getStdID()) + "\n");//set text
		output.append(fr.deserializeObject().getFirstName() + "\n");//deserializeObect returns a Student object
		output.append(fr.deserializeObject().getLastName() + "\n");//used to call getters in Student class
		output.append("[ ");//format
		for (int i = 0; i < fr.deserializeObject().getCourses().size(); ++i) {
			if (i != fr.deserializeObject().getCourses().size() - 1) {//used to stop adding comma after last element
				output.append(fr.deserializeObject().getCourses().get(i) + ", ");
			} else {
				output.append(fr.deserializeObject().getCourses().get(i));
			}
		}
		output.append(" ]");//format
		outputContainer.add(output);//added text in textarea component to output frame
		outputContainer.setLocationRelativeTo(null);//set to box appear in middle of screen
		outputContainer.setVisible(true);
	}

	public static void main(String[] args) {
		File file = new File(args[0]);
		SwingStudent ss = null;
		try {
			ss = new SwingStudent(file);
		} catch (FileReadException e) {
			e.printStackTrace();
		}
		ss.createGUI();

	}

}