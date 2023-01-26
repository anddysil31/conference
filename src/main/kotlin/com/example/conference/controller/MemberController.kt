package com.example.conference.controller

import com.example.conference.model.Member
import com.example.conference.service.MemberService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/member")
class MemberController {
    @Autowired
    lateinit var memberService: MemberService
//
//    @GetMapping
//    fun list():List<Member>{
//        return memberService.list()
//    }
    @GetMapping
    fun list(pageable: Pageable, member: Member):ResponseEntity<*>{
        val response = memberService.list(pageable,member)
        return ResponseEntity(response, HttpStatus.OK)
    }
//    @GetMapping
//    fun list(member: Member, pageable: Pageable):ResponseEntity<*>{
//        val response = memberService.list(pageable, member)
//        return ResponseEntity(response, HttpStatus.ACCEPTED)
//    }

    @GetMapping("/{id}")
    fun listById(@PathVariable("id") id:Long):ResponseEntity<Member>{
        return ResponseEntity(memberService.listById(id), HttpStatus.ACCEPTED)
    }
    @PostMapping
    fun save(@RequestBody @Valid member: Member): ResponseEntity<Member>?{
        return ResponseEntity(memberService.save(member), HttpStatus.ACCEPTED)

    }

    @PutMapping
    fun update(@RequestBody member:Member): ResponseEntity<Member> {
        return ResponseEntity(memberService.update(member), HttpStatus.ACCEPTED)
    }

    @PatchMapping
    fun updateName(@RequestBody member:Member): ResponseEntity<Member> {
        return ResponseEntity(memberService.updateName(member), HttpStatus.ACCEPTED)
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long):Boolean?{
        return memberService.delete(id)
    }

}