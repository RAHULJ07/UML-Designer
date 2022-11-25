import javax.swing.*;
import java.awt.Color;

public class StatusBar extends JLabel {
  public StatusBar(){
    super();
    super.setBorder(BorderFactory.createLineBorder(Color.black));
    setMessage("Status:");
  }
  
  public void setStatus(String message){
    setText(" "+message);
  }
}
