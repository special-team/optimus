package assist.sample.support;

import io.ebean.config.EncryptKey;

public class DemoEncryptKey implements EncryptKey {

    @Override
    public String getStringValue() {
        return "123456";
    }
}
