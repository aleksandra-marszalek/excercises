package set_exercises;

public class Planet extends HeavenlyBody {
    public Planet(String name, double orbitalPeriod) {
        super(name, BodyTypes.Planet, orbitalPeriod);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if (moon.getKey().getBodyType() == HeavenlyBody.BodyTypes.Moon) {
            return super.addSatellite(moon);
        } else {
            return false;
        }
    }
}
