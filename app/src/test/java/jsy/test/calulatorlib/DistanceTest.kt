package jsy.test.calulatorlib

import android.location.Location
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito.mock


class DistanceTest {

    private val logTag = javaClass.simpleName
    private var distanceCalculator: DistanceCalculator? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {

        println("setUp");
        distanceCalculator = DistanceCalculator()
    }

    @Test
    fun testShortestLocation() {
        println("testShortestLocation");
        if(distanceCalculator==null) return;

        val latitude = 37.5666805
        val longitude = 126.9784147

        val mockLocation = mock(Location::class.java)
        given(mockLocation.latitude).willReturn(latitude)
        given(mockLocation.longitude).willReturn(longitude)
        val locationList = ArrayList<Location>()

        for( i in 0..5){

            val mockLocation = mock(Location::class.java)
            given(mockLocation.latitude).willReturn(latitude + ((i+1)*0.002))
            given(mockLocation.longitude).willReturn(longitude - ((i+1)*0.002))
            locationList.add(mockLocation)


        }

        distanceCalculator!!.shortestDistance(mockLocation, locationList)
    }

}