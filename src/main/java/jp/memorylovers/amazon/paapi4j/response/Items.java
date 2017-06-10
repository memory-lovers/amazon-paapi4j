package jp.memorylovers.amazon.paapi4j.response;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;


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
    @ElementList(entry = "Error", required = false, inline = true)
    public List<Error> error;
}
