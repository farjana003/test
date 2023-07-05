package util;

import javax.swing.JFrame;
import javax.swing.JTable;

public class ComponentUtil {
    public static int getSelectedId(JTable listTbl) {
        int rowIdx = listTbl.getSelectedRow();
        int columnIdx = listTbl.getColumn("Id").getModelIndex();
        return (Integer) listTbl.getModel().getValueAt(rowIdx, columnIdx);
    }
    
    public static void swapComponents(JFrame frame1, JFrame frame2) {
        frame2.setVisible(true);
        frame1.setVisible(false);
    }
}
