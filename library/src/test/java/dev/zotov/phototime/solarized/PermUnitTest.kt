package dev.zotov.phototime.solarized

import org.junit.Test
import java.time.Instant
import java.time.ZoneOffset

class PermUnitTest  {

    private val date = Instant.ofEpochSecond(1651679484).atZone(ZoneOffset.UTC).toLocalDateTime()
    private val latitude = 58.000000
    private val longitude = 56.316666
    private val solarized = Solarized(latitude, longitude, date)

    @Test
    fun `Morning blur hour`() {
        solarized.blueHour.morning!!.assertTime("04:06-04:46")
    }

    @Test
    fun sunrise() {
        solarized.sunrise!!.assertTime("05:16")
    }

    @Test
    fun `Morning golden hour`() {
        solarized.goldenHour.morning!!.assertTime("04:46-06:13")
    }

    @Test
    fun day() {
        solarized.day!!.assertTime("06:13-20:10")
    }

    @Test
    fun `Evening golden hour`() {
        solarized.goldenHour.evening!!.assertTime("20:10-21:37")
    }

    @Test
    fun sunset() {
        solarized.sunset!!.assertTime("21:05")
    }

    @Test
    fun `Evening blue hour`() {
        solarized.blueHour.evening!!.assertTime("21:37-22:18")
    }
}