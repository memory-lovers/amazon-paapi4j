package jp.memorylovers.amazon.paapi4j.response;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;

public class BrowseNode {
    @Element(name = "BrowseNodeId", required = false)
    public String browseNodeId;

    @Element(name = "Name", required = false)
    public String name;

    @Element(name = "IsCategoryRoot", required = false)
    public String isCategoryRoot;

    @Path("Ancestors")
    @Element(name = "BrowseNode", required = false)
    public BrowseNode ancestors;

    @Path("Children")
    @ElementList(entry="BrowseNode", required = false, inline = true)
    public List<BrowseNode> children;
}
