package com.example.conference.repository

import com.example.conference.model.Member
import org.springframework.data.jpa.repository.JpaRepository

import org.springframework.stereotype.Repository

@Repository
interface MemberRepository:JpaRepository<Member, Long> {
    fun findById(id:Long?):Member?


}