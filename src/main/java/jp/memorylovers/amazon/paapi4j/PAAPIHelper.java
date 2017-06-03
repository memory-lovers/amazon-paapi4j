package jp.memorylovers.amazon.paapi4j;

import jp.memorylovers.amazon.paapi4j.request.Request;
import jp.memorylovers.amazon.paapi4j.request.sign.SignedRequestsHelper;
import jp.memorylovers.amazon.paapi4j.response.Response;
import jp.memorylovers.amazon.paapi4j.response.ResponseHelper;
import jp.memorylovers.amazon.paapi4j.utils.Utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class PAAPIHelper {

    static Response getResponse(Request request) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        String requestUrl = SignedRequestsHelper.getInstance(request.getSecretKey()).sign(request);
        Response response = ResponseHelper.getResponse(requestUrl);
        if (response != null) {
            response.setRequest(request);
            return response;
        } else {
            throw new NullPointerException();
        }
    }

    private static Map<String, String> gainParams(Calendar calendar, String publisher, int page) {
        Map<String, String> params = gainParams(calendar, page);
        params.put("Publisher", publisher);
        return params;
    }

    private static Map<String, String> gainParams(Calendar calendar, int page) {
        Map<String, String> params = gainCommonParams(page);
        params.put("Power", "pubdate:" + Utils.format(calendar));
        return params;
    }

    private static Map<String, String> gainCommonParams(int page) {
        Map<String, String> params = gainCommonParams();
        params.put("ItemPage", Integer.toString(page));
        return params;
    }

    private static Map<String, String> gainCommonParams() {
        Map<String, String> params = new HashMap<>();
        params.put("Service", "AWSECommerceService");
        params.put("Version", "2013-08-01");
        params.put("Operation", "ItemSearch");
        params.put("SearchIndex", "Books");
        params.put("ResponseGroup", "Medium");
        params.put("AssociateTag", "toshokan06a-22");
        params.put("Condition", "New");
        params.put("MerchantId", "Amazon");
        params.put("BrowseNode", "2278488051");
        params.put("VariationPage", "0");
        return params;
    }
}
