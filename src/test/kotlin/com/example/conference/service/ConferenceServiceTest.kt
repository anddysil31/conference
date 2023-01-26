package com.example.conference.service

import com.example.conference.model.Conference
import com.example.conference.model.Event
import com.example.conference.repository.ConferenceRepository
import com.example.conference.repository.EventRepository
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
import java.time.LocalTime

@SpringBootTest
class ConferenceServiceTest {
@InjectMocks
lateinit var conferenceService: ConferenceService

@Mock
lateinit var conferenceRepository: ConferenceRepository

@Mock
lateinit var eventRepository: EventRepository

    val eventJsonResponse = File("./src/test/resources/event.json").readText(Charsets.UTF_8)
    val eventMock:Event = Gson().fromJson(eventJsonResponse, Event::class.java)

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
    fun saveWhenConferenceIsCorrect(){
        Mockito.`when`(eventRepository.findById(conferenceMock.eventId)).thenReturn(eventMock)
        Mockito.`when`(conferenceRepository.save(Mockito.any(Conference::class.java) )).thenReturn(conferenceMock)
        val response = conferenceService.save(conferenceMock)
        Assertions.assertEquals(response.id, conferenceMock.id)
    }


}