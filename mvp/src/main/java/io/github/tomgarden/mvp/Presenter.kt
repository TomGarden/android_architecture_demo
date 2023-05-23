package io.github.tomgarden.mvp

class Presenter(
    private var mainView: Contract.View?,
    private val model: Contract.Model,
) : Contract.Presenter {


    override fun onButtonClick() = mainView?.let { mainView ->
        mainView.showProgress()
        model.getNextCourse(object : Contract.Model.OnFinishedListener {
            override fun onFinished(string: String?) {
                mainView.setString(string)
                mainView.hideProgress()
            }
        })
        Unit
    } ?: Unit

    override fun onDestroy() {
        mainView = null
    }
}