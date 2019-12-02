#!/usr/bin/env kscript

import java.io.File

File("audit-smaller-sorted.txt")
    .readLines()
    .map(String::toDouble)      
    .map { Math.floor(it / 3) - 2 }
    .sum()
    .let { println(it)}
