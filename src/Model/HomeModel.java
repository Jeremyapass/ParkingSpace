/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Event.HomeListener;
import Event.LoginListener;

/**
 *
 * @author MSI KATANA
 */
public class HomeModel {
    private HomeListener HomeListener;

    public HomeListener getHomeListener() {
        return HomeListener;
    }
    public void setHomeListener(HomeListener HomeListener) {
        this.HomeListener = HomeListener;
    }
    
}
