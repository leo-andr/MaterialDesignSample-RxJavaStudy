package demo.test.com.rxjavaretrofitdemp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "RxJavaStudy";

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14,
            btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24, btn25, btn26, btn27,
            btn28, btn29, btn30, btn31, btn32, btn33, btn34, btn35, btn36, btn37, btn38, btn39, btn40,
            btn41, btn42, btn43, btn44, btn45, btn46, btn47, btn48, btn49, btn50, btn51, btn52,
            btn53, btn54, btn55, btn56, btn57, btn58, btn59;

    EditText etName, etAge, etJob, etSearch;
    TextView tvSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn10 = findViewById(R.id.btn10);
        btn11 = findViewById(R.id.btn11);
        btn12 = findViewById(R.id.btn12);
        btn13 = findViewById(R.id.btn13);
        btn14 = findViewById(R.id.btn14);
        btn15 = findViewById(R.id.btn15);
        btn16 = findViewById(R.id.btn16);
        btn17 = findViewById(R.id.btn17);
        btn18 = findViewById(R.id.btn18);
        btn19 = findViewById(R.id.btn19);
        btn20 = findViewById(R.id.btn20);
        btn21 = findViewById(R.id.btn21);
        btn22 = findViewById(R.id.btn22);
        btn23 = findViewById(R.id.btn23);
        btn24 = findViewById(R.id.btn24);
        btn25 = findViewById(R.id.btn25);
        btn26 = findViewById(R.id.btn26);
        btn27 = findViewById(R.id.btn27);
        btn28 = findViewById(R.id.btn28);
        btn29 = findViewById(R.id.btn29);
        btn30 = findViewById(R.id.btn30);
        btn31 = findViewById(R.id.btn31);
        btn32 = findViewById(R.id.btn32);
        btn33 = findViewById(R.id.btn33);
        btn34 = findViewById(R.id.btn34);
        btn35 = findViewById(R.id.btn35);
        btn36 = findViewById(R.id.btn36);
        btn37 = findViewById(R.id.btn37);
        btn38 = findViewById(R.id.btn38);
        btn39 = findViewById(R.id.btn39);
        btn40 = findViewById(R.id.btn40);
        btn41 = findViewById(R.id.btn41);
        btn42 = findViewById(R.id.btn42);
        btn43 = findViewById(R.id.btn43);
        btn44 = findViewById(R.id.btn44);
        btn45 = findViewById(R.id.btn45);
        btn46 = findViewById(R.id.btn46);
        btn47 = findViewById(R.id.btn47);
        btn48 = findViewById(R.id.btn48);
        btn49 = findViewById(R.id.btn49);
        btn50 = findViewById(R.id.btn50);
        btn51 = findViewById(R.id.btn51);
        btn52 = findViewById(R.id.btn52);
        btn53 = findViewById(R.id.btn53);
        btn54 = findViewById(R.id.btn54);
        btn55 = findViewById(R.id.btn55);
        btn56 = findViewById(R.id.btn56);
        btn57 = findViewById(R.id.btn57);
        btn58 = findViewById(R.id.btn58);
        btn59 = findViewById(R.id.btn59);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etJob = findViewById(R.id.etJob);
        etSearch = findViewById(R.id.etSearch);

        tvSearch = findViewById(R.id.tvSearch);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn14.setOnClickListener(this);
        btn15.setOnClickListener(this);
        btn16.setOnClickListener(this);
        btn17.setOnClickListener(this);
//        btn18.setOnClickListener(this);
        btn19.setOnClickListener(this);
        btn20.setOnClickListener(this);
        btn21.setOnClickListener(this);
        btn22.setOnClickListener(this);
        btn23.setOnClickListener(this);
        btn24.setOnClickListener(this);
        btn25.setOnClickListener(this);
        btn26.setOnClickListener(this);
        btn27.setOnClickListener(this);
        btn28.setOnClickListener(this);
        btn29.setOnClickListener(this);
        btn30.setOnClickListener(this);
        btn31.setOnClickListener(this);
        btn32.setOnClickListener(this);
        btn33.setOnClickListener(this);
        btn34.setOnClickListener(this);
        btn35.setOnClickListener(this);
        btn36.setOnClickListener(this);
        btn37.setOnClickListener(this);
        btn38.setOnClickListener(this);
        btn39.setOnClickListener(this);
        btn40.setOnClickListener(this);
        btn41.setOnClickListener(this);
        btn42.setOnClickListener(this);
        btn43.setOnClickListener(this);
//        btn44.setOnClickListener(this);
        btn45.setOnClickListener(this);
        btn46.setOnClickListener(this);
        btn47.setOnClickListener(this);
        btn48.setOnClickListener(this);
        btn49.setOnClickListener(this);
        btn50.setOnClickListener(this);
        btn51.setOnClickListener(this);
        btn52.setOnClickListener(this);
        btn53.setOnClickListener(this);
        btn54.setOnClickListener(this);
        btn55.setOnClickListener(this);
        btn56.setOnClickListener(this);
        btn57.setOnClickListener(this);
        btn58.setOnClickListener(this);
        btn59.setOnClickListener(this);

        // 联合条件判断 可否点击按钮
        jointJudgment();

        // throttleFirst()功能防抖
        functionalAntiShake();

        // debounce()联合搜索优化
        searchOptimization();

        // 代码演示1:初始化必要的被观察者 & 观察者
        initDemonstation1();

        // 异步订阅逻辑演示 数据初始化
        initAsynchronousSubscriptionLogic();

//        JSONObject jsonObject = new JSONObject();
//        JSONObject quotesObj = new JSONObject();
//        JSONArray quotesArray = new JSONArray();
//        try {
//            quotesObj.put("id", 11);
//            quotesObj.put("type", "type122121");
//            quotesArray.put(quotesObj);
//
//            jsonObject.put("properties", quotesArray);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        Log.e(TAG, "initView: " + jsonObject.toString());

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                getTranslationData();
                break;
            case R.id.btn2:
                useMapConvertDemo();
                break;
            case R.id.btn3:
                useFlatMapConvertDemo();
                break;
            case R.id.btn4:
                useConcatMapConvertDemo();
                break;
            case R.id.btn5:
                useBufferConvertDemo();
                break;
            case R.id.btn6:
                nestedCallBacks();
                break;
            case R.id.btn7:
                concatOrConcatArrayDemo();
                break;
            case R.id.btn8:
                mergeOrMergeArrayDemo();
                break;
            case R.id.btn9:
                concatDelayErrorOrMergeDelayErrorDemo();
                break;
            case R.id.btn10:
                zipDemo();
                break;
            case R.id.btn11:
                combineLatestDemo();
                break;
            case R.id.btn12:
                reduceDemo();
                break;
            case R.id.btn13:
                collectDemo();
                break;
            case R.id.btn14:
                startWithOrStartWithArrayDemo();
                break;
            case R.id.btn15:
                countDemo();
                break;
            case R.id.btn16:
                mergeDataAndShow();
                break;
            case R.id.btn17:
                getDataFromDiskAndCaches();
                break;
//            case R.id.btn18:
//                jointJudgment();
//                break;
            case R.id.btn19:
                subscribeDemo();
                break;
            case R.id.btn20:
                delayDemo();
                break;
            case R.id.btn21:
                doOnLifeCycleDemo();
                break;
            case R.id.btn22:
                onErrorReturnDemo();
                break;
            case R.id.btn23:
                onErrorResumeNextDemo();
                break;
            case R.id.btn24:
                onExceptionResumeNextDemo();
                break;
            case R.id.btn25:
                retryDemo();
                break;
            case R.id.btn26:
                retryUntilDemo();
                break;
            case R.id.btn27:
                retryWhenDemo();
                break;
            case R.id.btn28:
                repeatDemo();
                break;
            case R.id.btn29:
                repeatWhenDemo();
                break;
            case R.id.btn30:
                threadScheduling();
                break;
            case R.id.btn31:
                hasConditionalPolling();
                break;
            case R.id.btn32:
                requestErrorReconnection();
                break;
            case R.id.btn33:
                filterDemo();
                break;
            case R.id.btn34:
                ofTypeDemo();
                break;
            case R.id.btn35:
                skipOrSkipLastDemo();
                break;
            case R.id.btn36:
                distinctOrDistinctUntilChangedDemo();
                break;
            case R.id.btn37:
                takeDemo();
                break;
            case R.id.btn38:
                takeLastDemo();
                break;
            case R.id.btn39:
                throttleDemo();
                break;
            case R.id.btn40:
                throttleWithTimeoutOrDebounceDemo();
                break;
            case R.id.btn41:
                firstElementOrLastElementDemo();
                break;
            case R.id.btn42:
                elementAtDemo();
                break;
            case R.id.btn43:
                elementAtOrErrorDemo();
                break;
