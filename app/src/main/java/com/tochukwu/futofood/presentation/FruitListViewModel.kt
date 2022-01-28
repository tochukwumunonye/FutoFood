package com.tochukwu.futofood.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tochukwu.futofood.domain.MainRepository
import com.tochukwu.futofood.domain.model.Fruit
import com.tochukwu.futofood.util.Event
import com.tochukwu.futofood.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FruitListViewModel @Inject constructor(
    private val fruitsRepo: MainRepository
) : ViewModel(){

    private val _fruitsChannel = MutableLiveData<Event<Resource<List<Fruit>>>>()

    val fruitsChannel: LiveData<Event<Resource<List<Fruit>>>> get() = _fruitsChannel


    fun getFruits() = viewModelScope.launch{
        fruitsRepo.getFruits().collectLatest{
            _fruitsChannel.postValue(Event(it))
        }

    }

}


