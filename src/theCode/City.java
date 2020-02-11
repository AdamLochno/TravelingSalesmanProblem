package theCode;

public class City {
    private static final double EARTH_EQUATORIAL_RADIUS = 6378.137D;
    private static final double CONVERT_DEGREES_TO_RADIANS = Math.PI / 180D;
    private static final double CONVERT_KM_TO_MILES = 0.62137;

    private String name;
    private double latitude;
    private double longtitude;

    public City(String name, double latitude, double longtitude) {
        this.name = name;
        this.latitude = latitude * CONVERT_DEGREES_TO_RADIANS;
        this.longtitude = longtitude * CONVERT_DEGREES_TO_RADIANS;
    }

    public double getLongtitude() {
        return this.longtitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return getName();
    }

    public double measureDistance(City city) {
        double deltaLongitude = (city.getLongtitude() - this.getLongtitude());
        double deltaLatitude = (city.getLatitude() - this.getLatitude());
        double a = Math.pow(Math.sin(deltaLatitude / 2D), 2D) +
                Math.cos(this.getLatitude()) * Math.cos(city.getLatitude()) * Math.pow(Math.sin(deltaLongitude / 2D), 2D);
        return CONVERT_KM_TO_MILES * EARTH_EQUATORIAL_RADIUS * 2D * Math.atan2(Math.sqrt(a), Math.sqrt(1D - a));
    }

}
