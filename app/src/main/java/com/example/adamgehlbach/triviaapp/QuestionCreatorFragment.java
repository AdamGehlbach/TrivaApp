package com.example.adamgehlbach.triviaapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuestionCreatorFragment extends Fragment {

    @BindView(R.id.question)
    protected EditText question;
    @BindView(R.id.correct_answer)
    protected EditText correctAnswerInput;
    @BindView(R.id.first_wrong_answer)
    protected EditText firsWrongAnswerInput;
    @BindView(R.id.second_wrong_answer)
    protected EditText secondWrongAnswerInput;
    @BindView(R.id.third_wrong_answer)
    protected EditText thirdWrongAnswerInput;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_creater,container,false);
        ButterKnife.bind(this,view);

        return view;
    }

    public static QuestionCreatorFragment newInstance() {

        Bundle args = new Bundle();

        QuestionCreatorFragment fragment = new QuestionCreatorFragment();
        fragment.setArguments(args);
        return fragment;
    }
       @OnClick(R.id.save_question_button)
    protected void addQuestion() {

        String questionTitle = question.getText().toString();
        String correctAnswer = this.correctAnswerInput.getText().toString();
        String firstWrongAnswer = this.firsWrongAnswerInput.getText().toString();
        String secondWrongAnswer = this.secondWrongAnswerInput.getText().toString();
        String thirdWrongAnswer = this.thirdWrongAnswerInput.getText().toString();

        Question question = new Question(questionTitle, correctAnswer, firstWrongAnswer, secondWrongAnswer, thirdWrongAnswer);

        
    }


}
