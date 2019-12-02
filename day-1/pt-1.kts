#!/usr/bin/env kscript

import java.io.File

fun fuel(mass: Double) = Math.floor(mass / 3) - 2

File("audit-smaller-sorted.txt")
    .readLines()
    .map(String::toDouble)      
    .map(::fuel)
    .sum()
    .let(::println)
