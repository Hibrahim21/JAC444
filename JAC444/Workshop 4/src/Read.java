import java.io.*;

public class Read {
	private File file;

	public Read(File file) throws ReadException {

		if (file.exists()) {
			this.file = file;
		} else {
			throw new ReadException("File could not be found");
		}
	}

	public void deserializeObject() throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream(this.file.getName());
		ObjectInputStream ois = new ObjectInputStream(fis);
		Student obj = null;
		obj = (Student) ois.readObject();
		System.out.println(obj.getStdID());
		System.out.println(obj.getFirstName());
		System.out.println(obj.getLastName());
		System.out.println(obj.getCourses());
		ois.close();
	}
}
