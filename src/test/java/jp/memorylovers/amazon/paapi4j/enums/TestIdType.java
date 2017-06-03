package jp.memorylovers.amazon.paapi4j.enums;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestIdType {

    @Test
    public void testToString() {
        IdType type = IdType.ASIN;

        assertEquals("ASIN", type.name());
        assertEquals("ASIN", type.toString());
    }
}
