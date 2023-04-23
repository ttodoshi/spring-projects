package org.todoshis.springdatarest.entities_views;

import org.springframework.data.rest.core.config.Projection;
import org.todoshis.springdatarest.entities.User;

@Projection(name = "user-view", types = User.class)
public interface UserView {
    String getName();
    String getLastName();
    String getEmail();
}
