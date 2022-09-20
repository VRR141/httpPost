import com.fasterxml.jackson.annotation.JsonProperty;

public class Post {

    private final String ID;
    private final String TEXT;
    private final String TYPE;
    private final String USER;
    private final Integer UPVOTES;

    public Post(
            @JsonProperty("id") String id,
            @JsonProperty("text") String text,
            @JsonProperty("type") String type,
            @JsonProperty("user") String user,
            @JsonProperty("upvotes") Integer upvotes
            ) {
        this.ID = id;
        this.TEXT = text;
        this. TYPE = type;
        this.USER = user;
        this.UPVOTES = upvotes;
    }

    public Integer getUpvotes(){
        return UPVOTES;
    }

    @Override
    public String toString() {
        return "Post{\n" +
                "id:" + ID +
                "\n text: " + TEXT +
                "\n type: " + TYPE +
                "\n user: " + USER +
                "\n upvotes: " + UPVOTES +
                "\n}";
    }

}
