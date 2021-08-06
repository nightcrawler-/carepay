package com.carepay.assignment.repository;

import com.carepay.assignment.domain.PostDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostDetails, Long> {
}
