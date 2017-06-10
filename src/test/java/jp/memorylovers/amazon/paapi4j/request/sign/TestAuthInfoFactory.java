package jp.memorylovers.amazon.paapi4j.request.sign;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.memorylovers.amazon.paapi4j.exception.IllegalPropertiesException;
import jp.memorylovers.amazon.paapi4j.exception.MissingPropertiesException;
import jp.memorylovers.amazon.paapi4j.exception.PAAPI4jException;
import jp.memorylovers.pp4j.PP4j;

public class TestAuthInfoFactory {

    @Test
    public void test_createByResoruce_default() throws PAAPI4jException {
        AuthInfo info = AuthInfoFactory.createByResoruce();

        assertNotNull(info.getAssociateTag());
        assertNotNull(info.getAccessKey());
        assertNotNull(info.getSecretKey());
    }

    @Test(expected = MissingPropertiesException.class)
    public void test_createByResoruce_no_file() throws PAAPI4jException {
        AuthInfoFactory.createByResoruce("dummey");
        fail("Exception doesn't occure...");
    }

    @Test(expected = IllegalPropertiesException.class)
    public void test_createByResoruce_empty_file() throws PAAPI4jException {
        AuthInfoFactory.createByResoruce("properties/empty_file");
        fail("Exception doesn't occure...");
    }

    @Test(expected = IllegalPropertiesException.class)
    public void test_createByResoruce_empty_values() throws PAAPI4jException {
        AuthInfo info = AuthInfoFactory.createByResoruce("properties/empty_values");
        fail("Exception doesn't occure...\n" + PP4j.pp(info));
    }
}
