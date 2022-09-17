package support;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;



public class MyTableModel extends DefaultTableModel{
	private int noOfCols;
	private String colName[];
	private int noOfRows;
	private Object cell[][];  //error source
	private JTable table;
	

	public void takeRowCol(String colName[]){
		this.noOfCols=colName.length;
		this.colName=colName; 
	}
	@Override
	public void setValueAt(Object data, int row, int col) {
		this.cell[row][col]=data;
	}


	@Override
	public int getColumnCount() {
		return this.noOfCols;
	}

	


	@Override
	public String getColumnName(int colNo) {
		return this.colName[colNo];
	}

	@Override
	public int getRowCount() {
		return this.noOfRows;
	}

	@Override
	public Object getValueAt(int row, int col) {
		return this.cell[row][col];
	}

	public void setRowCount(int noOfRows,int noOfCol) {
		this.noOfRows=noOfRows;
		this.cell=new Object[noOfRows][noOfCol]; 
	}

	
	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}
	

}
