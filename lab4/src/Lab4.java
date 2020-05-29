import mobile.Model;

import java.util.Arrays;

public class Lab4 {


    public static void main(String[] args) {
        City city = new City();
        city.setPlaces(Arrays.asList(new City.Place("Какой-то парк", City.Place.PlaceType.Park),
                new City.Place("Какая-то площадь", City.Place.PlaceType.Square)));
        city.setRoads(Arrays.asList(new City.Road("Какая-то улица", City.Road.RoadType.Street),
                new City.Road("Какой-то переулок", City.Road.RoadType.Avenue)));


        new Model("PHONE-1", "L", 100);
        new Model("PHONE-2", "XL", 100);
        new Model("PHONE-1", "LOPATA3000", 100);


    }

}
