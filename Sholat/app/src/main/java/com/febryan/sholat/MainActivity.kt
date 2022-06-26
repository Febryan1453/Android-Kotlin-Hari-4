package com.febryan.sholat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.febryan.sholat.api.ApiConfig
import com.febryan.sholat.databinding.ActivityMainBinding
import com.febryan.sholat.model.ResponseJadwalSholat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataJadwalSholat("667", getCurrentDate())

    }

    private fun getDataJadwalSholat(kota: String, tanggal: String) {
        ApiConfig.getService().getJadwalSholat(kota, tanggal).enqueue(object : Callback<ResponseJadwalSholat>{
            override fun onResponse(call: Call<ResponseJadwalSholat>, response: Response<ResponseJadwalSholat>) {
                if (response.isSuccessful){
                    val dataJadwalSholat = response.body()
                    val jadwal = dataJadwalSholat?.jadwal
                    val data = jadwal?.data

                    binding.tvSubuh.text = data?.subuh
                    binding.tvTerbit.text = data?.terbit
                    binding.tvDhuha.text = data?.dhuha
                    binding.tvDzuhur.text = data?.dzuhur
                    binding.tvAshar.text = data?.ashar
                    binding.tvMagrib.text = data?.maghrib
                    binding.tvIsya.text = data?.isya
                    binding.tvTanggal.text = data?.tanggal

                }
            }

            override fun onFailure(call: Call<ResponseJadwalSholat>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun getCurrentDate() : String{
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale("id", "ID"))
        val date = Date()
        return simpleDateFormat.format(date)
    }
}