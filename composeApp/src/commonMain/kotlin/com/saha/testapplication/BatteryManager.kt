package com.saha.testapplication

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class BatteryManager {
    fun getBatteryLevel(): Int
}