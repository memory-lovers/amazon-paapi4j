package jp.memorylovers.amazon.paapi4j.response;

import com.sun.istack.internal.Nullable;
import jp.memorylovers.amazon.paapi4j.request.Request;
import jp.memorylovers.amazon.paapi4j.request.SignedRequestsHelper;
import org.simpleframework.xml.core.Persister;

import java.io.InputStreamReader;
import java.net.URL;


public class ResponseHelper {

    private ResponseHelper() {
    }

    @Nullable
    public static Response getResponse(String requestUrl) {
        try (InputStreamReader ir = new InputStreamReader(
                new URL(requestUrl).openConnection().getInputStream())
        ) {
            return new Persister().read(Response.class, ir, false);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    public static Response getResponse(Request request) {
        try {
            String requestUrl = SignedRequestsHelper.getInstance(request.getSecretKey()).sign(request);
            Response response = getResponse(requestUrl);
            if (response != null) {
                response.setRequest(request);
                return response;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
