import java.util.ArrayList;
import java.util.List;

public class City {

    private List<Road>  roads  = new ArrayList<>();
    private List<Place> places = new ArrayList<>();


    public City() {

    }

    public City(List<Road> roads, List<Place> places) {
        this.roads = roads;
        this.places = places;
    }

    public List<Road> getRoads() {
        return roads;
    }

    public void setRoads(List<Road> roads) {
        this.roads = roads;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    interface Type {

    }

    static class Road extends CityObject {

        public Road(String name, Type type) {
            super(name, type);
        }

        enum RoadType implements Type {
            Street, Avenue,
        }

    }

    static class Place extends CityObject {

        public Place(String name, Type type) {
            super(name, type);
        }

        enum PlaceType implements Type {
            Square, Park, Area, Plaza
        }

    }

    static abstract class CityObject {
        private String name;
        private Type   type;

        public CityObject(String name, Type type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }
    }

}
