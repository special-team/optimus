package assist.sample.support;

import io.ebean.config.EncryptKey;
import io.ebean.config.EncryptKeyManager;

public class DemoEncryptKeyManager implements EncryptKeyManager {

    @Override
    public EncryptKey getEncryptKey(String tableName, String columnName) {
        return new DemoEncryptKey();
    }

    @Override
    public void initialise() {
    }
}
