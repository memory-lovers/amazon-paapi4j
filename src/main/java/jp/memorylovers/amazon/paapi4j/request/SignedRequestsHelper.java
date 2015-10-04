package jp.memorylovers.amazon.paapi4j.request;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class SignedRequestsHelper {
    // All strings are handled as UTF-8
    private static final String UTF8_CHARSET = "UTF-8";
    //The HMAC algorithm required by Amazon
    private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";
    // This is the URI for the service, don't change unless you really know what you're doing.
    private static final String REQUEST_URI = "/onca/xml";
    // The sample uses HTTP GET to fetch the response. If you changed the sample to use HTTP POST instead, change the value below to POST.
    private static final String REQUEST_METHOD = "GET";

    private SecretKeySpec secretKeySpec = null;
    private Mac mac = null;

    // The construct is private since we'd rather use getInstance()
    private SignedRequestsHelper() {
    }

    public static SignedRequestsHelper getInstance(
            String awsSecretKey
    ) throws IllegalArgumentException, UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        if (null == awsSecretKey || awsSecretKey.length() == 0) {
            throw new IllegalArgumentException("awsSecretKey is null or empty");
        }

        SignedRequestsHelper instance = new SignedRequestsHelper();

        byte[] secretyKeyBytes = awsSecretKey.getBytes(UTF8_CHARSET);
        instance.secretKeySpec = new SecretKeySpec(secretyKeyBytes, HMAC_SHA256_ALGORITHM);
        instance.mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
        instance.mac.init(instance.secretKeySpec);

        return instance;
    }

    /**
     * This method signs requests in hashmap form. It returns a URL that should
     * be used to fetch the response. The URL returned should not be modified in
     * any way, doing so will invalidate the signature and Amazon will reject
     * the request.
     *
     * @param request Request @see Request
     * @return Request URL
     */
    public String sign(Request request) {
        // The parameters need to be processed in lexicographical order, so we'll
        // use a TreeMap implementation for that.
        SortedMap<String, String> sortedParamMap = new TreeMap<>(request.getParamsMap());

        // get the canonical form the query string
        String canonicalQS = this.canonicalize(sortedParamMap);

        // create the string upon which the signature is calculated 
        String toSign =
                REQUEST_METHOD + "\n"
                        + request.endPoint + "\n"
                        + REQUEST_URI + "\n"
                        + canonicalQS;

        // get the signature
        String hmac = hmac(toSign);
        String sig = percentEncodeRfc3986(hmac);

        // construct the URL
        return "http://" + request.endPoint + REQUEST_URI + "?" + canonicalQS + "&Signature=" + sig;
    }

    /**
     * Compute the HMAC.
     *
     * @param stringToSign String to compute the HMAC over.
     * @return base64-encoded hmac value.
     */
    private String hmac(String stringToSign) {
        String signature;
        byte[] data;
        byte[] rawHmac;
        try {
            data = stringToSign.getBytes(UTF8_CHARSET);
            rawHmac = mac.doFinal(data);
            Base64 encoder = new Base64();
            signature = new String(encoder.encode(rawHmac));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(UTF8_CHARSET + " is unsupported!", e);
        }
        return signature;
    }

    /**
     * Canonicalize the query string as required by Amazon.
     *
     * @param sortedParamMap Parameter name-value pairs in lexicographical order.
     * @return Canonical form of query string.
     */
    private String canonicalize(SortedMap<String, String> sortedParamMap) {
        if (sortedParamMap.isEmpty()) {
            return "";
        }

        StringBuilder buffer = new StringBuilder();
        Iterator<Map.Entry<String, String>> iter = sortedParamMap.entrySet().iterator();

        while (iter.hasNext()) {
            Map.Entry<String, String> kvpair = iter.next();
            buffer.append(percentEncodeRfc3986(kvpair.getKey()));
            buffer.append("=");
            buffer.append(percentEncodeRfc3986(kvpair.getValue()));
            if (iter.hasNext()) {
                buffer.append("&");
            }
        }
        return buffer.toString();
    }

    /**
     * Percent-encode values according the RFC 3986. The built-in Java
     * URLEncoder does not encode according to the RFC, so we make the
     * extra replacements.
     *
     * @param s decoded string
     * @return encoded string per RFC 3986
     */
    private String percentEncodeRfc3986(String s) {
        String out;
        try {
            out = URLEncoder.encode(s, UTF8_CHARSET)
                    .replace("+", "%20")
                    .replace("*", "%2A")
                    .replace("%7E", "~");
        } catch (UnsupportedEncodingException e) {
            out = s;
        }
        return out;
    }
}
