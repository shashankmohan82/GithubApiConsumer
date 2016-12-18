package com.learntoanimate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.transitionseverywhere.ArcMotion;
import com.transitionseverywhere.ChangeBounds;
import com.transitionseverywhere.Fade;
import com.transitionseverywhere.Scene;
import com.transitionseverywhere.Transition;
import com.transitionseverywhere.TransitionManager;
import com.transitionseverywhere.TransitionSet;
import com.transitionseverywhere.extra.Scale;
import com.transitionseverywhere.extra.TranslationTransition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.learntoanimate.api.*;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Scene endScene;
    private ViewGroup container;
    private View parentView;
    private Scene startScene;
    private Button secondButton;
    private WeakReference<GithubAPIHelper> asyncTaskweakref;
    private View progressView;
    private EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parentView = getLayoutInflater().inflate(R.layout.activity_main, null);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        if(!isNetworkConnected())
            createAlertForNoInternet();
        else
            setUpTransitionEffects();

    }

    private void createAlertForNoInternet() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
                .setTitle("NO INTERNET CONNECTION")
                .setMessage("Please turn on data and restart.")
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int id) {
                                // Sent user to GPS settings screen

                                finish();

                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void createAlertForNoInternetWithCancelButton(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
                .setTitle("NO INTERNET CONNECTION")
                .setMessage("Please turn on data and click on OK.")
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int id) {
                                // Sent user to GPS settings screen

                                dialog.dismiss();

                            }
                        })
                .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
    }


    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

    private void setUpTransitionEffects() {

        setupScenes();
        setUpViewChildren();
    }

    private void setUpToolbar() {

    }

    private void setupScenes() {
        container = (ViewGroup) findViewById(R.id.scene_root);
        startScene = Scene.getCurrentScene(container);
        endScene = Scene.getSceneForLayout(container, R.layout.login_form_scene, this);
    }

    /* 5:48 pm*/

    private void setUpViewChildren() {

        final Button signinButton = (Button) (findViewById(R.id.sign_in));
        secondButton = (Button) findViewById(R.id.email_sign_in_button);
        final ImageView logo = (ImageView) findViewById(R.id.logo);
        progressView = findViewById(R.id.progressBar);


        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                com.transitionseverywhere.TransitionManager.beginDelayedTransition(
                        (ViewGroup) findViewById(R.id.parent1),
                        new ChangeBounds().setInterpolator(new LinearOutSlowInInterpolator()).setStartDelay(100).setDuration(300));
                signinButton.setText("");
                signinButton.setBackgroundColor(getResources().getColor(R.color.white));
                animateProperties();
                com.transitionseverywhere.TransitionManager.go(
                        endScene,
                        new TransitionSet()
                                .addTransition(new Scale().setStartDelay(100).setDuration(200)
                                        .setInterpolator(new LinearInterpolator()))
                                .addTransition(new Fade().setStartDelay(100).setDuration(200)
                                        .setInterpolator(new LinearInterpolator()))
                                .setOrdering(TransitionSet.ORDERING_SEQUENTIAL)
                );

                View viewById =  container.findViewById(R.id.login_form_container);
                if(viewById instanceof ConstraintLayout){
                    username = (EditText) viewById.findViewById(R.id.username);
                }

                com.transitionseverywhere.TransitionManager.beginDelayedTransition(
                        (ViewGroup) findViewById(R.id.activity_main),
                        new TransitionSet().addTransition(new Scale().setStartDelay(180).setDuration(400))
                        .addTransition(new TranslationTransition())
                );
                secondButton.setVisibility(View.VISIBLE);
            }
        });

        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptToLogin();
            }
        });
    }

    public void attemptToLogin() {
        if(isAsyncTaskPendingorRunning()) {
            Log.d("github", "async task pending or running");
            return;
        }
        Log.d("github", username.getText().toString()+" is text");
        // Reset errors.
        username.setError(null);

        // Store values at the time of the login attempt.
        String userId = username.getText().toString();

        boolean cancel = false;
        View focusView = null;


        // Check for a valid email address.
        if (TextUtils.isEmpty(userId)) {
//            username.setText("hi");
            username.setError(getString(R.string.error_field_required));
            focusView = username;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            if(!isNetworkConnected()) {
                createAlertForNoInternetWithCancelButton();
            }
            else {
                showProgress(true);
                Log.d("github", "starting async task");
                executeAPIHelperTask(userId);
            }
        }
    }

    private void executeAPIHelperTask(String userId) {
        GithubAPIHelper asyncHelper = new GithubAPIHelper(this, userId);
        asyncTaskweakref = new WeakReference<GithubAPIHelper>(asyncHelper);
        asyncHelper.execute(ApiConstants.USER.getS());
    }

    private boolean isAsyncTaskPendingorRunning() {
        return this.asyncTaskweakref != null &&
                this.asyncTaskweakref.get() != null &&
                !this.asyncTaskweakref.get().getStatus().equals(AsyncTask.Status.FINISHED);
    }

    public void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            container.setVisibility(show ? View.GONE : View.VISIBLE);
            container.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    container.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            progressView.setVisibility(show ? View.VISIBLE : View.GONE);
            progressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    progressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            progressView.setVisibility(show ? View.VISIBLE : View.GONE);
            container.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }


    public void startNewActivity(Bundle bundle) {
        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
        // Pass data object in the bundle and populate details activity.
        intent.putExtra("user", bundle );
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(MainActivity.this, (View)secondButton, "button");
        startActivity(intent, options.toBundle());
        finish();
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void animateProperties() {
        int colorFrom = getResources().getColor(R.color.color_main_background);
        int colorTo = getResources().getColor(R.color.white);
        ValueAnimator animator = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        animator.setDuration(200);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                container.setBackgroundColor((int)animation.getAnimatedValue());
            }
        });
        animator.start();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                com.transitionseverywhere.TransitionManager.go(startScene);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public EditText getUserName() {
        return username;
    }

    private static class GithubAPIHelper extends AsyncTask<String, Void, String> {

        private final String userId;
        private WeakReference<MainActivity> mainActivityWeakRef;
        private final String USER_FOUND = "found";
        private final String USER_NOT_FOUND = "not found";
        private HashMap<String, String> userDetails;

         GithubAPIHelper(MainActivity context, String userId) {
            this.mainActivityWeakRef = new WeakReference<MainActivity>(context);
            this.userId = userId;
            this.userDetails = new HashMap<>();
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                String url = String.format(params[0], userId);
                Log.d("github", "Attempting to connect to "+url);
                URL urls = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) urls.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                Log.d("github", "connected");

                if(connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    getUserDetails(connection);
                    Log.d("github", "user details retrieved"+(userDetails.isEmpty()?"unsuccessfully":"successfully"));
                    return USER_FOUND;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.d("github", "user does not exist");
            return USER_NOT_FOUND;
        }

        private void getUserDetails(HttpURLConnection connection) {
            try {
                InputStream inputStream = connection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null)
                    return;
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }

                JSONObject jsonObject = new JSONObject(buffer + "");
                if (jsonObject != null) {
                    userDetails.put("login", jsonObject.optString("login"));
                    userDetails.put("id", jsonObject.optString("id"));
                    userDetails.put("avatar_url", jsonObject.optString("avatar_url"));
                    userDetails.put("repos_url", jsonObject.optString("repos_url"));
                    userDetails.put("name", jsonObject.optString("name"));
                    userDetails.put("company", jsonObject.optString("company"));
                    userDetails.put("public_repos", jsonObject.optString("public_repos"));
                    userDetails.put("followers", jsonObject.optString("followers"));
                    userDetails.put("following", jsonObject.optString("following"));
                    userDetails.put("created_at", jsonObject.optString("created_at"));
                }


            } catch (JSONException e) {
                e.printStackTrace();
                Log.e("github", "JSON error");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void onPostExecute(String s) {
            MainActivity context = mainActivityWeakRef.get();
            context.showProgress(false);
            if(!USER_FOUND.equals(s)) {
                context.getUserName().setText("");
                context.attemptToLogin();
                Toast.makeText(context, "Invalid Username", Toast.LENGTH_SHORT).show();
            } else {
                Bundle bundle = new Bundle();
                for(Map.Entry<String, String> e : userDetails.entrySet()) {
                    bundle.putString(e.getKey(), e.getValue());
                    Log.d("github", e.toString());
                }
                context.startNewActivity(bundle);
            }

        }
    }

}
