package jp.memorylovers.amazon.paapi4j.request;

import org.junit.Test;

public class PowerBuilderTest {

    @Test
    public void testPowerBuilder() {
        PowerBuilder builder = PowerBuilder.builder();
        PowerBuilder.IPowerCond cond = builder.pubdateAfter(2015);
        System.out.println(cond);
    }
}
