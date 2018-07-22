package com.packtpublishing.tddjava.ch04ship;

public class Ship {

    private Location location;
    private Planet planet;

    public Ship(Location location, Planet planet) {
        this.location = location;
        this.planet = planet;
    }

    public Location getLocation() {
        return location;
    }

    public void moveForward() {
        location.forward();
    }

    public void moveBackward(){
        location.backward();
    }


    public void turnLeft() {
        location.turnLeft();
    }

    public void turnRight() {
        location.turnRight();
    }

    public void receiveCommand(String commands) {
        for(char command : commands.toCharArray()){
            switch (command){
                case 'f':
                    moveForward();
                    break;
                case 'b':
                    moveBackward();
                    break;
                case 'r':
                    turnRight();
                    break;
                case 'l':
                    turnLeft();
                    break;
            }
        }

    }

    public Planet getPlanet() {
        return planet;
    }
}
