package com.github.for_the_win

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ForTheWinApplication

fun main(args: Array<String>) {
	runApplication<ForTheWinApplication>(*args)
}
