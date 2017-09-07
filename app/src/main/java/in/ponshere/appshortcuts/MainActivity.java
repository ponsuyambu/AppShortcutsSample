package in.ponshere.appshortcuts;

import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnMain = findViewById(R.id.btnMain);
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,BottomNavActivity.class);
                startActivity(intent);
                ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);

                ShortcutInfo shortcut = new ShortcutInfo.Builder(MainActivity.this, "id1")
                        .setShortLabel("Web site")
                        .setLongLabel("Open the web site")
                        .setIcon(Icon.createWithResource(MainActivity.this, R.drawable.ic_dashboard_black_24dp))
                        .setIntents(new Intent[]{
                                new Intent(Intent.ACTION_MAIN, Uri.EMPTY, MainActivity.this, BottomNavActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK),
                        })
                        .build();

                shortcutManager.setDynamicShortcuts(Arrays.asList(shortcut));

            }
        });
    }
}
