import org.apache.beam.sdk.schemas.JavaFieldSchema;
import org.apache.beam.sdk.schemas.annotations.DefaultSchema;
import org.apache.beam.sdk.schemas.annotations.SchemaCreate;

@DefaultSchema(JavaFieldSchema.class)
public class Location {
    public Long userId;
    public double latitude;
    public double longtitude;

    @SchemaCreate
    public Location(Long userId, double latitude, double longtitude) {
        this.userId = userId;
        this.latitude = latitude;
        this.longtitude = longtitude;
    }
}
