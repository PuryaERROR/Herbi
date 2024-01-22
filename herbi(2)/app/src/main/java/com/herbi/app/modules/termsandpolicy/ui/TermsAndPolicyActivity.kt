package com.herbi.app.modules.termsandpolicy.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.herbi.app.R
import com.herbi.app.appcomponents.base.BaseActivity
import com.herbi.app.databinding.ActivityTermsAndPolicyBinding
import com.herbi.app.modules.homefeed.ui.HomeFeedActivity
import com.herbi.app.modules.termsandpolicy.`data`.viewmodel.TermsAndPolicyVM
import kotlin.String
import kotlin.Unit

class TermsAndPolicyActivity :
    BaseActivity<ActivityTermsAndPolicyBinding>(R.layout.activity_terms_and_policy) {
  private val viewModel: TermsAndPolicyVM by viewModels<TermsAndPolicyVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.termsAndPolicyVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnContinue.setOnClickListener {
      val destIntent = HomeFeedActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "TERMS_AND_POLICY_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, TermsAndPolicyActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
