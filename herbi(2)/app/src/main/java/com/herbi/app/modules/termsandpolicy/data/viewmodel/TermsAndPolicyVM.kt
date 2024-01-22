package com.herbi.app.modules.termsandpolicy.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.herbi.app.modules.termsandpolicy.`data`.model.TermsAndPolicyModel
import org.koin.core.KoinComponent

class TermsAndPolicyVM : ViewModel(), KoinComponent {
  val termsAndPolicyModel: MutableLiveData<TermsAndPolicyModel> =
      MutableLiveData(TermsAndPolicyModel())

  var navArguments: Bundle? = null
}
