package jp.memorylovers.amazon.paapi4j.enums;

public enum ContentType {
    TEXT_XML, TEXT_HTML;

    @Override
    public String toString() {
        switch (this) {
            case TEXT_HTML:
                return "text html";
            case TEXT_XML:
            default:
                return "text/xml";
        }
    }
}
