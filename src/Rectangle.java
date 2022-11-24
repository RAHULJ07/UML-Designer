import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Rectangle extends JPanel implements MouseInputListener {

   int xPos, yPos;
   String className = "";

   public Rectangle(int x, int y, String className) {
      this.className = className;
      addMouseListener(this);
      this.setLayout(new GridBagLayout());
      this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      this.xPos = x;
      this.yPos = y;
      this.setLocation(x, y);
      this.setSize(200, 60);
      JLabel label = new JLabel(className);
      this.add(label);
      this.setBackground(Color.YELLOW);
   }

   @Override
   public void mouseClicked(MouseEvent e) {
      System.out.println("Clicked on a box");
      clickEmulator();
   }

   public void clickEmulator() {
      DrawPanel.getDrawPanel().boxClickTracker(this);
   }

   @Override
   public void mousePressed(MouseEvent e) {
      
   }

   @Override
   public void mouseReleased(MouseEvent e) {
      
   }

   @Override
   public void mouseEntered(MouseEvent e) {
      
   }

   @Override
   public void mouseExited(MouseEvent e) {
      
   }

   @Override
   public void mouseDragged(MouseEvent e) {
      
   }

   @Override
   public void mouseMoved(MouseEvent e) {
      
   }

}