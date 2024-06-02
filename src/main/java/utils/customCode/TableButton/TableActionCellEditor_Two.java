
package utils.customCode.TableButton;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;


public class TableActionCellEditor_Two extends DefaultCellEditor{

    private TableActionEvent_Two event;
    
    public TableActionCellEditor_Two(TableActionEvent_Two event){
        super(new JCheckBox());
        this.event = event;
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PanelAction_Two action = new PanelAction_Two();
        action.initEvent(event, row);
        action.setBackground(table.getSelectionBackground());
        return action;
    }
    
}
