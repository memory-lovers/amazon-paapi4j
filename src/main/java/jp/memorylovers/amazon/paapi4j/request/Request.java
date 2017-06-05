package jp.memorylovers.amazon.paapi4j.request;

import static jp.memorylovers.amazon.paapi4j.enums.EndPoint.*;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import jp.memorylovers.amazon.paapi4j.enums.EndPoint;
import jp.memorylovers.amazon.paapi4j.exception.PAAPI4jException;
import jp.memorylovers.amazon.paapi4j.request.sign.AuthInfo;
import jp.memorylovers.amazon.paapi4j.request.sign.SignedRequestsHelper;
import lombok.Getter;

/**
 * Model of Common Request Parameter.<br>
 * unsupported for 'ContentType','Style', 'XMLEscaping'
 *
 * @see <a href=
 *      "https://images-na.ssl-images-amazon.com/images/G/09/associates/paapi/dg/index.html?rw_useCurrentProtocol=1">
 *      共通のリクエストパラメータ</a>
 */
@Getter
public abstract class Request {
    protected final static String SERVICE = "AWSECommerceService";

    protected AuthInfo authInfo;
    protected EndPoint endPoint = ENDPOINT_JP;
    protected String merchantId;
    protected boolean validate = false;
    protected String version = "2013-08-01";

    protected Request(AuthInfo authInfo) {
        this.authInfo = authInfo;
    }

    protected Request(EndPoint endPoint, AuthInfo authInfo) {
        this.authInfo = authInfo;
        this.endPoint = endPoint;
    }

    public String getRequestUrl() throws PAAPI4jException {
        try {
            return SignedRequestsHelper.getInstance(authInfo.getSecretKey())
                .sign(this);
        } catch (InvalidKeyException | IllegalArgumentException
                | UnsupportedEncodingException | NoSuchAlgorithmException e) {
            throw new PAAPI4jException(e);
        }
    }

    public Map<String, String> getParamsMap() {
        Map<String, String> params = new HashMap<>();
        params.put("Service", SERVICE);
        params.put("Version", version);
        params.put("Operation", operation());
        params.put("AssociateTag", authInfo.getAssociateTag());
        if (merchantId != null) params.put("MerchantId", merchantId);
        params.put("Timestamp", timestamp());
        params.put("Validate", validate ? "True" : "False");
        params.put("AWSAccessKeyId", authInfo.getAccessKey());
        return setParams(params);
    }

    protected abstract Map<String, String> setParams(Map<String, String> params);

    public abstract String operation();

    protected String enc(String str) {
        return str.replace(" ", "%20")
            .replace("　", "%20");
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
