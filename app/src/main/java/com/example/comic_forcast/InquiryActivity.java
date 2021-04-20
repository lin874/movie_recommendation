package com.example.comic_forcast;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.example.comic_forcast.entity.ratings;
import com.example.comic_forcast.entity.ratings_eight;
import com.example.comic_forcast.entity.ratings_five;
import com.example.comic_forcast.entity.ratings_four;
import com.example.comic_forcast.entity.ratings_nine;
import com.example.comic_forcast.entity.ratings_one;
import com.example.comic_forcast.entity.ratings_seven;
import com.example.comic_forcast.entity.ratings_six;
import com.example.comic_forcast.entity.ratings_ten;
import com.example.comic_forcast.entity.ratings_three;
import com.example.comic_forcast.entity.ratings_two;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class InquiryActivity extends AppCompatActivity {
    private PyObject pyObject;
    private int download;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiry);
        Bmob.initialize(this, "c462b842464fce5bfa213277c43f534a");
        if (!Python.isStarted()) {
            Python.start(new AndroidPlatform(InquiryActivity.this));
        }
        Python python = Python.getInstance();
        pyObject = python.getModule("Comic_Algorithm");
        download = 0;
        getData();
    }


    private void getData() {
        for (int i = 0; i < 200; i++) {
            getOneRating(i);
        }
        Log.d("TEST", "全部结束");
    }

    private void getTwoData() {
        for (int i = 0; i < 200; i++) {
            getTwoRating(i);
        }
    }

    private void getThreeData() {
        for (int i = 0; i < 200; i++) {
            getThreeRating(i);
        }
    }

    private void getFourData() {
        for (int i = 0; i < 200; i++) {
            getFourRating(i);
        }
    }

    private void getFiveData() {
        for (int i = 0; i < 200; i++) {
            getFiveRating(i);
        }
    }

    private void getSixData() {
        for (int i = 0; i < 200; i++) {
            getSixRating(i);
        }
    }

    private void getSevenData() {
        for (int i = 0; i < 200; i++) {
            getSevenRating(i);
        }
    }

    private void getEightData() {
        for (int i = 0; i < 200; i++) {
            getEightRating(i);
        }
    }

    private void getNineData() {
        for (int i = 0; i < 200; i++) {
            getNineRating(i);
        }
    }

    private void getOneRating(int i) {
        new BmobQuery<ratings_one>().setLimit(100000).setSkip(i * 500).findObjects(new FindListener<ratings_one>() {
            @Override
            public void done(List<ratings_one> list, BmobException e) {
                if (list != null && !list.isEmpty()) {
                    Log.d("TEST", "获取数据长度：" + list.size());
                    pyObject.callAttr("get_dataset", list);
                    download += list.size();
                    if (download >= 100000) {
                        Log.d("TEST", "获取全部数据结束" + download);
                        getTwoData();
                    }
                } else {
                    Log.d("TEST", "获取数据失败" + e.toString());
                    getOneRating(i);
                }
            }
        });
    }

    private void getTwoRating(int i) {
        new BmobQuery<ratings_two>().setLimit(100000).setSkip(i * 500).findObjects(new FindListener<ratings_two>() {
            @Override
            public void done(List<ratings_two> list, BmobException e) {
                if (list != null && !list.isEmpty()) {
                    Log.d("TEST", "获取数据长度：" + list.size());
                    pyObject.callAttr("get_dataset", list);
                    download += list.size();
                    if (download >= 200000) {
                        Log.d("TEST", "获取全部数据结束" + download);
                        getThreeData();
                    }
                } else {
                    Log.d("TEST", "获取数据失败" + e.toString());
                    getTwoRating(i);
                }
            }
        });
    }

    private void getThreeRating(int i) {
        new BmobQuery<ratings_three>().setLimit(100000).setSkip(i * 500).findObjects(new FindListener<ratings_three>() {
            @Override
            public void done(List<ratings_three> list, BmobException e) {
                if (list != null && !list.isEmpty()) {
                    Log.d("TEST", "获取数据长度：" + list.size());
                    pyObject.callAttr("get_dataset", list);
                    download += list.size();
                    if (download >= 300000) {
                        Log.d("TEST", "获取全部数据结束" + download);
                        getFourData();
                    }
                } else {
                    Log.d("TEST", "获取数据失败" + e.toString());
                    getThreeRating(i);
                }
            }
        });
    }

    private void getFourRating(int i) {
        new BmobQuery<ratings_four>().setLimit(100000).setSkip(i * 500).findObjects(new FindListener<ratings_four>() {
            @Override
            public void done(List<ratings_four> list, BmobException e) {
                if (list != null && !list.isEmpty()) {
                    Log.d("TEST", "获取数据长度：" + list.size());
                    pyObject.callAttr("get_dataset", list);
                    download += list.size();
                    if (download >= 400000) {
                        Log.d("TEST", "获取全部数据结束" + download);
                        getFiveData();
                    }
                } else {
                    Log.d("TEST", "获取数据失败" + e.toString());
                    getFourRating(i);
                }
            }
        });
    }

    private void getFiveRating(int i) {
        new BmobQuery<ratings_five>().setLimit(100000).setSkip(i * 500).findObjects(new FindListener<ratings_five>() {
            @Override
            public void done(List<ratings_five> list, BmobException e) {
                if (list != null && !list.isEmpty()) {
                    Log.d("TEST", "获取数据长度：" + list.size());
                    pyObject.callAttr("get_dataset", list);
                    download += list.size();
                    if (download >= 500000) {
                        Log.d("TEST", "获取全部数据结束" + download);
                        getSixData();
                    }
                } else {
                    Log.d("TEST", "获取数据失败" + e.toString());
                    getFiveRating(i);
                }
            }
        });
    }

    private void getSixRating(int i) {
        new BmobQuery<ratings_six>().setLimit(100000).setSkip(i * 500).findObjects(new FindListener<ratings_six>() {
            @Override
            public void done(List<ratings_six> list, BmobException e) {
                if (list != null && !list.isEmpty()) {
                    Log.d("TEST", "获取数据长度：" + list.size());
                    pyObject.callAttr("get_dataset", list);
                    download += list.size();
                    if (download >= 600000) {
                        Log.d("TEST", "获取全部数据结束" + download);
                        getSevenData();
                    }
                } else {
                    Log.d("TEST", "获取数据失败" + e.toString());
                    getSixRating(i);
                }
            }
        });
    }

    private void getSevenRating(int i) {
        new BmobQuery<ratings_seven>().setLimit(100000).setSkip(i * 500).findObjects(new FindListener<ratings_seven>() {
            @Override
            public void done(List<ratings_seven> list, BmobException e) {
                if (list != null && !list.isEmpty()) {
                    Log.d("TEST", "获取数据长度：" + list.size());
                    pyObject.callAttr("get_dataset", list);
                    download += list.size();
                    if (download >= 700000) {
                        Log.d("TEST", "获取全部数据结束" + download);
                        getEightData();
                    }
                } else {
                    Log.d("TEST", "获取数据失败" + e.toString());
                    getSevenRating(i);
                }
            }
        });
    }

    private void getEightRating(int i) {
        new BmobQuery<ratings_eight>().setLimit(100000).setSkip(i * 500).findObjects(new FindListener<ratings_eight>() {
            @Override
            public void done(List<ratings_eight> list, BmobException e) {
                if (list != null && !list.isEmpty()) {
                    Log.d("TEST", "获取数据长度：" + list.size());
                    pyObject.callAttr("get_dataset", list);
                    download += list.size();
                    if (download >= 800000) {
                        Log.d("TEST", "获取全部数据结束" + download);
                        getNineData();

                    }
                } else {
                    Log.d("TEST", "获取数据失败" + e.toString());
                    getEightRating(i);
                }
            }
        });
    }

    private void getNineRating(int i) {
        new BmobQuery<ratings_nine>().setLimit(100000).setSkip(i * 500).findObjects(new FindListener<ratings_nine>() {
            @Override
            public void done(List<ratings_nine> list, BmobException e) {
                if (list != null && !list.isEmpty()) {
                    Log.d("TEST", "获取数据长度：" + list.size());
                    pyObject.callAttr("get_dataset", list);
                    download += list.size();
                    if (download >= 900000) {
                        Log.d("TEST", "获取全部数据结束" + download);
                        getTenData();
                    }
                } else {
                    Log.d("TEST", "获取数据失败" + e.toString());
                    getNineRating(i);
                }
            }
        });
    }

    private void getTenData() {
        for (int i = 0; i < 200; i++) {
            getTenRating(i);
        }
    }

    private void getTenRating(int i) {
        new BmobQuery<ratings_ten>().setLimit(100000).setSkip(i * 500).findObjects(new FindListener<ratings_ten>() {
            @Override
            public void done(List<ratings_ten> list, BmobException e) {
                if (list != null && !list.isEmpty()) {
                    Log.d("TEST", "获取数据长度：" + list.size());
                    pyObject.callAttr("get_dataset", list);
                    download += list.size();
                    if (download >= 1000000) {
                        Log.d("TEST", "获取全部数据结束" + download);
                    }
                } else {
                    Log.d("TEST", "获取数据失败" + e.toString());
                    getTenRating(i);
                }
            }
        });
    }


    private void getRecommend(List<ratings_one> list) {
        pyObject.callAttr("get_dataset", list);
//        Map map = new HashMap();
//        map.put("296", 3);
//        map.put("1175", 2.5);
//        map.put("1260", 5.0);
//        Map result = pyObject.callAttr("recommend", map).asMap();
    }
}
