package com.example

import io.micronaut.core.annotation.Introspected
import io.micronaut.http.annotation.*
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("com.example")
		.start()
}

data class Response1(
	val method: String,
	val origin: String,
	val url: String,
	val optionalValue: String = "x"
)

@Introspected
data class Response2(
	val method: String,
	val origin: String,
	val url: String,
	val optionalValue: String = "x"
)

@Client("https://httpbin.org")
interface HttpBin {
	@Post("/anything")
	suspend fun anything1(
		@Header someHeader: String
	): Response1

	@Post("/anything")
	suspend fun anything2(
		@Header someHeader: String
	): Response2
}

@Controller
class IndexController(
	private val httpBin: HttpBin
) {

	@Get("/it-works")
	suspend fun index1(): Response1 {
		return httpBin.anything1("someValue")
	}

	@Get("/it-does-not-work")
	suspend fun index2(): Response2 {
		return httpBin.anything2("someValue")
	}
}