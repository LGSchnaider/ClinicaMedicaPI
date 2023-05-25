package modelTabelas;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelo.Paciente;


public class PacienteTableModel  extends AbstractTableModel {
    private String[] columnNames = { "Nome", "CPF"};
    	private ArrayList<Paciente> listaPaciente;
    	
    	public PacienteTableModel(ArrayList<Paciente> listaPaciente) {
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
        	Paciente pc = listaPaciente.get(row);
        	if(col == 0) {
        		return pc.getNome();
        	}else {
        		return pc.getCpf();
        	}
        }
        
        public Paciente getPaciente(int p) {
        	return listaPaciente.get(p);
        }
        
        

}
