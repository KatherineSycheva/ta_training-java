package com.epam.training.ekaterina_sycheva.clean_code.aircompany;

import com.epam.training.ekaterina_sycheva.clean_code.aircompany.models.MilitaryType;
import com.epam.training.ekaterina_sycheva.clean_code.aircompany.Planes.MilitaryPlane;
import com.epam.training.ekaterina_sycheva.clean_code.aircompany.Planes.PassengerPlane;
import com.epam.training.ekaterina_sycheva.clean_code.aircompany.Planes.Plane;

import java.util.*;
import java.util.function.Function;


// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private List<? extends Plane> planes;

    public <T> List<T> getListOfPlanesSameType(Class clazz) {
        List<? extends Plane> listOfPlanes = this.planes;
        List<T> listOfPlanesSameType = new ArrayList<T>();
        for (Plane plane : listOfPlanes) {
            if (plane.getClass() == clazz) listOfPlanesSameType.add((T) plane);
        }
        return listOfPlanesSameType;
    }

/*    public List<PassengerPlane> getPassengerPlanes() {
        List<? extends Plane> listOfPlanes = this.planes;
        List<PassengerPlane> listOfPassengersPlanes = new ArrayList<>();
        for (Plane plane : listOfPlanes) {
            if (plane instanceof PassengerPlane) listOfPassengersPlanes.add((PassengerPlane) plane);
        }
        return listOfPassengersPlanes;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) militaryPlanes.add((MilitaryPlane) plane);
        }
        return militaryPlanes;
    }*/


    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getListOfPlanesSameType(PassengerPlane.class);
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (int i = 0; i < passengerPlanes.size(); i++) {
            if (passengerPlanes.get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlanes.get(i);
            }
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getMilitaryPlanesSameType(MilitaryType militaryType) {
        List<MilitaryPlane> militaryPlanesSameType = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getListOfPlanesSameType(MilitaryPlane.class);
        for (int i = 0; i < militaryPlanes.size(); i++) {
            if (militaryPlanes.get(i).getType() == militaryType) militaryPlanesSameType.add(militaryPlanes.get(i));
        }
        return militaryPlanesSameType;
    }

/*
    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getListOfPlanesSameType(MilitaryPlane.class);
        //List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (int i = 0; i < militaryPlanes.size(); i++) {
            if (militaryPlanes.get(i).getType() == MilitaryType.TRANSPORT) transportMilitaryPlanes.add(militaryPlanes.get(i));
        }
        return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getListOfPlanesSameType(MilitaryPlane.class);
        for (int i = 0; i < militaryPlanes.size(); i++) {
            MilitaryPlane militaryPlane = militaryPlanes.get(i);
            if (militaryPlanes.get(i).getType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(militaryPlane);
            }
        }
        return bomberMilitaryPlanes;
    }
*/

    public Airport sortBy(Function<Plane, Integer> functionForCompare) {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane plane, Plane planeCompared) {
                return functionForCompare.apply(plane) - functionForCompare.apply(planeCompared);
            }
        });
        return this;
    }

/*
    public Airport sortByMaxDistance() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane plane, Plane planeCompared) {
                return plane.GetMaxFlightDistance() - planeCompared.GetMaxFlightDistance();
            }
        });
        return this;
    }
*/


 /*   public Airport sortByMaxSpeed() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane plane, Plane planeCompared) {
                return plane.getMaxSpeed() - planeCompared.getMaxSpeed();
            }
        });
        return this;
    }*/

/*    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane plane, Plane planeCompared) {
                return plane.getMinLoadCapacity() - planeCompared.getMinLoadCapacity();
            }
        });
        return this;
    }*/

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    private void printPlanesList(Collection<? extends Plane> collection) {
        Iterator<? extends Plane> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

}
