package app.template.patches.shared

import app.morphe.patcher.patch.ApkFileType
import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility

object Constants {
    const val YT_STUDIO_PACKAGE_NAME =
        "com.google.android.apps.youtube.creator"

    const val VIRTUAL_MASTER_PACKAGE_NAME =
        "com.clone.android.dual.space"

    val YT_STUDIO_COMPATIBILITY = Compatibility(
        name = "YouTube Studio",
        packageName = com.google.android.apps.youtube.creator,
        apkFileType = ApkFileType.APK,
        appIconColor = 0xFF0000,
        targets = listOf(
            AppTarget(
                version = null
            )
        )
    )

    val VIRTUAL_MASTER_COMPATIBILITY = Compatibility(
        name = "Virtual Master",
        packageName = com.clone.android.dual.space,
        apkFileType = ApkFileType.APK,
        appIconColor = 0xFF0000,
        targets = listOf(
            AppTarget(
                version = "3.2.71"
            )
        )
    )
}
