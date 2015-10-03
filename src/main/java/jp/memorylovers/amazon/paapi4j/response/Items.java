package jp.memorylovers.amazon.paapi4j.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

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

    @Override
    public String toString() {
        return "\tItems{\n" +
                "\t\ttotalResults               = " + totalResults + ",\n" +
                "\t\ttotalPages                 = " + totalPages + ",\n" +
                "\t\tmoreSearchResultUrl        = '" + moreSearchResultUrl + "\',\n" +
                toString(itemList) + "\n" +
                "\t}";
    }

    private String toString(List list) {
        StringBuilder sb = new StringBuilder();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            if (iterator.hasNext()) {
                sb.append(",\n");
            }
        }
        return sb.toString();
    }
}
