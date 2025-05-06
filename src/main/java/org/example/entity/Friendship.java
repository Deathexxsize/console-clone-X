package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Entity
@Table(name = "friendship")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Кто отправил запрос
    @ManyToOne
    @JoinColumn(name = "requester_id", nullable = false)
    private User requester;

    // Кто получил запрос
    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private User receiver;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private FriendshipStatus status;

    private LocalDateTime requestedAt;
    private LocalDateTime acceptedAt;
}
