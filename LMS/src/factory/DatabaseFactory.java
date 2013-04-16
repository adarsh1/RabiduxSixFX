//this approach to create singleton is ingenius!
package factory;

import datamanagement.Database;
import datamanagement.MySQLDB;

/**
 *
 * @author Allen
 */
public class DatabaseFactory {
    
    private DatabaseFactory() {
    }
    
    public static DatabaseFactory getInstance() {
        return DataStoreFactoryHolder.INSTANCE;
    }
    
    private static class DataStoreFactoryHolder {

        private static final DatabaseFactory INSTANCE = new DatabaseFactory();
    }
    
    public Database createDatabase(){
        
        SystemConfig instance = SystemConfig.getInstance();
        String databaseType = instance.getDatabaseType();
        
        if (databaseType.equals("MySQL")){
            
            String host = instance.getMySQLPasswordHost();
            String databaseName = instance.getMySQLPasswordDatabaseName();
            String user = instance.getMySQLPasswordUser();
            String password = instance.getMySQLPasswordPassword();
            return new MySQLDB(host, databaseName, user, password);
            
        }
        else {
            
            throw new UnsupportedOperationException("Not supported yet.");
            
        }
        
    }
    
}
