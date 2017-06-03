package jp.memorylovers.amazon.paapi4j.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;

import java.util.Iterator;
import java.util.List;


public class Items {
    @Element(name = "TotalResults", required = false)
    public int totalResults;
    @Element(name = "TotalPages", required = false)
    public int totalPages;
    @Element(name = "MoreSearchResultsUrl", required = false)
    public String moreSearchResultUrl;
    @ElementList(entry = "Item", inline = true, required = false)
    public List<Item> itemList;

    @Path("Request/Errors")
    @Element(name = "Error", required = false)
    public Error error;

    @Override
    public String toString() {
        return "\tItems{\n" +
                "\t\ttotalResults               = " + totalResults + ",\n" +
                "\t\ttotalPages                 = " + totalPages + ",\n" +
                "\t\tmoreSearchResultUrl        = '" + moreSearchResultUrl + "\',\n" +
                "\t\terror                      = " + error + ",\n" +
                toString(itemList) + "\n" +
                "\t}";
    }

    private String toString(List<Item> list) {
        if (list == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Iterator<Item> iterator = list.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            if (iterator.hasNext()) {
                sb.append(",\n");
            }
        }
        return sb.toString();
    }

}
