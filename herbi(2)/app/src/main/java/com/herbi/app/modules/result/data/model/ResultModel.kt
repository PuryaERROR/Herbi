package com.herbi.app.modules.result.data.model

import android.graphics.Bitmap

data class ResultModel(
    var herbName: String? = null,
    var scientificName: String? = null,
    var description: String? = null,
    var medicinalUses: String? = null,
    var capturedImagePath: Bitmap? = null
)
