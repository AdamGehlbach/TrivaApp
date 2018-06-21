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
    private int correctAnswers = 0;
    private QuizCallback quizCallback;


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
        //Just like with the buttons, this arrayList will take all of the possible answers and allow us to access them
        List<String> possibleAnswersList = new ArrayList<>();
        possibleAnswersList.add(question.getCorrectAnswer());
        possibleAnswersList.add(question.getIncorrectAnswerOne());
        possibleAnswersList.add(question.getIncorrectAnswerTwo());
        possibleAnswersList.add(question.getIncorrectAnswerThree());
        //This for Each loop takes the arrayList we made and actually allows us to randomize what question goes on which button
        for (Button button : buttonList) {

            //Creates a random number that will allow us to pick an answer from our arrayList
            int random = (int)Math.ceil(Math.random() * (possibleAnswersList.size() - 1));

            //Using the random number above we will set the text of the button by getting that item from the possible answers list.
            button.setText(possibleAnswersList.get(random));
            //To make sure we don't use the same answer twice we remove the possible answer from the list.
            possibleAnswersList.remove(random);
        }
    }

    private void checkAnswer(String answer) {
        disableAnswerButtons();
        //Increments questionListPosition so we can go to the next question
        questionListPosition++;

        if (question.getCorrectAnswer().equals(answer)) {
            //Sets the textView to show the user they were correct
            quizQuestion.setText(R.string.correct);
            //Increments the correct answers the user has gotten
            correctAnswers++;
        } else {
            quizQuestion.setText(getString(R.string.wrong_answer_text,question.getCorrectAnswer()));

        }

    }

    @OnClick(R.id.next_question_button)
        protected void nextQuestion () {


    }
    @OnClick(R.id.correct_answer)
    protected void buttonOneclicked(){
     checkAnswer(correctanswer.getText().toString());
    }
    @OnClick(R.id.wrong_answer1)
    protected void buttonTwoClicked(){
    checkAnswer(wronganswer1.getText().toString());
    }
    @OnClick(R.id.wrong_answer2)
    protected void buttonThreeClicked(){
checkAnswer(wronganswer2.getText().toString());
    }
    @OnClick(R.id.wrong_answer3)
    protected void buttonFourClicked(){
checkAnswer(wronganswer3.getText().toString());
    }
    @OnClick(R.id.next_question_button)
    protected void buttonNextClicked(){

        if (questionListPosition <= questionsList.size() -1) {
            populateQuizContent();

        } else {
            //Handing no more questions, taking user back to MainActivity
            quizCallback.quizFinished(correctAnswers);

        }
    }
    private void disableAnswerButtons() {
        correctanswer.setEnabled(false);
        wronganswer1.setEnabled(false);
        wronganswer2.setEnabled(false);
        wronganswer3.setEnabled(false);
    }
    private void enableAnswerButtons() {
        correctanswer.setEnabled(true);
        wronganswer1.setEnabled(true);
        wronganswer2.setEnabled(true);
        wronganswer3.setEnabled(true);
    }

    public void attachParent (QuizCallback quizCallback) {
        this.quizCallback = quizCallback;
    }

    public interface QuizCallback  {

        void quizFinished(int correctAnswers);
    }
}
