package io.github.tomgarden.mvvm

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable


class AppViewModel(var model: Model = Model()) : BaseObservable() {
    // string variables for
    // toast messages
    private val successMessage = "Login successful"
    private val errorMessage = "Email or Password is not valid"

    // string variable for
    // toast message

    @Bindable
    var toastMessage: String = ""
        get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.toastMessage);
        }

    @get:Bindable
    var userEmail:String
        get() = model.email
        set(value) {
            model.email = value
            notifyPropertyChanged(BR.userEmail)
        }

    @get:Bindable
    var userPwd:String
        get() = model.password
        set(value) {
            model.password = value
            notifyPropertyChanged(BR.userPwd)
        }

    // method to keep a check
    // that variable fields must
    // not be kept empty by user
    private fun isValid(): Boolean {
        return !TextUtils.isEmpty(userEmail) &&
                Patterns.EMAIL_ADDRESS.matcher(userEmail).matches() &&
                userPwd.length > 5
    }

    // actions to be performed
    // when user clicks
    // the LOGIN button
    fun onButtonClicked() {
//        toastMessage = "${if (isValid()) successMessage else errorMessage} \n ${curStr()}"
        toastMessage = curStr()
    }

    fun curStr(): String = "$userEmail \n $userPwd"
}