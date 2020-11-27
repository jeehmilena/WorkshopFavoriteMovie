package com.jessica.yourfavoritemovies.favorites.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.jessica.yourfavoritemovies.model.Result

class FavoriteViewModel(application: Application): AndroidViewModel(application) {
    var stateRemoveFavorite: MutableLiveData<Result> = MutableLiveData()
    var stateList: MutableLiveData<List<Result>> = MutableLiveData()

    //TODO - Implementar a função que recupera os filmes salvos no RealTime Database

    //TODO - Implementar a função que remove um filme favoritado
}