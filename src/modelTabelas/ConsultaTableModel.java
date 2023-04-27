	package modelTabelas;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelo.Consulta;

public class ConsultaTableModel extends AbstractTableModel {
	private String[] columnNames = {"Paciente", "Medico"};
	private ArrayList<Consulta> listaConsulta;
	
	public ConsultaTableModel(ArrayList<Consulta> listaConsulta) {
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
			return c.getIdPaciente();
		}else {
			return c.getIdMedico();
		}
	}
	public Consulta getConsulta(int p) {
		return listaConsulta.get(p);
	}
}
