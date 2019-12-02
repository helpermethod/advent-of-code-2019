#!/usr/bin/env kscript

import java.io.File

fun fuel(mass: Double) = Math.floor(mass / 3) - 2

tailrec fun fuelRec(mass: Double, acc: Double = 0.0): Double {
    val amount = fuel(mass)

    return if (amount <= 0.0) acc else fuelRec(amount, acc + amount)
}

File("audit-smaller-sorted.txt")
    .readLines()
    .map(String::toDouble)      
    .map(::fuel)
    .map { it + fuelRec(it) }
    .sum()
    .let(::println)
