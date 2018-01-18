package cting.com.robintool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import cting.com.robintool.utils.FileHelper;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "robin/MainAct";

    ScrollView mContainer;
    TextView mMessage;
    EditText mEditFilePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContainer = (ScrollView) findViewById(R.id.scroll_container);
        mMessage = (TextView) findViewById(R.id.text_message);
        mEditFilePath = (EditText) findViewById(R.id.edit_input_file_path);

        mMessage.setText("");
    }

    protected void setMessage(String message) {
        if (message == null) {
            message = "MESSAGE NULL!!";
            mMessage.setText(message);
        }else {
            mMessage.append(message);
        }
        mContainer.scrollTo(0, mContainer.getBottom());
    }

    public void clickClearFilePathBtn(View v) {
        mEditFilePath.setText("");
    }

    public void clickReadFileBtn(View v) {
        String filePath = mEditFilePath.getText().toString();
        if (TextUtils.isEmpty(filePath)) {
            Toast.makeText(this, R.string.toast_file_path_empty, Toast.LENGTH_SHORT).show();
            return;
        }
        setMessage(FileHelper.readFile(filePath));
    }

    public void clickClearMessageBtn(View v) {
        mMessage.setText("");
        mContainer.scrollTo(0, mContainer.getBottom());
    }
}
