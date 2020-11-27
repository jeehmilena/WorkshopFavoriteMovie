package com.jessica.yourfavoritemovies.home.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jessica.yourfavoritemovies.MovieRepository
import com.jessica.yourfavoritemovies.model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = MovieRepository()
    var stateList: MutableLiveData<List<Result>> = MutableLiveData()
    var error: MutableLiveData<String> = MutableLiveData()
    var loading: MutableLiveData<Boolean> = MutableLiveData()

    fun getListMovies(language: String) {
        viewModelScope.launch {
            loading.value = true
            try {
                val movieResult = withContext(Dispatchers.IO) {
                    repository.getMovies(language)
                }
                stateList.value = movieResult.results
                loading.value = false
            } catch (ex: Exception) {
                errorMessage("It looks like we had a problem. Try later!")
            } finally {
                loading.value = false
            }
        }
    }

    //TODO - Implementar a função de savar o filme favorito

    private fun errorMessage(message: String) {
        error.value = message
    }
}


