package jp.memorylovers.amazon.paapi4j.response;

import org.simpleframework.xml.Element;

public class Offers {
    @Element(name="TotalOffers", required = false)
    public String totalOffers;

    @Element(name="TotalOfferPages", required = false)
    public String totalOfferPages;

    @Element(name="MoreOffersUrl", required = false)
    public String moreOffersUrl;

    @Element(name="Offer", required = false)
    public Offer offer;
}
