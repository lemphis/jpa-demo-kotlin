package me.lemphis.jpademokotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JpaDemoKotlinApplication

fun main(args: Array<String>) {
	runApplication<JpaDemoKotlinApplication>(*args)
}
