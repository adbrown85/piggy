package swing;

import javax.swing.Box;
import javax.swing.BoxLayout;


/**
 * Box that aligns its components vertically.
 */
public class VerticalBox extends Box {
    
    public VerticalBox() {
        super(BoxLayout.PAGE_AXIS);
    }
}
