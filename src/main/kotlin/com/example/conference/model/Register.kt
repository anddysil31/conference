package com.example.conference.model

import jakarta.persistence.*

@Entity
@Table(name="register")
class Register {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id:Long? = null
    var code:String? = null
    @Column(name="registered_at")
    var registeredAt:String? = null
    @Column(columnDefinition = "BIT")
    var assisted:Boolean? = null
    @Column(name = "conference_id")
    var conferenceId:Long?=null
    @Column(name = "member_id")
    var memberId:Long?=null



}