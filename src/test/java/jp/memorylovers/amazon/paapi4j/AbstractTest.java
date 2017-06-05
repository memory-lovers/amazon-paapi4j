package jp.memorylovers.amazon.paapi4j;

import static org.junit.Assert.*;

import org.junit.BeforeClass;

import jp.memorylovers.amazon.paapi4j.exception.PAAPI4jException;
import jp.memorylovers.amazon.paapi4j.request.Request;
import jp.memorylovers.amazon.paapi4j.request.sign.AuthInfo;
import jp.memorylovers.amazon.paapi4j.request.sign.AuthInfoFactory;
import jp.memorylovers.amazon.paapi4j.response.Response;

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

    public Response getResponse(Request request) {
        Response response = null;
        try {
            response = new DebugResponseHelper().getResponse(request);
            response.setRequest(request);
            System.out.println(response.toString());
        } catch (Exception e) {
            e.getCause().printStackTrace();
            fail(e.getLocalizedMessage());
        }

        return response;
    }
}
