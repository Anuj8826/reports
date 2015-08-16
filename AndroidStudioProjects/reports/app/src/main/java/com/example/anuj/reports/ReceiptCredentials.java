package com.example.anuj.reports;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by anuj on 9/8/15.
 */
public class ReceiptCredentials extends Activity {
    private  ReceiptModel receiptModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        receiptModel = new ReceiptModel();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        // Begin with main data entry view,
        // NewReceiptFragment
        setContentView(R.layout.activity_new_receipt);
        FragmentManager manager = getFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragmentContainer);

        if (fragment == null) {
            fragment = new NewReceiptFragment();
            manager.beginTransaction().add(R.id.fragmentContainer, fragment)
                    .commit();
        }
    }

    public ReceiptModel getCurrentReceipt() {
        return receiptModel;
    }
}
