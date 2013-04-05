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
        String databaseType = instance.getDatabase();
        if (databaseType.equals( SystemConfig.MYSQL)){
            return new MySQLDB();
        }
        else {
            return new MySQLDB();
        }
    }
}
