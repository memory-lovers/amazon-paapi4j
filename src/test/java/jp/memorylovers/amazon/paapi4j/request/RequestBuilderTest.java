package jp.memorylovers.amazon.paapi4j.request;

import jp.memorylovers.amazon.paapi4j.AbstractTest;
import jp.memorylovers.amazon.paapi4j.enums.ResponseGroup;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;


public class RequestBuilderTest extends AbstractTest {

    @Test
    public void testBuilder() {
        Request request = RequestItemSearch
                .builder(secretKey, accessKey)
                .author("Author")
                .browseNode(2278488051L)
                .responseGroup(ResponseGroup.MEDIUM)
                .build();
        assertNotNull(request);
    }
}
