package com.example.viewmodeldemo1

import androidx.lifecycle.ViewModel

// ViewModel을 위한 클래스
class MainActivityViewModel : ViewModel() {
    private var count = 0

    fun getCurrentCount(): Int {
        return count
    }

    fun getUpdateCount(): Int {
        return ++count
    }
}