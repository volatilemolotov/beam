import org.apache.beam.sdk.schemas.JavaFieldSchema;
import org.apache.beam.sdk.schemas.annotations.DefaultSchema;
import org.apache.beam.sdk.schemas.annotations.SchemaCreate;

@DefaultSchema(JavaFieldSchema.class)
public class User {
    public Long userId;
    public String userName;
    public String userSurname;

    public Location location;

    @SchemaCreate
    public User(Long userId, String userName, String userSurname, Location location) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userId = userId;
        this.location = location;
    }
}
