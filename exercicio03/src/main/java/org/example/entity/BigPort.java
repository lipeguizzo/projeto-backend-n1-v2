package org.example.entity;

import java.util.ArrayList;

public class BigPort extends PortBase{
    public BigPort() {
    }

    public BigPort(String name, ArrayList<Boat> mooredBoats) {
        super(name, mooredBoats);
    }

    @Override
    public void dockBoat(Boat boat){
        if( boat.getSize() > 10 ){
           super.getMooredBoats().add(boat);
            System.out.println(boat.getName() + " atracado no " + this.getName());
        }
    }
}
