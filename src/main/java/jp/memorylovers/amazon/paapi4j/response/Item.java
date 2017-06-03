package jp.memorylovers.amazon.paapi4j.response;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
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

    @Path("BrowseNodes")
    @ElementList(entry = "BrowseNode", required = false, inline = true)
    public List<BrowseNode> browseNodes;
}
