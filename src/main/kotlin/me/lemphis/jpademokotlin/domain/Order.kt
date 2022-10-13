package me.lemphis.jpademokotlin.domain

import java.time.LocalDateTime
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table


@Entity
@Table(name = "orders")
class Order(
	@Id
	@GeneratedValue
	@Column(name = "order_id")
	var id: Long? = null,

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	var member: Member? = null,

	@OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
	val orderItems: MutableList<OrderItem> = mutableListOf(),

	@OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	@JoinColumn(name = "delivery_id")
	var delivery: Delivery? = null,

	var orderDate: LocalDateTime? = null,

	@Enumerated(EnumType.STRING)
	var status: OrderStatus? = null,
) {

	fun updateMember(member: Member) {
		this.member = member
		member.orders.add(this)
	}

	fun addOrderItem(orderItem: OrderItem) {
		orderItems.add(orderItem)
		orderItem.order = this
	}

	fun updateDelivery(delivery: Delivery) {
		this.delivery = delivery
		delivery.order = this
	}

}
