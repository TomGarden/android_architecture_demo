package io.github.tomgarden.mvvm

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import io.github.tomgarden.mvvm.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {

    lateinit var vb :ActivityMainBinding
    lateinit var vm:AppViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = DataBindingUtil.setContentView(this, R.layout.activity_main)
        vm = AppViewModel()
        vb.viewModel = vm
        vb.executePendingBindings()

        vb.btnTest.setOnClickListener {
            vb.getViewModel()
            vm.userEmail = "123"
        }
    }

    companion object {
        @BindingAdapter("toastMessage")
        @JvmStatic
        fun toastMessage(view: Button, toastMessage: String) {
            if (toastMessage.isEmpty()) return
            view.context?.let { context ->
                Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
