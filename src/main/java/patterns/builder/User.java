package patterns.builder;


import lombok.ToString;

@ToString
public class User {



    private String name;
    private String city;
    private String email;

    private User(Builder builder) {
        this.name = builder.name;
        this.city = builder.city;
        this.email = builder.email;
    }

    public static class Builder {

        private String name;
        private String city;
        private String email;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}