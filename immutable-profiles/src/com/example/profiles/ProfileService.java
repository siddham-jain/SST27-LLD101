package com.example.profiles;

import java.util.Objects;

/**
 * Assembles profiles with scattered, inconsistent validation.
 */
public class ProfileService {

    // returns a fully built profile but mutates it afterwards (bug-friendly)
    public UserProfile createMinimal(String id, String email) {
        return UserProfile.builder().id(id).email(email).build();
    }

    // updateDisplayName removed as UserProfile is immutable
}
