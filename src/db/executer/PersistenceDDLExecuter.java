package db.executer;

import java.sql.SQLException;

import db.connection.DBConnectionData;
import db.connection.NoConnectionException;

public interface PersistenceDDLExecuter {
	void openDBConnection(DBConnectionData connectionData)
			throws ClassNotFoundException, SQLException, NoConnectionException;
/**	
 * Extends the given connection to a concrete database with name <servicename>
 */
	void establishConnectionToDatabase(String servicename)
			throws ClassNotFoundException, SQLException, NoConnectionException;
	void closeConnection() throws SQLException;
	void createDatabase(String servicename) throws SQLException, NoConnectionException;
	void createClassTable(String servicename, String classname, String attributeList)
			throws SQLException, NoConnectionException;
	void createRelationTable(String associationName, String p1Type, String p2Type)
			throws SQLException, NoConnectionException;
	void createTypeKeyTable(String servicename) throws SQLException, NoConnectionException;
	void createTypeKeyTableEntry(String servicename, String relName) throws SQLException, NoConnectionException;
	boolean typeKeyTableExists(String servicename) throws SQLException, NoConnectionException;
	boolean tableExists(String tableName) throws SQLException, NoConnectionException;
/**
 * REQUIRES no connection present for @param connectionData
 */
	void dropDatabase(DBConnectionData connectionData) throws PersistenceException;
}