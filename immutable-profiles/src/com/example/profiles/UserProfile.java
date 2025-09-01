package com.example.profiles;

/**
 * Mutable and confusing. Multiple constructors + setters.
 */
public class UserProfile {
    private final String id;
    private final String email;
    private final String phone;
    private final String displayName;
    private final String address;
    private final boolean marketingOptIn;
    private final String twitter;
    private final String github;

    private UserProfile(UserProfileBuilder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.phone = builder.phone;
        this.displayName = builder.displayName;
        this.address = builder.address;
        this.marketingOptIn = builder.marketingOptIn;
        this.twitter = builder.twitter;
        this.github = builder.github;
    }

    // getters
    public String getId() { return id; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getDisplayName() { return displayName; }
    public String getAddress() { return address; }
    public boolean isMarketingOptIn() { return marketingOptIn; }
    public String getTwitter() { return twitter; }
    public String getGithub() { return github; }

    public static UserProfileBuilder builder() {
        return new UserProfileBuilder();
    }

    public static class UserProfileBuilder {
        private String id;
        private String email;
        private String phone;
        private String displayName;
        private String address;
        private boolean marketingOptIn;
        private String twitter;
        private String github;

        public UserProfileBuilder id(String id) {
            this.id = id;
            return this;
        }

        public UserProfileBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserProfileBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserProfileBuilder displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public UserProfileBuilder address(String address) {
            this.address = address;
            return this;
        }

        public UserProfileBuilder marketingOptIn(boolean marketingOptIn) {
            this.marketingOptIn = marketingOptIn;
            return this;
        }

        public UserProfileBuilder twitter(String twitter) {
            this.twitter = twitter;
            return this;
        }

        public UserProfileBuilder github(String github) {
            this.github = github;
            return this;
        }

        public UserProfile build() {
            Validation.requireNonBlank(id, "id");
            Validation.requireEmail(email);
            // displayName validation, copied from ProfileService.updateDisplayName
            if (displayName != null && displayName.length() > 100) {
                // silently trim (inconsistent policy)
                this.displayName = displayName.substring(0, 100);
            }
            return new UserProfile(this);
        }
    }
}