//            case R.id.btn44:
//                functionalAntiShake();
//                break;
            case R.id.btn45:
                allTakeWhileTakeUntilDemo();
                break;
            case R.id.btn46:
                skipWhileSkipUntilSequenceEqualDemo();
                break;
            case R.id.btn47:
                containsIsEmptyAmbDefaultIfEmptyDemo();
                break;
            case R.id.btn48:
                basicUseOfFlowable();
                break;
            case R.id.btn49:
                codeDemonstation1();
                break;
            case R.id.btn50:
                codeDemonstation2();
                break;
            case R.id.btn51:
                synchronizeSubscription();
                break;
            case R.id.btn52:
                synchronizeControlSpeed();
                break;
            case R.id.btn53:
                synchronizeControlSpeedFeature1();
                break;
            case R.id.btn54:
                synchronizeControlSpeedFeature2();
                break;
            case R.id.btn55:
                synchronizeControlSpeedFeature3();
                break;
            case R.id.btn56:
                asynchronousSubscription();
                break;
            case R.id.btn57:
                asynchronousSubscriptionLogic.request(48);
                // 点击按钮 则 接收48个事件
                break;
            case R.id.btn58:
                backPressureMode();
                break;
            case R.id.btn59:
                backPressureMode2();
                break;
            default:
                break;
        }
    }

    /**
     * 无限轮询
     */
    private void getTranslationData() {
        /*
         * 步骤1：采用interval（）延迟发送
         * 注：此处主要展示无限次轮询，若要实现有限次轮询，仅需将interval（）改成intervalRange（）即可
         **/
        // 延迟2s后发送事件，每隔1秒产生1个数字（从0开始递增1，无限个）
        Observable.interval(2, 1, TimeUnit.SECONDS)
                /*
                 * 步骤2：每次发送数字前发送1次网络请求（doOnNext（）在执行Next事件前调用）
                 * 即每隔1秒产生1个数字前，就发送1次网络请求，从而实现轮询需求
                 **/
                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.d(TAG, "第 " + aLong + " 次轮询");

                        /*
                         * 步骤3：通过Retrofit发送网络请求
                         **/
                        // a. 创建Retrofit对象
                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl("http://fy.iciba.com/")// 设置 网络请求 Url
                                .addConverterFactory(GsonConverterFactory.create())//设置使用Gson解析(记得加入依赖)
                                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())// 支持RxJava
                                .build();

                        // b. 创建 网络请求接口 的实例
                        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

                        // c. 采用Observable<...>形式 对 网络请求 进行封装
                        Observable<Translation> observable = apiInterface.getTranslationData("hello%20world");

                        // d. 通过线程切换发送网络请求
                        observable.subscribeOn(Schedulers.io()) // 切换到IO线程进行网络请求
                                .observeOn(AndroidSchedulers.mainThread()) // 切换回到主线程 处理请求结果
                                .subscribe(new Observer<Translation>() {
                                    @Override
                                    public void onSubscribe(Disposable d) {
                                        Log.e(TAG, "数据-onSubscribe: ");
                                    }

                                    @Override
                                    public void onNext(Translation translation) {
                                        Log.e(TAG, "数据-onNext: " + translation.toString());
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        Log.e(TAG, "数据-onError: " + e.toString());
                                    }

                                    @Override
                                    public void onComplete() {
                                        Log.e(TAG, "数据-onComplete: ");
                                    }
                                });

                    }
                }).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(Long aLong) {
                Log.e(TAG, "onNext: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: " + e.toString());
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete: ");
            }
        });
    }

    /**
     * 变换操作符Map(),整形转换为字符串类型
     */
    private void useMapConvertDemo() {
        // 采用RxJava基于事件流的链式操作
        Observable.create(new ObservableOnSubscribe<Integer>() {

            // 1. 被观察者发送事件 = 参数为整型 = 1、2、3
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onNext(4);
            }

            // 2. 使用Map变换操作符中的Function函数对被观察者发送的事件进行统一变换：整型变换成字符串类型
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return "使用 Map变换操作符 将事件" + integer + "的参数从 整型" + integer + " 变换成 字符串类型" + integer;
            }
        }).subscribe(new Consumer<String>() {

            // 3. 观察者接收事件时，是接收到变换后的事件 = 字符串类型
            @Override
            public void accept(String s) throws Exception {
                Log.e(TAG, "变换后的事件 - accept: " + s);
            }
        });
    }

    /**
     * 变换操作符FlatMap(),无序的将被观察者发送的事件序列进行变换
     */
    private void useFlatMapConvertDemo() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onNext(4);
            }

            // 采用flatMap（）变换操作符
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    list.add("我是事件" + integer + "拆分后的事件" + i);
                    // 通过flatMap中将被观察者生产的事件序列先进行拆分，再将每个事件转换为一个新的发送三个String事件
                    // 最终合并，再发送给被观察者
                }
                return Observable.fromIterable(list);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e(TAG, "accept: " + s);
            }
        });
    }

    /**
     * 变换操作符ConcatMap(),有序的将被观察者发送的事件序列进行变换
     */
    private void useConcatMapConvertDemo() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onNext(4);
            }
            // 采用concatMap（）变换操作符
        }).concatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    list.add("我是事件 " + integer + "拆分后的子事件" + i);
                    // 通过concatMap中将被观察者生产的事件序列先进行拆分，再将每个事件转换为一个新的发送三个String事件
                    // 最终合并，再发送给被观察者
                }
                return Observable.fromIterable(list);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e(TAG, "accept: " + s);
            }
        });
    }

    /**
     * 变换操作符Buffer(),缓存被观察者发送的事件
     */
    private void useBufferConvertDemo() {
        Observable.just(1, 2, 3, 4, 5)
                .buffer(3, 1)
                // 设置缓存区大小 & 步长
                // 缓存区大小 = 每次从被观察者中获取的事件数量
                // 步长 = 每次获取新事件的数量
                .subscribe(new Observer<List<Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(List<Integer> integers) {
                        Log.e(TAG, "onNext: " + integers.size());
                        for (Integer value : integers) {
                            Log.e(TAG, "value - onNext: " + value);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete: ");
                    }
                });
    }

    /**
     * 变换操作符实际用例：网络请求嵌套回调
     * 结合 RxJava2中的变换操作符FlatMap（）实现嵌套网络请求
     * 需要进行嵌套网络请求：即在第1个网络请求成功后，继续再进行一次网络请求
     * 如 先进行 用户注册 的网络请求, 待注册成功后回再继续发送 用户登录 的网络请求
     */
    private void nestedCallBacks() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Observable<Translation> register = apiInterface.getTranslationData("开始注册");
        final Observable<Translation> login = apiInterface.getTranslationData("开始登录");

        register.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Translation>() {
                    @Override
                    public void accept(Translation translation) throws Exception {
                        Log.e(TAG, "第1次网络请求成功");
                        Log.e(TAG, "accept: " + translation.getContent().getOut());
                        Log.e(TAG, "accept: " + translation.toString());
                        // 对第1次网络请求返回的结果进行操作 = 显示翻译结果
                    }
                })

                .observeOn(Schedulers.io())
                // （新被观察者，同时也是新观察者）切换到IO线程去发起登录请求
                // 特别注意：因为flatMap是对初始被观察者作变换，所以对于旧被观察者，它是新观察者，所以通过observeOn切换线程
                // 但对于初始观察者，它则是新的被观察者
                .flatMap(new Function<Translation, ObservableSource<Translation>>() { // 作变换，即作嵌套网络请求
                    @Override
                    public ObservableSource<Translation> apply(Translation translation) throws Exception {
                        // 将网络请求1转换成网络请求2，即发送网络请求2
                        return login;
                        // 模拟一个注册失败的样例：
//                        return translation.getStatus() == 1 ? Observable.<Translation>error(new Throwable()) : login;
                    }
                })

                // （初始观察者）切换到主线程 处理网络请求2的结果
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Translation>() {
                    @Override
                    public void accept(Translation translation) throws Exception {
                        Log.e(TAG, "第2次网络请求成功");
                        Log.e(TAG, "translation: " + translation.getContent().getOut());
                        Log.e(TAG, "translation: " + translation.toString());
                        // 对第1次网络请求返回的结果进行操作 = 显示翻译结果
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e(TAG, "登录失败 - throwable: " + throwable.toString());
                    }
                });
    }

    /**
     * 组合操作符,concat()/concatArray()，按发送顺序串行执行
     */
    private void concatOrConcatArrayDemo() {
        // concat()：组合多个被观察者（≤4个）一起发送数据
        // 注：串行执行
        Observable.concat(Observable.just(1, 2, 3),
                Observable.just(4, 5, 6),
                Observable.just(7, 8, 9),
                Observable.just(10, 11, 12))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "concat() - onSubscribe: ");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "concat() - onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "concat() - onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "concat() - onComplete: ");
                    }
                });

        // concatArray（）：组合多个被观察者一起发送数据（可＞4个）
        // 注：串行执行
        Observable.concatArray(Observable.just(1, 2, 3),
                Observable.just(4, 5, 6),
                Observable.just(7, 8, 9),
                Observable.just(10, 11, 12),
                Observable.just(13, 14, 15))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "concatArray() - onSubscribe: ");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "concatArray() - onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "concatArray() - onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "concatArray() - onComplete: ");
                    }
                });
    }

    /**
     * 组合操作符,merge()/mergeArray()，按时间线并行执行
     */
    private void mergeOrMergeArrayDemo() {
        // merge()：组合多个被观察者（＜4个）一起发送数据
        // mergeArray()：组合多个被观察者（不限数据）一起发送数据
        // 注：合并后按照时间线并行执行
        // Observable.intervalRange 创建操作符 从0开始共发送3个数据 首次延迟1s发送 间隔时间1s
        Observable.merge(Observable.intervalRange(0, 3, 1, 1, TimeUnit.SECONDS),
                Observable.intervalRange(2, 5, 1, 1, TimeUnit.SECONDS))
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "merge() - onSubscribe: ");
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.e(TAG, "merge() - onNext: " + aLong);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "merge() - onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "merge() - onComplete: ");
                    }
                });
    }

    /**
     * 组合操作符,concatDelayError()/mergeDelayError()
     */
    private void concatDelayErrorOrMergeDelayErrorDemo() {
        // a.没有使用concatDelayError()
        Observable.concat(Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                // 发送Error事件，因为无使用concatDelayError，所以第2个Observable将不会发送事件
                emitter.onError(new NullPointerException());
                emitter.onComplete();
            }
        }), Observable.just(4, 5, 6))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "没有使用concatDelayError() - onSubscribe: ");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "没有使用concatDelayError() - onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "没有使用concatDelayError() - onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "没有使用concatDelayError() - onComplete: ");
                    }
                });

        // b.使用concatDelayError()
        Observable.concatArrayDelayError(Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                // 发送Error事件，因为使用concatDelayError，所以第2个Observable将会发送事件
                emitter.onError(new NullPointerException());
                emitter.onComplete();
            }
        }), Observable.just(4, 5, 6))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "使用了concatDelayError() - onSubscribe: ");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "使用了concatDelayError() - onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "使用了concatDelayError() - onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "使用了concatDelayError() - onComplete: ");
                    }
                });

        // mergeDelayError() 操作符同理，不作过多演示
    }

    /**
     * 合并操作符,zip()按个数合并，即1对1合并
     */
    private void zipDemo() {
        /* 创建第1个被观察者 */
        Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.e(TAG, "zip() - subscribe: 被观察者1发送了事件1");
                emitter.onNext(1);
                // 为了方便展示效果，所以在发送事件后加入2s的延迟
                Thread.sleep(1000);

                Log.e(TAG, "zip() - subscribe: 被观察者1发送了事件2");
                emitter.onNext(2);
                Thread.sleep(1000);

                Log.e(TAG, "zip() - subscribe: 被观察者1发送了事件3");
                emitter.onNext(3);
                Thread.sleep(1000);

                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.io()); // 设置被观察者1在工作线程1中工作

        /* 创建第2个被观察者 */
        Observable<String> observable2 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                Log.e(TAG, "zip() - subscribe: 被观察者2发送了事件A");
                emitter.onNext("A");
                // 为了方便展示效果，所以在发送事件后加入2s的延迟
                Thread.sleep(1000);

                Log.e(TAG, "zip() - subscribe: 被观察者3发送了事件B");
                emitter.onNext("B");
                Thread.sleep(1000);

                Log.e(TAG, "zip() - subscribe: 被观察者1发送了事件C");
                emitter.onNext("C");
                Thread.sleep(1000);

                Log.e(TAG, "zip() - subscribe: 被观察者1发送了事件D");
                emitter.onNext("D");
                Thread.sleep(1000);

                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.newThread()); // 设置被观察者2在工作线程2中工作
        // 假设不作线程控制，则该两个被观察者会在同一个线程中工作，即发送事件存在先后顺序，而不是同时发送

        /* 使用zip变换操作符进行事件合并 */
        // 注：创建BiFunction对象传入的第3个参数 = 合并后数据的数据类型
        Observable.zip(observable1, observable2, new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer integer, String s) throws Exception {
                return integer + s;
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "zip() - onSubscribe: ");
            }

            @Override
            public void onNext(String s) {
                Log.e(TAG, "zip() - onNext: " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "zip() - onError: " + e.toString());
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "zip() - onComplete: ");
            }
        });

        // 2个被观察者：最后不发送onComplete()：尽管被观察者2的事件D没有事件与其合并，但还是会继续发送
        // 若在被观察者1 & 被观察者2的事件序列最后发送onComplete()事件，则被观察者2的事件D也不会发送

    }

    /**
     * 合并操作符,combineLatest()按时间合并，在同一个时间点上合并
     */
    private void combineLatestDemo() {
        Observable.combineLatest(Observable.just(1L, 2L, 3L),
                // 第1个发送数据事件的Observable
                // 第2个发送数据事件的Observable：从0开始发送、共发送3个数据、第1次事件延迟发送时间 = 1s、间隔时间 = 1s
                Observable.intervalRange(0, 3, 1, 1, TimeUnit.SECONDS),
                new BiFunction<Long, Long, Long>() {
                    @Override
                    public Long apply(Long aLong1, Long aLong2) throws Exception {
                        // aLong1 = 第1个Observable发送的最新（最后）1个数据 ----> 3L
                        // aLong2 = 第2个Observable发送的每1个数据 ----> 0 1 2
                        Log.e(TAG, "combineLatest() - apply: aLong1 = " + aLong1 + ",aLong2 = " + aLong2);
                        // 合并的逻辑 = 相加
                        // 即第1个Observable发送的最后1个数据 与 第2个Observable发送的每1个数据进行相加
                        return aLong1 + aLong2; // 3 + 0 = 3   3 + 1 = 4   3 + 2 = 5
                    }
                }).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                Log.e(TAG, "combineLatest() - accept: " + aLong);
            }
        });

        // combineLatestDelayError（）
        //作用类似于concatDelayError（） / mergeDelayError（） ，即错误处理，此处不作过多描述
    }

    /**
     * 合并操作符,reduce()聚合
     * 把被观察者需要发送的事件聚合成1个事件 & 发送
     */
    private void reduceDemo() {
        Observable.just(1, 2, 3, 4)
                .reduce(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) throws Exception {
                        Log.e(TAG, "reduce() -apply: " + integer + "--" + integer2);
                        return integer * integer2;
                        // 本次聚合的逻辑是：全部数据相乘起来
                        // 原理：第1次取前2个数据相乘，之后每次获取到的数据 = 返回的数据 x 原始下1个数据
                        // 即：1*2=2  2*3=6 6*4=24
                        // reduce() 聚合规则根据自己的需求随意撰写
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e(TAG, "reduce() - accept: " + integer);
            }
        });
    }

    /**
     * 合并操作符,collect()
     */
    private void collectDemo() {
        Observable.just(1, 2, 3, 4, 5, 6)
                .collect(new Callable<ArrayList<Integer>>() {
                    @Override
                    public ArrayList<Integer> call() throws Exception {
                        return new ArrayList<>();
                    }
                }, new BiConsumer<ArrayList<Integer>, Integer>() {
                    @Override
                    public void accept(ArrayList<Integer> list, Integer integer) throws Exception {
                        // 参数说明：list = 容器，integer = 后者数据
                        list.add(integer);
                        // 对发送的数据进行收集
                        Log.e(TAG, "collect() - accept: integer = " + integer + ",list=" + list.toString());
                    }
                })
                .subscribe(new Consumer<ArrayList<Integer>>() {
                    @Override
                    public void accept(ArrayList<Integer> integers) throws Exception {
                        Log.e(TAG, "collect() - accept: " + integers);
                    }
                });
    }

    /**
     * 发送事件前追加发送事件,后调用先追加,startWith()/startWithArray()
     */
    private void startWithOrStartWithArrayDemo() {
        /* 在一个被观察者发送事件前，追加发送一些数据 */
        // 注：追加数据顺序 = 后调用先追加 startWithArray > startWith > just   --->  1 2 3 0 4 5 6
        Observable.just(4, 5, 6)
                .startWith(0)  // 追加单个数据 = startWith()
                .startWithArray(1, 2, 3) // 追加多个数据 = startWithArray()
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "追加发送一些数据 - onSubscribe: ");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "追加发送一些数据 - onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "追加发送一些数据 - onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "追加发送一些数据 - onComplete: ");
                    }
                });

        /* 在一个被观察者发送事件前，追加发送被观察者 & 发送数据 */
        // 注：追加数据顺序 = 后调用先追加 startWith > just  --->  1 2 3 4 5 6
        Observable.just(4, 5, 6)
                .startWith(Observable.just(1, 2, 3))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "追加发送被观察者 & 发送数据 - onSubscribe: ");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "追加发送被观察者 & 发送数据 - onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "追加发送被观察者 & 发送数据 - onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "追加发送被观察者 & 发送数据 - onComplete: ");
                    }
                });
    }

    /**
     * 统计发送事件数量,count()
     */
    private void countDemo() {
        // 注：返回结果 = Long类型
        Observable.just(1, 2, 3)
                .count()
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.e(TAG, "count() - accept: " + aLong);
                    }
                });

        Observable.just(1, 2, 3)
                .startWith(Observable.just(7, 8, 9))
                .startWith(0)
                .startWithArray(6, 7, 8)
                .count()
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.e(TAG, "count() - accept: " + aLong);
                    }
                });
    }

    String result = "数据源来自 = ";

    /**
     * 合并/组合操作符实际用例：合并数据源，同时展示
     * 此处采用merge()&zip()
     * merge() 实现较为简单的从(网络+本地)获取数据&同一展示
     * zip() 结合Retrofit与RxJava，实现较为复杂的合并2个网络请求向2个服务器获取数据&统一展示
     */
    private void mergeDataAndShow() {
        // a.采用merge()操作符
        /**
         * 设置第1个Observable：通过网络获取数据
         * 此处仅作网络请求的模拟
         */
        Observable<String> netWork = Observable.just("网络");
        /*
         * 设置第2个Observable：通过本地文件获取数据
         * 此处仅作本地文件请求的模拟
         **/
        Observable<String> file = Observable.just("本地文件");

        /*
         * 通过merge（）合并事件 & 同时发送事件
         **/
        Observable.merge(netWork, file)
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "合并数据源 & 同时展示 - merge() - onSubscribe: ");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "合并数据源 & 同时展示 - merge() - onNext: " + s);
                        result += s + "+";
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "合并数据源 & 同时展示 - merge() - onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "合并数据源 & 同时展示 - merge() - onComplete: " + result);
                    }
                });

        // a.采用zip()操作符
        /* 从不同数据源（2个服务器）获取数据，即 合并网络请求的发送 统一显示结果
            采用Get方法 对 金山词霸API 发送2个网络请求（将英文翻译成中文，翻译2次） & 将2次翻译的结果一起显示 */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Observable<Translation> observable1 =
                apiInterface.getTranslationData("你好").subscribeOn(Schedulers.io());
        Observable<Translation> observable2 =
                apiInterface.getTranslationData("世界").subscribeOn(Schedulers.io());

        Observable.zip(observable1, observable2,
                new BiFunction<Translation, Translation, String>() {
                    @Override
                    public String apply(Translation translation, Translation translation2) throws Exception {
                        Log.e(TAG, "合并数据源 & 同时展示 - zip() - apply: " + translation.toString() + "---" + translation2.toString());
                        return translation.getContent().getOut() + "---" + translation2.getContent().getOut();
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.e(TAG, "合并数据源 & 同时展示 - zip() - accept: " + s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e(TAG, "合并数据源 & 同时展示 - zip() - throwable: " + throwable.toString());
                    }
                });
    }

    /**
     * 合并/组合操作符实际用例：从磁盘/内存缓存中,获取缓存数据
     * 背景：需要向服务器获取数据
     * 冲突：每次获取数据都通过网络请求，浪费资源(流量时间)
     * 解决方案：从缓存中读物数据
     * 当需要获取数据时，先从本地磁盘/内存缓存获取，若缓存没有，则通过网络获取
     * 实现原理：组合操作符concat()   过滤操作符firstElement
     */
    private void getDataFromDiskAndCaches() {
        // 2变量用于模拟内存缓存 & 磁盘缓存中的数据
        final String memoryCache = null;
        final String diskCache = "从磁盘缓存中获取数据";

        /*
         * 设置第1个Observable：检查内存缓存是否有该数据的缓存
         **/
        Observable<String> memory = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                // 先判断内存缓存有无数据
                if (memoryCache != null) {
                    // 若有该数据，则发送
                    emitter.onNext(memoryCache);
                } else {
                    // 若无该数据，则直接发送结束事件
                    emitter.onComplete();
                }
            }
        });

        /*
         * 设置第2个Observable：检查磁盘缓存是否有该数据的缓存
         **/
        Observable<String> disk = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                // 先判断磁盘缓存有无数据
                if (diskCache != null) {
                    // 若有该数据，则发送
                    emitter.onNext(diskCache);
                } else {
                    // 若无该数据，则直接发送结束事件
                    emitter.onComplete();
                }
            }
        });

        /*
         * 设置第3个Observable：通过网络获取数据
         **/
        Observable<String> netWork = Observable.just("从网络中获取数据");

        /*
         * 通过concat（） 和 firstElement（）操作符实现缓存功能
         **/
        // 1. 通过concat（）合并memory、disk、network 3个被观察者的事件（即检查内存缓存、磁盘缓存 & 发送网络请求）
        //  contact是有顺序的 将它们按顺序串联成队列
        Observable.concat(memory, disk, netWork)
                // 2. 通过firstElement()，从串联队列中取出并发送第1个有效事件（Next事件），
                // 即依次判断检查memory、disk、network
                .firstElement()
                // 即本例的逻辑为：
                // a. firstElement()取出第1个事件 = memory，即先判断内存缓存中有无数据缓存；
                //      由于memoryCache = null，即内存缓存中无数据，所以发送结束事件（视为无效事件）
                // b. firstElement()继续取出第2个事件 = disk，即判断磁盘缓存中有无数据缓存：
                //      由于diskCache ≠ null，即磁盘缓存中有数据，所以发送Next事件（有效事件）
                // c. 即firstElement()已发出第1个有效事件（disk事件），所以停止判断。

                // 3. 观察者订阅
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.e(TAG, "从磁盘/内存缓存中,获取缓存数据 - accept: " + s);
                    }
                });
    }

    /**
     * 合并/组合操作符实际用例：联合判断多个事件
     * 如填写表单 作为联合判断功能展示
     * 即，表单里所有信息（姓名、年龄、职业等）都被填写后，才允许点击 "提交" 按钮
     * 采用 RxJava 组合操作符中的combineLatest（） 实现
     */
    private void jointJudgment() {
        /*
         * 步骤1：设置控件变量 & 绑定 findViewById
         **/

        /*
         * 步骤2：为每个EditText设置被观察者，用于发送监听事件
         * 说明：
         * 1. 此处采用了RxBinding：RxTextView.textChanges(name) = 对对控件数据变更进行监听（功能类似TextWatcher），
         *      需要引入依赖：compile 'com.jakewharton.rxbinding2:rxbinding:2.0.0'
         * 2. 传入EditText控件，点击任1个EditText撰写时，都会发送数据事件 = Function3（）的返回值（下面会详细说明）
         * 3. 采用skip(1)原因：跳过 一开始EditText无任何输入时的空值 此处不需要这个skip(1) 首次是空值  不应该让按钮可点击！
         **/
        Observable<CharSequence> nameObservable = RxTextView.textChanges(etName)/*.skip(1)*/;
        Observable<CharSequence> ageObservable = RxTextView.textChanges(etAge)/*.skip(1)*/;
        Observable<CharSequence> jobObservable = RxTextView.textChanges(etJob)/*.skip(1)*/;

        /*
         * 步骤3：通过combineLatest（）合并事件 & 联合判断
         **/
        Observable.combineLatest(nameObservable, ageObservable, jobObservable,
                new Function3<CharSequence, CharSequence, CharSequence, Boolean>() {
                    @Override
                    public Boolean apply(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) throws Exception {
                        /*
                         * 步骤4：规定表单信息输入不能为空
                         **/
                        // 1. 姓名信息
                        boolean isUserNameValid = !TextUtils.isEmpty(etName.getText());
                        // 除了设置为空，也可设置长度限制
//                        boolean isUserNameValid = !TextUtils.isEmpty(etName.getText())
//                                && (etName.getText().toString().length() > 2 && etName.getText().toString().length() < 9);

                        // 2. 年龄信息
                        boolean isUserAgeValid = !TextUtils.isEmpty(etAge.getText());
                        // 3.职业信息
                        boolean isUserJobValid = !TextUtils.isEmpty(etJob.getText());

                        /*
                         * 步骤5：返回信息 = 联合判断，即3个信息同时已填写，"提交按钮"才可点击
                         **/
                        return isUserNameValid && isUserAgeValid && isUserJobValid;
                    }
                }).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                /*
                 * 步骤6：返回结果 & 设置按钮可点击样式
                 **/
                Log.e(TAG, "合并/组合操作符实际用例：联合判断多个事件 - accept: " + aBoolean);
                btn18.setEnabled(aBoolean);
            }
        });

    }

    /**
     * 功能性操作符：subscribe()
     */
    private void subscribeDemo() {
//        observable.subscribe(observer);
//        前者 = 被观察者（observable）；后者 = 观察者（observer 或 subscriber）

        /* 1.分步骤的完整调用 */
        //  步骤1： 创建被观察者 Observable 对象
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        });

        // 步骤2：创建观察者 Observer 并 定义响应事件行为
        Observer<Integer> observer = new Observer<Integer>() {

            @Override
            public void onSubscribe(Disposable d) {
                // 默认最先调用复写的 onSubscribe（）
                Log.e(TAG, "分步骤的完整调用 - onSubscribe: ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG, "分步骤的完整调用 - onNext: " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "分步骤的完整调用 - onError: " + e.toString());
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "分步骤的完整调用 - onComplete: ");
            }
        };

        // 步骤3：通过订阅（subscribe）连接观察者和被观察者
        observable.subscribe(observer);

        /* 2. 基于事件流的链式调用 */
        Observable.create(new ObservableOnSubscribe<Integer>() {
            // 1. 创建被观察者 & 生产事件
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        }).subscribe(new Observer<Integer>() {
            // 2. 通过通过订阅（subscribe）连接观察者和被观察者
            // 3. 创建观察者 & 定义响应事件的行为
            @Override
            public void onSubscribe(Disposable d) {
                // 默认最先调用复写的 onSubscribe（）
                Log.e(TAG, "链式调用 - onSubscribe: ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG, "链式调用 - onNext: " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "链式调用 - onError: " + e.toString());
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "链式调用 - onComplete: ");
            }
        });

        // 扩展说明
        /* Observable.subscribe(Subscriber) 的内部实现
        public Subscription subscribe(Subscriber subscriber) {
            subscriber.onStart();
            // 在观察者 subscriber抽象类复写的方法 onSubscribe.call(subscriber)，用于初始化工作
            // 通过该调用，从而回调观察者中的对应方法从而响应被观察者生产的事件
            // 从而实现被观察者调用了观察者的回调方法 & 由被观察者向观察者的事件传递，即观察者模式
            // 同时也看出：Observable只是生产事件，真正的发送事件是在它被订阅的时候，即当 subscribe() 方法执行时
        }*/

    }

    /**
     * 功能性操作符：delay()
     */
    private void delayDemo() {
        /* 1. 指定延迟时间
                参数1 = 时间；参数2 = 时间单位
        delay( long delay, TimeUnit unit)
        2. 指定延迟时间 & 调度器
        参数1 = 时间；参数2 = 时间单位；参数3 = 线程调度器
        delay( long delay, TimeUnit unit, mScheduler scheduler)
        3. 指定延迟时间 & 错误延迟
        错误延迟，即：若存在Error事件，则如常执行，执行后再抛出错误异常
                参数1 = 时间；参数2 = 时间单位；参数3 = 错误延迟参数
        delay( long delay, TimeUnit unit,boolean delayError)
        4. 指定延迟时间 & 调度器 & 错误延迟
        参数1 = 时间；参数2 = 时间单位；参数3 = 线程调度器；参数4 = 错误延迟参数
        delay( long delay, TimeUnit unit, mScheduler scheduler,boolean delayError):指定延迟多长时间并添加调度器，
        错误通知可以设置是否延迟*/
        Observable.just(1, 2, 3)
                .delay(3, TimeUnit.SECONDS) // 延迟3s再发送，由于使用类似，所以此处不作全部展示
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "功能性操作符：delay() - onSubscribe: ");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "功能性操作符：delay() - onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "功能性操作符：delay() - onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "功能性操作符：delay() - onComplete: ");
                    }
                });

    }

    /**
     * 功能性操作符：do(),在某个事件的生命周期中调用
     */
    private void doOnLifeCycleDemo() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onError(new Throwable("发生错误了"));
            }
            // 1. 当Observable每发送1次数据事件就会调用1次
        }).doOnEach(new Consumer<Notification<Integer>>() {
            @Override
            public void accept(Notification<Integer> integerNotification) throws Exception {
                Log.e(TAG, "doOnEach: " + integerNotification.getValue());
            }
            // 2. 执行Next事件前调用
        }).doOnNext(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e(TAG, "doOnNext: " + integer);
            }
            // 3. 执行Next事件后调用
        }).doAfterNext(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e(TAG, "doAfterNext: " + integer);
            }
            // 4. Observable正常发送事件完毕后调用
        }).doOnComplete(new Action() {
            @Override
            public void run() throws Exception {
                Log.e(TAG, "doOnComplete: ");
            }
            // 5. Observable发送错误事件时调用
        }).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.e(TAG, "doOnError: " + throwable.toString());
            }
            // 6. 观察者订阅时调用
        }).doOnSubscribe(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                Log.e(TAG, "doOnSubscribe: ");
            }
            // 7. Observable发送事件完毕后调用，无论正常发送完毕 / 异常终止
        }).doAfterTerminate(new Action() {
            @Override
            public void run() throws Exception {
                Log.e(TAG, "doAfterTerminate: ");
            }
            // 8. 最后执行
        }).doFinally(new Action() {
            @Override
            public void run() throws Exception {
                Log.e(TAG, "doFinally: ");
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG, "onNext: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: ");
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete: ");
            }
        });
    }

    /**
     * 功能性操作符：onErrorReturn()
     * 遇到错误时，发送1个特殊事件 & 正常终止
     * 可捕获在它之前发生的异常
     */
    private void onErrorReturnDemo() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onError(new Throwable("发生错误了"));
            }
        }).onErrorReturn(new Function<Throwable, Integer>() {
            @Override
            public Integer apply(Throwable throwable) throws Exception {
                Log.e(TAG, "在onErrorReturn处理了错误: " + throwable.toString());

                return 666;
                // 发生错误事件后，发送一个"666"事件，最终正常结束
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "onErrorReturn - onSubscribe: ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG, "onErrorReturn - onNext: " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onErrorReturn - onError: " + e.toString());
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onErrorReturn - onComplete: ");
            }
        });
    }

    /**
     * 功能性操作符：onErrorResumeNext()
     * 遇到错误时，发送1个新的Observable
     * 拦截的错误 = Throwable
     * 若onErrorResumeNext（）拦截的错误 = Exception，则会将错误传递给观察者的onError方法
     */
    private void onErrorResumeNextDemo() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onError(new Throwable("发生错误了"));
            }
        }).onErrorResumeNext(new Function<Throwable, ObservableSource<? extends Integer>>() {
            @Override
            public ObservableSource<? extends Integer> apply(Throwable throwable) throws Exception {
                // 1. 捕捉错误异常
                Log.e(TAG, "在onErrorReturn处理了错误: " + throwable.toString());

                // 2. 发生错误事件后，发送一个新的被观察者 & 发送事件序列
                return Observable.just(22, 33);
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "onErrorResumeNext - onSubscribe: ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG, "onErrorResumeNext - onNext: " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onErrorResumeNext - onError: " + e.toString());
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onErrorResumeNext - onComplete: ");
            }
        });
    }

    /**
     * 功能性操作符：onExceptionResumeNext()
     * 遇到错误时，发送1个新的Observable
     * 拦截的错误 = Exception
     * 若onExceptionResumeNext（）拦截的错误 = Throwable，则会将错误传递给观察者的onError方法
     */
    private void onExceptionResumeNextDemo() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onError(new Exception("发生错误了"));
            }
        }).onExceptionResumeNext(new Observable<Integer>() {
            @Override
            protected void subscribeActual(Observer<? super Integer> observer) {
                observer.onNext(11);
                observer.onNext(22);
                observer.onComplete();
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "onExceptionResumeNext - onSubscribe: ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG, "onExceptionResumeNext - onNext: " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onExceptionResumeNext - onError: " + e.toString());
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onExceptionResumeNext - onComplete: ");
            }
        });
    }

    /**
     * 功能性操作符：retry()
     * 重试，即当出现错误时，让被观察者（Observable）重新发射数据
     * 1.接收到 onError（）时，重新订阅 & 发送事件
     * 2.Throwable 和 Exception都可拦截
     */
    private void retryDemo() {
        /*1. retry（）
        作用：出现错误时，让被观察者重新发送数据
        注：若一直错误，则一直重新发送

        2. retry（long time）
        作用：出现错误时，让被观察者重新发送数据（具备重试次数限制
                参数 = 重试次数

        3. retry（Predicate predicate）
        作用：出现错误后，判断是否需要重新发送数据（若需要重新发送 & 持续遇到错误，则持续重试）
        参数 = 判断逻辑

        4. retry（new BiPredicate<Integer, Throwable>）
        作用：出现错误后，判断是否需要重新发送数据（若需要重新发送 & 持续遇到错误，则持续重试
                参数 = 判断逻辑（传入当前重试次数 & 异常错误信息）

        5. retry（long time, Predicate predicate）
        作用：出现错误后，判断是否需要重新发送数据（具备重试次数限制
                参数 = 设置重试次数 & 判断逻辑*/

        // 1.retry()
        // 作用：出现错误时，让被观察者重新发送数据
        // 注：若一直错误，则一直重新发送 1 2 1 2 1 2 1 2 ...
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onError(new Exception("发生错误了"));
//                e.onNext(3);
//            }
//        })
//                .retry() // 遇到错误时，让被观察者重新发射数据（若一直错误，则一直重新发送）
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.e(TAG, "retry() - onSubscribe: ");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.e(TAG, "retry() - onNext: " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e(TAG, "retry() - onError: " + e.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.e(TAG, "retry() - onComplete: ");
//                    }
//                });

        // 2.retry(long time)
        // 作用：出现错误时，让被观察者重新发送数据（具备重试次数限制
        // 参数 = 重试次数
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onError(new Exception("发生错误了"));
//                e.onNext(3);
//            }
//        })
//                .retry(3) // 设置重试次数 = 3次
//                .subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.e(TAG, "retry(long time) - onSubscribe: ");
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                Log.e(TAG, "retry(long time) - onNext: " + integer);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.e(TAG, "retry(long time) - onError: " + e.toString());
//            }
//
//            @Override
//            public void onComplete() {
//                Log.e(TAG, "retry(long time) - onComplete: ");
//            }
//        });

        // 3.retry（Predicate predicate）
        // 作用：出现错误后，判断是否需要重新发送数据（若需要重新发送 & 持续遇到错误，则持续重试）
        // 参数 =  判断逻辑
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onError(new Exception("发生错误了"));
//                e.onNext(3);
//            }
//        })
//                // 拦截错误后，判断是否需要重新发送请求
//                .retry(new Predicate<Throwable>() {
//                    @Override
//                    public boolean test(@NonNull Throwable throwable) throws Exception {
//                        // 捕获异常
//                        Log.e(TAG, "retry（Predicate predicate） - retry错误: "+throwable.toString());
//
//                        //返回false = 不重新重新发送数据 & 调用观察者的onError结束
//                        //返回true = 重新发送请求（若持续遇到错误，就持续重新发送）
//                        return true;
//                    }
//                })
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//                    @Override
//                    public void onNext(Integer value) {
//                        Log.d(TAG, "retry（Predicate predicate） - 接收到了事件"+ value  );
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "retry（Predicate predicate） - 对Error事件作出响应");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "retry（Predicate predicate） - 对Complete事件作出响应");
//                    }
//                });

        // 4.retry（new BiPredicate<Integer, Throwable>）
        // 作用：出现错误后，判断是否需要重新发送数据（若需要重新发送 & 持续遇到错误，则持续重试
        // 参数 =  判断逻辑（传入当前重试次数 & 异常错误信息）
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onError(new Exception("发生错误了"));
//                e.onNext(3);
//            }
//            // 拦截错误后，判断是否需要重新发送请求
//        }).retry(new BiPredicate<Integer, Throwable>() {
//            @Override
//            public boolean test(Integer integer, Throwable throwable) throws Exception {
//                // 捕获异常
//                Log.e(TAG, "异常错误 =  "+throwable.toString());
//
//                // 获取当前重试次数
//                Log.e(TAG, "当前重试次数 =  "+integer);
//
//
//                // 返回false = 不重新重新发送数据 & 调用观察者的onError结束
//                // 返回true = 重新发送请求（若持续遇到错误，就持续重新发送）
////                return false;
//                return integer != 3;
//                // 重复3次之后，不再重新发送数据
//            }
//        }).subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.e(TAG, "retry（new BiPredicate<Integer, Throwable>）- onSubscribe: ");
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                Log.e(TAG, "retry（new BiPredicate<Integer, Throwable>）- onNext: " + integer);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.e(TAG, "retry（new BiPredicate<Integer, Throwable>）- onError: " + e.toString());
//            }
//
//            @Override
//            public void onComplete() {
//                Log.e(TAG, "retry（new BiPredicate<Integer, Throwable>）- onComplete: ");
//            }
//        });

        // 5. retry（long time,Predicate predicate）
        // 作用：出现错误后，判断是否需要重新发送数据（具备重试次数限制
        // 参数 = 设置重试次数 & 判断逻辑
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onError(new Exception("发生错误了"));
                e.onNext(3);
            }
            // 拦截错误后，判断是否需要重新发送请求
        }).retry(3, new Predicate<Throwable>() {
            @Override
            public boolean test(Throwable throwable) throws Exception {
                // 捕获异常
                Log.e(TAG, "retry错误: " + throwable.toString());

                //返回false = 不重新重新发送数据 & 调用观察者的onError（）结束
                //返回true = 重新发送请求（最多重新发送3次）
                return true;
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "retry（long time,Predicate predicate） - onSubscribe: ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG, "retry（long time,Predicate predicate） - onNext: " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "retry（long time,Predicate predicate） - onError: " + e.toString());
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "retry（long time,Predicate predicate） - onComplete: ");
            }
        });

    }

    /**
     * 出现错误后，判断是否需要重新发送数据
     * 1.若需要重新发送 & 持续遇到错误，则持续重试
     * 2.作用类似于retry（Predicate predicate）
     * 唯一区别：返回 true 则不重新发送数据事件
     * 返回false|true 都不重复发送数据 意义何在？
     */
    private void retryUntilDemo() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onError(new Exception("发生错误了"));
                e.onNext(3);
            }
        }).repeatUntil(new BooleanSupplier() {
            @Override
            public boolean getAsBoolean() throws Exception {
                // 是否需要重新发送数据
                // false true 都不重复发送数据
                return true;
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "repeatUntil - onSubscribe: ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG, "repeatUntil - onNext: " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "repeatUntil - onError: " + e.toString());
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "repeatUntil - onComplete: ");
            }
        });
    }

    /**
     * 遇到错误时，将发生的错误传递给一个新的被观察者（Observable），
     * 并决定是否需要重新订阅原始被观察者（Observable）& 发送事件
     */
    private void retryWhenDemo() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onError(new Exception("发生错误了"));
                e.onNext(3);
            }
        })
                // 遇到error事件才会回调
                .retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(final Observable<Throwable> throwableObservable) throws Exception {
                        // 参数Observable<Throwable>中的泛型 = 上游操作符抛出的异常 可通过该条件来判断异常的类型
                        // 返回Observable<?> = 新的被观察者 Observable（任意类型）
                        // 此时有2种情况：
                        // 1. 若 新的被观察者 Observable发送的事件 = Error事件，那么 原始Observable则不重新发送事件：
                        // 2. 若 新的被观察者 Observable发送的事件 = Next事件 ，那么原始的Observable则重新发送事件：
                        return throwableObservable.flatMap(new Function<Throwable, ObservableSource<?>>() {
                            @Override
                            public ObservableSource<?> apply(Throwable throwable) throws Exception {

                                // 1.若返回的Observable发送的事件 = Error事件，则原始的Observable不重新发送事件
                                // 该异常错误信息可在观察者中的onError（）中获得
//                                return Observable.error(new Throwable("retryWhen终止啦"));

                                // 2. 若返回的Observable发送的事件 = Next事件，则原始的Observable重新发送事件（若持续遇到错误，则持续重试）
                                return Observable.just(1);
                            }
                        });
                    }
                })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "retryWhen() - onSubscribe: ");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "retryWhen() - onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "retryWhen() - onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "retryWhen() - onComplete: ");
                    }
                });
    }

    /**
     * 功能性操作符：repeat()，无条件地、重复发送 被观察者事件
     * 具备重载方法，可设置重复创建次数
     */
    private void repeatDemo() {
        // 注：
        // 1. 接收到.onCompleted()事件后，触发重新订阅 & 发送
        // 2. 默认运行在一个新的线程上
        Observable.just(1, 2, 3, 4)
//                .repeat() // 无限次重复
                .repeat(3) // 重复创建次数 = 3次
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "repeat() - onSubscribe: ");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "repeat() - onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "repeat() - onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "repeat() - onComplete: ");
                    }
                });
    }

    /**
     * 功能性操作符：repeatWhen()，有条件地、重复发送 被观察者事件
     * 将原始 Observable 停止发送事件的标识（Complete（） /  Error（））转换成1个 Object 类型数据
     * 传递给1个新被观察者（Observable），以此决定是否重新订阅 & 发送原来的  Observable
     * 1.若新被观察者（Observable）返回1个Complete / Error事件，则不重新订阅 & 发送原来的 Observable
     * 2.若新被观察者（Observable）返回其余事件时，则重新订阅 & 发送原来的 Observable
     */
    private void repeatWhenDemo() {
        Observable.just(1, 2, 3, 4)
                // 在Function函数中，必须对输入的 Observable<Object>进行处理，这里我们使用的是flatMap操作符接收上游的数据
                .repeatWhen(new Function<Observable<Object>, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(Observable<Object> objectObservable) throws Exception {
                        // 将原始 Observable 停止发送事件的标识（Complete（） /  Error（））
                        // 转换成1个 Object 类型数据传递给1个新被观察者（Observable）
                        // 以此决定是否重新订阅 & 发送原来的 Observable
                        // 此处有2种情况：
                        // 1. 若新被观察者（Observable）返回1个Complete（） /  Error（）事件，则不重新订阅 & 发送原来的 Observable
                        // 2. 若新被观察者（Observable）返回其余事件，则重新订阅 & 发送原来的 Observable
                        return objectObservable.flatMap(new Function<Object, ObservableSource<?>>() {

                            @Override
                            public ObservableSource<?> apply(Object o) throws Exception {
                                // 情况1：若新被观察者（Observable）返回1个Complete（） /  Error（）事件，则不重新订阅 & 发送原来的 Observable
//                                return Observable.empty();
                                // Observable.empty() = 发送Complete事件，但不会回调观察者的onComplete（）

//                                 return Observable.error(new Throwable("不再重新订阅事件"));
                                // 返回Error事件 = 回调onError（）事件，并接收传过去的错误信息。

                                // 情况2：若新被观察者（Observable）返回其余事件，则重新订阅 & 发送原来的 Observable
                                return Observable.just(1);
                                // 仅仅是作为1个触发重新订阅被观察者的通知，发送的是什么数据并不重要，只要不是Complete（） /  Error（）事件
                            }
                        });
                    }
                }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "repeatWhen() - onSubscribe: ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG, "repeatWhen() - onNext: " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "repeatWhen() - onError: " + e.toString());
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "repeatWhen() - onComplete: ");
            }
        });
    }

    /**
     * 功能性操作符应用实例：线程控制(切换/调度)
     * 在RxJava模型中，被观察者(Observable)/观察者(Observer)的工作线程 = 创建自身的线程
     * 即：若被观察者/观察者在主线程被创建，那么他们的工作(生产事件/接收&响应事件)就发生在主线程
     * 对于一般的需求场景，需要在子线程中实现耗时的操作；然后回到主线程实现UI操作
     * 1.被观察者(Observable)在子线程中生产事件(如实现耗时操作)
     * 2.观察者(Observer)在主线程接收&响应事件(实现UI操作)
     */
    private void threadScheduling() {
        // 多种线程调度的类型
        // 1.Schedules.immediate()          当前线程 = 不指定线程    默认场景
        // 2.AndroidSchedules.mainThread()  Android主线程            操作UI
        // 3.Schedules.newThread()          常规新线程               耗时等操作
        // 4.Schedules.io()                 io操作线程               网络请求、读写文件等io密集型操作
        // 5.Schedules.computation()        CPU计算操作线程           大量继续操作

        // 1.若Observable.subscribe()多次指定被观察者生产事件的线程
        //          则只有第1次指定的有效，其余线程无效
        // 2.若Observable.observeOn（）多次指定观察者 接收 & 响应事件的线程，
        //          则每次指定均有效，即每指定一次，就会进行一次线程的切换


    }

    /**
     * 记录轮询次数
     */
    private int i = 0;

    /**
     * 功能性操作符应用实例：有条件轮询,测试采用repeatWhen()
     * 背景：客户端隔固定时间主动向服务器发送请求获取信息，可根据服务器返回停止轮询(有条件轮询)
     * 冲突：之前的实现方式较为复杂&可扩展性差：Handler发送延时消息/Timer定时器
     * 解决方案：才用RxJava中repeatWhen()操作符
     * 功能说明：采用Get方法对 金山词霸API 按规定时间重复发送网络请求，从而模拟 轮询 需求实现
     * 1.停止轮询的条件 = 当轮询到第4次
     * 2.采用 Gson 进行数据解析
     */
    private void hasConditionalPolling() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Observable<Translation> observable = apiInterface.getTranslationData("hello%20world");

        observable.repeatWhen(new Function<Observable<Object>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Observable<Object> objectObservable) throws Exception {
                return objectObservable.flatMap(new Function<Object, ObservableSource<?>>() {

                    @Override
                    public ObservableSource<?> apply(Object o) throws Exception {
                        // 加入判断条件：当轮询次数 = 5次后，就停止轮询
                        if (i > 3) {
                            // 此处选择发送onError事件以结束轮询，因为可触发下游观察者的onError（）方法回调
                            // Observable.empty() = 发送Complete事件，但不会回调观察者的onComplete（）
                            return Observable.error(new Throwable("停止轮询"));
                        }
                        // 若轮询次数＜4次，则发送1Next事件以继续轮询
                        // 注：此处加入了delay操作符，作用 = 延迟一段时间发送（此处设置 = 2s），以实现轮询间间隔设置
                        return Observable.just(1).delay(2, TimeUnit.SECONDS);
                    }
                });
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Translation>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "有条件轮询,测试采用repeatWhen() - onSubscribe: ");
                    }

                    @Override
                    public void onNext(Translation translation) {
                        Log.e(TAG, "有条件轮询,测试采用repeatWhen() - onNext: " + i);
                        i++;
                        Log.e(TAG, "有条件轮询,测试采用repeatWhen() - onNext: " + i);
                        Log.e(TAG, "有条件轮询,测试采用repeatWhen() - onNext: " + translation.getContent().getOut());
                    }

                    @Override
                    public void onError(Throwable e) {
                        // 获取轮询结束信息
                        Log.e(TAG, "有条件轮询,测试采用repeatWhen() - onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "有条件轮询,测试采用repeatWhen() - onComplete: ");
                    }
                });

    }

    /**
     * 可重试次数
     */
    private int maxConnecCount = 10;
    /**
     * 当前已重试次数
     */
    private int currentRetryCount = 0;
    /**
     * 重试等待时间
     */
    private int waitRetryTime = 0;

    /**
     * 功能性操作符应用实例：发送网络请求时的差错重连
     * 背景：发送网络请求过程中，会出现某些错误，从而导致请求失败
     * 解决方案：当发生错误请求失败时，自动重新发送网络请求，即差错自动重试机制
     * 实现原理：采用RxJava中的retryWhen()操作符
     * 具体说明：根据出错的错误类型，判断是否重试
     * 1.所有网络错误异常都属于I/O异常 = IOException
     * 2.其余异常都不在重试范围内
     * 若要重试，设置退避策略
     * 1.为请求重试设置1个合理的退避算法，而不是一出现错误马上重试
     * 2.合理的退避算法：
     * 1)遇到错误时应等待一段时间后再试
     * 2)若遇到的错误异常次数越多，(等待)退避时间应该越长
     * 3)限制可重复次数，避免无限重试
     * 4)功能总结：设置等待时间(随着错误异常次数真多可改变)，设置重复次数
     * 实例说明：用Get方法对 金山词霸API 发送网络请求
     * 1.通过 断开网络连接 模拟 网络异常错误（恢复网络即可成 功发送请求）
     * 2.限制重试次数 = 10次
     * 3.采用 Gson 进行数据解析
     */
    private void requestErrorReconnection() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Observable<Translation> observable = apiInterface.getTranslationData("hello%20world");

        // 发送网络请求 & 通过retryWhen（）进行重试
        // 注：主要异常才会回调retryWhen（）进行重试
        observable.retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Observable<Throwable> throwableObservable) throws Exception {
                // 参数Observable<Throwable>中的泛型 = 上游操作符抛出的异常，可通过该条件来判断异常的类型
                return throwableObservable.flatMap(new Function<Throwable, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(Throwable throwable) throws Exception {
                        Log.e(TAG, "发送网络请求时的差错重连retryWhen() - 发生异常 : " + throwable.toString());

                        /**
                         * 需求1：根据异常类型选择是否重试
                         * 即，当发生的异常 = 网络异常 = IO异常 才选择重试
                         */
                        if (throwable instanceof IOException) {
                            Log.e(TAG, "属于IO异常，需重试");
                            /**
                             * 需求2：限制重试次数
                             * 即，当已重试次数 < 设置的重试次数，才选择重试
                             */
                            if (currentRetryCount < maxConnecCount) {
                                // 记录重试次数
                                currentRetryCount++;
                                Log.e(TAG, "重试次数 = " + currentRetryCount);

                                /**
                                 * 需求2：实现重试
                                 * 通过返回的Observable发送的事件 = Next事件，从而使得retryWhen（）重订阅，最终实现重试功能
                                 *
                                 * 需求3：延迟1段时间再重试
                                 * 采用delay操作符 = 延迟一段时间发送，以实现重试间隔设置
                                 *
                                 * 需求4：遇到的异常越多，时间越长
                                 * 在delay操作符的等待时间内设置 = 每重试1次，增多延迟重试时间1s
                                 */
                                // 设置等待时间
                                waitRetryTime = 1000 + currentRetryCount * 1000;
                                Log.e(TAG, "等待时间 = " + waitRetryTime);
                                // TimeUnit.DAYS 天
                                // TimeUnit.HOURS 小时
                                // TimeUnit.MICROSECONDS 微秒
                                // TimeUnit.MILLISECONDS 毫秒
                                // TimeUnit.MINUTES 分钟
                                // TimeUnit.NANOSECONDS 纳秒
                                // TimeUnit.SECONDS 秒
                                return Observable.just(1).delay(waitRetryTime, TimeUnit.MILLISECONDS);
                            } else {
                                // 若重试次数已 > 设置重试次数，则不重试
                                // 通过发送error来停止重试（可在观察者的onError（）中获取信息）
                                return Observable.error(new Throwable("重试次数已超过设置次数 = " + currentRetryCount + "，即 不再重试"));
                            }

                        } else {
                            // 若发生的异常不属于I/O异常，则不重试
                            // 通过返回的Observable发送的事件 = Error事件 实现（可在观察者的onError（）中获取信息）
                            return Observable.error(new Throwable("发生了非网络异常（非I/O异常）"));
                        }
                    }
                });
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Translation>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "发送网络请求时的差错重连retryWhen() - onSubscribe: ");
                    }

                    @Override
                    public void onNext(Translation translation) {
                        Log.e(TAG, "发送网络请求时的差错重连retryWhen() - onNext: " + translation.getContent().getOut());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "发送网络请求时的差错重连retryWhen() - onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "发送网络请求时的差错重连retryWhen() - onComplete: ");
                    }
                });
    }

    /**
     * 过滤操作符，filter(),过滤特定条件的事件
     */
    private void filterDemo() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                // 1. 发送5个事件
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onNext(4);
                emitter.onNext(5);
            }
            // 2. 采用filter（）变换操作符
        }).filter(new Predicate<Integer>() {
            // 根据test()的返回值 对被观察者发送的事件进行过滤 & 筛选
            // a. 返回true，则继续发送
            // b. 返回false，则不发送（即过滤）
            @Override
            public boolean test(Integer integer) throws Exception {
                // 本例子 = 过滤了整数≤3的事件
                return integer > 3;
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "过滤操作符，filter(),过滤特定条件的事件 - onSubscribe: ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG, "过滤操作符，filter(),过滤特定条件的事件 - onNext: " + integer);
                // 4 5
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "过滤操作符，filter(),过滤特定条件的事件 - onError: " + e.toString());
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "过滤操作符，filter(),过滤特定条件的事件 - onComplete: ");
            }
        });
    }

    /**
     * 过滤操作符，ofType(),过滤特定数据类型的数据
     * Byte、Short、Integer、Long、Double、Float、Character、Boolean
     */
    private void ofTypeDemo() {
        Observable.just(1, "A", 2, "C", 3, "D", true, false)
                .ofType(Integer.class) // 筛选出 整型数据
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "过滤操作符，ofType(),过滤Integer类型的数据 = " + integer);
                    }
                });

        Observable.just(1, "A", 2, "C", 3, "D", true, false)
                .ofType(Boolean.class) // 筛选出 Boolean数据
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        Log.e(TAG, "过滤操作符，ofType(),过滤Boolean类型的数据 = " + aBoolean);
                    }
                });

        Observable.just(1, "A", 2, "C", 3, "D", true, false)
                .ofType(String.class) // 筛选出 String数据
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String str) throws Exception {
                        Log.e(TAG, "过滤操作符，ofType(),过滤String类型的数据 = " + str);
                    }
                });
    }

    /**
     * 过滤操作符，skip()/skipLast(),跳过某个事件
     */
    private void skipOrSkipLastDemo() {
        // 1.根据顺序跳过数据项
        Observable.just(1, 2, 3, 4, 5)
                .skip(1) // 跳过正序的前1项
                .skipLast(2) // 跳过正序的后2项
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "skip()/skipLast():根据顺序跳过数据项 " + integer);
                        // 2 3
                    }
                });

        // 2.根据时间跳过数据项
        // 发送事件特点：从0开始发送5个数据，每隔1s发送一次，每次递增1；第1次发送延迟0s
        Observable.intervalRange(0, 5, 0, 1, TimeUnit.SECONDS)
                .skip(1, TimeUnit.SECONDS) // 跳过第1s发送的数据
                .skipLast(1, TimeUnit.SECONDS) // 跳过最后1s发送的数据
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.e(TAG, "skip()/skipLast():根据时间跳过数据项" + aLong);
                        // 1 2 3
                    }
                });

    }

    /**
     * 过滤操作符，distinct()/distinctUntilChanged(),过滤事件序列中重复的事件 / 连续重复的事件
     */
    private void distinctOrDistinctUntilChangedDemo() {
        // 1：过滤事件序列中重复的事件
        Observable.just(1, 2, 3, 1, 2)
                .distinct()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "过滤操作符，distinct(): " + integer);
                        // 1 2 3
                    }
                });

        // 2：过滤事件序列中 连续重复的事件
        Observable.just(1, 2, 3, 1, 2, 3, 3, 4, 4)
                .distinctUntilChanged()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "过滤操作符，distinctUntilChanged(): " + integer);
                        // 1 2 3 1 2 3 4
                    }
                });

    }

    /**
     * 过滤操作符，take(),指定观察者最多能接收到的事件数量
     */
    private void takeDemo() {
        Observable.just(1, 2, 3, 4, 5, 6, 7)
                .take(2)
                // 采用take（）变换操作符
                // 指定了观察者只能接收2个事件
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "take(long count): " + integer);
                        // 1 2
                    }
                });
        Observable.intervalRange(0, 5, 0, 1, TimeUnit.SECONDS)
                .take(3, TimeUnit.SECONDS)
                // 采用take（）变换操作符
                // 指定了观察者接受到延迟3次的事件
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.e(TAG, "take(long time, TimeUnit unit):" + aLong);
                        // 0 1 2
                    }
                });
    }

    /**
     * 过滤操作符，take(),指定观察者只能接收到被观察者发送的最后几个事件
     */
    private void takeLastDemo() {
        Observable.just(1, 2, 3, 4, 5)
                .takeLast(3)  //指定观察者只能接受被观察者发送的最后3个事件
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "takeLast(): " + integer);
                        // 3 4 5
                    }
                });

        // 0 1 2 3 4
        Observable.intervalRange(0, 5, 0, 1, TimeUnit.SECONDS)
                .takeLast(3, TimeUnit.SECONDS)
                // 指定了观察者接受到最后延迟3次的事件
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.e(TAG, "takeLast(long time, TimeUnit unit)" + aLong);
                        // 2 3 4
                    }
                });
    }

    /**
     * 过滤操作符，throttleFirst()/throttleLast()/sample(),在某段时间内，只发送该段时间内第1次事件 / 最后1次事件
     * 如，1段时间内连续点击按钮，但只执行第1次的点击操作
     */
    private void throttleDemo() {
//        在某段时间内，只发送该段时间内第1次事件
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                // 隔段事件发送时间
                e.onNext(1);  // -- 1发出去 0s
                Thread.sleep(500);

                e.onNext(2); // -- 2发出去 0.5s
                Thread.sleep(400);

                e.onNext(3); // -- 3发出去 0.9s
                Thread.sleep(300);

                e.onNext(4); // -- 4发出去 1.2s
                Thread.sleep(300);

                e.onNext(5);// -- 5发出去 1.5s
                Thread.sleep(300);

                e.onNext(6);
                Thread.sleep(400);

                e.onNext(7);
                Thread.sleep(300);
                e.onNext(8);

                Thread.sleep(300);
                e.onNext(9);

                Thread.sleep(300);
                e.onComplete();
            }
        }).throttleFirst(1, TimeUnit.SECONDS) // 每1秒中采用数据
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "开始采用subscribe连接");
                    }

                    @Override
                    public void onNext(Integer value) {
                        Log.e(TAG, "接收到了事件" + value);
                        // 1 4 7
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "对Complete事件作出响应");
                    }
                });


