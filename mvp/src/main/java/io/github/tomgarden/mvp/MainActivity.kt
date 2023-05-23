package io.github.tomgarden.mvp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.github.tomgarden.mvp.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity(), Contract.View {

    lateinit var vb :ActivityMainBinding
    lateinit var model :Contract.Model
    lateinit var presenter:Contract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)

        vb.button.setOnClickListener { presenter.onButtonClick() }

        model = Model()
        presenter = Presenter(this, model)
    }

    override fun showProgress() = vb.progressBar.setVisibility(View.VISIBLE)

    override fun hideProgress() = vb.progressBar.setVisibility(View.GONE)

    override fun setString(string: String?) = vb.textView.setText(string)

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}