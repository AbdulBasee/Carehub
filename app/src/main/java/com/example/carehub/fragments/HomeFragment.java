package com.example.carehub.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.carehub.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import okhttp3.Headers;

public class HomeFragment extends Fragment {
    // textview for displaying the daily quote on Homepage

    TextView tvViewGreeting;
    public static final String TAG = "HomeFragment";
    TextView tvquote;
    TextView tvAuthorName;
    Spinner homepageSpinner;
    // the api link for motivational quotes
    public static final String motivationalQuotes = "http://quotes.rest/qod.json?category=inspire";

    public HomeFragment() {

   }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        greeting(view);

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(motivationalQuotes, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Headers headers, JSON json) {
                System.out.println("very good");
                Log.d(TAG, "Onsuccess");
                JSONObject jsonObject = json.jsonObject;

                System.out.println(jsonObject);

                try {
                    JSONObject secondObject =  jsonObject.getJSONObject("contents");
                    System.out.println(secondObject);
                    JSONArray jsonArray = secondObject.getJSONArray("quotes");

                    JSONObject in = (JSONObject) jsonArray.get(0);
                    System.out.println("the in material" + in);
                    String quo = (String) in.get("quote");
                    tvquote = view.findViewById(R.id.tvViewquote);
                    tvquote.setText(quo);

                    String author = (String) in.get("author");
                    tvAuthorName = view.findViewById(R.id.textViewAuthor);
                    tvAuthorName.setText("-" + author + "-");

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int i, Headers headers, String s, Throwable throwable) {
                Log.d(TAG, "Onfailure");

            }
        });
        updateDate(view);



    }
    public void updateDate(View view){
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.LONG).format(calendar.getTime());
        TextView textViewDate = view.findViewById(R.id.textviewCalender);
        textViewDate.setText(currentDate);
    }
    public void greeting(View view){
//        TextView textMessage = (TextView) findViewById(R.id.textMessage);
        tvViewGreeting =  view.findViewById(R.id.tvViewgreeting);
        //get a reference to the EditText so that we can read in the value typed
        // by the user


        //Get the time of day
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);

        //Set greeting
        String greeting = null;
        if(hour>= 12 && hour < 17){
            greeting = "Good Afternoon";
            tvViewGreeting.setText(greeting);
        } else if(hour >= 17 && hour < 21){
            greeting = "Good Evening";
            tvViewGreeting.setText(greeting);
        } else if(hour >= 21 && hour < 24){
            greeting = "Good Night";
            tvViewGreeting.setText(greeting);
        } else {
            greeting = "Good Morning";
            tvViewGreeting.setText(greeting);
        }


    }




}

