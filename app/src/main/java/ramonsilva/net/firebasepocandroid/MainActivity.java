package ramonsilva.net.firebasepocandroid;

import android.app.Dialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        int errorCode = connectionResult.getErrorCode();

        if(errorCode == ConnectionResult.SERVICE_MISSING
                || errorCode == ConnectionResult.SERVICE_DISABLED
                || errorCode == ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED){

            Dialog errorDialog = GooglePlayServicesUtil.getErrorDialog(errorCode, this, 0);
            errorDialog.show();
        }
    }

    @Override
    protected void onResume() {
        GoogleApiClient client = new GoogleApiClient.Builder(this).build();
        client.registerConnectionFailedListener(this);
        super.onResume();
    }

    @Override
    protected void onPause() {
        GoogleApiClient client = new GoogleApiClient.Builder(this).build();
        client.unregisterConnectionFailedListener(this);
        super.onPause();
    }
}
