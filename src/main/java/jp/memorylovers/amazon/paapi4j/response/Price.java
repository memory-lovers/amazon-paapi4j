package jp.memorylovers.amazon.paapi4j.response;

import org.simpleframework.xml.Element;

public class Price {
    @Element(name = "Amount", required = false)
    public long amount;
    @Element(name = "CurrencyCode", required = false)
    public String currencyCode;
}
