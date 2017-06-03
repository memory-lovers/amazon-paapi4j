package jp.memorylovers.amazon.paapi4j.response;

import org.simpleframework.xml.core.Persister;

import jp.memorylovers.amazon.paapi4j.exception.PAAPI4jException;
import jp.memorylovers.amazon.paapi4j.request.Request;
import okhttp3.OkHttpClient;

public class ResponseHelper {

    protected Request request;

    protected Response readResponse() throws Exception {
        String requestUrl = request.getRequestUrl();

        OkHttpClient client = new OkHttpClient();
        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(requestUrl)
                .build();

        try (okhttp3.Response response = client.newCall(request).execute()) {
            return deserialize(response.body().string());
        } catch (Exception e) {
            throw e;
        }
    }

    protected Response deserialize(String responseBodsy) throws Exception {
        return new Persister().read(Response.class, responseBodsy, false);
    }

    public Response getResponse(Request request) throws PAAPI4jException {

        try {
            this.request = request;
            Response response = readResponse();
            if (response != null) {
                response.setRequest(request);
                response.setRequestUrl(request.getRequestUrl());
                return response;
            }
        } catch (Exception e) {
            String url = request.getRequestUrl();
            String msg = e.getLocalizedMessage() + "\nurl is " + url;
            throw new PAAPI4jException(msg, e);
        }
        return null;
    }
}
