/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramos.clases;

import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.text.Text;

/**
 *
 * @author dam2
 */
public class Temporizador {

    public int seconds = 0;
    public Timer myTimer = new Timer();
    public TimerTask task;

    public void time(Text fxText) {

        task = new TimerTask() {
            @Override
            public void run() {
                seconds++;
                fxText.setText("" + seconds);
                
            }
        };
    }
    
    public void start(){
        task.run();
        myTimer.scheduleAtFixedRate(task, 1000, 1000); 
    }
    
    public void stop(){
        task.cancel();
        myTimer.cancel();
        myTimer.purge();
        myTimer = new Timer();
        
        
    }
    

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getSeconds() {
        return seconds;
    }
    
    

}
