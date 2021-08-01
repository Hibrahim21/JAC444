import java.lang.reflect.MalformedParameterizedTypeException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CarClient {
    public static void main(String[] args) {
        try {
            Registration regristry = (Registration) Naming.lookup("rmi://localhost:1099/RegistrationCarService");

            Car tempCar1 = new Car("Honda","Red",1000);
            Car tempCar2 = new Car("Toyota","Blue",2000);
            Car tempCar3 = new Car("Ford","Gray",3000);

            System.out.println(tempCar1);
            System.out.println(tempCar2);
            System.out.println(tempCar3);

            tempCar1 = regristry.registrateVehicle(tempCar1);
            tempCar2 = regristry.registrateVehicle(tempCar2);
            tempCar3 = regristry.registrateVehicle(tempCar3);
            System.out.println(tempCar1);
            System.out.println(tempCar2);
            System.out.println(tempCar3);

        } catch (NotBoundException ex) {
            ex.printStackTrace();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

    }




}
