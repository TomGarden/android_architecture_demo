package io.github.tomgarden.mvc

import java.beans.PropertyChangeEvent
import java.beans.PropertyChangeListener
import java.util.ArrayList
import java.util.LinkedHashSet
import java.util.Observable
import kotlin.properties.ObservableProperty


class Model : Observable() {
    private var flag: Int = 0

    fun plus(): Unit {
        flag++
        setChanged()
        notifyObservers()
    }

    fun subtrakt(): Unit {
        flag--
        setChanged()
        notifyObservers()
    }

    fun reset(value: Int): Unit {
        flag = value
    }

    fun getVal(): Int = flag
}