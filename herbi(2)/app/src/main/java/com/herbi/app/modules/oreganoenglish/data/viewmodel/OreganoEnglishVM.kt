package com.herbi.app.modules.oreganoenglish.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.herbi.app.modules.oreganoenglish.`data`.model.OreganoEnglishModel
import org.koin.core.KoinComponent

class OreganoEnglishVM : ViewModel(), KoinComponent {
  val oreganoEnglishModel: MutableLiveData<OreganoEnglishModel> =
      MutableLiveData(OreganoEnglishModel())

  var navArguments: Bundle? = null
}
