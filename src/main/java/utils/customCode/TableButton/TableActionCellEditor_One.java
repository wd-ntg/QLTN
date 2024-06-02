
package utils.customCode.TableButton;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;


public class TableActionCellEditor_One extends DefaultCellEditor{

    private TableActionEvent_One event;
    
    public TableActionCellEditor_One(TableActionEvent_One event){
        super(new JCheckBox());
        this.event = event;
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PanelAction_One action = new PanelAction_One();
        action.initEvent(event, row,column);
        action.setBackground(table.getSelectionBackground());
        return action;
    }
    
}
