package Controller;

import Model.*;
import View.*;
import javax.swing.*;
import javax.tools.FileObject;
import java.io.*;
import java.util.Scanner;

public class LoadOperationHandler implements IHandler {

    @Override
    public void handleRequest(RequestType type) {
        if(type == RequestType.Load) {
            String fileName;
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                fileName = fileChooser.getSelectedFile().getAbsolutePath();
                Storage storage = Storage.getInstance();
                File obj = new File(fileName);
                Scanner scanner = null;
                try {
                    scanner = new Scanner(obj);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.startsWith("Rectangles")) {
                        while (scanner.hasNextLine()) {
                            line = scanner.nextLine();
                            String[] str = line.split(",", 3);
                            Rectangle rect = new Rectangle(Integer.parseInt(str[1]), Integer.parseInt(str[2]), str[0], new DrawPanel());
                            Storage.getInstance().addRectangle(rect);
                        }
                    } else if (line.startsWith("LineCoordinates")) {
                        while (scanner.hasNextLine()) {
                            line = scanner.nextLine();
                            String[] str = line.split(",", 5);
                            LineCoordinates lineCoordinate = new LineCoordinates(Integer.parseInt(str[0]), Integer.parseInt(str[1]),
                                    Integer.parseInt(str[2]), Integer.parseInt(str[3]),
                                    str[4]);
                            Storage.getInstance().addCoordinates(lineCoordinate);
                        }
                    }
                }
            }
        }
    }
}
