import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CarServer {
    public CarServer() {
        try {
            Registration obj = new RegistrationImp();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("RegistrationCarService", obj);

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void main(String args[]) {
        new CarServer();
        System.out.println("RegistrationCarService is running...");
    }
}
