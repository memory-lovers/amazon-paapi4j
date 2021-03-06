package jp.memorylovers.amazon.paapi4j.request;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.memorylovers.amazon.paapi4j.AbstractTest;
import jp.memorylovers.amazon.paapi4j.enums.ResponseGroup;

public class TestRequestItemLookup extends AbstractTest {

    @Test
    public void test() {
        String[] itemId = {"B00F5OG37K", "4422100513"};
        RequestItemLookup request = RequestItemLookup.builder(authInfo)
            .itemId(itemId)
            .responseGroup(ResponseGroup.BROWSE_NODES)
            .build();

        assertNotNull(getResponse(request));
    }
}
