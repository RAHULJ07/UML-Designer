import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends JPanel implements Observable, MouseListener, MouseMotionListener {
    
    private static DrawPanel drawPanel;
    private static ArrayList<Rectangle> rectangles;
    private static ArrayList<Rectangle> rectanglesClicked;
    private static List<Observer> observerList;

    private DrawPanel(){
    }

    public static DrawPanel getDrawPanel() {
        if (drawPanel == null) {
            drawPanel = new DrawPanel();
            rectangles = new ArrayList<>();
            rectanglesClicked = new ArrayList<>();
            observerList = new ArrayList<Observer>();
        }
        drawPanel.setLayout(null);
        drawPanel.addMouseListener(drawPanel);
        return drawPanel;
    }

    public void boxClickTracker(Rectangle rectangle) {
        rectanglesClicked.add(rectangle);
        if (rectanglesClicked.size() == 2) {
            System.out.println("Invoke an arrow function");
            rectanglesClicked.clear();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        rectanglesClicked.clear();
        int x = e.getX();
        int y = e.getY();
        String className = JOptionPane.showInputDialog("Enter class name");
        if ((className != null)) {
            if (className.length() == 0) {
                className = "Enter class name";
            }
            Rectangle newRectangle = new Rectangle(x, y, className);
            rectangles.add(newRectangle);
            drawPanel.add(newRectangle);
            updateObserver(className);
            drawPanel.revalidate();
            drawPanel.repaint();
        }
        
    }

    @Override
    public void addObserver(Observer o){
        observerList.add(o);
    }

    @Override
    public void updateObserver(String className){
        for (Observer observer : observerList) {
            observer.update(className);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}