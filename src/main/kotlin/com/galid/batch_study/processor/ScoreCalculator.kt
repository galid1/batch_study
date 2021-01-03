package com.galid.batch_study.processor

interface ScoreCalculator<T> {
    fun calculate(t: T): Double
}