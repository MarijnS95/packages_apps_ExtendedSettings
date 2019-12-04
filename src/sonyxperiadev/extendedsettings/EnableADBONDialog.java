package sonyxperiadev.extendedsettings;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemProperties;
import android.support.v14.preference.SwitchPreference;

import vendor.sysprop.VendorProperties;

/**
 * Created by myself5 on 9/6/16.
 * Dialog for enabling ADB Over Network.
 * Base on Googles fire missile dialog
 */
public class EnableADBONDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.pref_description_adbonswitchdialog)
                .setTitle(R.string.pref_title_adbonswitch)
                .setCancelable(false)
                .setPositiveButton(R.string.enable, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        VendorProperties.vendor_adb_network_port("5555");
                        ExtendedSettingsFragment.updateADBSummary(true);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ExtendedSettingsFragment.updateADBSummary(false);
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
