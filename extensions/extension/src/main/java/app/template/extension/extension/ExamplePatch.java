package app.template.extension.extension;

import android.content.Context;
import android.content.SharedPreferences;

@SuppressWarnings("unused")
public class ChangeFlags {

    private static final String PREFS_NAME = "heliofloxz_change_flags";
    private static final String CALL_RECORDING = "call_recording";

    /*
     * Stage 1:
     * 0 = use Google Phone's normal eligibility result
     * 1 = force call-recording eligibility on
     */
    public static boolean isCallRecordingForced(Context context) {
        return getPreferences(context).getBoolean(CALL_RECORDING, false);
    }

    public static void setCallRecordingForced(
            Context context,
            boolean enabled
    ) {
        getPreferences(context)
                .edit()
                .putBoolean(CALL_RECORDING, enabled)
                .apply();
    }

    private static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(
                PREFS_NAME,
                Context.MODE_PRIVATE
        );
    }
}
