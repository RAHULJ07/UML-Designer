import javax.swing.*;
import java.awt.Color;

public class StatusBar extends JLabel {
  
	protected static StatusBar instance = null;
	
	private StatusBar(){
	  super();
	  super.setBorder(BorderFactory.createLineBorder(Color.black));
	  setText("Status:");
	  }
	  
	public static StatusBar getStatus() {
		if (instance == null) {
			instance = new StatusBar();
		}
		return instance;
	}
	  
	public void setStatus(String message){
	setText(" "+message);
	}
}
