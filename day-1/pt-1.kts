#!/usr/bin/env kscript

import java.io.File

fun fuel(mass: Int) = mass / 3 - 2

File("input.txt")
    .readLines()
    .map(String::toInt)      
    .map(::fuel)
    .sum()
    .let(::println)
