package modelTabelas;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelo.MPatient;


public class MTPacienteTableModel  extends AbstractTableModel {
    private String[] columnNames = { "Nome", "CPF"};
    	private ArrayList<MPatient> listaPaciente;
    	
    	public MTPacienteTableModel(ArrayList<MPatient> listaPaciente) {
			this.listaPaciente = listaPaciente;
		}

       
        public int getColumnCount() {
          return columnNames.length;
        }

        public int getRowCount() {
          return listaPaciente.size();
        }

        public String getColumnName(int col) {
          return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
        	MPatient pc = listaPaciente.get(row);
        	if(col == 0) {
        		return pc.getNome();
        	}else {
        		return pc.getCpf();
        	}
        }
        
        public MPatient getPaciente(int p) {
        	return listaPaciente.get(p);
        }
        
        

}
