package test.optimus;

import optimus.KERNEL;
import optimus.SQL;
import com.github.ooknight.rubik.support.core.exception.BusinessException;
import com.github.ooknight.rubik.support.core.exception.BusinessExceptionType;

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
        throw KERNEL.ERROR(BusinessExceptionType.Default.ENTITY_NOT_FOUND);
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
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("1234567");
        encryptor.setSaltGenerator(new ZeroSaltGenerator());
        System.out.println(encryptor.encrypt("a"));
        System.out.println(encryptor.encrypt("a"));
        System.out.println(encryptor.decrypt("OzEXxjfRMQs="));
    }

    @Test
    public void test5() {
        //TextEncryptor encryptor = new BasicTextEncryptor();
        //TextEncryptor encryptor = new StrongTextEncryptor();
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("1234567");
        encryptor.setSaltGenerator(new StringFixedSaltGenerator("123456789012345678"));
        System.out.println(encryptor.encrypt("a"));
        System.out.println(encryptor.encrypt("a"));
        System.out.println(encryptor.decrypt("EUxhyeMuc+M="));
    }
}
