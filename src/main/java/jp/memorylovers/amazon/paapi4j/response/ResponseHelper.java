package jp.memorylovers.amazon.paapi4j.response;

import java.io.InputStreamReader;
import java.net.URL;

import org.simpleframework.xml.core.Persister;

import jp.memorylovers.amazon.paapi4j.exception.PAAPI4jException;
import jp.memorylovers.amazon.paapi4j.request.Request;

public class ResponseHelper {

    protected ResponseHelper() {
    }

    public Response getResponse(String operationName, String requestUrl)
            throws PAAPI4jException {
        try (InputStreamReader ir = new InputStreamReader(new URL(requestUrl)
            .openConnection()
            .getInputStream())) {
            return new Persister().read(Response.class, ir, false);
        } catch (Exception e) {
            throw new PAAPI4jException(e.getLocalizedMessage() + "\nurl is " + requestUrl, e);
        }
    }

    public Response getResponse(Request request) {
        String requestUrl = null;
        try {
            requestUrl = request.getRequestUrl();
            Response response = getResponse(request.operation(), requestUrl);
            if (response != null) {
                response.setRequest(request);
                response.setRequestUrl(requestUrl);
                return response;
            }
        } catch (Exception e) {
            if (requestUrl != null) System.err.println("URL:" + requestUrl);
            e.printStackTrace();
        }

        return null;
    }
}
