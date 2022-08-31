package com.calendar.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "MeetingEntity")
@Table(name = "meetings", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MeetingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "meeting_name", nullable = false)
    private String meeting_name;

    @Column(name = "description")
    private String description;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date", nullable = false)
    private Timestamp date;

    @Column(name = "time", nullable = false)
    private Timestamp time;
}
