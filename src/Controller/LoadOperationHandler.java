package Controller;

import Model.*;
import View.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

/**
 * LoadOperationHandler performs action on click of Load operation.
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumur
 */
public class LoadOperationHandler extends CloseOperation  implements IHandlerAction {

    /**
     * handle request on load operation
     * @param action
     */
    @Override
    public void handleRequest(String action) {

        if(action.equals("Load")) {
            String fileName;
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                super.close();
                fileName = fileChooser.getSelectedFile().getAbsolutePath();
                Storage storage = Storage.getInstance();
                File obj = new File(fileName);
                Scanner scanner = null;
                try {
                    scanner = new Scanner(obj);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }

                convertToObject(scanner);
                storage.updateObserver();
            }
        }
    }

    /**
     * convert file object to instance and fire UI
     * @param scanner
     */
    private void convertToObject(Scanner scanner) {

        DrawPanel drawPanel = MainController.getInstance().getAppPanelController().getDrawPanelController().getDrawPanel();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.startsWith("Rectangles")){
                String[] str = line.split(",", 4);
                RectangleModel rectangleModel = new RectangleModel(Integer.parseInt(str[2]), Integer.parseInt(str[3]), str[1]);
                Rectangle rect = new Rectangle(rectangleModel);
                RectangleController rectangleController = new RectangleController(rect, rectangleModel, drawPanel);
                Storage.getInstance().addRectangle(rectangleModel);
                drawPanel.add(rect);
                drawPanel.repaint();
            }
            else if (line.startsWith("LineCoordinates")) {
                String[] str = line.split(",", 6);
                LineCoordinates lineCoordinate = new LineCoordinates(Integer.parseInt(str[2]), Integer.parseInt(str[3]),
                            Integer.parseInt(str[4]), Integer.parseInt(str[5]),
                            str[1]);
                Storage.getInstance().addCoordinates(lineCoordinate);
                drawPanel.repaint();
            }
        }
    }
}
