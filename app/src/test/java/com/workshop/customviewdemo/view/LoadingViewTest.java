package com.workshop.customviewdemo.view;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.workshop.customviewdemo.BuildConfig;
import com.workshop.customviewdemo.MainActivity;
import com.workshop.customviewdemo.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.annotation.RealObject;
import org.robolectric.util.ActivityController;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class LoadingViewTest {

    private LoadingView loadingView;
    private View loadingSpinner;
    private TextView loadingTextView;

    @Before
    public void setUp() throws Exception {
        ActivityController<Activity> activityController = Robolectric.buildActivity(Activity.class);
        loadingView = (LoadingView) LayoutInflater.from(activityController.get()).inflate(R.layout.loading_view, null);
        loadingSpinner = loadingView.findViewById(R.id.loading_view_spinner);
        loadingTextView = (TextView) loadingView.findViewById(R.id.loading_text_view);
    }

    @Test
    public void testStopLoadingAndSetTextShouldHideTheSpinnerAndShowTheTextView() throws Exception {
        assertThat(loadingSpinner.getVisibility(), equalTo(View.VISIBLE));
        assertThat(loadingTextView.getVisibility(), equalTo(View.INVISIBLE));

        loadingView.stopLoadingAndSetText(R.string.unit_tests_ftw);

        assertThat(loadingSpinner.getVisibility(), equalTo(View.GONE));
        assertThat(loadingTextView.getVisibility(), equalTo(View.VISIBLE));
    }

}