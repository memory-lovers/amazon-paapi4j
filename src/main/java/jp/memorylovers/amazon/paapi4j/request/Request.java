package jp.memorylovers.amazon.paapi4j.request;

import jp.memorylovers.amazon.paapi4j.enums.EndPoint;
import lombok.Getter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import static jp.memorylovers.amazon.paapi4j.enums.EndPoint.ENDPOINT_JP;

/**
 * Model of Common Request Parameter.<br/>
 * represent for {@see <a href="https://images-na.ssl-images-amazon.com/images/G/09/associates/paapi/dg/index.html?rw_useCurrentProtocol=1">共通のリクエストパラメータ</a>}
 * unsupported for 'ContentType','Style', 'XMLEscaping'
 */
@Getter
public abstract class Request {
    protected final static String SERVICE = "AWSECommerceService";

    protected String awsAccessKeyId;
    protected String secretKey;
    protected EndPoint endPoint = ENDPOINT_JP;
    protected String associateTag = "toshokan06a-22";
    protected String merchantId;
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

    public Map<String, String> getParamsMap() {
        Map<String, String> params = new HashMap<>();
        params.put("Service", SERVICE);
        params.put("Version", version);
        params.put("Operation", operation());
        if (associateTag != null) params.put("AssociateTag", associateTag);
        if (merchantId != null) params.put("MerchantId", merchantId);
        params.put("Timestamp", timestamp());
        params.put("Validate", validate ? "True" : "False");
        params.put("AWSAccessKeyId", awsAccessKeyId);
        return setParams(params);
    }

    protected abstract Map<String, String> setParams(Map<String, String> params);

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
