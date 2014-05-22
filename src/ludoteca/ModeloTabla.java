/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ludoteca;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JoseRamon
 */
public class ModeloTabla extends AbstractTableModel {
    List<Ventas> list;
    
    public void setDataList(List<Ventas> list) {
        this.list = list;
    }
    
    @Override
    public String getColumnName (int column) {
        switch(column) {
            case 0:
                return "Cliente";
            case 1: 
                return "Juego";
            case 2:
                return "Fecha";
            case 3: 
                return "Cantidad";
            case 4:
                return "2º Mano";
            default:
                return "";
        }
    }
    
    @Override
    public int getRowCount() {
        return list.size();    
    }
 
    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ventas venta = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return venta.getCliNum();
            case 1:
                return venta.getJueNum();
            case 2:
                return venta.getFechaCompra();
            case 3:
                return venta.getCantidad();
            case 4:
                return venta.getSegundaMano();
            default:
                return null;
        }
    }
}
