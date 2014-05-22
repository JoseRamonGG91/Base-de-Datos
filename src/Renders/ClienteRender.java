package Renders;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import ludoteca.Clientes;

public class ClienteRender extends DefaultTableCellRenderer {
    
    public ClienteRender() {
        setHorizontalAlignment(SwingConstants.LEFT);
    }
    
    @Override
    public void setValue (Object aValue) {
        Object cliente = aValue;
        if ((aValue != null) && (aValue instanceof Clientes)) {
            Clientes dataCliente = (Clientes) aValue;
            cliente = dataCliente.getCliNom();
        }
        super.setValue(cliente);
    }
}
