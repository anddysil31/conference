package com.example.conference.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.sql.Date
import java.sql.Time

@Entity
@Table(name = "conference")
class Conference {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id:Long? = null
    @NotBlank(message = "Este campo no puede ser nulo")
    var title:String? = null
    @NotNull(message = "Este campo no puede ser nulo")
    var speaker:String? = null
    var hour:Time? = null
    var day: Date? = null
    @Column(name = "total_attendees")
    var totalAttendees: Long? = null
    @Column(name ="event_id")
    var eventId: Long? = null

}