/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.util.Map;

/**
 *
 * @author Allen
 */
public class SystemConfig {
    
    public static final String DATABASE_TYPE = "Database";
    
    public static final String HOST = "host";
    public static final String DATABASE = "database";
    public static final String USER = "user";
    public static final String PASSWORD = "password";
    
    private String MySQL = "MySQL";
    private String MySQLHost = "jdbc:mysql://localhost";
    private String MySQLDatabase = "rabidusDB";
    private String MySQLUser = "root";
    private String MySQLPassword = "password";
    
    private Map<String, String> databaseConfigs;
    
    private SystemConfig() {
    }
    
    public static SystemConfig getInstance() {
        return SystemConfigHolder.INSTANCE;
    }
    
    private static class SystemConfigHolder {

        private static final SystemConfig INSTANCE = new SystemConfig();
    }
    
    public void useMySQLDB(){
        databaseConfigs.put(DATABASE_TYPE, MySQL);
        databaseConfigs.put(HOST, MySQLHost);
        databaseConfigs.put(DATABASE, MySQLDatabase );
        databaseConfigs.put(USER, MySQLUser);
        databaseConfigs.put(PASSWORD, MySQLPassword);
    }
    
    public String getDatabaseType(){
        return databaseConfigs.get(DATABASE);
    }
    
    public String getMySQLPasswordHost(){
        return databaseConfigs.get(HOST);
    }
    
    public String getMySQLPasswordDatabaseName(){
        return databaseConfigs.get(DATABASE);
    }
    
    public String getMySQLPasswordUser(){
        return databaseConfigs.get(USER);
    }
    
    public String getMySQLPasswordPassword(){
        return databaseConfigs.get(PASSWORD);
    }
}
