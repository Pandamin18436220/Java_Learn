package GOF23.Builder;

public class SxtAirShipDirextor implements AirShipDirextor{
    private AirShipBuider builder;
    public SxtAirShipDirextor(AirShipBuider builder){
        this.builder = builder;
    }
    @Override
    public AirShip directAirShip() {
        Engine e = builder.buiderEngine();
        OrbitalModule o = builder.buiderOrbitalModule();
        EscapeTower et = builder.buiderEscapeTower();

        //组装
        AirShip ship = new AirShip();
        ship.setEngine(e);
        ship.setOrbitalModule(o);
        ship.setEscapeTower(et);

        return ship;
    }
}
