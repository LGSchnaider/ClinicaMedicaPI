package modelTabelas;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelo.Consulta;
import modelo.Paciente;

public class MTMain extends AbstractTableModel{
	private String[] columnNames = { "Paciente", "Médico", "Data"};
	private ArrayList<Consulta> listaConsulta;
	
	public MTMain(ArrayList<Consulta> listaConsulta) {
		this.listaConsulta = listaConsulta;
	}
	
	public int getRowCount() {
		return listaConsulta.size();
	}

	public int getColumnCount() {
		return columnNames.length;
	}

    public String getColumnName(int col) {
        return columnNames[col];
    }
    
	public Object getValueAt(int row, int col) {
		Consulta c = listaConsulta.get(row);
		if(col == 0) {
			return c.getNamePatient();
		}if(col == 1){
			return c.getNameDoctor();
		}else {
			return c.getData();
		}
	}

}
