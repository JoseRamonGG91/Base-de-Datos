package Renders;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class SegundaManoRender  extends DefaultTableCellRenderer {
    
    public SegundaManoRender() {
        setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    @Override
    public void setValue (Object aValue) {
        if (aValue != null) {
            if ((boolean) aValue == true) {
                    setIcon(new ImageIcon(getClass().getResource("/img/tic_yes.png")));
            } else
                setIcon(new ImageIcon(getClass().getResource("/img/tic_no.png")));   
        }
    }
}
