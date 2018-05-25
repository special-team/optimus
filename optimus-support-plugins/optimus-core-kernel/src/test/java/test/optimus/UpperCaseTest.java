package test.optimus;

import optimus.KERNEL;
import optimus.SQL;
import com.github.ooknight.rubik.support.core.exception.BusinessException;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.salt.StringFixedSaltGenerator;
import org.jasypt.salt.ZeroSaltGenerator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UpperCaseTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test1() {
        thrown.expect(BusinessException.class);
        throw KERNEL.ERROR(BusinessException.Type.ENTITY_NOT_FOUND);
    }

    @Test
    public void test2() {
        thrown.expect(RuntimeException.class);
        KERNEL.PROPAGATE(new ClassNotFoundException());
    }

    @Test
    public void test3() {
        System.out.println(SQL.NOW());
        System.out.println(SQL.CURRENT_DATE());
        //noinspection ConstantConditions
        System.out.println(SQL.NOT_NULL(1));
    }

    @Test
    public void test4() {
        //TextEncryptor encryptor = new BasicTextEncryptor();
        //TextEncryptor encryptor = new StrongTextEncryptor();
        StringEncryptor encryptor = new StandardPBEStringEncryptor();
        ((StandardPBEStringEncryptor) encryptor).setPassword("1234567");
        ((StandardPBEStringEncryptor) encryptor).setSaltGenerator(new StringFixedSaltGenerator("123456789012345678"));
        ((StandardPBEStringEncryptor) encryptor).setSaltGenerator(new ZeroSaltGenerator());
        System.out.println(encryptor.encrypt("a"));
        System.out.println(encryptor.encrypt("a"));
        System.out.println(encryptor.decrypt("Hu9DabO2Z7E="));
    }
}
