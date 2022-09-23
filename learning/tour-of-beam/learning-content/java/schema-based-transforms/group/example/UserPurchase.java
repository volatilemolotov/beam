import org.apache.beam.sdk.schemas.JavaFieldSchema;
import org.apache.beam.sdk.schemas.annotations.DefaultSchema;
import org.apache.beam.sdk.schemas.annotations.SchemaCreate;


@DefaultSchema(JavaFieldSchema.class)
public class UserPurchase {
    public Long userId;
    public String country;
    public long cost;
    public double transactionDuration;

    @SchemaCreate
    public UserPurchase(Long userId, String country, long cost, double transactionDuration) {
        this.userId = userId;
        this.country = country;
        this.cost = cost;
        this.transactionDuration = transactionDuration;
    }
}