package me.lemphis.jpademokotlin.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "order_item")
class OrderItem(
	@Id
	@GeneratedValue
	@Column(name = "order_item_id")
	var id: Long? = null,

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id")
	var item: Item? = null,

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	var order: Order? = null,

	var orderPrice: Int? = null,

	var count: Int? = null,
)
