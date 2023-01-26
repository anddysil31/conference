package com.example.conference.service

import com.example.conference.model.Conference
import com.example.conference.model.Member
import com.example.conference.model.Register
import com.example.conference.repository.ConferenceRepository
import com.example.conference.repository.MemberRepository
import com.example.conference.repository.RegisterRepository
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File
import java.sql.Date
import java.sql.Time

@SpringBootTest
class RegisterServiceTest {
    @InjectMocks
    lateinit var registerService: RegisterService
    @Mock
    lateinit var registerRepository: RegisterRepository
    @Mock
    lateinit var memberRepository: MemberRepository
    @Mock
    lateinit var conferenceRepository: ConferenceRepository

//    val registerJsonResponse = File("./src/test/resources/register.json").readText(Charsets.UTF_8)
//    val registerMock: Register = Gson().fromJson(registerJsonResponse, Register::class.java)

    val registerMock = Register().apply {
        id= 1
        code= "12345"
        registeredAt= "Juan Garcia"
        assisted= true
        conferenceId= 1
        memberId= 1
    }
    val memberJsonResponse = File("./src/test/resources/member.json").readText(Charsets.UTF_8)
    val memberMock: Member = Gson().fromJson(memberJsonResponse, Member::class.java)
    val conferenceMock = Conference().apply {
        id= 1
        title= "Aventuras"
        speaker= "Juan"
        hour= Time.valueOf("10:30:30")
        day= Date.valueOf("2022-12-12")
        totalAttendees= 11
        eventId= 1
    }
    @Test
    fun saveRegisterWhenIsCorrect(){
        Mockito.`when`(memberRepository.findById(registerMock.memberId)).thenReturn(memberMock)
        Mockito.`when`(conferenceRepository.findById(registerMock.conferenceId)).thenReturn(conferenceMock)
        Mockito.`when`(registerRepository.save(Mockito.any(Register::class.java))).thenReturn(registerMock)
        val response = registerService.save(registerMock)
        Assertions.assertEquals(response.id, registerMock.id)
    }

}