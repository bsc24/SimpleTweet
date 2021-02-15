package com.codepath.apps.restclienttemplate.models;

import com.codepath.apps.restclienttemplate.TimeFormatter;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Tweet {

    public String body;
    public String created_at;
    public String source;
    public long id;
    public User user;

    public Tweet() {}

    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.created_at = jsonObject.getString("created_at");
        tweet.source = jsonObject.getString("source").split(">")[1].split("<")[0];
        tweet.id = jsonObject.getLong("id");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        return tweet;
    }

    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }

        return tweets;
    }

    public String getBody() {
        return body;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getTimeStamp() {
        return TimeFormatter.getTimeStamp(created_at);
    }

    public String getTimeSince() {
        return TimeFormatter.getTimeDifference(created_at);
    }

    public String getSource() {
        return source;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }
}
