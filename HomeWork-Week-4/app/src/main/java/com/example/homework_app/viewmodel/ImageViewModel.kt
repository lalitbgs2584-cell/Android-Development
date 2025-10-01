package com.example.homework_app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ImageViewModel: ViewModel() {
    private val _image = MutableLiveData<String>("https://fastly.picsum.photos/id/646/300/200.jpg?hmac=vF186oU3dslkx6RZ2K1sYFoRI40OKEUlo-WtT58DV9o")
    val img: LiveData<String> get() = _image

    fun setImage(newUrl: String){
        if (newUrl != null) {
            _image.value = newUrl
        }
    }
}