package org.example.dao;

import org.example.entity.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendshipDao extends JpaRepository<Friendship, Integer> {
}
