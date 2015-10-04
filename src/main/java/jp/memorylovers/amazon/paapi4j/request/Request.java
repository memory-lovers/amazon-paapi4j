package jp.memorylovers.amazon.paapi4j.request;

import jp.memorylovers.amazon.paapi4j.enums.ContentType;
import jp.memorylovers.amazon.paapi4j.enums.EndPoint;
import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import static jp.memorylovers.amazon.paapi4j.enums.EndPoint.ENDPOINT_JP;

public abstract class Request {
    protected final static String SERVICE = "AWSECommerceService";
    @Getter
    protected String awsAccessKeyId;
    @Getter
    protected String secretKey;
    @Getter
    protected EndPoint endPoint = ENDPOINT_JP;
    @Setter
    protected String associateTag = "toshokan06a-22";
    protected ContentType contentType = ContentType.TEXT_XML;
    @Setter
    protected String merchantId = "Amazon";
    @Setter
    protected boolean validate = false;
    protected String version = "2013-08-01";

    protected Request(String secretKey, String awsAccessKeyId) {
        this.secretKey = secretKey;
        this.awsAccessKeyId = awsAccessKeyId;
    }

    protected Request(EndPoint endPoint, String secretKey, String awsAccessKeyId) {
        this(secretKey, awsAccessKeyId);
        this.endPoint = endPoint;
    }

    public Map<String, String> build() {
        Map<String, String> params = new HashMap<>();
        params.put("Service", SERVICE);
        params.put("Version", version);
        params.put("Operation", operation());
        if (associateTag != null) params.put("AssociateTag", associateTag);
        params.put("MerchantId", merchantId);
        params.put("Timestamp", timestamp());
        params.put("AWSAccessKeyId", awsAccessKeyId);
        return buildParams(params);
    }

    protected abstract Map<String, String> buildParams(Map<String, String> params);

    protected abstract String operation();

    protected String enc(String str) {
        return str.replace(" ", "%20").replace("　", "%20");
    }

    /**
     * Generate a ISO-8601 format timestamp as required by Amazon.
     *
     * @return ISO-8601 format timestamp.
     */
    private String timestamp() {
        String timestamp;
        Calendar cal = Calendar.getInstance();
        DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        dfm.setTimeZone(TimeZone.getTimeZone("GMT"));
        timestamp = dfm.format(cal.getTime());
        return timestamp;
    }
}
