package modelTabelas;

import javax.swing.table.AbstractTableModel;

public class MTMain extends AbstractTableModel{
	private String[] columnNames = { "Paciente", "Médico", "Data"};
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
    public String getColumnName(int col) {
        return columnNames[col];
      }

}
