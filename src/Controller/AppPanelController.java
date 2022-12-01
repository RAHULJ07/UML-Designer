package Controller;

import View.AppPanel;

public class AppPanelController {

    DrawPanelController drawPanelController;
    private AppPanel appPanel;

    public AppPanelController(AppPanel appPanel){
        this.appPanel = appPanel;
        drawPanelController = new DrawPanelController(appPanel.getDrawPanel());
    }

    public AppPanel getAppPanel() {
        return appPanel;
    }

    public DrawPanelController getDrawPanelController() {
        return drawPanelController;
    }
}
