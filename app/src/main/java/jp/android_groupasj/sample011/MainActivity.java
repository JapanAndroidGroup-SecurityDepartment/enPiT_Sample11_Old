package jp.android_groupasj.sample011;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private int mAutherUserID = 0;
    private String mAutherUserName = "";
    private static String mServerIP = "";

    private Button mLoginBtn;
    private Button mEntryBtn;
    private TextView mlogin_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mlogin_title = findViewById(R.id.txt_login_title2);
        mLoginBtn = findViewById(R.id.btn_login);
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Login
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivityForResult(intent, Constants.REQUEST_GET_USER);
            }
        });

        mEntryBtn = findViewById(R.id.btn_entry);
        mEntryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAutherUserID == 0 || mServerIP.length() == 0) {
                    Toast.makeText(getApplicationContext(), R.string.no_login_error, Toast.LENGTH_LONG).show();
                    return;
                }
                // Entry Menu
                Intent intent = new Intent(getApplicationContext(), EntryMenuActivity.class);
                intent.putExtra(Constants.EXTRA_USER_ID, mAutherUserID);
                intent.putExtra(Constants.EXTRA_USER_NAME, mAutherUserName);
                intent.putExtra(Constants.EXTRA_SERVER_IP, mServerIP);
                startActivityForResult(intent, Constants.REQUEST_GET_ENTRY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case Constants.REQUEST_GET_USER:
                if (resultCode == RESULT_OK) {
                    mAutherUserID = data.getIntExtra(Constants.EXTRA_USER_ID, 0);
                    mAutherUserName = data.getStringExtra(Constants.EXTRA_USER_NAME);
                    mServerIP = data.getStringExtra(Constants.EXTRA_SERVER_IP);
                    if (mAutherUserID > 0) {
                        mLoginBtn.setVisibility(View.GONE);
                        mlogin_title.setText("Login User Name:" + mAutherUserName);
                    }
                }
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
