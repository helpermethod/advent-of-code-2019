#!/usr/bin/env kscript

import java.io.File

fun fuel(mass: Int) = mass / 3 - 2

File("audit-smaller-sorted.txt")
    .readLines()
    .map(String::toInt)      
    .map(::fuel)
    .sum()
    .let(::println)
