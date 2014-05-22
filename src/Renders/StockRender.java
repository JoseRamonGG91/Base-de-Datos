/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Renders;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author JoseRamon
 */
public class StockRender extends DefaultTableCellRenderer {
    
    public StockRender() {
        setHorizontalAlignment(SwingConstants.RIGHT);
    }
    
    @Override
    public void setValue (Object aValue) {
        Object stock = aValue;
        int intStock = -1;
        if ((aValue != null) && (aValue instanceof Integer)) {
             intStock = (int) aValue;
            if (intStock <= 1)
                setForeground(Color.red);
            else
                setForeground(Color.blue);
        }
        super.setValue(intStock);
    }
    
}
