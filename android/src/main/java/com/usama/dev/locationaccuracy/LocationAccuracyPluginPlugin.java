package com.usama.dev.locationaccuracy;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
@CapacitorPlugin(name = "LocationAccuracyPlugin")
public class LocationAccuracyPluginPlugin extends Plugin {

    private static final int REQUEST_CHECK_SETTINGS = 1001;
//    private Location implementation = new LocationAccuracyPlugin();

    @PluginMethod
    public void checkLocationAccuracy(PluginCall call) {
        // Create a location request
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        // Build the location settings request
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest);

        // Get the settings client
        SettingsClient client = LocationServices.getSettingsClient(getContext());
        Task<LocationSettingsResponse> task = client.checkLocationSettings(builder.build());

        // Check if location settings are satisfied
        task.addOnSuccessListener(new OnSuccessListener<LocationSettingsResponse>() {
            @Override
            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                JSObject ret = new JSObject();
                ret.put("status", "enabled");
                call.resolve(ret);
            }
        });

        // Handle the case where location settings are not satisfied
        task.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if (e instanceof ResolvableApiException) {
                    try {
                        ResolvableApiException resolvable = (ResolvableApiException) e;
                        IntentSender intentSender = resolvable.getResolution().getIntentSender();
                        getActivity().startIntentSenderForResult(intentSender, REQUEST_CHECK_SETTINGS, null, 0, 0, 0, null);
                    } catch (IntentSender.SendIntentException ex) {
                        call.reject("Could not prompt user for location accuracy", ex);
                    }
                } else {
                    call.reject("Location settings are not satisfied.");
                }
            }
        });
    }

    @Override
    protected void handleOnActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.handleOnActivityResult(requestCode, resultCode, data);
        PluginCall savedCall = getSavedCall();

        if (requestCode == REQUEST_CHECK_SETTINGS) {
            if (savedCall != null) {
                if (resultCode == getActivity().RESULT_OK) {
                    JSObject ret = new JSObject();
                    ret.put("status", "enabled");
                    savedCall.resolve(ret);
                } else {
                    savedCall.reject("User denied location accuracy request.");
                }
            }
        }
    }
}
