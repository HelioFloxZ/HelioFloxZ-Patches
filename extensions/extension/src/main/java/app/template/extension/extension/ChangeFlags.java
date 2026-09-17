package app.template.extension.extension;

import android.content.Context;
import android.content.SharedPreferences;

@SuppressWarnings("unused")
public final class ChangeFlags {

    private static final String PREFS_NAME = "heliofloxz_change_flags";
    private static final String CALL_RECORDING_FORCE = "call_recording_force";

    private ChangeFlags() {
    }

    public static boolean isCallRecordingForced(Context context) {
        return getPreferences(context).getBoolean(
                CALL_RECORDING_FORCE,
                false
        );
    }

    public static void setCallRecordingForced(
            Context context,
            boolean enabled
    ) {
        getPreferences(context)
                .edit()
                .putBoolean(CALL_RECORDING_FORCE, enabled)
                .apply();
    }

    private static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(
                PREFS_NAME,
                Context.MODE_PRIVATE
        );
    }
}
