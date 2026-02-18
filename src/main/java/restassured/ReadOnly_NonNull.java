package restassured;

public class ReadOnly_NonNull {

    //public enum Access {
    //    AUTO,           // Default - both read and write
    //    READ_ONLY,      // Only deserialize (JSON → Java), don't serialize (Java → JSON)
    //    WRITE_ONLY,     // Only serialize (Java → JSON), don't deserialize (JSON → Java)
    //    READ_WRITE      // Both directions (same as AUTO)
    //}

    //This annotation tells Jackson (the JSON serialization library) that a field should only be included when reading/deserializing JSON (converting JSON → Java object), but NOT when writing/serializing JSON (converting Java object → JSON).
    //Practical Example
    //java@Data
    //@Builder
    //public class User {
    //
    //    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    //    private String id;
    //
    //    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    //    private String createdAt;
    //
    //    private String name;
    //    private String email;
    //}



    //@JsonProperty(access = READ_ONLY) means:
    //
    //✅ Receive this field from API responses
    //❌ Don't send this field in API requests
    //Perfect for server-generated fields like: id, createdAt, updatedAt, computed values


    //@Data
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    //public class User {
    //    private String id;  // If null, excluded from JSON
    //    private String createdAt;  // If null, excluded from JSON
    //    private String name;
    //    private String email;
    //}


}
