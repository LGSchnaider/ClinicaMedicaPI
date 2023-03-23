package modelTabelas;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelo.Secretaria;



public class SecretariaTableModel  extends AbstractTableModel {
    private String[] columnNames = { "Nome", "CPF"};
    	private ArrayList<Secretaria> listaSecretaria;
    	
    	public SecretariaTableModel(ArrayList<Secretaria> listaSecretaria) {
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
        	Secretaria s = listaSecretaria.get(row);
        	if(col == 0) {
        		return s.getNome();
        	}else {
        		return s.getCpf();
        	}
        }
        
        public Secretaria getSecretaria(int p) {
        	return listaSecretaria.get(p);
        }
        
        

}
