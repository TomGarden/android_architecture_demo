package io.github.tomgarden.mvc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.tomgarden.mvc.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {

    lateinit var vb: ActivityMainBinding
    lateinit var model: Model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)

        model = Model()
        model.addObserver { o, arg -> vb.tv.text = model.getVal().toString() }

        vb.btnPlus.setOnClickListener { model.plus() }
        vb.btnSubtraktion.setOnClickListener { model.subtrakt() }
    }
}