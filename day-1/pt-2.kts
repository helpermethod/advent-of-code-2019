#!/usr/bin/env kscript

import java.io.File

fun fuel(mass: Int) = mass / 3 - 2

tailrec fun fuelRec(mass: Int, acc: Int = 0): Int {
    val amount = fuel(mass)

    return if (amount <= 0) acc else fuelRec(amount, acc + amount)
}

File("input.txt")
    .readLines()
    .map(String::toInt)      
    .map(::fuel)
    .map { it + fuelRec(it) }
    .sum()
    .let(::println)
