package View;

import Model.RectangleModel;

import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;

public class Rectangle extends JPanel {
   public String rectClassName;

   public Rectangle(RectangleModel model) {
      this.setLayout(new GridBagLayout());
      this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      this.setLocation(model.getxPos(), model.getyPos());
      this.setSize(80, 50);
      JLabel label = new JLabel(model.getClassName());
      this.add(label);
      this.setBackground(Color.YELLOW);

      this.rectClassName = model.getClassName();
   }


}