package de.vw.f73.kitereisen.location;

import java.util.ArrayList;
import java.util.List;

public class Location {

    private String name;
    private String url;
    private List<Integer> windyDays = new ArrayList<>();
    private List<Integer> rainyDays = new ArrayList<>();
    private List<Integer> airTemp = new ArrayList<>();
    private List<Integer> waterTemp = new ArrayList<>();

    public Location(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Integer> getWindyDays() {
        return this.windyDays;
    }

    public void setWindyDays(List<Integer> windyDays) {
        this.windyDays = windyDays;
    }

    public List<Integer> getRainyDays() {
        return this.rainyDays;
    }

    public void setRainyDays(List<Integer> rainyDays) {
        this.rainyDays = rainyDays;
    }

    public List<Integer> getAirTemp() {
        return this.airTemp;
    }

    public void setAirTemp(List<Integer> airTemp) {
        this.airTemp = airTemp;
    }

    public List<Integer> getWaterTemp() {
        return this.waterTemp;
    }

    public void setWaterTemp(List<Integer> waterTemp) {
        this.waterTemp = waterTemp;
    }

}
