package com.caozeal.someTry;

import java.util.ArrayList;
import java.util.List;

public class Wave {

    private int[] wavePoints;
    private List<Point> allPoints = new ArrayList<>();
    private List<Point> crestPoints = new ArrayList<>();
    private List<Point> throughPoints = new ArrayList<>();

    public Wave(int[] wavePoints) {
        this.wavePoints = wavePoints;
        init();
    }

    private void init() {
        initAllPoints();
        for(int i=1; i<allPoints.size()-1; i++){
            if(allPoints.get(i).getY() > allPoints.get(i-1).getY() && allPoints.get(i).getY() > allPoints.get(i+1).getY()){
                crestPoints.add(allPoints.get(i));
            }
            if( allPoints.get(i).getY() < allPoints.get(i-1).getY() && allPoints.get(i).getY() < allPoints.get(i+1).getY() ){
                throughPoints.add(allPoints.get(i));
            }
        }
    }

    private void initAllPoints() {
        for(int i=0; i<this.wavePoints.length; i++) {
            Point p = new Point(i, wavePoints[i]);
            if( i !=0 && wavePoints[i] == wavePoints[i-1]){
                continue;
            }
            allPoints.add(p);
        }
    }

    public List<Point> getCrestPoints() {
        return crestPoints;
    }

    public List<Point> getThroughPoints() {
        return throughPoints;
    }
}
