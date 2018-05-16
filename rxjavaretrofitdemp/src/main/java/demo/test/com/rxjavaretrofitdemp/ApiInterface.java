package demo.test.com.rxjavaretrofitdemp;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author lipiao
 * @data 2018/5/10.
 * @description 描述
 */
public interface ApiInterface {
    /* 参数说明：
     a：固定值 fy
     f：原文内容类型，日语取 ja，中文取 zh，英语取 en，韩语取 ko，德语取 de，西班牙语取 es，法语取 fr，自动则取 auto
     t：译文内容类型，日语取 ja，中文取 zh，英语取 en，韩语取 ko，德语取 de，西班牙语取 es，法语取 fr，自动则取 auto
     w：查询内容*/
    @GET("ajax.php?a=fy&f=auto&t=auto")
//    @GET("ajax.php?a=fy&f=en&t=zh")
    Observable<Translation> getTranslationData(@Query("w") String queryData);

}
