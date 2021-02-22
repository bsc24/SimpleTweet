package com.codepath.apps.restclienttemplate;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

public class DetailActivity extends Activity {

    public static final String TAG = "DetailActivity";

    ImageView ivProfileImage;
    TextView tvScreenName;
    TextView tvName;
    TextView tvBody;
    TextView tvTimestamp;
    TextView tvSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        ivProfileImage = findViewById(R.id.ivProfileImage);
        tvScreenName = findViewById(R.id.tvScreenName);
        tvName = findViewById(R.id.tvName);
        tvBody = findViewById(R.id.tvBody);
        tvTimestamp = findViewById(R.id.tvTimestamp);
        tvSource = findViewById(R.id.tvSource);

        Tweet tweet = Parcels.unwrap(getIntent().getParcelableExtra("tweet"));

        tvBody.setText(tweet.getBody());
        tvScreenName.setText("@" + tweet.getUser().getScreenName());
        tvName.setText(tweet.getUser().getName());
        tvTimestamp.setText(tweet.getTimeStamp());
        tvSource.setText(" \u00b7 " + tweet.getSource());

        Glide.with(this)
                .load(tweet.getUser().getPublicImageUrl())
                .transform(new RoundedCorners(100))
                .into(ivProfileImage);
    }
}
