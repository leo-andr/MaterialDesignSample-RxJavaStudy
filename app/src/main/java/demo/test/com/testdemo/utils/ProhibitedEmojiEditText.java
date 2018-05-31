package demo.test.com.testdemo.utils;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.Toast;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lipiao
 * @data 2018/5/11.
 * @description 禁止输入表情 不允许特殊字符 默认最多15个字符
 * todo 若有特殊字符限制等等 可以自定义添加属性
 */
public class ProhibitedEmojiEditText extends EditText {
    private Context mContext;

    public ProhibitedEmojiEditText(Context context) {
        super(context);
        this.mContext = context;
        initEditText();
    }

    public ProhibitedEmojiEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initEditText();
    }

    public ProhibitedEmojiEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initEditText();
    }

    /**
     * 初始化
     */
    private void initEditText() {
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String editable = getText().toString();
                String str = StringUntil.stringFilterLetterNumber(editable);
                if (!editable.equals(str)) {
                    setText(str);
                    setSelection(str.length());
                }
            }

            @Override

            public void afterTextChanged(Editable s) {
            }

        });
        setFilters(new InputFilter[]{inputFilter, new InputFilter.LengthFilter(15)});
    }

    InputFilter inputFilter = new InputFilter() {
        Pattern emoji = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",
                Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            Matcher emojiMatcher = emoji.matcher(source);
            if (emojiMatcher.find()) {
                Toast.makeText(mContext, "不支持输入表情符号!", Toast.LENGTH_SHORT).show();
                return "";
            }
            return null;
        }
    };

}