//        在某段时间内，只发送该段时间内最后1次事件
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                // 隔段事件发送时间
                e.onNext(1);  // -- 1发出去 0s
                Thread.sleep(500);

                e.onNext(2); // -- 2发出去 0.5s
                Thread.sleep(400);

                e.onNext(3); // -- 3发出去 0.9s
                Thread.sleep(300);

                e.onNext(4); // -- 4发出去 1.2s
                Thread.sleep(300);

                e.onNext(5); // -- 5发出去 1.5s
                Thread.sleep(300);

                e.onNext(6);
                Thread.sleep(400);

                e.onNext(7);
                Thread.sleep(300);
                e.onNext(8);

                Thread.sleep(300);
                e.onNext(9);

                Thread.sleep(300);
                e.onComplete();
            }
        }).throttleLast(1, TimeUnit.SECONDS) // 每1秒中采用数据
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "开始采用subscribe连接");
                    }

                    @Override
                    public void onNext(Integer value) {
                        Log.e(TAG, "接收到了事件" + value);
                        // 3 6 9
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "对Complete事件作出响应");
                    }
                });

        // sample() 与 throttleLast（） 操作符类似
        // 在某段时间内，只发送该段时间内最新（最后）1次事件
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                // 隔段事件发送时间
                e.onNext(1);
                Thread.sleep(500);

                e.onNext(2);
                Thread.sleep(400);

                e.onNext(3);
                Thread.sleep(300);

                e.onNext(4);
                Thread.sleep(300);

                e.onNext(5);
                Thread.sleep(300);

                e.onNext(6);
                Thread.sleep(400);

                e.onNext(7);
                Thread.sleep(300);
                e.onNext(8);

                Thread.sleep(300);
                e.onNext(9);

                Thread.sleep(300);
                e.onComplete();
            }
        })
                .sample(1, TimeUnit.SECONDS)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "开始采用subscribe连接");
                    }

                    @Override
                    public void onNext(Integer value) {
                        Log.e(TAG, "接收到了事件" + value);
                        // 3 6 9
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "对Complete事件作出响应");
                    }
                });
    }

    /**
     * 过滤操作符，throttleWithTimeout()/debounce()
     * 发送数据事件时，若2次发送事件的间隔＜指定时间，就会丢弃前一次的数据，保留后一件事件
     * 若2次发送事件的间隔>=指定时间，就会之前被保留的事件将发出
     * todo 重点-----直到指定时间内都没有新数据发射时才会发送后一次的数据
     */
    private void throttleWithTimeoutOrDebounceDemo() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                // 隔段事件发送时间
                e.onNext(1);
                Thread.sleep(500);
                e.onNext(2); // 1和2之间的间隔小于指定时间1s，所以前1次数据（1）会被抛弃，2会被保留
                Thread.sleep(1500);  // 因为2和3之间的间隔大于指定时间1s，所以之前被保留的2事件将发出
                e.onNext(3);
                Thread.sleep(1500);  // 因为3和4之间的间隔大于指定时间1s，所以3事件将发出
                e.onNext(4);
                Thread.sleep(500); // 因为4和5之间的间隔小于指定时间1s，所以前1次数据（4）会被抛弃，5会被保留
                e.onNext(5);
                Thread.sleep(500); // 因为5和6之间的间隔小于指定时间1s，所以前1次数据（5）会被抛弃，6会被保留
                e.onNext(6);
                Thread.sleep(1500); // 因为6和Complete之间的间隔大于指定时间1s，所以之前被保留的6事件将发出

                e.onComplete();
            }
        }).throttleWithTimeout(1, TimeUnit.SECONDS)//每1秒中采用数据
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer value) {
                        Log.e(TAG, "接收到了事件" + value);
                        // 2 3 6
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "对Complete事件作出响应");
                    }
                });

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                // 隔段事件发送时间
                e.onNext(1);
                Thread.sleep(500);
                e.onNext(2); // 1和2之间的间隔小于指定时间2s，所以前1次数据（1）会被抛弃，2会被保留
                Thread.sleep(2500);  // 因为2和3之间的间隔大于指定时间2s，所以之前被保留的2事件将发出
                e.onNext(3);
                Thread.sleep(2500);  // 因为3和4之间的间隔大于指定时间2s，所以3事件将发出
                e.onNext(4);
                Thread.sleep(300); // 因为4和5之间的间隔小于指定时间2s，所以前1次数据（4）会被抛弃，5会被保留
                e.onNext(5);
                Thread.sleep(2000); // 因为5和6之间的间隔 >= 指定时间2s，之前被保留的5事件将发出
                e.onNext(6);
                Thread.sleep(2500); // 因为6和Complete实践之间的间隔大于指定时间2s，所以之前被保留的6事件将发出

                e.onComplete();
            }
        }).debounce(2, TimeUnit.SECONDS)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer value) {
                        Log.e(TAG, "接收到了事件" + value);
                        // 2 3 5 6
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "对Complete事件作出响应");
                    }
                });
    }

    /**
     * 过滤操作符，firstElement()/lastElement()，仅选取第1个元素 / 最后一个元素
     */
    private void firstElementOrLastElementDemo() {
        // 获取第1个元素
        Observable.just(1, 2, 3, 4, 5)
                .firstElement()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "firstElement() -  获取第1个元素 - " + integer);
                        // 1
                    }
                });

        // 获取最后1个元素
        Observable.just(1, 2, 3, 4, 5)
                .lastElement()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "firstElement() -  获取最后1个元素 - " + integer);
                        // 5
                    }
                });
    }

    /**
     * 过滤操作符，elementAt()，指定接收某个元素（通过 索引值 确定）
     * 注：允许越界，即获取的位置索引 ＞ 发送事件序列长度
     */
    private void elementAtDemo() {
        // 使用1：获取位置索引 = 2的 元素
        // 位置索引从0开始
        Observable.just(1, 2, 3, 4, 5)
                .elementAt(2)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "elementAt(long index): " + integer);
                    }
                });

        // 使用2：获取的位置索引 ＞ 发送事件序列长度时，设置默认参数
        Observable.just(1, 2, 3, 4, 5)
