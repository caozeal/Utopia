package com.caozeal.temp;

import java.util.ArrayList;
import java.util.List;

public class Maze {

    private int row;

    private int column;

    private List<Point> roadPoints = new ArrayList<>();

    public Maze() {
    }

    public Maze(int row, int column, List<Point> roadPoints) {
        this.row = row;
        this.column = column;
        this.roadPoints = roadPoints;
    }

    public void init(int roadRaw, int roadColumn){
        if(roadRaw <= 0 || roadColumn <= 0){
            throw new RuntimeException("Number out of range .");
        }
        this.row = 2 * roadRaw + 1;
        this.column = 2 * roadColumn + 1;
        for(int i=0; i<roadRaw; i++){
            for(int j=0; j<roadColumn; j++){
                roadPoints.add(new Point(2*i+1, 2*j+1));
            }
        }
    }

    public static Point transFromRoadPoint(Point roadPoint){
        return new Point(2*roadPoint.getX()+1, 2*roadPoint.getY()+1);
    }

    /**
     * 检查一个点是否在范围内
     * @param p
     * @return
     */
    public boolean checkBorder(Point p){
        if(p.getX() >= 0 && p.getY() >= 0 && p.getX() < this.row && p.getY() < this.column){
            return true;
        }
        return false;
    }

    public void render(){
        for(int i=0; i<this.row; i++){
            for(int j=0; j<this.column; j++){
                if(roadPoints.contains(new Point(i ,j))){
                    System.out.print("[R] ");
                }else {
                    System.out.print("[W] ");
                }
            }
            System.out.println("");
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public List<Point> getRoadPoints() {
        return roadPoints;
    }

    public void setRoadPoints(List<Point> roadPoints) {
        this.roadPoints = roadPoints;
    }
}
