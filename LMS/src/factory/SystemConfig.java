/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

/**
 *
 * @author Allen
 */
public class SystemConfig {
    
    private SystemConfig() {
    }
    
    public static SystemConfig getInstance() {
        return SystemConfigHolder.INSTANCE;
    }
    
    private static class SystemConfigHolder {

        private static final SystemConfig INSTANCE = new SystemConfig();
    }
}
