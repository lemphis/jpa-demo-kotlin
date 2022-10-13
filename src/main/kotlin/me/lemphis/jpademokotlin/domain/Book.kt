package me.lemphis.jpademokotlin.domain

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("B")
class Book(
	var author: String? = null,
	var idbn: String? = null,
) : Item()
