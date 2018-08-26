package jp.android_groupasj.sample011;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

public abstract class BaseAppCompatActivity extends AppCompatActivity {
    /** ログ出力用 */
    private static final String TAG = BaseAppCompatActivity.class.getName().toString();

    /** リクエストコード:ダイアログ風メッセージ画面表示 */
    private static final int REQUEST_COMMON_MESSAGE = 1;
    /** リクエストコード:ダイアログ風インフォメーション画面表示 */
    private static final int REQUEST_COMMON_INFORMATION = REQUEST_COMMON_MESSAGE + 1;
    /** リクエストコード:ダイアログ風警告画面表示 */
    private static final int REQUEST_COMMON_EXCLAMATION = REQUEST_COMMON_INFORMATION + 1;

    /** コンテキスト */
    protected Context mContext;
    /** レイアウト生成用 */
    protected LayoutInflater mInflater;
    /** ダイアログID */
    private int mDialogId;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getApplicationContext();
        mInflater = getLayoutInflater();

        setFinishOnTouchOutside(false);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
