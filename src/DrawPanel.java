import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends JPanel implements Observable, MouseListener, MouseMotionListener {

    private ArrayList<Rectangle> rectangles;
    private ArrayList<LineCoordinates> coordinates;
    private ArrayList<Rectangle> rectanglesClicked;
    private List<Observer> observerList;
    private String aType;

    public DrawPanel(){
        rectangles = new ArrayList<>();
        rectanglesClicked = new ArrayList<>();
        observerList = new ArrayList<>();
        coordinates = new ArrayList<>();
        setLayout(null);
        addMouseListener(this);
    }

    public void boxClickTracker(Rectangle rectangle) {
        rectanglesClicked.add(rectangle);
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Line line;
        InheritanceArrow inheritanceArrow;
        CompositionArrow compositionArrow;
        AggregationArrow aggregationArrow;

        LineCoordinates coordinate;
        if (rectanglesClicked.size() == 2) {
            coordinate = new LineCoordinates(rectanglesClicked.get(0).getX(),rectanglesClicked.get(0).getY(),
                    rectanglesClicked.get(1).getX(), rectanglesClicked.get(1).getY(), ArrowType.getArrowType());
            coordinates.add(coordinate);
            rectanglesClicked.clear();
        }
        if(coordinates.size()>0){
            for(LineCoordinates coord : coordinates){
                aType= coord.getArrowType();
                line = new Line(coord);
                if(aType.equals("Composition") ){
                    compositionArrow = new CompositionArrow(coord);
                    compositionArrow.add(line);
                    compositionArrow.draw(g2);

                }
                else if (aType.equals("Aggregation")){
                    aggregationArrow = new AggregationArrow(coord);
                    aggregationArrow.add(line);
                    aggregationArrow.draw(g2);

                }
                else if( aType.equals("Inheritance")){
                    inheritanceArrow = new InheritanceArrow(coord);
                    inheritanceArrow.add(line);
                    inheritanceArrow.draw(g2);

                }
            }
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
            Rectangle newRectangle = new Rectangle(x, y, className, this);
            rectangles.add(newRectangle);
            add(newRectangle);
            updateObserver(className);
            repaint();
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