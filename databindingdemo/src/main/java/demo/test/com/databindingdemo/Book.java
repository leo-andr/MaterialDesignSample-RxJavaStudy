package demo.test.com.databindingdemo;

import android.databinding.BaseObservable;

/**
 * @author lipiao
 * @data 2018/5/3.
 * @description 描述
 */
public class Book extends BaseObservable{
    public String name;
    public int page;

    Book(String name, int page) {
        this.name = name;
        this.page = page;
    }

    public void setPage(int page) {
        this.page = page;
        notifyPropertyChanged(BR.book);
    }
}