//                .elementAt(4, 6) // 5
                .elementAt(6, 10) // 10
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "elementAt(long index, T defaultItem): " + integer);
                    }
                });
    }

    /**
     * 过滤操作符，elementAtOrError()，在elementAt（）的基础上，
     * 当出现越界情况（即获取的位置索引 ＞ 发送事件序列长度）时，即抛出异常崩溃
     */
    private void elementAtOrErrorDemo() {
        Observable.just(1, 2, 3, 4, 5)
                .elementAtOrError(6)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "elementAtOrError(): " + integer);
                    }
                });
    }

    /**
     * 过滤操作符实际应用：功能防抖
     * 背景：用户只需要使用功能1次
     * 冲突：由于外部原因，多次触发功能，导致出现冗余功能操作
     * 例子：用户只需使用网络请求功能1次(点击按钮)
     * 但网络不好，点击1次后用户发现无响应，多次点击，最终发出多个请求
     * 解决方案：功能防抖
     * 原理：通过根据指定时间 过滤事件 的过滤操作符实现，防止功能的抖动
     * throttleFirst() 规定时间，仅会响应1次操作
     */
    private void functionalAntiShake() {
        RxView.clicks(btn44).throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "功能防抖throttleFirst() - onSubscribe: ");
                    }

                    @Override
                    public void onNext(Object o) {
                        Log.e(TAG, "功能防抖throttleFirst() - onNext: ");

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "功能防抖throttleFirst() - onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "功能防抖throttleFirst() - onComplete: ");
                    }
                });
    }

    /**
     * 过滤操作符实际应用：联想搜索优化
     * 背景：每当用户输入一个字符，即显示与输入框内支字符关的搜索结果
     * 基本流程：1.通过editText.addTextChangedListener()监听输入框变化
     * 2.当输入框发生变化后，回调afterTextChanged() 将当前输入框内文字向服务器发起请求
     * 3.服务器返回与该搜索文字相关联结果
     * 冲突：在用户搜索需求明确情况下(体现为连续输入)，可能发起一些不必要的请求
     * 例子：用户搜索需求明确 = abc,即连续输入了abc
     * 按上面实现，客户端会向服务器发起a、ab、abc 3个网络请求
     * 即：多发起了a、ab 2个不必要的请求
     * 解决方案：通过根据指定时间过滤事件 的过滤操作符(debounce)实现，防止不必要的网络请求
     * 功能说明：当输入框发生变化，不会立即将当前输入框内文字发送给服务器，而是等待一段时间
     * 若在这段时间内，输入框内不再有文字输入(无变化时)，那么才发送输入框内文字给服务器
     * 若在这段时间内，输入框有文字输入(发生变化)，则继续等待该段时间，循环上述事件
     */
    private void searchOptimization() {
        /*
         * 说明
         * 1. 此处采用了RxBinding：RxTextView.textChanges(name) = 对对控件数据变更进行监听（功能类似TextWatcher），
         *              需要引入依赖：compile 'com.jakewharton.rxbinding2:rxbinding:2.0.0'
         * 2. 传入EditText控件，输入字符时都会发送数据事件（此处不会马上发送，因为使用了debounce（））
         * 3. 采用skip(1)原因：跳过 第1次请求 = 初始输入框的空字符状态
         **/
        RxTextView.textChanges(etSearch)
                .debounce(1, TimeUnit.SECONDS).skip(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CharSequence>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "过滤操作符实际应用：联想搜索优化debounce() - onSubscribe: ");
                    }

                    @Override
                    public void onNext(CharSequence charSequence) {
                        Log.e(TAG, "过滤操作符实际应用：联想搜索优化debounce() - onNext: " + charSequence.toString());
                        tvSearch.setText("发送给服务器的字符 = " + charSequence.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "过滤操作符实际应用：联想搜索优化debounce() - onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "过滤操作符实际应用：联想搜索优化debounce() - onComplete: ");
                    }
                });
    }

    /**
     * 条件/布尔操作符：
     * all() 判断发送的每项数据是否都满足 设置的函数条件,若满足，返回 true；否则，返回 false
     * takeWhile() 判断发送的每项数据是否满足 设置函数条件,若发送的数据满足该条件，则发送该项数据；否则不发送
     * takeUntil() 执行到某个条件时，停止发送事件
     */
    private void allTakeWhileTakeUntilDemo() {
        // 1.all()
        Observable.just(1, 2, 3, 4, 5, 6)
                .all(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer <= 10;
                        // 该函数用于判断Observable发送的数据是否都满足integer<=10
                    }
                }).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                Log.e(TAG, "条件/布尔操作符：all(): " + aBoolean);
                // true
            }
        });

        // 2.takeWhile()
        // 每1s发送1个数据 = 从0开始，递增1，即0、1、2、3、5、6
        Observable.interval(1, TimeUnit.SECONDS)
                .takeWhile(new Predicate<Long>() {
                    @Override
                    public boolean test(Long aLong) throws Exception {
                        return aLong < 3;
                        // 当发送的数据满足<3时，才发送Observable的数据
                    }
                }).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                Log.e(TAG, "条件/布尔操作符：takeWhile():  " + aLong);
                // 0 1 2
            }
        });

        // 3.takeUntil()
        //      1)每1s发送1个数据 = 从0开始，递增1，即0、1、2、3、4
        Observable.interval(1, TimeUnit.SECONDS)
                .takeUntil(new Predicate<Long>() {
                    @Override
                    public boolean test(Long aLong) throws Exception {
                        return aLong > 3;
                        // 返回true时，就停止发送事件
                        // 当发送的数据满足>3时，就停止发送Observable的数据
                    }
                }).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                Log.e(TAG, "条件/布尔操作符：takeUntil(1):  " + aLong);
                // 0 1 2 3
            }
        });
        //      2)判断条件也可以是Observable
        Observable.interval(1, TimeUnit.SECONDS)
                // 第2个Observable：延迟5s后开始发送1个Long型数据
                .takeUntil(Observable.timer(5, TimeUnit.SECONDS))
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.e(TAG, "条件/布尔操作符：takeUntil(2):  " + aLong);
                        // 0 1 2 3 4
                    }
                });

    }

    /**
     * 条件/布尔操作符：
     * skipWhile() 判断发送的每项数据是否满足 设置函数条件,直到该判断条件 = false时，才开始发送Observable的数据
     * skipUntil() 等到 skipUntil（） 传入的Observable开始发送数据，（原始）第1个Observable的数据才开始发送数据
     * sequenceEqual() 判定两个Observables需要发送的数据是否相同,若相同，返回 true；否则，返回 false
     */
    private void skipWhileSkipUntilSequenceEqualDemo() {
        // 1.skipWhile()
        // 每隔1s发送1个数据 = 从0开始，每次递增1
        Observable.interval(1, TimeUnit.SECONDS)
                // 2. 通过skipWhile（）设置判断条件
                .skipWhile(new Predicate<Long>() {
                    @Override
                    public boolean test(Long aLong) throws Exception {
                        return aLong < 5;
                        // 直到判断条件不成立 = false = 发射的数据≥5，才开始发送数据
                    }
                }).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                Log.e(TAG, "条件/布尔操作符：skipWhile(): " + aLong);
                // 5 6 7 8 9 ...
            }
        });

        // 2.skipUntil()
        // （原始）第1个Observable：每隔1s发送1个数据 = 从0开始，每次递增1
        Observable.interval(1, TimeUnit.SECONDS)
                // 第2个Observable：延迟5s后开始发送1个Long型数据
                .skipUntil(Observable.timer(5, TimeUnit.SECONDS))
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.e(TAG, "条件/布尔操作符：skipUntil(): " + aLong);
                        // 4 5 6 7 8 9 ...
                        // todo 第5s开始发送，从4开始算起
                    }
                });

        // 3.sequenceEqual()
        Observable.sequenceEqual(
                Observable.just(1, 2, 3),
                Observable.just(1, 2, 3)
        ).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                Log.e(TAG, "条件/布尔操作符：sequenceEqual(): 2个Observable是否相同--" + aBoolean);
                // true
            }
        });

    }

    /**
     * 条件/布尔操作符：
     * contains() 判断发送的数据中是否包含指定数据 若包含，返回 true；否则，返回 false	内部实现 = exists（）
     * isEmpty() 判断发送的数据是否为空 若为空，返回 true；否则，返回 false
     * amb() 当需要发送多个 Observable时，只发送 先发送数据的Observable的数据，而其余 Observable则被丢弃。
     * defaultIfEmpty() 在不发送任何有效事件（ Next事件）、仅发送了 Complete 事件的前提下，发送一个默认值
     */
    private void containsIsEmptyAmbDefaultIfEmptyDemo() {
        // 1.contains()
        Observable.just(1, 2, 3, 4, 5, 6)
                .contains(4)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        Log.e(TAG, "条件/布尔操作符: contains(): " + aBoolean);
                        // true
                    }
                });

        // 2.isEmpty()
        Observable.just(1, 2, 3, 4, 5, 6)
                .isEmpty()
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        Log.e(TAG, "条件/布尔操作符: isEmpty(): " + aBoolean);
                        // false
                    }
                });

        // 3.amb()
        // 设置2个需要发送的Observable & 放入到集合中
        List<ObservableSource<Integer>> list = new ArrayList<>();
        // 第1个Observable延迟1秒发射数据
        list.add(Observable.just(1, 2, 3).delay(1, TimeUnit.SECONDS));
        // 第2个Observable正常发送数据
        list.add(Observable.just(4, 5, 6));

        // 一共需要发送2个Observable的数据
        // 但由于使用了amb(),所以仅发送先发送数据的Observable
        // 即第二个（因为第1个延时了）
        Observable.amb(list).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e(TAG, "条件/布尔操作符: amb(): " + integer);
                // 4 5 6
            }
        });

        // 4.defaultIfEmpty()
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                // 不发送任何有效事件
                //  e.onNext(1);
                //  e.onNext(2);

                // 仅发送Complete事件
                emitter.onComplete();
            }
        }).defaultIfEmpty(10)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "条件/布尔操作符: defaultIfEmpty():onSubscribe: ");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "条件/布尔操作符: defaultIfEmpty():onNext: " + integer);
                        // 10
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "条件/布尔操作符: defaultIfEmpty():onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "条件/布尔操作符: defaultIfEmpty():onComplete: ");
                    }

                });

    }

    /**
     * 背压策略：Flowable的基础使用
     */
    private void basicUseOfFlowable() {
        // 例子：被观察者发送事件速度 = 10ms/个，观察者接收事件速度 = 5s/个
        // 即,出现发送 & 接收事件严重不匹配的问题
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            // 1. 创建被观察者 & 生产事件
//            @Override
//            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
//                for (int i=0;;i++) {
//                    Log.e(TAG, "发送了事件: " + i);
//                    Thread.sleep(10);
//                    // 发送事件速度：10ms / 个
//                    emitter.onNext(i);
//                }
//            }
//        }).subscribeOn(Schedulers.io()) // 设置被观察者在io线程中进行
//                .observeOn(AndroidSchedulers.mainThread()) // 设置观察者在主线程中进行
//                .subscribe(new Observer<Integer>() {
//                    // 2. 通过通过订阅（subscribe）连接观察者和被观察者
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.e(TAG, "开始采用subscribe连接");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        try {
//                            Thread.sleep(5000);
//                            // 接收事件速度：5s / 个
//                            Log.e(TAG, "接收到了事件: " + integer);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e(TAG, "对Error事件作出响应: " + e.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.e(TAG, "对Complete事件作出响应: ");
//                    }
//                });
//        //  被观察者发送事件速度 > 观察者接收事件速度，所以出现流速不匹配问题，从而导致OOM


        // todo 背压策略解决方案：
        // 在 RxJava2.0中，采用 Flowable 实现 背压策略 “非阻塞式背压” 策略
        // Flowable 特点：
        // 1.对应的观察者变为Subscriber
        //      (被观察者)Flowable - Subscribe(观察者)
        //      RxJava1.0 旧观察者模型 (被观察者)Observable - Observer(观察者)
        // 2.所有的操作符强制支持背压
        //      Flowable中的操作符大多与旧有的Observable类似
        // 3.缓存区存放策略
        //      按发送的顺序保存在缓存区 即 先发送 - 先进入缓存区
        //      先进缓存区的事件先取出
        //      类似队列，实际上，在zip()内部的实现 = 队列
        // 4.默认的缓存区(队列)大小 = 128
        // 那么，为什么要采用新实现Flowable实现背压，而不采用旧的Observable呢？
        // 主要原因：旧实现Observable无法很好解决背压问题。


        // Flowable的基础使用 Flowable的基础使用非常类似于 Observable
        /**
         * 步骤1：创建被观察者 =  Flowable
         */
//        Flowable<Integer> flowable = Flowable.create(new FlowableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
//                emitter.onNext(1);
//                emitter.onNext(2);
//                emitter.onNext(3);
//                emitter.onComplete();
//            }
//        }, BackpressureStrategy.ERROR);
//        // 需要传入背压参数BackpressureStrategy，下面会详细讲解
//
//        /**
//         * 步骤2：创建观察者 =  Subscriber
//         */
//        Subscriber<Integer> subscriber = new Subscriber<Integer>() {
//
//            @Override
//            public void onSubscribe(Subscription s) {
//                // 对比Observer传入的Disposable参数，Subscriber此处传入的参数 = Subscription
//                // 相同点：Subscription具备Disposable参数的作用，即Disposable.dispose()切断连接, 同样的调用Subscription.cancel()切断连接
//                // 不同点：Subscription增加了void request(long n)
//                Log.e(TAG, "onSubscribe: ");
//                s.request(Long.MAX_VALUE);
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                Log.e(TAG, "onNext: " + integer);
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                Log.e(TAG, "onError: " + t.toString());
//            }
//
//            @Override
//            public void onComplete() {
//                Log.e(TAG, "onComplete: ");
//            }
//        };

        /**
         * 步骤3：建立订阅关系
         */
//        flowable.subscribe(subscriber);

        // 更加优雅的链式调用
        // 步骤1：创建被观察者 =  Flowable
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
                // 一共发送4个事件
                Log.e(TAG, "发送事件 1");
                emitter.onNext(1);
                Log.e(TAG, "发送事件 2");
                emitter.onNext(2);
                Log.e(TAG, "发送事件 3");
                emitter.onNext(3);
                Log.e(TAG, "发送事件 4");
                emitter.onNext(4);
                Log.e(TAG, "发送完成");
                emitter.onComplete();
            }
        }, BackpressureStrategy.ERROR)
                .subscribeOn(Schedulers.io()) // 设置被观察者在io线程中进行
                .observeOn(AndroidSchedulers.mainThread()) // 设置观察者在主线程中进行
                .subscribe(new Subscriber<Integer>() {
                    // 步骤2：创建观察者 =  Subscriber & 建立订阅关系
                    @Override
                    public void onSubscribe(Subscription s) {
                        // 对比Observer传入的Disposable参数，Subscriber此处传入的参数 = Subscription
                        // 相同点：Subscription参数具备Disposable参数的作用，即Disposable.dispose()切断连接, 同样的调用Subscription.cancel()切断连接
                        // 不同点：Subscription增加了void request(long n)
                        Log.e(TAG, "onSubscribe: ");
                        s.request(3);
                        // 作用：决定观察者能够接收多少个事件
                        // 如设置了s.request(3)，这就说明观察者能够接收3个事件（多出的事件存放在缓存区）
                        // 官方默认推荐使用Long.MAX_VALUE，即s.request(Long.MAX_VALUE);
                        // todo 若不设置，即说明观察者不接收事件
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e(TAG, "onError: " + t.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete: ");
                    }

                });

        // 结论：对于异步订阅情况(2者工作在不同线程)，若观察者没有设置Subscription.request(long n),说明观察者不接受事件
        //     todo 此时被观察者仍能继续发送事件(存放在缓存区)，等待观察者需要时再取出被观察者事件
        // 解释：观察者虽不接收事件 - 不设置Subscription.request(long n)
        //      todo 但由于一步订阅关系中存在缓存区 (大小 = 128)
        //      所以被观察者仍然能继续发送事件 & 暂时存储到缓存区 --- todo 异常：当缓存区存满时 (128个事件)，就会溢出报错
        //              只有当观察者有需求时，才从缓存区中按需取出事件  调用request(long n)
        // 额外：缓存区大小 = 128 由Flowable的buffersize大小决定

    }

    /**
     * 步骤1：设置变量
     */
    private Subscription mSubscription;

    /**
     * 代码演示1:观察者不接收事件的情况下，被观察者继续发送事件 存放到缓存区；再按需取出
     */
    private void codeDemonstation1() {
        /**
         * 步骤2：设置点击事件 = 调用Subscription.request（long n ）
         */
        mSubscription.request(2);
    }

    /**
     * 代码演示1:初始化必要的被观察者 & 观察者
     */
    private void initDemonstation1() {
        /**
         * 步骤3：异步调用
         */
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
                Log.e(TAG, "发送事件 1");
                emitter.onNext(1);
                Log.e(TAG, "发送事件 2");
                emitter.onNext(2);
                Log.e(TAG, "发送事件 3");
                emitter.onNext(3);
                Log.e(TAG, "发送事件 4");
                emitter.onNext(4);
                Log.e(TAG, "发送完成");
                emitter.onComplete();
            }
        }, BackpressureStrategy.ERROR)
                .subscribeOn(Schedulers.io()) // 设置被观察者在io线程中进行
                .observeOn(AndroidSchedulers.mainThread()) // 设置观察者在主线程中进行
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.e(TAG, "代码演示1::onSubscribe: ");
                        mSubscription = s;
                        // 保存Subscription对象，等待点击按钮时（调用request(2)）观察者再接收事件
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "代码演示1::onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e(TAG, "代码演示1::onError: " + t.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "代码演示1::onComplete: ");
                    }
                });
    }

    /**
     * 代码演示2:观察者不接收事件的情况下，被观察者继续发送事件至超出缓存区大小（128）
     */
    private void codeDemonstation2() {
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
                // 一共发送129个事件，即超出了缓存区的大小
                for (int i = 0; i < 129; i++) {
                    Log.e(TAG, "发送了事件: " + i);
                    emitter.onNext(i);
                }
                emitter.onComplete();
            }
        }, BackpressureStrategy.ERROR)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.e(TAG, "onSubscribe: ");
                        // 默认不设置可接收事件大小
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e(TAG, "onError: " + t.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete: ");
                    }
                });

    }

    /**
     * 同步订阅
     * 同步订阅 & 异步订阅 的区别在于：
     * 同步订阅中，被观察者 & 观察者工作于同1线程 同步订阅关系中没有缓存区
     */
    private void synchronizeSubscription() {
        // 被观察者在发送1个事件后，必须等待观察者接收后，才能继续发下1个事件
        /**
         * 步骤1：创建被观察者 =  Flowable
         */
        Flowable<Integer> flowable = Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
                // 发送3个事件
                Log.e(TAG, "被观察者发送事件数量 = 观察者接收事件数量: 发送了事件1");
                emitter.onNext(1);
                Log.e(TAG, "被观察者发送事件数量 = 观察者接收事件数量: 发送了事件2");
                emitter.onNext(2);
                Log.e(TAG, "被观察者发送事件数量 = 观察者接收事件数量: 发送了事件3");
                emitter.onNext(3);

                emitter.onComplete();
            }
        }, BackpressureStrategy.ERROR);

        /**
         * 步骤2：创建观察者 =  Subscriber
         */
        Subscriber<Integer> subscriber = new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                Log.e(TAG, "被观察者发送事件数量 = 观察者接收事件数量: onSubscribe");
                s.request(3);
                // 每次可接收事件 = 3 二次匹配
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG, "被观察者发送事件数量 = 观察者接收事件数量: onNext: " + integer);
            }

            @Override
            public void onError(Throwable t) {
                Log.e(TAG, "被观察者发送事件数量 = 观察者接收事件数量: onError: " + t.toString());
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "被观察者发送事件数量 = 观察者接收事件数量: onComplete: ");
            }
        };

        /**
         * 步骤3：建立订阅关系
         */
        flowable.subscribe(subscriber);

        // 所以，实际上并不会出现被观察者发送事件速度 > 观察者接收事件速度的情况。
        // 可是，却会出现被观察者发送事件数量 > 观察者接收事件数量的问题。
        // 如：观察者只能接受3个事件，但被观察者却发送了4个事件，所以出现了不匹配情况
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
                // 被观察者发送事件数量 = 4个
                Log.d(TAG, "被观察者发送事件数量 > 观察者接收事件数量： 发送了事件1");
                emitter.onNext(1);
                Log.d(TAG, "被观察者发送事件数量 > 观察者接收事件数量： 发送了事件2");
                emitter.onNext(2);
                Log.d(TAG, "被观察者发送事件数量 > 观察者接收事件数量： 发送了事件3");
                emitter.onNext(3);
                Log.d(TAG, "被观察者发送事件数量 > 观察者接收事件数量： 发送了事件4");
                emitter.onNext(4);
                emitter.onComplete();
            }
        }, BackpressureStrategy.ERROR)
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.e(TAG, "被观察者发送事件数量 > 观察者接收事件数量： onSubscribe: ");
                        s.request(3);
                        // 观察者接收事件 = 3个 ，即不匹配
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "被观察者发送事件数量 > 观察者接收事件数量： onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e(TAG, "被观察者发送事件数量 > 观察者接收事件数量： onError: " + t.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "被观察者发送事件数量 > 观察者接收事件数量： onComplete: ");
                    }
                });

        // todo 所以，对于没有缓存区概念的同步订阅关系来说，单纯采用控制观察者的接收事件数量（响应式拉取）
        // todo 实际上就等于 “单相思”，虽然观察者控制了要接收3个事件，但假设被观察者需要发送4个事件，还是会出现问题。

        // 特殊情况：若观察者没有设置Subscription.request(long n),此时被观察者开始发送事件，
        // 那么观察者将不会收到被观察者发送的任何事件 & 抛出MissingbackpressureException异常
        // 解释：观察者没有设置Subscription.request(long n),那么被观察者默认观察者没有处理事件能力
        //      所以观察者发送了1个事件后就不会再发送
        // 抛出异常原因：被观察者发送1个事件后都会等观察者接收完再继续发送事件
        //      既然观察者无法接受事件，那么被观察者一直等待会耗费资源，所以会抛异常来提醒观察者接收事件

    }

    /**
     * 背压策略：同步订阅：控制被观察者发送事件的速度
     * 原理：反馈控制
     * 即被观察者根据观察者的接收事件能力从而控制发送事件速度：
     * 观察者预先告知被观察者其事件接收能力
     * 被观察者在发送时间前获知被观察者其事件接收能力 & 调整事件发送速度
     * 实现方式：FlowableEmitter.requested()
     * 即通过被观察者中的FlowableEmitter类的requested()方法控制流速
     * 反向控制被观察者发送事件速度原理：
     * 同步订阅关系(被观察者 与 观察者 处于同一线程)：
     * 1.被观察者FlowableEmitter.requested()的返回值 = 观察者Subscription.request(a)中的a
     * 2.即被观察者通过FlowableEmitter.requested()知道了观察者自身接收事件的能力，从而根据该信息
     * 控制事件发送速度，从而达到了观察者反向控制被观察者的效果
     * 异步订阅关系(被观察者 与 观察者 处于不同线程)：
     * 1.被观察者FlowableEmitter.requested()的返回值 = 被观察者线程中RxJava内部调用的request(n)
     * 中的n的值(n=128、96、0)
     * 2.观察者requested()的返回值 = 观察者中的request(a)中的a
     * 3.由于二者处于不同线程，被关闭差值无法通过FlowableEmitter.requested()指导观察者自身的接收事件能力
     * 只能通过RxJava内部固定设置 从而反向控制被观察者发送事件速度
     */
    private void synchronizeControlSpeed() {
        // 下面的例子 = 被观察者根据观察者自身接收事件能力（10个事件），从而仅发送10个事件
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
                // 调用emitter.requested()获取当前观察者需要接收的事件数量
                long n = emitter.requested();

                Log.e(TAG, "观察者可接收事件:subscribe: " + n);

                // 根据emitter.requested()的值，即当前观察者需要接收的事件数量来发送事件
                for (int i = 0; i < n; i++) {
                    Log.e(TAG, "同步订阅：控制被观察者发送事件的速度 - 发送了事件: " + i);
                    emitter.onNext(i);
                }

            }
        }, BackpressureStrategy.ERROR).subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                Log.e(TAG, "同步订阅：控制被观察者发送事件的速度 - onSubscribe: ");

                // 设置观察者每次能接受10个事件
                s.request(10);
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG, "同步订阅：控制被观察者发送事件的速度 - onNext: " + integer);
            }

            @Override
            public void onError(Throwable t) {
                Log.e(TAG, "同步订阅：控制被观察者发送事件的速度 - onError: " + t.toString());
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "同步订阅：控制被观察者发送事件的速度 - onComplete: ");
            }
        });

        // todo 同步订阅情况中使用FlowableEmitter.requested():
        // 1.可叠加性：观察者可连续要求接收事件，被观察者会进行叠加并一起发送
        // 2.实时更新性：每次发送事件后，FlowableEmitter.requested()的返回值会实时更新观察者能接收的事件
        // 3.异常：当FlowableEmitter.requested()返回值为0，代表观察者已经不可以接收事件
        //      此时被观察者若继续发送事件，则会抛出MissingBackpressureException
        //      额外：若观察者没有设置可接收事件数量，即无调用Subscription.request()
        //          那么被观察者默认观察者可接收事件数量=0，即FLowableEmitter.requester()返回值为0
        //          因为同步订阅关系中，不存在缓存区的概念
    }

    /**
     * 情况1：可叠加性
     * 即：观察者可连续要求接收事件，被观察者会进行叠加并一起发送
     * Subscription.request（a1）；
     * Subscription.request（a2）；
     * FlowableEmitter.requested()的返回值 = a1 + a2
     */
    private void synchronizeControlSpeedFeature1() {
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
                // 调用emitter.requested()获取当前观察者需要接收的事件数量
                Log.e(TAG, "观察者可接收事件: " + emitter.requested());
            }
        }, BackpressureStrategy.ERROR)
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.e(TAG, "onSubscribe: ");
                        s.request(10); // 第1次设置观察者每次能接受10个事件
                        s.request(20); // 第2次设置观察者每次能接受20个事件
                    }

                    @Override
                    public void onNext(Integer integer) {

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 情况2：实时更新性
     * 即，每次发送事件后，emitter.requested()会实时更新观察者能接受的事件
     * 1.即一开始观察者要接收10个事件，发送了1个后，会实时更新为9个
     * 2.仅计算Next事件，complete & error事件不算。
     * <p>
     * Subscription.request（10）；
     * // FlowableEmitter.requested()的返回值 = 10
     * <p>
     * FlowableEmitter.onNext(1); // 发送了1个事件
     * // FlowableEmitter.requested()的返回值 = 9
     */
    private void synchronizeControlSpeedFeature2() {
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {

                // 1. 调用emitter.requested()获取当前观察者需要接收的事件数量
                Log.e(TAG, "观察者可接收事件数量 = " + emitter.requested());

                // 2. 每次发送事件后，emitter.requested()会实时更新观察者能接受的事件
                // 即一开始观察者要接收10个事件，发送了1个后，会实时更新为9个
                Log.e(TAG, "发送了事件 1");
                emitter.onNext(1);
                Log.e(TAG, "发送了事件1后, 还需要发送事件数量 = " + emitter.requested());

                Log.e(TAG, "发送了事件 2");
                emitter.onNext(2);
                Log.e(TAG, "发送事件2后, 还需要发送事件数量 = " + emitter.requested());

                Log.e(TAG, "发送了事件 3");
                emitter.onNext(3);
                Log.e(TAG, "发送事件3后, 还需要发送事件数量 = " + emitter.requested());

                emitter.onComplete();
            }
        }, BackpressureStrategy.ERROR)
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.d(TAG, "onSubscribe");

                        s.request(10); // 设置观察者每次能接受10个事件
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "接收到了事件" + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.w(TAG, "onError: ", t);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });
    }

    /**
     * 情况3：异常
     * 当FlowableEmitter.requested()减到0时，则代表观察者已经不可接收事件
     * 此时被观察者若继续发送事件，则会抛出MissingBackpressureException异常
     * <p>
     * 如观察者可接收事件数量 = 1，当被观察者发送第2个事件时，就会抛出异常
     */
    private void synchronizeControlSpeedFeature3() {
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {

                // 1. 调用emitter.requested()获取当前观察者需要接收的事件数量
                Log.d(TAG, "观察者可接收事件数量 = " + emitter.requested());

                // 2. 每次发送事件后，emitter.requested()会实时更新观察者能接受的事件
                // 即一开始观察者要接收10个事件，发送了1个后，会实时更新为9个
                Log.d(TAG, "发送了事件 1");
                emitter.onNext(1);
                Log.d(TAG, "发送了事件1后, 还需要发送事件数量 = " + emitter.requested());

                Log.d(TAG, "发送了事件 2");
                emitter.onNext(2);
                Log.d(TAG, "发送事件2后, 还需要发送事件数量 = " + emitter.requested());

                emitter.onComplete();
            }
        }, BackpressureStrategy.ERROR)
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                        Log.d(TAG, "onSubscribe");
                        s.request(1); // 设置观察者每次能接受1个事件

                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "接收到了事件" + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.w(TAG, "onError: ", t);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });
    }

    /**
     * 背压策略：异步订阅问题举例
     * 由于二者处于不同线程，所以被观察者 无法通过 FlowableEmitter.requested()知道观察者自身接收事件能力，
     * 即 被观察者不能根据 观察者自身接收事件的能力 控制发送事件的速度。具体请看下面例子
     */
    private void asynchronousSubscription() {
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
                // 调用emitter.requested()获取当前观察者需要接收的事件数量
                Log.e(TAG, "观察者可接收事件数量 = " + emitter.requested());
                // 128
            }
        }, BackpressureStrategy.ERROR)
                .subscribeOn(Schedulers.io()) // 设置被观察者在io线程中进行
                .observeOn(AndroidSchedulers.mainThread()) // 设置观察者在主线程中进行
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.e(TAG, "onSubscribe: ");
                        s.request(150);
                        // 该设置仅影响观察者线程中的requested，却不会影响的被观察者中的FlowableEmitter.requested()的返回值
                        // 因为FlowableEmitter.requested()的返回值 取决于RxJava内部调用request(n)，
                        // 而该内部调用会在一开始就调用request(128)
                        // 为什么是调用request(128)下面再讲解
                    }

                    @Override
                    public void onNext(Integer integer) {

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        // 在异步订阅关系中，反向控制的原理是：通过RxJava内部固定调用被观察者线程中的request(n)
        // 从而 反向控制被观察者的发送事件速度
        // 至于为什么是调用request（128） & request（96） & request（0），感兴趣的读者可自己阅读 Flowable的源码
    }

    /**
     * 背压策略：异步订阅逻辑演示
     */
    private Subscription asynchronousSubscriptionLogic;

    private void initAsynchronousSubscriptionLogic() {
        // 被观察者：一共需要发送500个事件，但真正开始发送事件的前提 = FlowableEmitter.requested()返回值 ≠ 0
        // 观察者：每次接收事件数量 = 48（点击按钮）
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {

                Log.d(TAG, "观察者可接收事件数量 = " + emitter.requested());
                boolean flag; //设置标记位控制

                // 被观察者一共需要发送500个事件
                for (int i = 0; i < 500; i++) {
                    flag = false;

                    // 若requested() == 0则不发送
                    while (emitter.requested() == 0) {
                        if (!flag) {
                            Log.d(TAG, "不再发送");
                            flag = true;
                        }
                    }
                    // requested() ≠ 0 才发送
                    Log.d(TAG, "发送了事件" + i + "，观察者可接收事件数量 = " + emitter.requested());
                    emitter.onNext(i);


                }
            }
        }, BackpressureStrategy.ERROR).subscribeOn(Schedulers.io()) // 设置被观察者在io线程中进行
                .observeOn(AndroidSchedulers.mainThread()) // 设置观察者在主线程中进行
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.d(TAG, "onSubscribe");
                        asynchronousSubscriptionLogic = s;
                        // 初始状态 = 不接收事件；通过点击按钮接收事件
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "接收到了事件" + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.w(TAG, "onError: ", t);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });
    }

    /**
     * 背压策略：背压模式介绍(自动创建)
     */
    private void backPressureMode() {
        // 需要解决的问题：流水不匹配，发送事件速度 > 接收事件速度
        //      具体表现：当缓存区大小存满(默认128)，被观察者仍然继续发送下1个事件
        // 解决方案：
        //      1.手动创建Flowable
        //          1)BackpressureStrategy.ERROR,直接抛出异常MissingBackpressureException
        //          2)backpressureStrategy.MISSING，友好提示，缓存区满了
        //          3)BackpressureStrategy.BUFFER,将缓存区设置成无限大，即被观察者可无限发送事件
        //              观察者实际上是存放在缓存区，注意内存，防止OOM
        //          4)BackpressureStrategy.DROP,超过缓存区128的事件丢弃
        //          5)BackpressureStrategy.LATEST，值保存最新(最后)事件，超过缓存区的丢弃
        //      2.自动创建Flowable
        //          1)onBackpressureBuffer()
        //          2)onBackpressureDrop()
        //          3)onBackpressureLatest()
        //          4)默认才用BackpressureStrategy.ERROR
        //          todo 作用通模式参数

        // 出现当缓存区大小存满（默认缓存区大小 = 128）、被观察者仍然继续发送下1个事件时
        // 1.BackpressureStrategy.ERROR
        // MissingBackpressureException: create: could not emit value due to lack of requests
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {

                // 发送 129个事件
                for (int i = 0;i< 129; i++) {
                    Log.d(TAG, "发送了事件" + i);
                    emitter.onNext(i);
                }
                emitter.onComplete();
            }
        }, BackpressureStrategy.ERROR) // 设置背压模式 = BackpressureStrategy.ERROR
                .subscribeOn(Schedulers.io()) // 设置被观察者在io线程中进行
                .observeOn(AndroidSchedulers.mainThread()) // 设置观察者在主线程中进行
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.d(TAG, "onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "接收到了事件" + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.w(TAG, "onError: ", t);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });

        // 2.BackpressureStrategy.MISSING 友好提示：缓存区满了
        // MissingBackpressureException: Queue is full?!
//        Flowable.create(new FlowableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
//
//                // 发送 129个事件
//                for (int i = 0;i< 129; i++) {
//                    Log.d(TAG, "发送了事件" + i);
//                    emitter.onNext(i);
//                }
//                emitter.onComplete();
//            }
//        }, BackpressureStrategy.MISSING) // 设置背压模式 = BackpressureStrategy.MISSING
//                .subscribeOn(Schedulers.io()) // 设置被观察者在io线程中进行
//                .observeOn(AndroidSchedulers.mainThread()) // 设置观察者在主线程中进行
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "接收到了事件" + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.w(TAG, "onError: ", t);
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete");
//                    }
//                });

        // 3.BackpressureStrategy.BUFFER 将缓存区大小设置成无限大
        // 被观察者可无限发送事件 观察者，但实际上是存放在缓存区 要注意内存情况，防止出现OOM
//        Flowable.create(new FlowableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
//
//                // 发送 129个事件
//                for (int i = 1;i< 130; i++) {
//                    Log.d(TAG, "发送了事件" + i);
//                    emitter.onNext(i);
//                }
//                emitter.onComplete();
//            }
//        }, BackpressureStrategy.BUFFER) // 设置背压模式 = BackpressureStrategy.BUFFER
//                .subscribeOn(Schedulers.io()) // 设置被观察者在io线程中进行
//                .observeOn(AndroidSchedulers.mainThread()) // 设置观察者在主线程中进行
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "接收到了事件" + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.w(TAG, "onError: ", t);
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete");
//                    }
//                });
        // 可以接收超过原先缓存区大小（128）的事件数量了


        // todo 以下两个demo BackpressureStrategy.DROP BackpressureStrategy.LATEST
        // todo 在一个点击事件里面没有测出来，应该初始化数据，然后点击按钮的时候调用 s.request(128);

        // 4. BackpressureStrategy.DROP 超过缓存区大小（128）的事件丢弃
        // 如发送了150个事件，仅保存第1 - 第128个事件，第129 -第150事件将被丢弃
//        Flowable.create(new FlowableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
//                // 发送150个事件
//                for (int i = 0;i< 150; i++) {
//                    Log.d(TAG, "发送了事件" + i);
//                    emitter.onNext(i);
//                }
//                emitter.onComplete();
//            }
//        }, BackpressureStrategy.DROP)      // 设置背压模式 = BackpressureStrategy.DROP
//                .subscribeOn(Schedulers.io()) // 设置被观察者在io线程中进行
//                .observeOn(AndroidSchedulers.mainThread()) // 设置观察者在主线程中进行
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "onSubscribe");
//                        s.request(128);
//                        // 通过按钮进行接收事件
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "接收到了事件" + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.w(TAG, "onError: ", t);
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete");
//                    }
//                });

        // 5.BackpressureStrategy.LATEST 只保存最新（最后）事件，超过缓存区大小（128）的事件丢弃
        // 即如果发送了150个事件，缓存区里会保存129个事件（第1-第128 + 第150事件）
        // todo 1.被观察者一下子发送了150个事件，点击按钮接收时观察者接收了128个事件；
        // todo 2.再次点击接收时却接收到1个事件（第150个事件），这说明超过缓存区大小的事件仅保留最后的事件（第150个事件）
