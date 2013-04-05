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
    
    public static final String DATABASE = "Database";
    public static final String MYSQL = "MySQL";
    
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
        databaseConfigs.put(DATABASE, MYSQL);
    }
    
    public String getDatabase(){
        return databaseConfigs.get(DATABASE);
    }
}
