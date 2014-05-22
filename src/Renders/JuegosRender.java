package Renders;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import ludoteca.Juegos;

public class JuegosRender extends DefaultTableCellRenderer {
    
    public JuegosRender() {
        setHorizontalAlignment(SwingConstants.LEFT);
    }
    
    @Override
    public void setValue (Object aValue) {
        Object juego = aValue;
        if ((aValue != null) && (aValue instanceof Juegos)) {
            Juegos dataJuego = (Juegos) aValue;
            juego = dataJuego.getJueNom();
        }
        super.setValue(juego);
    }
    
}
