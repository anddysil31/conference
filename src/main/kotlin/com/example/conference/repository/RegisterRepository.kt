package com.example.conference.repository

import com.example.conference.model.Member
import com.example.conference.model.Register
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface RegisterRepository:JpaRepository<Register, Long> {
    fun findById(id:Long?): Register?

    @Query(nativeQuery = true)
    fun allConferences(@Param("mid") mid:Long?):Any?
}