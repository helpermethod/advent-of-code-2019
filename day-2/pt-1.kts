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

    positions[positions[start + 3]] = op(positions[positions[start + 1]], positions[positions[start + 2]])

    return compute(positions, start + 4)
}

File("input.txt")
    .readText()
    .trimEnd()
    .split(",")
    .map(String::toInt)
    .mapIndexed { i, e ->
        when(i) {
            1 -> 12
            2 -> 2
            else -> e
        }
    }
    .let { compute(it.toMutableList()) }
    .let { println(it[0]) }
