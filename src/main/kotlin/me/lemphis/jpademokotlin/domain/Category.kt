package me.lemphis.jpademokotlin.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
class Category(
	@Id
	@GeneratedValue
	@Column(name = "category_id")
	var id: Long? = null,

	@ManyToMany
	@JoinTable(
		name = "category_item",
		joinColumns = [JoinColumn(name = "category_id")],
		inverseJoinColumns = [JoinColumn(name = "item_id")],
	)
	var items: MutableList<Item> = mutableListOf(),

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	var parent: Category? = null,

	@OneToMany(mappedBy = "parent")
	var child: MutableList<Category> = mutableListOf(),
) {

	fun addChildCategory(child: Category) {
		this.child.add(child)
		child.parent = this
	}

}
