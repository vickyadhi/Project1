package com.example.project1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project1.modelclass.Quote
import com.example.project1.retrofit.QuoteApi
import kotlinx.coroutines.launch

enum class QuoteApiStatus { LOADING, ERROR, DONE }

class MainActivityViewModel : ViewModel() {

    private val _status = MutableLiveData<QuoteApiStatus>()

    val status: LiveData<QuoteApiStatus> = _status

    private val _quote = MutableLiveData<List<Quote>>()

    val quoteList: LiveData<List<Quote>> = _quote
init {
    getQuote()
}

private fun getQuote(){
    viewModelScope.launch {
        _status.value = QuoteApiStatus.LOADING
        try {
            _quote.value = QuoteApi.retrofitService.getQuotes()
            _status.value = QuoteApiStatus.DONE
        }catch (e:Exception){
            _status.value = QuoteApiStatus.ERROR
            _quote.value = listOf()
        }
    }

}
}