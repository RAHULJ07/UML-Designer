package Controller;

import View.AppPanel;
import View.MenuView;

public class MainController {

    protected static MainController instance;

    private MenuController menuController;
    private AppPanelController appPanelController;

    private MainController(){
        menuController = new MenuController(new MenuView());
        appPanelController = new AppPanelController(new AppPanel());
    }

    public static MainController getInstance(){
        if(instance == null)
            instance = new MainController();
        return instance;
    }

    public MenuController getMenuController() {
        return menuController;
    }

    public AppPanelController getAppPanelController() {
        return appPanelController;
    }
}
