package org.example;

import org.example.entity.BigPort;
import org.example.entity.Boat;
import org.example.entity.SmallPort;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SmallPort smallPort = new SmallPort();
        smallPort.setName("Porto Pequeno");

        BigPort bigPort = new BigPort();
        bigPort.setName("Porto Grande");

        List<Boat> boatsList = List.of(
                new Boat("Barco 1", 2),
                new Boat("Barco 2", 5),
                new Boat("Barco 3", 7),
                new Boat("Barco 4", 12),
                new Boat("Barco 5", 20)
        );

        for ( Boat boat : boatsList ){
            smallPort.dockBoat(boat);
            bigPort.dockBoat(boat);
        }
    }
}