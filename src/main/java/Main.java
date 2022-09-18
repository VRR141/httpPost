import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.IOException;
import java.util.List;

public class Main {

    private static final String url = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";
    private static final ObjectMapper objectMapper = new ObjectMapper();


    public static void main(String[] args) {
        GetPosts getPosts = new GetPosts(url);
        try (CloseableHttpResponse response = getPosts.createHttpResponse()) {
            List<Post> posts = objectMapper
                    .readValue(response.getEntity().getContent(), new TypeReference<>() {
            });
            posts.stream().
                    filter(post -> post.getUpvotes() != null && post.getUpvotes() > 0)
                    .forEach(System.out::println);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
