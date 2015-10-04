package jp.memorylovers.amazon.paapi4j.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

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

    @Override
    public String toString() {
        return "\t\t\tItemAttributes{\n" +
                "\t\t\t\tauthor             = '" + author + "\',\n" +
                "\t\t\t\tbinding            = '" + binding + "\',\n" +
                "\t\t\t\tean                = '" + ean + "\',\n" +
                "\t\t\t\tisbn               = '" + isbn + "\',\n" +
                "\t\t\t\tlistPrice          = '" + listPrice + "\',\n" +
                "\t\t\t\tmanufacturer       = '" + manufacturer + "\',\n" +
                "\t\t\t\tproductGroup       = '" + productGroup + "\',\n" +
                "\t\t\t\tpublicationDate    = '" + publicationDate + "\',\n" +
                "\t\t\t\tpublisher          = '" + publisher + "\',\n" +
                "\t\t\t\treleaseDate        = '" + releaseDate + "\',\n" +
                "\t\t\t\ttitle              = '" + title + "\'\n" +
                "\t\t\t}";
    }
}
