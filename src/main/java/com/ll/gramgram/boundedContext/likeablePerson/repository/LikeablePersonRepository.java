package com.ll.gramgram.boundedContext.likeablePerson.repository;


import com.ll.gramgram.boundedContext.likeablePerson.entity.LikeablePerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

<<<<<<< HEAD
public interface LikeablePersonRepository extends JpaRepository<LikeablePerson, Long>, LikeablePersonRepositoryCustom {
=======

public interface LikeablePersonRepository extends JpaRepository<LikeablePerson, Long> {
>>>>>>> d35a9ff3bbc13b200aa43b6c4cca9c289cda3493
    List<LikeablePerson> findByFromInstaMemberId(Long fromInstaMemberId);

    List<LikeablePerson> findByToInstaMember_username(String username);

    LikeablePerson findByFromInstaMemberIdAndToInstaMember_username(long fromInstaMemberId, String username);
<<<<<<< HEAD

    Optional<LikeablePerson> findByFromInstaMember_usernameAndToInstaMember_username(String fromInstaMemberUsername, String toInstaMemberUsername);
=======
>>>>>>> d35a9ff3bbc13b200aa43b6c4cca9c289cda3493
}
