package com.example.conference.repository

import com.example.conference.model.Conference
import com.example.conference.model.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ConferenceRepository:JpaRepository<Conference, Long> {
    fun findById(id:Long?):Conference?

    @Query(nativeQuery = true)
    fun sumParticipants(@Param("eventId") eventId:Long?):Long?
}