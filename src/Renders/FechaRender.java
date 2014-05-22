/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Renders;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author JoseRamon
 */
public class FechaRender extends DefaultTableCellRenderer {
    
    public FechaRender() {
        setHorizontalAlignment(SwingConstants.RIGHT);
    }
    
    @Override
    public void setValue (Object aValue) {
        Object fecha = aValue;
        if ((aValue != null) && (aValue instanceof Date)) {
            Date fechaConFormato = (Date) aValue;
            SimpleDateFormat formato = new SimpleDateFormat("dd'-'MM'-'YYYY");
            fecha = formato.format(fechaConFormato.getTime());
        }
        super.setValue(fecha);
    }
}
