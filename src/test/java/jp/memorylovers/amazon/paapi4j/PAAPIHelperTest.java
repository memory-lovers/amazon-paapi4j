package jp.memorylovers.amazon.paapi4j;

import jp.memorylovers.amazon.paapi4j.request.PowerBuilder;
import jp.memorylovers.amazon.paapi4j.request.Request;
import jp.memorylovers.amazon.paapi4j.request.RequestItemSearch;
import jp.memorylovers.amazon.paapi4j.request.sign.SignedRequestsHelper;
import jp.memorylovers.amazon.paapi4j.response.Response;
import jp.memorylovers.amazon.paapi4j.response.ResponseHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static jp.memorylovers.amazon.paapi4j.enums.EndPoint.ENDPOINT_JP;
import static jp.memorylovers.amazon.paapi4j.enums.ResponseGroup.MEDIUM;
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
    public void test() {
        RequestItemSearch request = RequestItemSearch
                .builder(ENDPOINT_JP, secretKey, accessKey)
                .browseNode(2278488051L)
                .responseGroup(MEDIUM)
                .publisher("集英社")
                .build();
        assertResult(request);
    }

    @Test
    public void testErrorNoResult() {
        RequestItemSearch request = RequestItemSearch
                .builder(ENDPOINT_JP, secretKey, accessKey)
                .browseNode(2278488051L)
                .author("Author")
                .responseGroup(MEDIUM)
                .publisher("ああああ")
                .build();
        assertResult(request);
    }

    @Test
    public void testPowerBuilder() {
        PowerBuilder builder = PowerBuilder.builder();
        RequestItemSearch request = RequestItemSearch
                .builder(ENDPOINT_JP, secretKey, accessKey)
                .browseNode(2278488051L)
                .responseGroup(MEDIUM)
                .publisher("集英社")
                .power(builder.pubdateAfter(2015))
                .build();
        assertResult(request);
    }

    private void assertResult(Request request) {
        try {
            String requestUrl = SignedRequestsHelper.getInstance(request.getSecretKey()).sign(request);
            System.out.println("url: " + requestUrl);
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
