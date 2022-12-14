import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.IOException;
import java.util.List;

public class Main {

    public static final String URL = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        GetPosts getPosts = new GetPosts(URL);
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
