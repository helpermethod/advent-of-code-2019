#!/usr/bin/env kscript

import java.io.File

fun plus(a: Int, b: Int) = a + b
fun times(a: Int, b: Int) = a * b

tailrec fun compute(positions: MutableList<Int>, start: Int = 0): MutableList<Int> {
    if (positions[start] == 99) return positions

    val op = when(positions[start]) {
        1 -> ::plus
        2 -> ::times
        else -> throw AssertionError("Unknown opcode")
    }

    positions[start + 3] = op(positions[start + 1], positions[start + 2])

    return compute(positions, start + 4)
}
val positions = 
    File("input.txt")
        .readText()
        .split(",")
        .map(String::toInt)
        .toMutableList()

println(compute(positions))