//        Flowable.create(new FlowableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
//                for (int i = 0;i< 150; i++) {
//                    Log.d(TAG, "发送了事件" + i);
//                    emitter.onNext(i);
//                }
//                emitter.onComplete();
//            }
//        }, BackpressureStrategy.LATEST) // // 设置背压模式 = BackpressureStrategy.LATEST
//                .subscribeOn(Schedulers.io()) // 设置被观察者在io线程中进行
//                .observeOn(AndroidSchedulers.mainThread()) // 设置观察者在主线程中进行
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        Log.d(TAG, "onSubscribe");
//                        s.request(128);
//                        // 通过按钮进行接收事件
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "接收到了事件" + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.w(TAG, "onError: ", t);
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete");
//                    }
//                });

    }

    /**
     * 背压策略：背压模式介绍(手动创建)
     */
    private void backPressureMode2(){
        Flowable.interval(1, TimeUnit.MILLISECONDS)
                .onBackpressureBuffer() // 添加背压策略封装好的方法，此处选择Buffer模式，即缓存区大小无限制
                .observeOn(Schedulers.newThread())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.d(TAG, "onSubscribe");
                        mSubscription = s;
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.d(TAG, "onNext: " + aLong);
                        try {
                            Thread.sleep(1000);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onError(Throwable t) {
                        Log.w(TAG, "onError: ", t);
                    }
                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });
    }

}
