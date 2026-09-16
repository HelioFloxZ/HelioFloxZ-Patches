package app.template.patches.googlephone

import app.morphe.patcher.patch.bytecodePatch
import app.template.patches.shared.Constants.GOOGLE_PHONE_COMPATIBILITY

@Suppress("unused")
val callRecordingPatch = bytecodePatch(
    name = "Call recording support",
    description = "Prepares the existing Google Phone call-recording implementation for customization.",
    default = true,
) {
    compatibleWith(GOOGLE_PHONE_COMPATIBILITY)

    execute {
        CallRecordingCountryGateFingerprint.method
    }
}
