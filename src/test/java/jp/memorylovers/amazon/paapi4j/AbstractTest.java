package jp.memorylovers.amazon.paapi4j;

import static org.junit.Assert.*;

import org.junit.BeforeClass;

import jp.memorylovers.amazon.paapi4j.exception.PAAPI4jException;
import jp.memorylovers.amazon.paapi4j.sign.AuthInfo;
import jp.memorylovers.amazon.paapi4j.sign.AuthInfoFactory;

public class AbstractTest {
    protected static String accessKey;
    protected static String secretKey;

    protected static AuthInfo authInfo;

    @BeforeClass
    public static void readProperties() {
        try {
            authInfo = AuthInfoFactory.createByResoruce();
            accessKey = authInfo.getAccessKey();
            secretKey = authInfo.getSecretKey();
            System.out.println(authInfo.toString());
        } catch (PAAPI4jException e) {
            fail(e.getMessage());
            e.printStackTrace();
        }
    }
}
