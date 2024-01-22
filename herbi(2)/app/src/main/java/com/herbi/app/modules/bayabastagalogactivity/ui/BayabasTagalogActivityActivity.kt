package com.herbi.app.modules.bayabastagalogactivity.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.herbi.app.R
import com.herbi.app.appcomponents.base.BaseActivity
import com.herbi.app.databinding.ActivityBayabasTagalogActivityBinding
import com.herbi.app.modules.bayabasenglishactivity.ui.BayabasEnglishActivityActivity
import com.herbi.app.modules.bayabastagalogactivity.`data`.viewmodel.BayabasTagalogVMVM
import com.herbi.app.modules.homefeed.ui.HomeFeedActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class BayabasTagalogActivityActivity :
    BaseActivity<ActivityBayabasTagalogActivityBinding>(R.layout.activity_bayabas_tagalog_activity)
    {
  private val viewModel: BayabasTagalogVMVM by viewModels<BayabasTagalogVMVM>()

  private val REQUEST_CODE_HOME_FEED_ACTIVITY: Int = 570


  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.bayabasTagalogVMVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      val destIntent = HomeFeedActivity.getIntent(this, null)
      startActivityForResult(destIntent, REQUEST_CODE_HOME_FEED_ACTIVITY)
    }
    binding.imageRectangleNinetyTwo.setOnClickListener {
      val destIntent = BayabasEnglishActivityActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "BAYABAS_TAGALOG_ACTIVITY_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, BayabasTagalogActivityActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
