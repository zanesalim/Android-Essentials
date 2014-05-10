package com.twitter.university.android.yamba;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


public class TweetFragment extends Fragment {

    private TextView countView;
    private EditText tweetView;
    private Button submitButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tweet, container, false);
        tweetView = (EditText) v.findViewById(R.id.tweet_tweet);
        countView = (TextView) v.findViewById(R.id.tweet_count);
        submitButton = (Button) v.findViewById(R.id.tweet_submit);

        submitButton = (Button) v.findViewById(R.id.tweet_submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vv) { post(); }
        });

        ((EditText) v.findViewById(R.id.tweet_tweet)).addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) { }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) { }

                    @Override
                    public void afterTextChanged(Editable editable) { updateCount(); }
                }

        );

        return v;
    }

    private void updateCount() {
        countView.setText(String.valueOf(140-tweetView.length()));
        if (tweetView.length()>140) { countView.setTextColor(-65536); }
        else if (tweetView.length()<130) {
            countView.setTextColor(-16711936);
            submitButton.setEnabled(true);
        }
        else { countView.setTextColor(-256); }
    }


    void post() {
        String tweet = tweetView.getText().toString();
        if (tweetView.length()>140) { return; }

        tweetView.setText("");

        String status = "Tweet failed";

        try {
            Thread.sleep(2 * 60 * 1000); // replace with actual network call
            status = "Tweeted!";
        }
        catch (Exception e) { }

        Toast.makeText(getActivity(), status, Toast.LENGTH_LONG).show();
    }
}

