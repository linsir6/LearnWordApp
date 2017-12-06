package com.qf58.learnwordapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.CacheUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.blankj.utilcode.util.ToastUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by linSir
 * date at 2017/12/4.
 * describe:
 */

public class GoOverFragment extends Fragment {

    private TextView count, result, known, unknown, next;
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private String already = CacheUtils.getInstance().getString(TimeUtils.getNowString(format));
    ;
    private String[] words;
    private static final ArrayList<Word> wordsList = Constant.getAllList();
    private static ArrayList<Word> todayWordList = new ArrayList<>();

    private int m = 0;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_go_over, container, false);


        count = view.findViewById(R.id.count);
        result = view.findViewById(R.id.result);
        known = view.findViewById(R.id.known);
        unknown = view.findViewById(R.id.unknown);
        next = view.findViewById(R.id.next);


        already = CacheUtils.getInstance().getString(TimeUtils.getNowString(format));
        if (already == null) {
            already = "";
            count.setText("今天已经背了(0/100)");
        } else {
            words = already.split(";");
            count.setText("今天已经背了(" + words.length + "/100)");
        }


        known.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (todayWordList.size() == 0) {
                    ToastUtils.showShort("您今天还没有背单词，不能进行复习");
                    return;
                }

                result.setText("单词 : " + todayWordList.get(m).getWord() + "\n"
                        + "词性 : " + todayWordList.get(m).getType() + "\n"
                        + "翻译 : " + todayWordList.get(m).getRightSolution());

            }
        });

        unknown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (todayWordList.size() == 0) {
                    ToastUtils.showShort("您今天还没有背单词，不能进行复习");
                    return;
                }

                result.setText("单词 : " + todayWordList.get(m).getWord() + "\n"
                        + "词性 : " + todayWordList.get(m).getType() + "\n"
                        + "翻译 : " + todayWordList.get(m).getRightSolution());

            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNewWord();

            }
        });

        return view;
    }


    private void setNewWord() {
        already = CacheUtils.getInstance().getString(TimeUtils.getNowString(format));
        if (already == null) {
            ToastUtils.showShort("您今天还没有背单词，不能进行复习");

            return;
        }

        words = already.split(";");
        count.setText("今天已经背了(" + words.length + "/100)");


        todayWordList = new ArrayList<>();
        for (int i = 0; i < wordsList.size(); i++) {
            if (already.contains(wordsList.get(i).getWord())) {
                todayWordList.add(wordsList.get(i));
            }
        }
        if (todayWordList.size() == 0) {
            return;
        }
        result.setText("单词 : " + todayWordList.get(m).getWord());
        m++;

        if (m >= todayWordList.size()) {
            m = 0;
        }

    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            setNewWord();
        }
    }


}
