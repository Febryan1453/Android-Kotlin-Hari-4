package com.febryan.sholat.model

import com.google.gson.annotations.SerializedName

data class ResponseJadwalSholat(

	@field:SerializedName("jadwal")
	val jadwal: Jadwal? = null,

	@field:SerializedName("query")
	val query: Query? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class Query(

	@field:SerializedName("kota")
	val kota: String? = null,

	@field:SerializedName("format")
	val format: String? = null,

	@field:SerializedName("tanggal")
	val tanggal: String? = null
)

data class Jadwal(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class Data(

	@field:SerializedName("imsak")
	val imsak: String? = null,

	@field:SerializedName("isya")
	val isya: String? = null,

	@field:SerializedName("dzuhur")
	val dzuhur: String? = null,

	@field:SerializedName("dhuha")
	val dhuha: String? = null,

	@field:SerializedName("subuh")
	val subuh: String? = null,

	@field:SerializedName("terbit")
	val terbit: String? = null,

	@field:SerializedName("ashar")
	val ashar: String? = null,

	@field:SerializedName("tanggal")
	val tanggal: String? = null,

	@field:SerializedName("maghrib")
	val maghrib: String? = null
)
