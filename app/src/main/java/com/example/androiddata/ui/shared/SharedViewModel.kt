package com.example.androiddata.ui.shared

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.androiddata.data.Film
import com.example.androiddata.data.FilmRepository

class SharedViewModel(app: Application) : AndroidViewModel(app) {
    private val dataRepo = FilmRepository(app)
    val filmData = dataRepo.filmData

    val selectedFilm = MutableLiveData<Film>()

    fun refreshData() {
        dataRepo.refreshData()
    }

}
