package org.todoshis.springdatarest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.todoshis.springdatarest.entities.User;
import org.todoshis.springdatarest.entities_views.UserView;

import java.util.List;

@RepositoryRestResource(excerptProjection = UserView.class)
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(@Param("name") String name);
}
