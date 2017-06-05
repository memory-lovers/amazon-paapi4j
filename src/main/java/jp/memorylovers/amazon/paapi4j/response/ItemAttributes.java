package jp.memorylovers.amazon.paapi4j.response;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

public class ItemAttributes {
    @ElementList(entry = "Author", required = false, inline = true)
    public List<String> author;
    @Element(name = "Binding", required = false)
    public String binding;
    @Element(name = "EAN", required = false)
    public String ean;
    @Element(name = "ISBN", required = false)
    public String isbn;
    @Element(name = "ListPrice", required = false)
    public Price listPrice;
    @Element(name = "Manufacturer", required = false)
    public String manufacturer;
    @Element(name = "ProductGroup", required = false)
    public String productGroup;
    @Element(name = "PublicationDate", required = false)
    public String publicationDate;
    @Element(name = "Publisher", required = false)
    public String publisher;
    @Element(name = "ReleaseDate", required = false)
    public String releaseDate;

    @Element(name = "Title", required = false)
    public String title;
}
