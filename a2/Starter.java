package com.mycompany.a2;

import com.codename1.ui.Display;
import com.codename1.ui.Form;
/*
 *Bryce Hairabedian
 * CSC 133 Sec 1
 * Assignment 2
 */
public class Starter {
    private Form current;

    public void init(Object context) {
    }

    public void start() {
        if(current != null){
            current.show();
            return;
        }
        new Game();
    }

    public void stop() {
        current = Display.getInstance().getCurrent();
    }

    public void destroy() {
    }
}
