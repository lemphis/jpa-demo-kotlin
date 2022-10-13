package me.lemphis.jpademokotlin.domain

import javax.persistence.Column
import javax.persistence.DiscriminatorColumn
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.InheritanceType
import javax.persistence.ManyToMany

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
abstract class Item(
	@Id
	@GeneratedValue
	@Column(name = "item_id")
	var id: Long? = null,

	var name: String? = null,

	var price: Int? = null,

	var stockQuantity: Int? = null,

	@ManyToMany(mappedBy = "items")
	var categories: MutableList<Category> = mutableListOf(),
)
