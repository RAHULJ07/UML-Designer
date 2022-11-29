package View;

import Controller.RectangleController;
import Model.Storage;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.Serializable;

public class Rectangle extends JPanel {

   int xPos, yPos, preX, preY;
   boolean pressOut = false;
   String className;
   DrawPanel drawPanel;

   RectangleController rectangleController;

   public Rectangle(int x, int y, String className, DrawPanel drawPanel) {
      rectangleController = new RectangleController(this);
      this.className = className;
      addMouseListener(rectangleController);
      this.setLayout(new GridBagLayout());
      this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      this.xPos = x;
      this.yPos = y;
      this.setLocation(x, y);
      this.setSize(80, 50);
      JLabel label = new JLabel(className);
      this.add(label);
      this.setBackground(Color.YELLOW);
      this.drawPanel = drawPanel;
   }

   public int getPreX() {
      return preX;
   }

   public void setPreX(int preX) {
      this.preX = preX;
   }

   public int getPreY() {
      return preY;
   }

   public void setPreY(int preY) {
      this.preY = preY;
   }

   public boolean isPressOut() {
      return pressOut;
   }

   public void setPressOut(boolean pressOut) {
      this.pressOut = pressOut;
   }

   public String getClassName() {
      return className;
   }

   public void setClassName(String className) {
      this.className = className;
   }

   public DrawPanel getDrawPanel() {
      return drawPanel;
   }

   public void setDrawPanel(DrawPanel drawPanel) {
      this.drawPanel = drawPanel;
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