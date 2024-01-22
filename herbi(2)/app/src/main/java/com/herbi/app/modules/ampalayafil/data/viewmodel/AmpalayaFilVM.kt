package com.herbi.app.modules.ampalayafil.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.herbi.app.modules.ampalayafil.`data`.model.AmpalayaFilModel
import org.koin.core.KoinComponent

class AmpalayaFilVM : ViewModel(), KoinComponent {
  val ampalayaFilModel: MutableLiveData<AmpalayaFilModel> = MutableLiveData(AmpalayaFilModel())

  var navArguments: Bundle? = null
}
