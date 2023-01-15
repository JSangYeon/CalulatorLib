package jsy.test.calulatorlib

import android.location.Location
import kotlin.math.pow
import kotlin.math.sqrt

class DistanceCalculator {

    private val logTag = javaClass.simpleName


    fun shortestDistance(point: Location, pointList: ArrayList<Location>) {

        var minDistance = 10000000000f;
        var maxDistance = 0f;

        pointList.forEach { location ->
            val distance = getDistance(point, location)
            getDistance(point,location)

            println("distance : $distance")

            if (distance < minDistance) minDistance = distance
            if (distance > maxDistance) maxDistance = distance
        }


        println("minDistance : $minDistance, maxDistance : $maxDistance")

    }

    private fun getDistance(location1: Location, location2:Location): Float {

        val x1 = location1.latitude
        val y1 = location1.longitude
        val x2 = location2.latitude
        val y2 = location2.longitude

        // Math.pow() <- 제곱
        // Math.sqrt() <- 루트
        val d: Float
        val yd: Double = (y2 - y1).pow(2.0)
        val xd: Double = (x2 - x1).pow(2.0)
        d = sqrt((yd + xd)).toFloat()
        return d
    }


}