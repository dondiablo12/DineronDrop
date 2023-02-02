package me.diablo.dineron.drop.object.util;

import com.google.common.collect.Sets;
import me.diablo.dineron.drop.object.User;

import java.util.Set;

public class UserUtil {

    private static final Set<User> USERS = Sets.newConcurrentHashSet();

    public static Set<User> getUsers() {
        return USERS;
    }

    protected void addUser(User user) {
        USERS.add(user);
    }
}