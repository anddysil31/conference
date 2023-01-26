package com.example.conference.repository

import com.example.conference.model.Event
import com.example.conference.model.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface EventRepository:JpaRepository<Event, Long> {
    fun findById(id:Long?): Event?


}