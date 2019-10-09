package set_exercises;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> stars = new HashSet<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();
    private static Set<HeavenlyBody> moons = new HashSet<>();
    private static Set<HeavenlyBody> dwarves = new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody temp = new Star("Sun", 24.00);
        solarSystem.put(temp.getKey(), temp);
        stars.add(temp);

        temp = new Planet("Mercury", 88.00);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Venus", 224.65);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Earth", 365.25);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new Moon("Moon", 27.30);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        moons.add(tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Mars", 687.00);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Phobos", 0.30);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        moons.add(tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Deimos", 1.25);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        moons.add(tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Jupiter", 4328.90);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Io", 1.75);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        moons.add(tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Europa", 3.55);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        moons.add(tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Ganymede", 7.15);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        moons.add(tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Castillo", 16.70);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        moons.add(tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Saturn", 10759.20);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Uranus", 30688.50);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Neptune", 60182.00);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new DwarfPlanet("Vesta", 1325.75);
        solarSystem.put(temp.getKey(), temp);
        dwarves.add(temp);

        temp = new DwarfPlanet("Ceres", 1683.15);
        solarSystem.put(temp.getKey(), temp);
        dwarves.add(temp);

        temp = new DwarfPlanet("Pluto", 90560.00);
        solarSystem.put(temp.getKey(), temp);
        dwarves.add(temp);

        temp = new DwarfPlanet("Eris", 203645.00);
        solarSystem.put(temp.getKey(), temp);
        dwarves.add(temp);


        for (HeavenlyBody heavenlyBody : dwarves) {
            System.out.println(heavenlyBody);
        }


    }

}
