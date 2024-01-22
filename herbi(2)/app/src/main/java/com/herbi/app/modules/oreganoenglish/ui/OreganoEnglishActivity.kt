package com.herbi.app.modules.oreganoenglish.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.herbi.app.R
import com.herbi.app.appcomponents.base.BaseActivity
import com.herbi.app.databinding.ActivityOreganoEnglishBinding
import com.herbi.app.modules.homefeed.ui.HomeFeedActivity
import com.herbi.app.modules.oreganoenglish.`data`.viewmodel.OreganoEnglishVM
import com.herbi.app.modules.oreganotagalog.ui.OreganoTagalogActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class OreganoEnglishActivity :
    BaseActivity<ActivityOreganoEnglishBinding>(R.layout.activity_oregano_english) {
  private val viewModel: OreganoEnglishVM by viewModels<OreganoEnglishVM>()

  private val REQUEST_CODE_HOME_FEED_ACTIVITY: Int = 905


  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.oreganoEnglishVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      val destIntent = HomeFeedActivity.getIntent(this, null)
      startActivityForResult(destIntent, REQUEST_CODE_HOME_FEED_ACTIVITY)
    }
    binding.imageRectangleNinetyOne.setOnClickListener {
      val destIntent = OreganoTagalogActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "OREGANO_ENGLISH_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, OreganoEnglishActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
