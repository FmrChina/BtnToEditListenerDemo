package btntoeditlistener.fmr.btntoeditlistenerdemo;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/28.
 */
@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class BtnToEditListenerUtils {

    private List<EditText> editTextList = new ArrayList<>();

    private Button btn;

    private volatile static BtnToEditListenerUtils mInstance;


    //其实这个单例没必要，只会在UI线程操作UI
    public static BtnToEditListenerUtils getInstance(){
        if (mInstance == null) {
            synchronized (BtnToEditListenerUtils.class){
                if (mInstance == null) {
                    mInstance = new BtnToEditListenerUtils();
                }
            }
        }

        return mInstance;
    }

    public BtnToEditListenerUtils setBtn(Button btn){
        this.btn = btn;
        btn.setEnabled(false);
        return this;
    }

    public BtnToEditListenerUtils addEditView(EditText editText){
        editTextList.add(editText);
        return this;
    }

    public void build(){
            setWatcher();
    }

    /**
     * 给每一个EditText设置Watcher监听，当前的EditText文本不为空时遍历每一个EditText，
     * 只有都不为空时 tag为true
     */
    private void setWatcher(){

        for (int i = 0; i < editTextList.size(); i++) {
            editTextList.get(i).addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (s.length() == 0) {
                        setBtnUnavailable();
                        return;
                    }

                    boolean tag = false;

                    for (int i = 0; i < editTextList.size(); i++) {
                        if (editTextList.get(i).getText().length() != 0) {
                            tag = true;
                        }else{
                            tag = false;
                            break;
                        }
                    }

                    if (tag) {
                        setBtnAvailable();
                    }else{
                        setBtnUnavailable();
                    }
                }
            });
        }


    }

    private void setBtnAvailable(){
        btn.setBackground(ContextCompat.getDrawable(App.getAppContext(), R.drawable.main_color_btn_round_bg));
        btn.setEnabled(true);
    }
    private void setBtnUnavailable(){
        btn.setBackground(ContextCompat.getDrawable(App.getAppContext(), R.drawable.gray_btn_round_bg));
        btn.setEnabled(true);
    }

}
