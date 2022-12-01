package Controller;

import View.Rectangle;
import Model.*;
import javax.swing.*;
import java.beans.XMLEncoder;
import java.io.*;

public class SaveOperationHandler implements IHandler {

    protected IHandler successor;

    public void setSuccessor(IHandler successor) {
        this.successor = successor;
    }

    @Override
    public void handleRequest(RequestType type) {
        if(type == RequestType.Save){
            String fileName;
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION) {
                fileName = fileChooser.getSelectedFile().getAbsolutePath();
                Storage storage = Storage.getInstance();
                try {
                    FileWriter writer = new FileWriter(fileName);
                    String str;
                    for (RectangleModel rectangle : storage.getRectangles()) {
                        str = rectangle.toString();
                        writer.write(str + System.lineSeparator());
                    }

                    for (LineCoordinates coordinate : storage.getCoordinates()) {
                        str = coordinate.toString();
                        writer.write(str + System.lineSeparator());
                    }

                    writer.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }else if(successor != null){
            successor.handleRequest(type);
        }

    }
}
