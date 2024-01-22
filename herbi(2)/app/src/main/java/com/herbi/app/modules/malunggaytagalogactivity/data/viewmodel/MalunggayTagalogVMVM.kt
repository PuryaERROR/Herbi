package com.herbi.app.modules.malunggaytagalogactivity.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.herbi.app.modules.malunggaytagalogactivity.`data`.model.MalunggayTagalogModelModel
import org.koin.core.KoinComponent

class MalunggayTagalogVMVM : ViewModel(), KoinComponent {
  val malunggayTagalogModelModel: MutableLiveData<MalunggayTagalogModelModel> =
      MutableLiveData(MalunggayTagalogModelModel())

  var navArguments: Bundle? = null
}
