package com.example.conference.service

import com.example.conference.model.Conference
import com.example.conference.model.Event
import com.example.conference.model.Member
import com.example.conference.repository.MemberRepository
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
class MemberServiceTest {
@InjectMocks
lateinit var memberService: MemberService
@Mock
lateinit var memberRepository: MemberRepository

    val memberJsonResponse = File("./src/test/resources/member.json").readText(Charsets.UTF_8)
    val memberMock: Member = Gson().fromJson(memberJsonResponse, Member::class.java)

    @Test
    fun saveWhenMemberIsCorrect(){
        Mockito.`when`(memberRepository.save(Mockito.any(Member::class.java) )).thenReturn(memberMock)
        val response = memberService.save(memberMock)
        Assertions.assertEquals(response.id, memberMock.id)
    }

}