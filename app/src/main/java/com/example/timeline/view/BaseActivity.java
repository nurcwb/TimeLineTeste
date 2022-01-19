package com.example.timeline.view;

import android.app.ProgressDialog;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    private ProgressDialog progress;

    protected void hideLoading() {
        progress.dismiss();
    }

    protected void showLoading() {
        progress = new ProgressDialog(this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("INDO_PARA", this.getClass().getSimpleName());
    }
}
