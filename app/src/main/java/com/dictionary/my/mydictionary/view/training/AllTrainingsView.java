package com.dictionary.my.mydictionary.view.training;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dictionary.my.mydictionary.R;
import com.dictionary.my.mydictionary.view.TrainingListener;

/**
 * Created by luxso on 27.09.2017.
 */

public class AllTrainingsView extends Fragment{
    TrainingListener mListener;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            Log.d("LOG_TAG", "AllTrainingsView: onAttach()");
            mListener = (TrainingListener) context;
        }catch (ClassCastException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("LOG_TAG_C/D_Training", "AllTrainingsView: onCreate() " + this.hashCode());
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("LOG_TAG_C/D_Training", "AllTrainingsView: onCreateView() " + this.hashCode());
        View view = inflater.inflate(R.layout.all_trainings_fragment, null);
        view.findViewById(R.id.btnTrainingWordTranslate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.openTrainingWordTranslate();
            }
        });
        view.findViewById(R.id.btnTrainingTranslateWord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.openTrainingTranslateWord();
            }
        });
        view.findViewById(R.id.btnTrainingConstructor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.openTrainingConstructor();
            }
        });
        view.findViewById(R.id.btnTrainingSprint).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.openTrainingSprint();
            }
        });

        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("LOG_TAG_C/D_Training", "AllTrainingsView: onDestroyView()" + this.hashCode());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("LOG_TAG_C/D_Training", "AllTrainingsView: onDestroy()" + this.hashCode());
    }
}
