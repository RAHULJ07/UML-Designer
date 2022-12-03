package Controller;

import View.AppPanel;
/**
 * AppPanelController initializes the application panel and DrawPanelController
 * @author Haritej Lakshmi Narayan, Chris Lazar, Sunayana Gupta, Rahul Kumar, Cameron Woehler, Bhavana Priya Kanumuri
 */
public class AppPanelController {
    DrawPanelController drawPanelController;
    private AppPanel appPanel;
    /**
     * AppPanelController gets and initializes appPanel and DrawPanelController
     * @param appPanel
     */
    public AppPanelController(AppPanel appPanel){
        this.appPanel = appPanel;
        drawPanelController = new DrawPanelController(appPanel.getDrawPanel());
    }
    /**
     * Getter method that returns the application panel
     * @return returns the application panel which contains DrawPanel and TextPanel
     */
    public AppPanel getAppPanel() {
        return appPanel;
    }
    /**
     * Getter method that returns the DrawPanelController
     * @return returns the DrawPanelController which controls the creation of the draw panel
     */
    public DrawPanelController getDrawPanelController() {
        return drawPanelController;
    }
}
