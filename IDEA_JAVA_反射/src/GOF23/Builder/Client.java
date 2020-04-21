package GOF23.Builder;

public class Client {
    public static void main(String[] args) {
        AirShipDirextor director = new SxtAirShipDirextor(new SxtAirShipBuilder());
        AirShip ship = director.directAirShip();
        System.out.println(ship.getEngine().getName());
        ship.launch();
    }
}
