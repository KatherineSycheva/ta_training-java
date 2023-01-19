package com.epam.training.ekaterina_sycheva.clean_code.aircompany;

import com.epam.training.ekaterina_sycheva.clean_code.aircompany.Planes.ExperimentalPlane;
import com.epam.training.ekaterina_sycheva.clean_code.aircompany.models.ClassificationLevel;
import com.epam.training.ekaterina_sycheva.clean_code.aircompany.models.ExperimentalTypes;
import com.epam.training.ekaterina_sycheva.clean_code.aircompany.models.MilitaryType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.epam.training.ekaterina_sycheva.clean_code.aircompany.Planes.MilitaryPlane;
import com.epam.training.ekaterina_sycheva.clean_code.aircompany.Planes.PassengerPlane;
import com.epam.training.ekaterina_sycheva.clean_code.aircompany.Planes.Plane;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);
    private static List<Plane> planesSortedByMaxLoadCapacity = Arrays.asList(
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT)
    );


    @Test
    public void testGetTransportMilitaryPlanes() {
        Airport airport = new Airport(planes);
        Stream <MilitaryPlane> militaryPlanesStream = airport.getMilitaryPlanesSameType(MilitaryType.TRANSPORT).stream();
        Assertions.assertTrue(militaryPlanesStream.allMatch(plane -> plane.getType() == MilitaryType.TRANSPORT));
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        Airport airport = new Airport(planes);
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assertions.assertEquals(planeWithMaxPassengerCapacity, expectedPlaneWithMaxPassengersCapacity);
    }

    @Test
    public void testSortByMaxLoadCapacity() {
        Airport airport = new Airport(planes);
        airport.sortBy(Plane::getMaxLoadCapacity);
        List<? extends Plane> planesSortedByMaxLoadCapacityActual = airport.getPlanes();
        Assertions.assertEquals(planesSortedByMaxLoadCapacity, planesSortedByMaxLoadCapacityActual);
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        Airport airport = new Airport(planes);
        Assertions.assertTrue(airport.getMilitaryPlanesSameType(MilitaryType.BOMBER).size() != 0);
    }

    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified(){
        Airport airport = new Airport(planes);
        List<ExperimentalPlane> experimentalPlanes = airport.getListOfPlanesSameType(ExperimentalPlane.class);
        Assertions.assertTrue(experimentalPlanes.stream().anyMatch(plane -> plane.getClassificationLevel() != ClassificationLevel.UNCLASSIFIED));
    }
}
