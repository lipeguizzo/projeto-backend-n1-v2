package org.example.entity;

import java.util.ArrayList;

public class PortBase {
    private String name;
    private ArrayList<Boat> mooredBoats = new ArrayList<>();

    public PortBase() {
    }

    public PortBase(String name, ArrayList<Boat> mooredBoats) {
        this.name = name;
        this.mooredBoats = mooredBoats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Boat> getMooredBoats() {
        return mooredBoats;
    }

    public void setMooredBoats(ArrayList<Boat> mooredBoats) {
        this.mooredBoats = mooredBoats;
    }

    public void dockBoat(Boat boat){
        this.mooredBoats.add(boat);
    }

    public void undockBoat(Boat boat){
        this.mooredBoats.remove(boat);
    }


}
