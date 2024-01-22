package com.herbi.app.modules.malunggayenglishactivity.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.herbi.app.R
import com.herbi.app.appcomponents.base.BaseActivity
import com.herbi.app.databinding.ActivityMalunggayEnglishActivityBinding
import com.herbi.app.modules.homefeed.ui.HomeFeedActivity
import com.herbi.app.modules.malunggayenglishactivity.data.viewmodel.MalunggayEnglishVMVM
import com.herbi.app.modules.malunggaytagalogactivity.ui.MalunggayTagalogActivityActivity

class MalunggayEnglishActivityActivity :
  BaseActivity<ActivityMalunggayEnglishActivityBinding>(R.layout.activity_malunggay_english_activity) {

  private val viewModel: MalunggayEnglishVMVM by viewModels<MalunggayEnglishVMVM>()

  private val startForResult =
    registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
      if (result.resultCode == RESULT_OK) {
        // Handle the result if needed
      }
    }

  private val REQUEST_CODE_HOME_FEED_ACTIVITY: Int = 275

  override fun onInitialized() {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.malunggayEnglishVMVM = viewModel
  }

  override fun setUpClicks() {
    binding.imageArrowleft.setOnClickListener {
      val destIntent = HomeFeedActivity.getIntent(this, null)
      startForResult.launch(destIntent)
    }
    binding.imageRectangleNinetyTwo.setOnClickListener {
      val destIntent = MalunggayTagalogActivityActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "MALUNGGAY_ENGLISH_ACTIVITY_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, MalunggayEnglishActivityActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}