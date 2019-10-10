package set_exercises;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class HeavenlyBodyTest {

    private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> stars = new HashSet<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();
    private static Set<HeavenlyBody> moons = new HashSet<>();
    private static Set<HeavenlyBody> dwarves = new HashSet<>();
    private static HeavenlyBody sun;
    private static HeavenlyBody earth;
    private static HeavenlyBody moon;
    private static HeavenlyBody vesta;

    @Before
    public void setup() {

        sun = new Star("Sun", 24.00);
        solarSystem.put(sun.getKey(), sun);
        stars.add(sun);

        earth = new Planet("Earth", 365.25);
        solarSystem.put(earth.getKey(), earth);
        planets.add(earth);

        moon = new Moon("Moon", 27.30);
        solarSystem.put(moon.getKey(), moon);
        moons.add(moon);
        //earth.addSatellite(earth);

        vesta = new DwarfPlanet("Vesta", 1325.75);
        solarSystem.put(vesta.getKey(), vesta);
        dwarves.add(vesta);
    }

    @Test
    public void toStringVerifyTest() {
        String expectedOutputStar = "[Sun : Star, 24.0]";
        String expectedOutputPlanet = "[Earth : Planet, 365.25]";
        String expectedOutputMoon = "[Moon : Moon, 27.3]";
        String expectedOutputDwarf = "[Vesta : DwarfPlanet, 1325.75]";

        String actualOutputStar = stars.toString();
        String actualOutputPlanet = planets.toString();
        String actualOutputMoon = moons.toString();
        String actualOutputDwarf = dwarves.toString();

        assertEquals(actualOutputStar, expectedOutputStar);
        assertEquals(actualOutputPlanet, expectedOutputPlanet);
        assertEquals(actualOutputMoon, expectedOutputMoon);
        assertEquals(actualOutputDwarf, expectedOutputDwarf);
    }

    @Test
    public void equalsTestIdenticalObject() {
        assertTrue(sun.equals(sun));
        assertTrue(earth.equals(earth));
        assertTrue(moon.equals(moon));
        assertTrue(vesta.equals(vesta));
    }

    @Test
    public void equalsTestSame() {
        HeavenlyBody sunRepeat = new Star("Sun", 24.0);
        HeavenlyBody earthRepeat = new Planet("Earth", 365.25);
        HeavenlyBody moonRepeat = new Moon("Moon", 27.3);
        HeavenlyBody dwarfRepeat = new DwarfPlanet("Vesta", 1325.75);
        assertTrue(sunRepeat.equals(sun));
        assertTrue(sun.equals(sunRepeat));
        assertTrue(earthRepeat.equals(earth));
        assertTrue(earth.equals(earthRepeat));
        assertTrue(moonRepeat.equals(moon));
        assertTrue(moon.equals(moonRepeat));
        assertTrue(dwarfRepeat.equals(vesta));
        assertTrue(vesta.equals(dwarfRepeat));
    }

    @Test
    public void equalsTestDifferent() {
        HeavenlyBody vega = new Star("Vega", 0.5);
        assertFalse(vega.equals(sun));
    }

    @Test
    public void equalsTestNotInstanceOfHeavenlyBody() {
        String notHeavenlyBody = "Not a HeavenlyBody";
        assertFalse(sun.equals(notHeavenlyBody));
    }

    @Test
    public void hashCodeTestMatch() {
        HeavenlyBody sunRepeat = new Star("Sun", 1.0);
        HeavenlyBody earthRepeat = new Planet("Earth", 2.0);
        HeavenlyBody moonRepeat = new Moon("Moon", 3.0);
        HeavenlyBody dwarfRepeat = new DwarfPlanet("Vesta", 4.0);
        assertEquals(sunRepeat.hashCode(), sun.hashCode());
        assertEquals(earthRepeat.hashCode(), earth.hashCode());
        assertEquals(moonRepeat.hashCode(), moon.hashCode());
        assertEquals(dwarfRepeat.hashCode(), vesta.hashCode());
    }

    @Test
    public void hashCodeTestDifferent() {
        HeavenlyBody sunRepeat = new Star("Sun", 1.0);
        assertNotEquals(sunRepeat.hashCode(), earth.hashCode());
    }

    @Test
    public void addSatelliteStarDwarf() {
        sun.addSatellite(vesta);
        String actualOutput = sun.getSatellites().toString();
        String expectedOutput = "[Vesta : DwarfPlanet, 1325.75]";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void addSatellitePlanetMoon() {
        earth.addSatellite(moon);
        String actualOutput = earth.getSatellites().toString();
        String expectedOutput = "[Moon : Moon, 27.3]";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void addSatellitePlanetNonPlanet() {
        earth.addSatellite(vesta);
        String actualOutput = earth.getSatellites().toString();
        String expectedOutput = "[]";
        assertEquals(expectedOutput, actualOutput);
    }




}
