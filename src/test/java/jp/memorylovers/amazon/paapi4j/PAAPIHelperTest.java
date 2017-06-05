package jp.memorylovers.amazon.paapi4j;

import static jp.memorylovers.amazon.paapi4j.enums.EndPoint.*;
import static jp.memorylovers.amazon.paapi4j.enums.ResponseGroup.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jp.memorylovers.amazon.paapi4j.request.PowerBuilder;
import jp.memorylovers.amazon.paapi4j.request.Request;
import jp.memorylovers.amazon.paapi4j.request.RequestItemSearch;

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
                .builder(ENDPOINT_JP, authInfo)
                .browseNode(2278488051L)
                .responseGroup(MEDIUM)
                .publisher("集英社")
                .build();
        assertResult(request);
    }

    @Test
    public void testErrorNoResult() {
        RequestItemSearch request = RequestItemSearch
                .builder(ENDPOINT_JP, authInfo)
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
                .builder(ENDPOINT_JP, authInfo)
                .browseNode(2278488051L)
                .responseGroup(MEDIUM)
                .publisher("集英社")
                .power(builder.pubdateAfter(2015))
                .build();
        assertResult(request);
    }

    private void assertResult(Request request) {
        getResponse(request);
    }
}
