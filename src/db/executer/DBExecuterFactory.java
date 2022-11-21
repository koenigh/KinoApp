package db.executer;

public class DBExecuterFactory extends PersistenceExecuterFactory {
/** 
 * 	Can only be used by PersistenceExecuterFactory.getConfiguredFactory()
 */
	protected DBExecuterFactory() {}
	@Override
	public PersistenceDDLExecuter getDBDDLExecuter() {
		return new DBDDLExecuter();
	}
	@Override
	public PersistenceDMLExecuter getDBDMLExecuter() {
		return new DBDMLExecuter();
	}
	public TypeKeyManagerInterface getTypeKeyManager() {
		return TypeKeyManagerDB.getTheInstance();
	}
	public String getModeText() {
		return "Mode = Integrated Database";
	}
	public boolean isDBPresent() {
		return true;
	}
}
