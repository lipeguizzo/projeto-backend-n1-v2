package org.example.entity;

import java.util.ArrayList;

public class SmallPort extends PortBase{
    public SmallPort() {
    }

    public SmallPort(String name, ArrayList<Boat> mooredBoats) {
        super(name, mooredBoats);
    }

    @Override
    public void dockBoat(Boat boat){
        if( boat.getSize() <= 10 ){
           super.getMooredBoats().add(boat);
           System.out.println(boat.getName() + " atracado no " + this.getName());
        }
    }
}
