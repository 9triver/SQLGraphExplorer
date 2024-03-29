package cn.edu.nju.core.tools.ra.adt;

import java.util.ArrayList;

public class Database {

	private String name;
	private ArrayList<Table> tables;
//	private DbmsDriver dbmsDriver;
	
	/**
	 * @param aName name for the database.
	 */
	public Database(String aName) {
		name = aName;
		tables = new ArrayList<Table>();
	}
	
	public Database(String aName, ArrayList<Table> tableList) {
		name = aName;
		tables = tableList;
	}
	
	public void addTable(Table newTable) {
		if (containsTable(newTable.getName())) {
			return;
		}
		
		getTables().add(newTable);
	}
	
	public void removeTable(Table tableToRemove) {
		for (int i = 0; i < tables.size(); i++) {
			if (tables.get(i).getName().equalsIgnoreCase(tableToRemove.getName())) {
				tables.remove(i);
			}
		}
	}
	
	public String[] getTablesNames() {
		String[] tablesNames = new String[getTables().size()];
		
		for (int i = 0; i < getTables().size(); i++) {
			tablesNames[i] = getTables().get(i).getName();
		}
		
		return tablesNames;
	}
	
	/**
	 * Ask if the database contains the specified table 
	 * (case sensitive way).
	 * 
	 * @param tableName
	 * @return
	 */
	public boolean containsTable(String tableName) {
		for (int i = 0; i < getTables().size(); i++) {
			if (getTables().get(i).getName().equalsIgnoreCase(tableName)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Returns the attribute which matches the name.
	 * @param attrName
	 * @return
	 */
	public Attribute getAttributeByName(String attrName) {
		for (int i = 0; i < getTables().size(); i++) {
			for (int j = 0; j < getTables().get(i).getAttributes().size(); j++) {
				Attribute auxAttr = getTables().get(i).getAttributes().get(j);
				if (attrName.equalsIgnoreCase(auxAttr.getName())) {
					return auxAttr;
				}
			}
		}
		
		return null;
	}
	
	public String toString() {
		return getName();
	}
	
	public String toDSL() {
		String toString = "";
		
		toString += "DATABASE " + getName() + ";\n";
		
		for (int i = 0; i < getTables().size(); i++) {
			toString += "\nTABLE " + getTables().get(i).getName() + " (";
			
			// Attributes with domains
			for (int j = 0; j < getTables().get(i).getAttributes().size(); j++) {
				toString += getTables().get(i).getAttributes().get(j).getName() + ": " +
						getTables().get(i).getAttributes().get(j).getDataType();
				
				// Add semicolon
				if (j < getTables().get(i).getAttributes().size() - 1) {
					toString += ",\n";
				} 
				
				else {
					toString += ")\n";
				}
			}
			
			toString += "=>\n";
			
			// Rows
			for (int j = 0; j < getTables().get(i).getRows().size(); j++) {
				toString += "(";
				for (int k = 0; k < getTables().get(i).getRows().get(j).size(); k++) {
					String datum = getTables().get(i).getRows().get(j).getData().get(k).getStringValue();
					toString += datum;
					
					if (k < getTables().get(i).getRows().get(j).size() - 1) {
						toString += ",";
					}
					
					else {
						toString += ");\n";
					}
				}
			}
		}
		
		return toString;
	}
	
	/**
	 * Returns the table whose name matches the specified.
	 * 
	 * @param tableName
	 * @return
	 */
	public Table getTableByName(String tableName) {
		for (int i = 0; i < getTables().size(); i++) {
			if (tableName.equalsIgnoreCase(getTables().get(i).getName())) {
				return getTables().get(i);
			}
		}
		
		return null;
	}
	
	/**
	 * Returns the number of tables the DB has.
	 * @return
	 */
	public int getNumOfTables() {
		return getTables().size();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Table> getTables() {
		return tables;
	}

	public void setTables(ArrayList<Table> tables) {
		this.tables = tables;
	}

	/*public DbmsDriver getDbmsDriver() {
		return dbmsDriver;
	}

	public void setDbmsDriver(DbmsDriver dbmsDriver) {
		this.dbmsDriver = dbmsDriver;
	}*/
}
