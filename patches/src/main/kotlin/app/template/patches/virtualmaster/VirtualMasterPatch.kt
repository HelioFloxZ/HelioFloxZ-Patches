package app.template.patches.virtualmaster

import app.morphe.patcher.patch.bytecodePatch
import app.template.patches.shared.Constants.VIRTUAL_MASTER_COMPATIBILITY

@Suppress("unused")
val virtualMasterPatch = bytecodePatch(
    name = "Virtual Master support",
    description = "Virtual Master patch collection.",
    default = true,
) {
    compatibleWith(VIRTUAL_MASTER_COMPATIBILITY)
}
