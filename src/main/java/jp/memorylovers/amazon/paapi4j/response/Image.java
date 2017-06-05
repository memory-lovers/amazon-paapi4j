package jp.memorylovers.amazon.paapi4j.response;

import lombok.ToString;
import org.simpleframework.xml.Element;

@ToString
public class Image {
    @Element(name = "URL")
    public String URL;
    @Element(name = "Height")
    public int height;

    //    @Element(name = "Height")
//    @Path("Height/@Units")
//    @Attribute(name = "Units")
//    public String heightUnits;

    @Element(name = "Width")
    public int width;

    //    @Element(name = "Width")
//    @Path("Width/@Units")
//    @Attribute(name = "Units")
//    public String widthUnits;
}
