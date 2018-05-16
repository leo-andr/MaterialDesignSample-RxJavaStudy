package demo.test.com.rxjavaretrofitdemp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

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
            btn28, btn29;
    EditText etName, etAge, etJob;

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

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etJob = findViewById(R.id.etJob);

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

        // 联合条件判断 可否点击按钮
        jointJudgment();

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
                        Log.e(TAG, "accept: " + translation.getContent().getOut());
                        Log.e(TAG, "accept: " + translation.toString());
                        // 对第1次网络请求返回的结果进行操作 = 显示翻译结果
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e(TAG, "登录失败 - accept: " + throwable.toString());
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
                // 发送Error事件，因为使用concatDelayError，所以第2个Observable将不会发送事件
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

        // 2个被观察者：最后不发送onComplete()：事件尽管被观察者2的事件D没有事件与其合并，但还是会继续发送
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

    /**
     * 合并/组合操作符实际用例：合并数据源，同时展示
     * 此处采用merge()&zip()
     * merge() 实现较为简单的从(网络+本地)获取数据&同一展示
     * zip() 结合Retrofit与RxJava，实现较为复杂的合并2个网络请求向2个服务器获取数据&同意展示
     */
    String result = "数据源来自 = ";

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
     * 填写表单 作为联合判断功能展示
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
        Observable.just(1,2,3,4)
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
        Observable.just(1,2,3,4)
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


}
