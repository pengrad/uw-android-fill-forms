package io.github.pengrad.uw_android_fill_forms;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * stas
 * 8/10/15
 */
public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test);

        findViewById(R.id.buttonTap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TestActivity.this, "Button tapped", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
