package com.qf58.learnwordapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.CacheUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.TimeUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by linSir
 * date at 2017/12/4.
 * describe:
 */

public class LearnWordFragment extends Fragment {

    private TextView count, result, known, unknown, next;
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private String already = CacheUtils.getInstance().getString(TimeUtils.getNowString(format));
    ;
    private String[] words;
    private static final ArrayList<Word> wordsList = Constant.getAllList();

    private int m = 0;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learn_word, container, false);


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
            m = words.length;
            count.setText("今天已经背了(" + words.length + "/100)");
        }

        result.setText("单词 : " + wordsList.get(m).getWord() + "\n"
                + "词性 : " + wordsList.get(m).getType() + "\n"
                + "翻译 : " + wordsList.get(m).getRightSolution());
        known.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                result.setText("单词 : " + wordsList.get(m).getWord() + "\n"
                        + "词性 : " + wordsList.get(m).getType() + "\n"
                        + "翻译 : " + wordsList.get(m).getRightSolution());

            }
        });

        unknown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("单词 : " + wordsList.get(m).getWord() + "\n"
                        + "词性 : " + wordsList.get(m).getType() + "\n"
                        + "翻译 : " + wordsList.get(m).getRightSolution());

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
        already = already + ";" + wordsList.get(m).getWord();
        CacheUtils.getInstance().put(TimeUtils.getNowString(format), already);

        LogUtils.e("---lin--->  already  " + already);
        if (already == null) {
            already = "";
        } else {
            words = already.split(";");
            count.setText("今天已经背了(" + words.length + "/100)");
        }
        for (int i = m; i < wordsList.size(); i++) {
            if (!already.contains(wordsList.get(i).getWord())) {
                result.setText(wordsList.get(i).getWord());
                break;
            }
            m++;
        }

    }

}
















