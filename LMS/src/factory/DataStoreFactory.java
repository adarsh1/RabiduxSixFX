
package factory;

/**
 *
 * @author Allen
 */
public class DataStoreFactory {
    
    private DataStoreFactory() {
    }
    
    public static DataStoreFactory getInstance() {
        return DataStoreFactoryHolder.INSTANCE;
    }
    
    private static class DataStoreFactoryHolder {

        private static final DataStoreFactory INSTANCE = new DataStoreFactory();
    }
}
