package com.packtpublishing.tddjava.ch04ship;

import org.testng.annotations.*;

import static org.testng.Assert.*;

@Test
public class ShipSpec {

    int x = 12;
    int y = 13;
    Point point;
    Point max;
    Location location;
    Ship ship;
    Planet planet;

    @BeforeMethod
    public void before(){
        point = new Point(x, y);
        location = new Location(point, Direction.NORTH);
        max = new Point(100, 100);
        planet = new Planet(max);
        ship = new Ship(location, planet);
    }

    public void whenInstantiatedThenLocationIsSet(){
        assertEquals(ship.getLocation(), location);
    }

    public void whenMoveForwardThenForward(){
        Location location1 = location.copy();
        location1.forward();
        ship.moveForward();
        assertEquals(location1, ship.getLocation());
    }

    public void whenMoveBackwardThenForward(){
        Location location1 = location.copy();
        location1.backward();
        ship.moveBackward();
        assertEquals(location1, ship.getLocation());
    }

    public void whenTurnLeftThenLeft(){
        Location location1 = location.copy();
        location1.turnLeft();
        ship.turnLeft();
        assertEquals(location1, ship.getLocation());
    }

    public void whenTurnRightThenRight(){
        Location location1 = location.copy();
        location1.turnRight();
        ship.turnRight();
        assertEquals(location1, ship.getLocation());
    }

    public void whenReceiveCommandsThenAllAreExecuted(){
        Location location1 = location.copy();
        location1.forward();
        location1.backward();
        location1.turnRight();
        location1.turnLeft();
        ship.receiveCommand("fbrl");
        assertEquals(location1, ship.getLocation());
    }

    public void whenInstantiatedThenPlanetIsStored(){
        //TODO caozeal耦合度太高了
        assertEquals(ship.getPlanet(), planet);
    }
}
