package com.saha.testapplication

import oshi.SystemInfo
import kotlin.math.roundToInt

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class BatteryManager {
    actual fun getBatteryLevel(): Int {
        val systemInfo = SystemInfo()
        val powerSources = systemInfo.hardware.powerSources
            .onEach { it.updateAttributes() }

        // OSHI can expose placeholder battery entries on some desktops/laptops.
        // Prefer mathematically stable values from current/max capacity when available.
        val validByCapacity = powerSources.filter {
            it.maxCapacity > 1 && it.currentCapacity >= 0 && it.currentCapacity <= it.maxCapacity
        }
        if (validByCapacity.isNotEmpty()) {
            val totalCurrent = validByCapacity.sumOf { it.currentCapacity }
            val totalMax = validByCapacity.sumOf { it.maxCapacity }
            if (totalMax > 0) {
                return ((totalCurrent.toDouble() / totalMax.toDouble()) * 100).roundToInt()
            }
        }

        val validByPercent = powerSources
            .map { it.remainingCapacityPercent }
            .filter { it in 0.0..1.0 }
        if (validByPercent.isEmpty()) return -1

        // Fallback to average percent if capacities are not available.
        return (validByPercent.average() * 100).roundToInt()
    }
}