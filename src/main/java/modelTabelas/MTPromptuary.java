	package modelTabelas;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelo.MConsultation;
import modelo.MPromptuary;

public class MTPromptuary extends AbstractTableModel {
	private String[] columnNames = {"Medico", "Data", "Valor"};
	private ArrayList<MPromptuary> listaPronptuary;
	
	public MTPromptuary(ArrayList<MPromptuary> listaPronptuary) {
		this.listaPronptuary = listaPronptuary;
	}

	public int getRowCount() {
		return listaPronptuary.size();
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	public Object getValueAt(int row, int col) {
		MPromptuary pr = listaPronptuary.get(row);
		if(col == 0) {
			return pr.getNameDoctor();
		}
		if(col == 1) {
			return pr.getData();
		}else {
			return pr.getValor();
		}
	}
	public MPromptuary getPromptuary(int pr) {
		return listaPronptuary.get(pr);
	}
}
