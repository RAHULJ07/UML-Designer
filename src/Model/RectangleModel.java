package Model;

import View.DrawPanel;

public class RectangleModel {

    int xPos, yPos;

    String className;

    public RectangleModel(int xPos, int yPos, String className){
        this.xPos = xPos;
        this.yPos = yPos;
        this.className = className;
    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    @Override
    public String toString(){
        String str;
        str = className + "," + xPos + "," + yPos;
        return str;
    }
}
