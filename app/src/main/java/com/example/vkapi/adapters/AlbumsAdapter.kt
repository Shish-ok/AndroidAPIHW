package com.example.vkapi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vkapi.databinding.ItemAlbumBinding
import com.example.vkapi.models.Album

class AlbumsAdapter : RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder>() {

    var albums: List<Album> = emptyList()

    class AlbumsViewHolder(
        val binding: ItemAlbumBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAlbumBinding.inflate(inflater, parent, false)
        return AlbumsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumsViewHolder, position: Int) {
        val album = albums[position]
        with(holder.binding) {
            albumTitle.text = album.title
        }
    }

    override fun getItemCount(): Int = albums.size

    fun addAlbums(albums: List<Album>) {
        val oldSize = this.albums.size
        this.albums += albums
        notifyItemRangeInserted(oldSize, albums.size)
    }
}