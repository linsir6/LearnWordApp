package com.qf58.learnwordapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;

import java.util.ArrayList;

/**
 * Created by linSir
 * date at 2017/12/4.
 * describe:
 */

public class TestFragment extends Fragment {

    private TextView tab1, tab2, tab3, tab4, count, word;
    private Button restart;
    private int m = -1;
    private ArrayList<Word> mWordList = new ArrayList<Word>();
    private ArrayList<Word> allWord = Constant.getAllList();
    private TextView[] textViews = new TextView[4];
    private String[] texts = new String[4];

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);

        tab1 = view.findViewById(R.id.tab1);
        tab2 = view.findViewById(R.id.tab2);
        tab3 = view.findViewById(R.id.tab3);
        tab4 = view.findViewById(R.id.tab4);
        word = view.findViewById(R.id.word);
        count = view.findViewById(R.id.count);
        restart = view.findViewById(R.id.restart);
        mWordList = newTest();
        textViews[0] = tab1;
        textViews[1] = tab2;
        textViews[2] = tab3;
        textViews[3] = tab4;


        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWordList = newTest();
                m = -1;
                newWord();
                count.setText("当前已测试单词(" + "0/50)\n当前得分" + m * 2 + "分");

            }
        });

        newWord();
        tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogUtils.e("---lin---> click " + m);
                LogUtils.e("---lin---> click " + tab1.getText().toString());
                LogUtils.e("---lin---> click " + mWordList.get(m).getRightSolution());


                if (tab1.getText().toString().equals(mWordList.get(m).getRightSolution())) {
                    count.setText("当前已测试单词(" + m + "/50)\n当前得分" + m * 2 + "分");
                    newWord();
                }else {
                    ToastUtils.showShort("回答错误，请检查");
                }
            }
        });

        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tab2.getText().toString().equals(mWordList.get(m).getRightSolution())) {
                    count.setText("当前已测试单词(" + m + "/50)\n当前得分" + m * 2 + "分");
                    newWord();
                }else {
                    ToastUtils.showShort("回答错误，请检查");
                }
            }
        });

        tab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tab3.getText().toString().equals(mWordList.get(m).getRightSolution())) {
                    count.setText("当前已测试单词(" + m + "/50)\n当前得分" + m * 2 + "分");
                    newWord();
                }else {
                    ToastUtils.showShort("回答错误，请检查");
                }
            }
        });

        tab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tab4.getText().toString().equals(mWordList.get(m).getRightSolution())) {
                    count.setText("当前已测试单词(" + m + "/50)\n当前得分" + m * 2 + "分");
                    newWord();
                }else {
                    ToastUtils.showShort("回答错误，请检查");
                }
            }
        });

        return view;
    }


    private void newWord() {
        m++;
        if (m == 51) {
            ToastUtils.showShort("本次考试已经完成，下面将重新开始");
            mWordList = newTest();
        }
        texts[0] = mWordList.get(m).getRightSolution();
        texts[1] = mWordList.get(m).getErrorSolution1();
        texts[2] = mWordList.get(m).getErrorSolution2();
        texts[3] = mWordList.get(m).getErrorSolution3();

        ArrayList<Integer> list = getNewRandom();
        for (int i = 0; i < list.size(); i++) {
            LogUtils.e("---lin--->   newWord" + i);
            LogUtils.e("---lin--->   newWord" + i);

            textViews[i].setText(texts[list.get(i) - 1]);

        }
        word.setText(mWordList.get(m).getWord());


    }

    private ArrayList<Integer> getNewRandom() {
        ArrayList<Integer> list = new ArrayList<>();

        while (list.size() < 4) {
            LogUtils.e("---lin--->   getNewRandom");
            int ran = (int) (Math.random() * 4);
            if (!list.contains(ran + 1))
                list.add(ran + 1);
        }
        return list;
    }

    private ArrayList<Word> newTest() {
        m = 0;
        mWordList = new ArrayList<Word>();
        ArrayList<Integer> list = new ArrayList<>();

        while (list.size() < 50) {
            int ran = (int) (Math.random() * 470);
            if (!list.contains(ran + 1))
                list.add(ran + 1);
        }

        for (int i = 0; i < list.size(); i++) {
            mWordList.add(allWord.get(list.get(i)));
        }

        return mWordList;

    }


}
