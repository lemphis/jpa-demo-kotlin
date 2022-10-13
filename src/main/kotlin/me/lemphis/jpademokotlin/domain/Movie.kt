package me.lemphis.jpademokotlin.domain

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("M")
class Movie(
	var director: String? = null,
	var actor: String? = null,
) : Item()
