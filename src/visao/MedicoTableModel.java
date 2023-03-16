package visao;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelo.Medico;

public class MedicoTableModel  extends AbstractTableModel {
    private String[] columnNames = { "Nome", "CRM"};
    	private ArrayList<Medico> listaMedico;
    	
    	public MedicoTableModel(ArrayList<Medico> listaMedico) {
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
        	Medico m = listaMedico.get(row);
        	if(col == 0) {
        		return m.getNome();
        	}else {
        		return m.getCrm();
        	}
        }

}
