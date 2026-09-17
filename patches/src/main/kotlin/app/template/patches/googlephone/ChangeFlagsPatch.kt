package app.template.patches.googlephone

import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.template.patches.shared.Constants.GOOGLE_PHONE_COMPATIBILITY

@Suppress("unused")
val changeFlagsPatch = bytecodePatch(
    name = "Change flags",
    description = "Adds customizable Google Phone feature flags.",
    default = true,
) {
    compatibleWith(GOOGLE_PHONE_COMPATIBILITY)

    extendWith("extensions/extension.mpe")

    execute {
        CallRecordingCountryGateFingerprint.method.addInstructions(
            0,
            """
                invoke-static {}, Lapp/template/extension/extension/ChangeFlags;->forceCallRecording()Z
                move-result v0
                return v0
            """.trimIndent(),
        )
    }
}
