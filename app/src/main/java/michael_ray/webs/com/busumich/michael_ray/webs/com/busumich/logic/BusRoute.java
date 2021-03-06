package michael_ray.webs.com.busumich.michael_ray.webs.com.busumich.logic;

import java.util.ArrayList;

/**
 * BusRoute.java
 * Stores information regarding each bus route
 * @author Michael Ray
 * @version 1
 * @since 10-09-14
 */
public class BusRoute {
    private int id;
    private String name, short_name, description, schedule_url, color;
    private boolean active;
    private double[] path;
    private int[] stops;
    private ArrayList<Bus> buses;

    public BusRoute(int id, String name, String short_name, String description, String color, double[] path, String schedule_url, boolean active, int[] stops) {
        this.id = id;
        this.name = name;
        this.short_name = short_name;
        this.description = description;
        this.color = color;
        this.path = path;
        this.active = active;
        this.stops = stops;
        this.schedule_url = schedule_url;
        this.buses = new ArrayList<Bus>();
    }

    public int getId() { return this.id; }
    public String getColor() { return this.color; }
    public String getName() { return this.name; }
    public String getShortName() { return this.short_name; }
    public String getDescription() { return this.description; }
    public String getScheduleURL() { return this.schedule_url; }
    public boolean getActive() { return this.active; }
    public double[] getPath() { return this.path; }
    public int[] getStops() { return this.stops; }

    public void setId(int id) { this.id = id; }
    public void setColor(String color) { this.color = color; }
    public void setName(String name) { this.name = name; }
    public void setShortName(String short_name) { this.short_name = short_name; }
    public void setDescription(String description) { this.description = description; }
    public void setScheduleURL(String url) { this.schedule_url = url; }
    public void setPath(double[] path) { this.path = path; }
    public void setStops(int[] stops) { this.stops = stops; }

    public ArrayList<Bus> getBuses() { return this.buses; }
    public void setBuses(ArrayList<Bus> buses) { this.buses = buses; }
    private boolean isBusInRoute(Bus bus) {
        for (int i=0; i<buses.size(); i++) {
            if (bus.getId() == buses.get(i).getId())
                return true;
        }
        return false;
    }
    public void addBus(Bus bus, boolean overwrite) {
        if (isBusInRoute(bus) && overwrite) {
            for (int i=0; i<buses.size(); i++)
                if (bus.getId() == buses.get(i).getId()) {
                    buses.remove(i);
                    buses.add(i,bus);
                }
        }
    }

}
