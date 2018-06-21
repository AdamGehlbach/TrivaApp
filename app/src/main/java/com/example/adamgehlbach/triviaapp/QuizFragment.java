package com.example.adamgehlbach.triviaapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.adamgehlbach.triviaapp.MainActivity.QUESTIONS_LIST;

public class QuizFragment extends Fragment {

    @BindView(R.id.quiz_question_textview)
    protected TextView quizQuestion;

    @BindView(R.id.correct_answer)
    protected Button correctanswer;

    @BindView(R.id.wrong_answer1)
    protected Button wronganswer1;

    @BindView(R.id.wrong_answer2)
    protected Button wronganswer2;

    @BindView(R.id.wrong_answer3)
    protected Button wronganswer3;

    private List<Question> questionsList;
    private Question question;
    private int questionListPosition = 0;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    public static QuizFragment newInstance() {

        Bundle args = new Bundle();

        QuizFragment fragment = new QuizFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();

        questionsList = getArguments().getParcelableArrayList(QUESTIONS_LIST);

        populateQuizContent();
    }

    private void populateQuizContent() {
        question = questionsList.get(questionListPosition);
        quizQuestion.setText(question.getQuestion());

        List<Button> buttonList = new ArrayList<>();
        buttonList.add(correctanswer);
        buttonList.add(wronganswer1);
        buttonList.add(wronganswer2);
        buttonList.add(wronganswer3);

        List<String> possibleAnswersList = new ArrayList<>();
        possibleAnswersList.add(question.getCorrectAnswer());
        possibleAnswersList.add(question.getIncorrectAnswerOne());
        possibleAnswersList.add(question.getIncorrectAnswerTwo());
        possibleAnswersList.add(question.getIncorrectAnswerThree());

        for (Button button : buttonList) {

            int random = (int)(Math.random() * (possibleAnswersList.size() - 1));

            button.setText(possibleAnswersList.get(random));
            possibleAnswersList.remove(random);
        }




    }

    @OnClick(R.id.next_question_button)
        protected void nextQuestion () {
    }
    @OnClick(R.id.correct_answer)
    protected void buttonOneclicked(){

    }
    @OnClick(R.id.wrong_answer1)
    protected void buttonTwoClicked(){

    }
    @OnClick(R.id.wrong_answer2)
    protected void buttonThreeClicked(){

    }
    @OnClick(R.id.wrong_answer3)
    protected void buttonFourClicked(){

    }
    @OnClick(R.id.next_question_button)
    protected void buttonNextClicked(){

    }

}
