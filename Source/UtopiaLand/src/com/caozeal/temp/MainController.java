package com.caozeal.temp;

public class MainController {

    public static void main(String[] args) {
        try{
            String command = "4 4\n" +
                    "0,1 0,2;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1";

            Maze maze = MazeFactory.create(command);
            maze.render();
        }catch (NumberFormatException e){
            System.out.println("Invalid number format .");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Incorrect command format .");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
