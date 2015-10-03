package jp.memorylovers.amazon.paapi4j;

import jp.memorylovers.amazon.paapi4j.enums.ResponseGroup;
import jp.memorylovers.amazon.paapi4j.request.RequestBuilder;
import jp.memorylovers.amazon.paapi4j.request.RequestItemSearch;
import jp.memorylovers.amazon.paapi4j.request.SignedRequestsHelper;
import jp.memorylovers.amazon.paapi4j.response.Response;
import jp.memorylovers.amazon.paapi4j.response.ResponseHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static jp.memorylovers.amazon.paapi4j.enums.EndPoint.ENDPOINT_JP;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;

public class PAAPIHelperTest extends AbstractTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test2() {
        RequestItemSearch request = RequestBuilder.builderItemSearch(ENDPOINT_JP, secretKey, accessKey);
        request.setResponseGroup(ResponseGroup.MEDIUM);
        request.setPublisher("集英社");

        try {
            String requestUrl = SignedRequestsHelper.getInstance(request.getSecretKey()).sign(request);
            System.out.println("url: " + requestUrl);
//            ResponseHelper.response(requestUrl);
            Response response = ResponseHelper.getResponse(requestUrl);
            response.setRequest(request);
            assertNotNull(response);
            System.out.println(response.toString());
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
            e.printStackTrace();
            fail();
        }
    }
}
