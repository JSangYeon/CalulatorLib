package jsy.test.calulatorlib

import android.location.Location
import android.util.Log
import org.junit.Before
import org.junit.Test


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

        val startLocation = Location("startPoint")
//        37.5666805, 경도 126.9784147인
        startLocation.latitude = 37.5666805
        startLocation.longitude = 126.9784147

        val locationList = ArrayList<Location>()

        for( i in 0..5){
            val location = Location("listPoint$i")
            location.latitude = startLocation.latitude + (i*0.002)
            location.longitude = startLocation.latitude - (i*0.002)
            locationList.add(location)
        }
        println("listPoint, $locationList")

        distanceCalculator!!.shortestDistance(startLocation, locationList)
    }

}