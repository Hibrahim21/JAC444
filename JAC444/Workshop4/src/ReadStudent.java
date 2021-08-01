import java.io.*;
import java.util.*;

public class ReadStudent {
	 public static void saver( ArrayList<Student> output) {
	        try {
	            FileOutputStream fis = new FileOutputStream ( "StudentAccount.bin" );
	            ObjectOutputStream ois = new ObjectOutputStream ( fis );
	            ois.writeObject ( output );
	        } catch ( FileNotFoundException e ) {
	            System.out.println ( e.getMessage ( ) );
	        } catch ( IOException e ) {
	            System.out.println ( e.getMessage ( ) );
	        } catch (Exception e ) {
	            System.out.println ( e.getMessage ( ) );
	        }
	    }
}
