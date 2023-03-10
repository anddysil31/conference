package com.example.conference.model

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name="event")
class Event {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id:Long? = null
    var description:String? = null
    @Column(name = "start_date")
    var startDate:Date? = null
    @Column(name = "end_date")
    var endDate:Date? = null
    @Column(name = "total_attendees")
    var totalAttendees: Long? = null

    var place:String? = null

}