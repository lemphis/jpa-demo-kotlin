package me.lemphis.jpademokotlin.domain

import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
class Delivery(
	@Id
	@GeneratedValue
	@Column(name = "delivery_id")
	var id: Long? = null,

	@OneToOne(mappedBy = "delivery")
	var order: Order? = null,

	@Embedded
	var address: Address? = null,

	@Enumerated(EnumType.STRING)
	var status: DeliveryStatus? = null,
)
