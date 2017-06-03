package jp.memorylovers.amazon.paapi4j;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.simpleframework.xml.core.Persister;

import jp.memorylovers.amazon.paapi4j.request.RequestItemLookup;
import jp.memorylovers.amazon.paapi4j.request.RequestItemSearch;
import jp.memorylovers.amazon.paapi4j.response.Response;
import jp.memorylovers.amazon.paapi4j.response.ResponseHelper;
import jp.memorylovers.amazon.paapi4j.utils.Utils;

public class DebugResponseHelper extends ResponseHelper {
    private static final String OUTPUT_DIR = "out";

    protected DebugResponseHelper() {
    }

    protected Response readResponse() throws Exception {
        String requestUrl = request.getRequestUrl();
        try (InputStream is = new URL(requestUrl).openConnection()
            .getInputStream()) {
            File outFile = dumpFile(is);
            return new Persister().read(Response.class, outFile, false);
        } catch (Exception e) {
            throw e;
        }
    }

    private File dumpFile(InputStream is) throws IOException {
        File outDir = new File(OUTPUT_DIR);

        if (!outDir.exists()) {
            outDir.mkdir();
        }

        StringBuilder sb = new StringBuilder();
        sb.append(request.operation());
        sb.append("_");

        if (request instanceof RequestItemLookup) {
            sb.append(((RequestItemLookup) request).getResponseGroup());
            sb.append("_");
        } else if (request instanceof RequestItemSearch) {
            sb.append(((RequestItemLookup) request).getResponseGroup());
            sb.append("_");
        }

        sb.append(Utils.getCurDateTIme());
        sb.append(".xml");

        File outFile = new File(outDir, sb.toString());

        System.out.println("output: " + outFile.getAbsolutePath());
        Files.copy(is, outFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

        return outFile;
    }
}
