import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class GetPosts {

    private final String url;

    public GetPosts(String url){
        this.url = url;
    }

    private CloseableHttpClient createHttpClient(){
        return HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.DEFAULT)
                .build();
    }

    private HttpGet createRequest(){
        HttpGet request = new HttpGet(url);
        request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
        return request;
    }

    public CloseableHttpResponse createHttpResponse() throws IOException {
        return createHttpClient().execute(createRequest());
    }

}
