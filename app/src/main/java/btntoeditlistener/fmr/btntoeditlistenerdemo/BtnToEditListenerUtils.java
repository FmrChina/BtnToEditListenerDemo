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
    private int count1;
    private int count2;
    private int count3;
    private int count4;
    private int count5;

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

        if (editTextList.size() == 2) {
            setWatcher2();
        }

        if (editTextList.size() == 3) {
            setWatcher3();
        }

    }

    private void setWatcher2(){
        editTextList.get(0).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                count1 = s.length();
                if (s.length() != 0 && count2 !=0) {
                    btn.setBackground(ContextCompat.getDrawable(App.getAppContext(), R.drawable.main_color_btn_round_bg));
                    btn.setEnabled(true);
                }else{
                    btn.setBackground(ContextCompat.getDrawable(App.getAppContext(),R.drawable.gray_btn_round_bg));
                    btn.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editTextList.get(1).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                count2 = s.length();
                if (s.length() != 0 && count1 !=0) {
                    btn.setBackground(ContextCompat.getDrawable(App.getAppContext(), R.drawable.main_color_btn_round_bg));
                    btn.setEnabled(true);
                }else{
                    btn.setBackground(ContextCompat.getDrawable(App.getAppContext(),R.drawable.gray_btn_round_bg));
                    btn.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    private void setWatcher3(){
        editTextList.get(0).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                count1 = s.length();
                if (count1 != 0 && count2 !=0 && count3 !=0) {
                    btn.setBackground(ContextCompat.getDrawable(App.getAppContext(), R.drawable.main_color_btn_round_bg));
                    btn.setEnabled(true);
                }else{
                    btn.setBackground(ContextCompat.getDrawable(App.getAppContext(),R.drawable.gray_btn_round_bg));
                    btn.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editTextList.get(1).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                count2 = s.length();
                if (count1 != 0 && count2 !=0 && count3 !=0) {
                    btn.setBackground(ContextCompat.getDrawable(App.getAppContext(), R.drawable.main_color_btn_round_bg));
                    btn.setEnabled(true);
                }else{
                    btn.setBackground(ContextCompat.getDrawable(App.getAppContext(),R.drawable.gray_btn_round_bg));
                    btn.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editTextList.get(2).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                count3 = s.length();
                if (count1 != 0 && count2 !=0 && count3 !=0) {
                    btn.setBackground(ContextCompat.getDrawable(App.getAppContext(), R.drawable.main_color_btn_round_bg));
                    btn.setEnabled(true);
                }else{
                    btn.setBackground(ContextCompat.getDrawable(App.getAppContext(),R.drawable.gray_btn_round_bg));
                    btn.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

}
