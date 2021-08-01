public class RegistrationImp extends java.rmi.server.UnicastRemoteObject implements Registration {

    public RegistrationImp() throws java.rmi.RemoteException {
        super();
    }

    public Car registrateVehicle(Car obj) {

        Car vehicle = obj;
        vehicle.setPlateNo("" + vehicle.hashCode());

        return vehicle;
    };
}
