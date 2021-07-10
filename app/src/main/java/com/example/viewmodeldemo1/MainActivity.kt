package com.example.viewmodeldemo1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodeldemo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // ViewModel Class의 인스턴스
    private lateinit var viewModel: MainActivityViewModel
/* 화면이 회전하게 되면 뷰가 재생성되어서 기존에 있던 변수들의 값이 초기화된다.
       ViewModel을 사용하게되면 ViewModel은 액티비티가 생성될 때 같이 메모리에 생성되고
       액티비티가 메모리에서 사라질 때 까지 ViewModel은 살아있다.
       그래서 ViewModel은 액티비티에 속하는 변수들을 가지고 있을 수 있다.
*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.apply {
            tvCount.text = viewModel.getCurrentCount().toString()
            btnClick.setOnClickListener {
                tvCount.text = viewModel.getUpdateCount().toString()
            }
        }

    }
}