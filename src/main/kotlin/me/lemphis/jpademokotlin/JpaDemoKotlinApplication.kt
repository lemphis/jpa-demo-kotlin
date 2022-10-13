package me.lemphis.jpademokotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@EntityScan(basePackages = ["me.lemphis.jpademokotlin.domain"])
@SpringBootApplication
class JpaDemoKotlinApplication

fun main(args: Array<String>) {
	runApplication<JpaDemoKotlinApplication>(*args)
}
