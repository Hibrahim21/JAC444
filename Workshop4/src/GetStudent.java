import java.io.*;
import java.util.*;


public class GetStudent {

    public static ArrayList<Student> loader(ArrayList<Student> input){
        try{
            FileInputStream fis = new FileInputStream ( "StudentAccount.bin" );
            ObjectInputStream ois = new ObjectInputStream(fis);

                input= (ArrayList)ois.readObject ();

        } catch ( FileNotFoundException e ) {
            System.out.println(e.getMessage());
        } catch ( IOException e ) {
            System.out.println(e.getMessage());
        } catch ( ClassNotFoundException e ) {
            System.out.println(e.getMessage());

        }
    return input;
    };

    public static void read(){
        ArrayList<Student> out = new ArrayList<Student> (  );
        try{

            FileInputStream fis = new FileInputStream ( "StudentAccount.bin" );
            ObjectInputStream ois = new ObjectInputStream(fis);

            out = (ArrayList) ois.readObject();
            for ( Student a : out ){
                System.out.println ( a.toString () );
            }
            
            ois.close();
        
        } catch ( FileNotFoundException e ) {
            System.out.println(e.getMessage());
        } catch ( IOException e ) {
            System.out.println(e.getMessage());
        } catch ( ClassNotFoundException e ) {
            System.out.println(e.getMessage());
        }
    }
}


