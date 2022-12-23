package com.example.vkapi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.vkapi.adapters.AlbumsAdapter
import com.example.vkapi.api.RetrofitInstance
import com.example.vkapi.databinding.ActivityAlbumsBinding
import com.example.vkapi.dto.AlbumsDTO
import com.example.vkapi.models.Album
import retrofit2.Response

class AlbumsActivity : AppCompatActivity() {
    private lateinit var err: TextView
    private lateinit var adapter: AlbumsAdapter
    private lateinit var binding: ActivityAlbumsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = AlbumsAdapter()

        val layoutManager = LinearLayoutManager(this)
        binding.albumsList.layoutManager = layoutManager
        binding.albumsList.adapter = adapter

        val userID = intent.getStringExtra("user_id")


        getUserAlbums(adapter, userID!!)
    }

    @SuppressLint("SetTextI18n")
    fun getUserAlbums(adapter: AlbumsAdapter, userID: String) {
        lifecycleScope.launchWhenCreated {
            var res: Response<AlbumsDTO>? = null

            try {
                res = RetrofitInstance.api.getAlbums(userID)
                if (res.isSuccessful) {
                    if (res.body()?.response?.count != 0) {
                        val albums: List<Album> = res.body()!!.response.items
                        adapter.addAlbums(albums)
                    } else {
                        err.text = "No albums"
                        err.visibility = View.VISIBLE
                    }
                } else {
                    err.text = "Bad connection"
                    err.visibility = View.VISIBLE
                }
            } catch (Ex: Exception) {
                when (res?.code()) {
                    10 -> err.text = "Internal server error"
                    100 -> err.text = "Incorrect param"
                    1116 -> err.text = "Token invalid"
                    else -> err.text = "Unidentified error"
                }
                err.visibility = View.VISIBLE
            }
        }
    }
}