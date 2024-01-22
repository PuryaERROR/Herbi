package com.herbi.app.modules.bayabasenglishactivity.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.herbi.app.R
import com.herbi.app.appcomponents.base.BaseActivity
import com.herbi.app.databinding.ActivityBayabasEnglishActivityBinding
import com.herbi.app.modules.bayabasenglishactivity.`data`.viewmodel.BayabasEnglishVMVM
import com.herbi.app.modules.bayabastagalogactivity.ui.BayabasTagalogActivityActivity
import com.herbi.app.modules.homefeed.ui.HomeFeedActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class BayabasEnglishActivityActivity :
    BaseActivity<ActivityBayabasEnglishActivityBinding>(R.layout.activity_bayabas_english_activity)
    {
  private val viewModel: BayabasEnglishVMVM by viewModels<BayabasEnglishVMVM>()

  private val REQUEST_CODE_HOME_FEED_ACTIVITY: Int = 287

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.bayabasEnglishVMVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      val destIntent = HomeFeedActivity.getIntent(this, null)
      startActivityForResult(destIntent, REQUEST_CODE_HOME_FEED_ACTIVITY)
    }
    binding.imageRectangleNinetyOne.setOnClickListener {
      val destIntent = BayabasTagalogActivityActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "BAYABAS_ENGLISH_ACTIVITY_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, BayabasEnglishActivityActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
