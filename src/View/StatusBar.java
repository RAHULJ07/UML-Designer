package View;

import javax.swing.*;
import java.awt.Color;

/**
 * StatusBar is a singleton class.It also inherits from JLabel.
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumuri
 */
public class StatusBar extends JLabel {
  
	protected static StatusBar instance = null;
	
	private StatusBar(){
	  super();
	  super.setBorder(BorderFactory.createLineBorder(Color.black));
	  setText("Status:");
	}

	/**
	 * gets the instance of the status bar if already present or creates a new instance
	 * @return instance of the status bar
	 */
	public static StatusBar getStatus() {
		if (instance == null) {
			instance = new StatusBar();
		}
		return instance;
	}

	/**
	 * setter method for setting the message in the status bar
	 * @param message string which shows the required message
	 */
	public void setStatus(String message){
	setText(" "+message);
	}
}
