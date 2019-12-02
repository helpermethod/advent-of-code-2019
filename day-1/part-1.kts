#!/usr/bin/env kscript
import java.io.File

val sum = 
    File("audit-smaller-sorted.txt")
        .readLines()
        .map(String::toDouble)      
        .map { Math.floor(it / 3) - 2 }
        .sum()

println("$sum")
