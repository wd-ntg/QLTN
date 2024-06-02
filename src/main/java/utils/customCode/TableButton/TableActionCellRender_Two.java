
package utils.customCode.TableButton;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class TableActionCellRender_Two extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        PanelAction_Two action_two = new PanelAction_Two();
        if(isSelected == false && row % 2 == 0){
            action_two.setBackground(Color.WHITE);
        }
        else{
            action_two.setBackground(com.getBackground());
        }
        return action_two;
    }
    
}
