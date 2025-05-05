package org.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendshipDao extends JpaRepository<FriendshipDao, Integer> {
}
