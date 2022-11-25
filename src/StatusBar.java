public class StatusBar extends JLabel {
  public StatusBar(){
  setMessage("Status:");
  }
  
  public void setStatus(String message){
    setText(" "+message);
  }
}
