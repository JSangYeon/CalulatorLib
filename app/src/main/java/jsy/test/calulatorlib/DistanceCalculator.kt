package jsy.test.calulatorlib

import android.location.Location
import android.util.Log

class DistanceCalculator {

    private val logTag = javaClass.simpleName


    fun shortestDistance(point: Location, pointList: ArrayList<Location>) : Float {

        Log.d(logTag, "shortestDistance");

        var minDistance = 10000000000f;

        Log.d(logTag, "point : $point\npointList : $pointList");
        pointList.forEach { location ->
            val distance = point.distanceTo(location)

            println("distance : $distance")

            if (distance < minDistance) minDistance = distance
        }

        return minDistance
    }


}