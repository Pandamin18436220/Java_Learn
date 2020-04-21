package GOF23.Builder;

public class SxtAirShipBuilder implements AirShipBuider{//stringBuider DomBuider SaxBuider
    @Override
    public Engine buiderEngine() {
        System.out.println("发动机");
        return new Engine("pandamin");
    }

    @Override
    public OrbitalModule buiderOrbitalModule() {
        System.out.println("逃逸塔");
        return new OrbitalModule("pandamin");
    }

    @Override
    public EscapeTower buiderEscapeTower() {
        System.out.println("轨道舱");
        return new EscapeTower("pandamin");
    }

}
