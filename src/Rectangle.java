import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Rectangle extends JPanel implements MouseInputListener {

   int xPos, yPos, preX, preY;
   boolean pressOut = false;
   String className;
   DrawPanel drawPanel;
   public Rectangle(int x, int y, String className, DrawPanel drawPanel) {
      this.className = className;
      addMouseListener(this);
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

   public void moved(int x, int y){
      for( LineCoordinates coord : drawPanel.getCoordinates()){
         if((coord.getStartX()== xPos) && (coord.getStartY()== yPos))
         {
            coord.setStartX(x);
            coord.setStartY(y);
         }
         else if((coord.getEndX()== xPos) && (coord.getEndY()== yPos)){
            coord.setEndX(x);
            coord.setEndY(y);
         }
      }
      this.xPos = x;
      this.yPos = y;
      this.setLocation(x, y);
   }

   @Override
   public void mouseClicked(MouseEvent e) {
      System.out.println("Clicked on a box");
      clickEmulator();
   }

   public void clickEmulator() {
      drawPanel.boxClickTracker(this);
   }

   @Override
   public void mousePressed(MouseEvent e) {
      preX = xPos- e.getX();
      preY = yPos- e.getY();
         moved(preX + e.getX(), preY+ e.getY());
         repaint();
         drawPanel.repaint();
   }

   @Override
   public void mouseReleased(MouseEvent e) {
      moved(preX + e.getX(), preY+ e.getY());
      repaint();
      drawPanel.repaint();
   }

   @Override
   public void mouseEntered(MouseEvent e) {
      
   }

   @Override
   public void mouseExited(MouseEvent e) {
      
   }

   @Override
   public void mouseDragged(MouseEvent e) {
      if(!pressOut){
         moved(preX + e.getX(), preY+ e.getY());
         repaint();
         drawPanel.repaint();
      }
   }

   @Override
   public void mouseMoved(MouseEvent e) {
      
   }

}