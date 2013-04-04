/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

/**
 *
 * @author Allen
 */
public class MgrFactory {
    
    private MgrFactory() {
    }
    
    public static MgrFactory getInstance() {
        return MgrFactoryHolder.INSTANCE;
    }
    
    private static class MgrFactoryHolder {

        private static final MgrFactory INSTANCE = new MgrFactory();
    }
}
