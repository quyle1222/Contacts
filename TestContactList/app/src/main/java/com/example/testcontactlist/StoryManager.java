package com.example.testcontactlist;

import android.content.Context;
import android.database.Cursor;
import android.provider.CallLog;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class StoryManager {
    private Context mContext;
    private ArrayList<StoryModel> storyModelsList;

    public StoryManager(Context mContext) {
        this.mContext = mContext;
        fetchCallLog();

    }

    public ArrayList<StoryModel> getStoryModelsList() {
        return storyModelsList;
    }

    public void fetchCallLog() {
        storyModelsList = new ArrayList<>();
        String sortOder = CallLog.Calls.DATE + " DESC";
        String[] data = {
                CallLog.Calls.NUMBER,
                CallLog.Calls.DURATION,
                CallLog.Calls.DATE,
        };
        Cursor story = mContext.getContentResolver().query(CallLog.Calls.CONTENT_URI, null, null, null, sortOder);

        int numberIndex = story.getColumnIndex(data[0]);
        int totalIndex = story.getColumnIndex(data[1]);
        int startIndex = story.getColumnIndex(data[2]);
        story.moveToFirst();
        do {
            String phoneNumber = story.getString(numberIndex);
            String totalStory = story.getString(totalIndex);

            String startFullDate = story.getString(startIndex);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd:MM:yyyy");
            String startDate = simpleDateFormat.format(new Date(Long.parseLong(startFullDate)));

            SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("HH:mm:ss");
            String startTime = simpleTimeFormat.format(Long.parseLong(startFullDate));

            String callMinuteTime = getFormatDateTime(startTime, "HH:mm:ss", "hh:mm:ss");
            String timeStart = callMinuteTime + "    " + startDate;

            String callDuration = DurationFormat(totalStory);

            storyModelsList.add(new StoryModel(phoneNumber,timeStart,callDuration));
        }while (story.moveToNext());
        story.close();
    }

    private String getFormatDateTime(String startTime, String input, String output) {
        String dateFormat = startTime;
        DateFormat inputFormat = new SimpleDateFormat(input, Locale.getDefault());
        DateFormat outputFormat = new SimpleDateFormat(output, Locale.getDefault());
        Date date = null;
        try {
            date = inputFormat.parse(startTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date != null) {
            dateFormat = outputFormat.format(date);
        }
        return dateFormat;

    }

    private String DurationFormat(String duration) {
        String durationFormatted = null ;
        if (Integer.parseInt(duration) < 60) {
            durationFormatted = duration + " sec";
        } else {
            int min = Integer.parseInt(duration) / 60;
            int sec = Integer.parseInt(duration) % 60;
            if (sec == 0) {
                durationFormatted = min + " min";
            }
            else {
                durationFormatted = min + " min " + sec + " sec";
            }
        }
        return durationFormatted;
    }

}