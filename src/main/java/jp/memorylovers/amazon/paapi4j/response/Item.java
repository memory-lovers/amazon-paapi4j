package jp.memorylovers.amazon.paapi4j.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;

public class Item {
    @Element(name = "ASIN", required = false)
    public String asin;
    @Element(name = "DetailPageURL", required = false)
    public String detailPageUrl;
    @Element(name = "ItemAttributes", required = false)
    public ItemAttributes itemAttributes;

    @Path("ImageSets/ImageSet[1]")
    @Element(name = "SwatchImage", required = false)
    public Image swatchImage;
    @Path("ImageSets/ImageSet[1]")
    @Element(name = "SmallImage", required = false)
    public Image smallImage;
    @Path("ImageSets/ImageSet[1]")
    @Element(name = "ThumbnailImage", required = false)
    public Image thumbnailImage;
    @Path("ImageSets/ImageSet[1]")
    @Element(name = "TinyImage", required = false)
    public Image tinyImage;
    @Path("ImageSets/ImageSet[1]")
    @Element(name = "MediumImage", required = false)
    public Image mediumImage;
    @Path("ImageSets/ImageSet[1]")
    @Element(name = "LargeImage", required = false)
    public Image largeImage;

    @Path("OfferSummary")
    @Element(name = "LowestNewPrice", required = false)
    public Price lowestNewPrice;
    @Path("OfferSummary")
    @Element(name = "LowestCollectiblePrice", required = false)
    public Price lowestCollectiblePrice;
    @Path("OfferSummary")
    @Element(name = "LowestUsedPrice", required = false)
    public Price lowestUsedPrice;

    @Override
    public String toString() {
        return "\t\tItem{\n" +
                "\t\t\tasin                   = '" + asin + "\',\n" +
                "\t\t\tdetailPageUrl          = '" + detailPageUrl + "\',\n" +
                itemAttributes + "\n" +
                "\t\t\tswatchImage            = " + swatchImage + "\n" +
                "\t\t\tsmallImage             = " + smallImage + "\n" +
                "\t\t\tthumbnailImage         = " + thumbnailImage + "\n" +
                "\t\t\ttinyImage              = " + tinyImage + "\n" +
                "\t\t\tmediumImage            = " + mediumImage + "\n" +
                "\t\t\tlargeImage             = " + largeImage + "\n" +
                "\t\t\tlowestNewPrice         = " + lowestNewPrice + "\n" +
                "\t\t\tlowestCollectiblePrice = " + lowestCollectiblePrice + "\n" +
                "\t\t\tlowestUsedPrice        = " + lowestUsedPrice + "\n" +
                "\t\t}";
    }
}

