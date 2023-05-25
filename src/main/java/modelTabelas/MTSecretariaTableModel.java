package modelTabelas;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelo.MSecretary;



public class MTSecretariaTableModel  extends AbstractTableModel {
    private String[] columnNames = { "Nome", "CPF"};
    	private ArrayList<MSecretary> listaSecretaria;
    	
    	public MTSecretariaTableModel(ArrayList<MSecretary> listaSecretaria) {
			this.listaSecretaria = listaSecretaria;
		}

       
        public int getColumnCount() {
          return columnNames.length;
        }

        public int getRowCount() {
          return listaSecretaria.size();
        }

        public String getColumnName(int col) {
          return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
        	MSecretary s = listaSecretaria.get(row);
        	if(col == 0) {
        		return s.getNome();
        	}else {
        		return s.getCpf();
        	}
        }
        
        public MSecretary getSecretaria(int p) {
        	return listaSecretaria.get(p);
        }
        
        

}
