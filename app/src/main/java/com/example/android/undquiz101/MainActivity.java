package com.example.android.undquiz101;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /* Check boxes for question 1 */
    private CheckBox questionOneAnswerOne;
    private CheckBox questionOneAnswerTwo;
    private CheckBox questionOneAnswerThree;
    private CheckBox questionOneAnswerFour;

    /* Check boxes for question 2 */
    private CheckBox questionTwoAnswerOne;
    private CheckBox questionTwoAnswerTwo;
    private CheckBox questionTwoAnswerThree;
    private CheckBox questionTwoAnswerFour;

    /* Check boxes for question 3 */
    private CheckBox questionThreeAnswerOne;
    private CheckBox questionThreeAnswerTwo;
    private CheckBox questionThreeAnswerThree;
    private CheckBox questionThreeAnswerFour;

    /* Radio buttons for question 4 */
    private RadioButton questionFourAnswerOne;
    private RadioButton questionFourAnswerTwo;
    private RadioButton questionFourAnswerThree;

    /* Radio buttons for question 5 */
    private RadioButton questionFiveAnswerOne;
    private RadioButton questionFiveAnswerTwo;
    private RadioButton questionFiveAnswerThree;

    /* Radio buttons for question 6 */
    private RadioButton questionSixAnswerOne;
    private RadioButton questionSixAnswerTwo;
    private RadioButton questionSixAnswerThree;

    /* EditText field for question 7 */
    private EditText questionSevenAnswer;

    /* EditText field for question 8 */
    private EditText questionEightAnswer;

    /* EditText field for user name */
    private EditText userName;

    /* EditText field for user email address */
    private EditText userEmail;

    /* Quiz score */
    private int quizScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find all the input fields
        findAllView();

        // Button for submit answer and get score
        Button submitAnswer = (Button) findViewById(R.id.submit_answer);
        // Attach a listener to submit button in order to listen to touch event
        submitAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = getUserName();
                // If user has not provided, show snack bar that displays "user name is required!"
                // and return.
                if (TextUtils.isEmpty(userName)) {
                    Snackbar snackbar = Snackbar.make(findViewById(R.id.myCoordinatorLayout)
                            , R.string.user_name_required
                            , Snackbar.LENGTH_SHORT);
                    snackbar.show();
                    return;
                }

                // Get the scores from all the questions and calculate the score
                quizScore = questionOneAnswerCheck()
                        + questionTwoAnswerCheck()
                        + questionThreeAnswerCheck()
                        + questionFourAnswerCheck()
                        + questionFiveAnswerCheck()
                        + questionSixAnswerCheck()
                        + questionSevenAnswerCheck()
                        + questionEightAnswerCheck();

                // Show the toast message for quiz score
                Toast.makeText(MainActivity.this,
                        userName + getString(R.string.toast_text_message_part_1)
                                + " "
                                + quizScore
                                + getString(R.string.toast_text_message_part_2),
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Button for resetting score
        final Button resetButton = (Button) findViewById(R.id.reset);
        // Attach a listener to reset button in order to listen to touch event
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When user clicks reset button reset everything
                reset();
            }
        });
    }

    /**
     * Checks answer to question one is correct or not
     * If answer is correct return 1 else return 0
     * Meaning point 1 for correct answer and 0 for incorrect answer
     * To score, all the three of answers must be true
     */
    private int questionOneAnswerCheck() {
        // Get the value from the check box
        boolean answerOne = questionOneAnswerOne.isChecked();
        boolean answerTwo = questionOneAnswerTwo.isChecked();
        boolean answerThree = questionOneAnswerThree.isChecked();
        boolean answerFour = questionOneAnswerFour.isChecked();

        // If answer to question one is correct return 1
        if (answerOne && answerTwo && (!answerThree) && answerFour) {
            return 1;
        }
        return 0;
    }

    /**
     * Checks answer to question two is correct or not
     * If answer is correct return 1 else return 0
     * Meaning point 1 for correct answer and 0 for incorrect answer
     * To score, all the two of answers must be true
     */
    private int questionTwoAnswerCheck() {
        // Get the value from the check box
        boolean answerOne = questionTwoAnswerOne.isChecked();
        boolean answerTwo = questionTwoAnswerTwo.isChecked();
        boolean answerThree = questionTwoAnswerThree.isChecked();
        boolean answerFour = questionTwoAnswerFour.isChecked();

        // If answer to question two is correct return 1
        if (answerOne && (!answerTwo) && (!answerThree) && answerFour) {
            return 1;
        }
        return 0;
    }

    /**
     * Checks answer to question two is correct or not
     * f answer is correct return 1 else return 0
     * Meaning point 1 for correct answer and 0 for incorrect answer
     * To score, all the three of answers must be true
     */
    private int questionThreeAnswerCheck() {
        // Get the value from the check box
        boolean answerOne = questionThreeAnswerOne.isChecked();
        boolean answerTwo = questionThreeAnswerTwo.isChecked();
        boolean answerThree = questionThreeAnswerThree.isChecked();
        boolean answerFour = questionThreeAnswerFour.isChecked();

        // If answer to question three is correct return 1
        if ((!answerOne) && answerTwo && answerThree && answerFour) {
            return 1;
        }
        return 0;
    }


    /**
     * Checks answer to question four is correct or not
     * If answer is correct return 1 else return 0
     * Meaning point 1 for correct answer and 0 for incorrect answer
     */
    private int questionFourAnswerCheck() {
        // Get the value from radio button
        boolean answerOne = questionFourAnswerOne.isChecked();
        // If answer to question four is correct return 1
        if (answerOne) {
            return 1;
        }
        return 0;
    }

    /**
     * Checks answer to question five is correct or not
     * If answer is correct return 1 else return 0
     * Meaning point 1 for correct answer and 0 for incorrect answer
     */
    private int questionFiveAnswerCheck() {
        // Get the value from radio button
        boolean answerTwo = questionFiveAnswerTwo.isChecked();
        // If answer to question five is correct return 1
        if (answerTwo) {
            return 1;
        }
        return 0;
    }

    /**
     * Checks answer to question six is correct or not
     * If answer is correct return 1 else return 0
     * Meaning point 1 for correct answer and 0 for incorrect answer
     */
    private int questionSixAnswerCheck() {
        // Get the value from radio button
        boolean answerTwo = questionSixAnswerTwo.isChecked();
        // If answer to question six is correct return 1
        if (answerTwo) {
            return 1;
        }
        return 0;
    }

    /**
     * Checks answer to question seven is correct or not
     * If answer is correct return 1 else return 0
     * Meaning point 1 for correct answer and 0 for incorrect answer
     */
    private int questionSevenAnswerCheck() {
        // Get the string from the EditText field
        String answerSeven = questionSevenAnswer.getText().toString();
        // If answer to question seven is correct return 1
        if (answerSeven.equalsIgnoreCase("ottawa")) {
            return 1;
        }
        return 0;
    }

    /**
     * Checks answer to question eight is correct or not
     * If answer is correct return 1 else return 0
     * Meaning point 1 for correct answer and 0 for incorrect answer
     */
    private int questionEightAnswerCheck() {
        // Get the string from the EditText field
        String answerEight = questionEightAnswer.getText().toString();
        // If answer to question eight is correct return 1
        if (answerEight.equals("99999")) {
            return 1;
        }
        return 0;
    }

    /**
     * This method is called to get name entered by user.
     */
    private String getUserName() {
        return userName.getText().toString();
    }

    /**
     * This method is called to get email address entered by user.
     */
    private String getUserEmail() {
        return userEmail.getText().toString();
    }

    /**
     * This method displays the result of quiz in alert dialog
     */
    private void showMessageBox(int score, String userName) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Set the title of alert dialog
        builder.setTitle(R.string.alert_dialog_title);
        // Set the message for alert dialog
        builder.setMessage(userName
                + getString(R.string.alert_dialog_message__part_1)
                + " "
                + score
                + getString(R.string.alert_dialog_message__part_2));
        builder.setPositiveButton(R.string.alert_dialog_positive_button
                , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // If user clicks OK button, dismiss the dialog
                        dialog.dismiss();
                    }
                });

        builder.setNegativeButton(R.string.alert_dialog_negative_button
                , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // If user clicks SEND EMAIL button, check email address id provided or not
                        // then sends an email
                        String userEmail = getUserEmail();
                        // If user has not provided email address , show snack bar that displays
                        // "user email address is required" and return.
                        if (TextUtils.isEmpty(userEmail)) {
                            Snackbar snackbar = Snackbar.make(findViewById(R.id.myCoordinatorLayout)
                                    , getString(R.string.user_email_address_required)
                                    , Snackbar.LENGTH_SHORT);
                            snackbar.show();
                        } else {
                            // Create a message for email body
                            String emailMessage = quizEmailBody(getUserName(), quizScore);
                            // Send email
                            sendEmail(getUserName(), getUserEmail(), emailMessage);
                        }
                    }
                });
        builder.create();
        builder.show();
    }

    /**
     * This method is called to find all the appropriate check boxes, radio buttons
     * and edit text fields
     */
    private void findAllView() {
        // Find all check box for question 1
        questionOneAnswerOne = (CheckBox) findViewById(R.id.question_one_answer_one);
        questionOneAnswerTwo = (CheckBox) findViewById(R.id.question_one_answer_two);
        questionOneAnswerThree = (CheckBox) findViewById(R.id.question_one_answer_three);
        questionOneAnswerFour = (CheckBox) findViewById(R.id.question_one_answer_four);

        // Find all check box for question 2
        questionTwoAnswerOne = (CheckBox) findViewById(R.id.question_two_answer_one);
        questionTwoAnswerTwo = (CheckBox) findViewById(R.id.question_two_answer_two);
        questionTwoAnswerThree = (CheckBox) findViewById(R.id.question_two_answer_three);
        questionTwoAnswerFour = (CheckBox) findViewById(R.id.question_two_answer_four);

        // Find all check box for question 3
        questionThreeAnswerOne = (CheckBox) findViewById(R.id.question_three_answer_one);
        questionThreeAnswerTwo = (CheckBox) findViewById(R.id.question_three_answer_two);
        questionThreeAnswerThree = (CheckBox) findViewById(R.id.question_three_answer_thee);
        questionThreeAnswerFour = (CheckBox) findViewById(R.id.question_three_answer_four);

        // Find all radio button for question 4
        questionFourAnswerOne = (RadioButton) findViewById(R.id.question_four_answer_one);
        questionFourAnswerTwo = (RadioButton) findViewById(R.id.question_four_answer_two);
        questionFourAnswerThree = (RadioButton) findViewById(R.id.question_four_answer_three);

        // Find all radio button for question 5
        questionFiveAnswerOne = (RadioButton) findViewById(R.id.question_five_answer_one);
        questionFiveAnswerTwo = (RadioButton) findViewById(R.id.question_five_answer_two);
        questionFiveAnswerThree = (RadioButton) findViewById(R.id.question_five_answer_three);

        // Find all radio button for question 6
        questionSixAnswerOne = (RadioButton) findViewById(R.id.question_six_answer_one);
        questionSixAnswerTwo = (RadioButton) findViewById(R.id.question_six_answer_two);
        questionSixAnswerThree = (RadioButton) findViewById(R.id.question_six_answer_three);

        // Find edit text field for question 7
        questionSevenAnswer = (EditText) findViewById(R.id.question_seven_answer);

        // Find edit text field for question 8
        questionEightAnswer = (EditText) findViewById(R.id.question_eight_answer);

        // Find edit text field for question user name
        userName = (EditText) findViewById(R.id.user_name);

        // Find edit text field for question user email
        userEmail = (EditText) findViewById(R.id.user_mail_address);
    }

    /**
     * This method is called to reset every input fields
     */
    private void reset() {
        // Reset all fields for question 1
        questionOneAnswerOne.setChecked(false);
        questionOneAnswerTwo.setChecked(false);
        questionOneAnswerThree.setChecked(false);
        questionOneAnswerFour.setChecked(false);

        // Reset all fields for question 2
        questionTwoAnswerOne.setChecked(false);
        questionTwoAnswerTwo.setChecked(false);
        questionTwoAnswerThree.setChecked(false);
        questionTwoAnswerFour.setChecked(false);

        // Reset all fields for question 3
        questionThreeAnswerOne.setChecked(false);
        questionThreeAnswerTwo.setChecked(false);
        questionThreeAnswerThree.setChecked(false);
        questionThreeAnswerFour.setChecked(false);

        // Reset all fields for question 4
        questionFourAnswerOne.setChecked(false);
        questionFourAnswerTwo.setChecked(false);
        questionFourAnswerThree.setChecked(false);

        // Reset all fields for question 5
        questionFiveAnswerOne.setChecked(false);
        questionFiveAnswerTwo.setChecked(false);
        questionFiveAnswerThree.setChecked(false);

        // Reset all fields for question 6
        questionSixAnswerOne.setChecked(false);
        questionSixAnswerTwo.setChecked(false);
        questionSixAnswerThree.setChecked(false);
        // Reset all fields for question 7
        questionSevenAnswer.setText("");
        // Reset all fields for question 8
        questionEightAnswer.setText("");
        // Reset all fields for user name
        userName.setText("");
        // Reset all fields for user email
        userEmail.setText("");
    }

    /**
     * Create email intent to send score to user
     *
     * @param userName  user name
     * @param userEmail user email
     * @param emailBody Message in email
     */
    private void sendEmail(String userName, String userEmail, String emailBody) {
        //Create email intent
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);

        // Make sure Intent is used by email apps only and add To email: user email
        emailIntent.setData(Uri.parse("mailto:" + userEmail));
        // Subject Line
        emailIntent.putExtra(Intent.EXTRA_SUBJECT
                , getString(R.string.email_subject_header) + userName);
        // Email body
        emailIntent.putExtra(Intent.EXTRA_TEXT, emailBody);

        //Check if there are email apps present or not, if not then terminate the action
        //stop app from crashing if there is no email app
        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(emailIntent);
        }
    }

    /**
     * @param userName  user name
     * @param quizScore total quiz score
     * @return Generates message for email body
     */
    private String quizEmailBody(String userName, int quizScore) {
        return getString(R.string.email_name_header) + userName +
                getString(R.string.email_score) + " " + quizScore +
                getString(R.string.email_body);
    }
}