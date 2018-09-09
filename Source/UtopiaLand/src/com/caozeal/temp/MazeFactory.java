package com.caozeal.temp;

public class MazeFactory {

    public static Maze create(String command) {
        Maze maze = new Maze();
        String[] s = command.split("\n");
        String[] shape = s[0].split(" ");
        int roadRaw = Integer.parseInt(shape[0]);
        int roadColumn = Integer.parseInt(shape[1]);
        maze.init(roadRaw, roadColumn);
        String[] cells = s[1].split(";");
        for (String cell : cells) {
            String[] points = cell.split(" ");
            String[] coord1 = points[0].split(",");
            String[] coord2 = points[1].split(",");
            Point point1 = Maze.transFromRoadPoint(new Point(Integer.parseInt(coord1[0]), Integer.parseInt(coord1[1])));
            Point point2 = Maze.transFromRoadPoint(new Point(Integer.parseInt(coord2[0]), Integer.parseInt(coord2[1])));
            if(!maze.checkBorder(point1) || !maze.checkBorder(point2)){
                throw new RuntimeException("Number out of range .");
            }
            Point point = getMidPoint(point1, point2);
            if(!maze.getRoadPoints().contains(point)){
                maze.getRoadPoints().add(point);
            }
        }
        return maze;
    }

    /**
     * 计算Maze中两点中间的点
     * @param p1
     * @param p2
     * @return
     */
    private static Point getMidPoint(Point p1, Point p2) {
        if (!checkAdj(p1, p2)){
            throw new RuntimeException("Maze format error.");
        }
        return new Point((p2.getX() + p1.getX()) / 2, (p2.getY() + p1.getY()) / 2);
    }

    /**
     * 检查Maze中的两个点是否相邻
     * @return
     */
    private static boolean checkAdj(Point p1, Point p2){
        if( (Math.abs(p2.getX() - p1.getX()) == 0 && Math.abs(p2.getY() - p1.getY()) == 2)
                || (Math.abs(p2.getX() - p1.getX()) == 2 && Math.abs(p2.getY() - p1.getY()) == 0)){
            return true;
        }
        return false;
    }
}
