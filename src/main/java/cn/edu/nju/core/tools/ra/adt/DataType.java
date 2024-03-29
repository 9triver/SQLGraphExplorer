package cn.edu.nju.core.tools.ra.adt;

/**
 * Available data types for tables' attributes
 */
public enum DataType {
	CHAR, STRING, INT, FLOAT, DATE;
	
	public String toString() {
		switch(this) {
			case CHAR: return "Char";
			case STRING: return "String";
			case INT: return "Integer";
			case FLOAT: return "Float";
			case DATE: return "Date";
			default: return "";
		}
	}
}
