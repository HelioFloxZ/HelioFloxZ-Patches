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
                iget-object v0, p0, Liwz;->c:Landroid/content/Context;

                invoke-static {v0}, Lapp/template/extension/extension/ChangeFlags;->isCallRecordingForced(Landroid/content/Context;)Z
                move-result v0

                if-eqz v0, :original

                const/4 v0, 0x1
                return v0

                :original
            """.trimIndent(),
        )
    }
}
