package modelTabelas;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelo.MDoctor;

public class MTMedicoTableModel  extends AbstractTableModel {
    private String[] columnNames = { "Nome", "CRM"};
    	private ArrayList<MDoctor> listaMedico;
    	
    	public MTMedicoTableModel(ArrayList<MDoctor> listaMedico) {
			this.listaMedico = listaMedico;
		}

       
        public int getColumnCount() {
          return columnNames.length;
        }

        public int getRowCount() {
          return listaMedico.size();
        }

        public String getColumnName(int col) {
          return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
        	MDoctor m = listaMedico.get(row);
        	if(col == 0) {
        		return m.getNome();
        	}else {
        		return m.getCrm();
        	}
        }
        
        public MDoctor getMedico(int p) {
        	return listaMedico.get(p);
        }
        
        

}
