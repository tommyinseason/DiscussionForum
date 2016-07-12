package com.epicodus.discussionforum.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.epicodus.discussionforum.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private Button mAddNewTopicButton;
    private EditText mTopicEditText;
    private ListView mTopicListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTopicEditText = (EditText) findViewById(R.id.topicEditText);
        mAddNewTopicButton = (Button) findViewById(R.id.addNewTopicButton);
        mTopicListView = (ListView) findViewById(R.id.TopicListView);
        String[] topics = new String[] {
                "Vacations",
                "Weather"
        };

        final List<String> topics_list = new ArrayList<String>(Arrays.asList(topics));

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, topics_list);


        mTopicListView.setAdapter(arrayAdapter);


        mAddNewTopicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String topic = mTopicEditText.getText().toString();
                Log.d(TAG, topic);
                topics_list.add(topic);
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
}

