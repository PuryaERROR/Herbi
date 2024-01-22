package com.herbi.app.modules.malunggaytagalogactivity.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.herbi.app.R
import com.herbi.app.appcomponents.base.BaseActivity
import com.herbi.app.databinding.ActivityMalunggayTagalogActivityBinding
import com.herbi.app.modules.homefeed.ui.HomeFeedActivity
import com.herbi.app.modules.malunggayenglishactivity.ui.MalunggayEnglishActivityActivity
import com.herbi.app.modules.malunggaytagalogactivity.`data`.viewmodel.MalunggayTagalogVMVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class MalunggayTagalogActivityActivity :
    BaseActivity<ActivityMalunggayTagalogActivityBinding>(R.layout.activity_malunggay_tagalog_activity)
    {
  private val viewModel: MalunggayTagalogVMVM by viewModels<MalunggayTagalogVMVM>()

  private val REQUEST_CODE_HOME_FEED_ACTIVITY: Int = 786


  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.malunggayTagalogVMVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      val destIntent = HomeFeedActivity.getIntent(this, null)
      startActivityForResult(destIntent, REQUEST_CODE_HOME_FEED_ACTIVITY)
    }
    binding.imageRectangleNinetyOne.setOnClickListener {
      val destIntent = MalunggayEnglishActivityActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "MALUNGGAY_TAGALOG_ACTIVITY_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, MalunggayTagalogActivityActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
