package com.epicodus.discussionforum.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.epicodus.discussionforum.Constants;
import com.epicodus.discussionforum.R;
import com.epicodus.discussionforum.adapters.TopicListAdapter;
import com.epicodus.discussionforum.model.Topic;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();
    private Button mAddNewTopicButton;
    private EditText mTopicEditText;
    private ListView mTopicListView;

    private DatabaseReference mTopicPostReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mTopicPostReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_TOPIC_POST);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);

        mTopicEditText = (EditText) findViewById(R.id.topicEditText);
        mAddNewTopicButton = (Button) findViewById(R.id.addNewTopicButton);
//        mTopicListView = (ListView) findViewById(R.id.TopicListView);

        mAddNewTopicButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mAddNewTopicButton) {
            String topic = mTopicEditText.getText().toString();

            saveTopicToFirebase(topic);
        }
    }

    public void saveTopicToFirebase(String topic) {
        mTopicPostReference.setValue(topic);
    }
}

