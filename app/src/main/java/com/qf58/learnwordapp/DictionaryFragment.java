package com.qf58.learnwordapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;

import java.util.ArrayList;

/**
 * Created by linSir
 * date at 2017/12/4.
 * describe:
 */

public class DictionaryFragment extends Fragment {

    private EditText word;
    private ImageButton search;
    private TextView result;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dictionary, container, false);

        word = view.findViewById(R.id.word);
        search = view.findViewById(R.id.search);
        result = view.findViewById(R.id.result);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isFind = false;
                ArrayList<Word> list = Constant.getAllList();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getWord().equals(word.getText().toString())) {
                        result.setText("单词 : " + list.get(i).getWord() + "\n"
                                + "词性 : " + list.get(i).getType() + "\n"
                                + "翻译 : " + list.get(i).getRightSolution());
                        isFind = true;
                        break;
                    }
                }
                if (isFind) {
                    isFind = false;
                } else {
                    ToastUtils.showShort("对不起，词库没有收录您所要的单词");
                }


            }
        });


        return view;
    }


}
