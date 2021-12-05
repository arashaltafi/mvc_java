package com.arash.altafi.mvc.models;

import android.text.TextUtils;
import android.util.Patterns;

public class User implements IUser {

    String email , password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public int inValid() {

        // 0. Check for Email Empty
        // 1. Check for Email Match pattern
        // 2. Check for Password < 6

        if (TextUtils.isEmpty(email)) {
            return 0;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return 1;
        }
        else if (TextUtils.isEmpty(password)) {
            return 2;
        }
        else if (password.length() <= 6) {
            return 3;
        }
        else {
            return -1;
        }

    }

}
