package com.herbi.app.modules.howworks.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.herbi.app.R
import com.herbi.app.appcomponents.base.BaseActivity
import com.herbi.app.databinding.ActivityHowWorksBinding
import com.herbi.app.modules.howworks.`data`.viewmodel.HowWorksVM
import com.herbi.app.modules.termsandpolicy.ui.TermsAndPolicyActivity
import kotlin.String
import kotlin.Unit

class HowWorksActivity : BaseActivity<ActivityHowWorksBinding>(R.layout.activity_how_works) {
  private val viewModel: HowWorksVM by viewModels<HowWorksVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.howWorksVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtSkip.setOnClickListener {
      val destIntent = TermsAndPolicyActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "HOW_WORKS_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, HowWorksActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
