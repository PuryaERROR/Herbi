package com.herbi.app.modules.malunggayenglishactivity.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.herbi.app.modules.malunggayenglishactivity.`data`.model.MalunggayEnglishModelModel
import org.koin.core.KoinComponent

class MalunggayEnglishVMVM : ViewModel(), KoinComponent {
  val malunggayEnglishModelModel: MutableLiveData<MalunggayEnglishModelModel> =
      MutableLiveData(MalunggayEnglishModelModel())

  var navArguments: Bundle? = null
}
