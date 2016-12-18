package com.learntoanimate;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learntoanimate.api.ApiConstants;
import com.learntoanimate.api.RepositoryDetails;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmQuery;

public class ProfileActivity extends AppCompatActivity {
    private WeakReference<AsyncTaskHelper> asyncTaskHelperWeakRef;
    private String userId;
    private WeakReference<AsyncTaskHelper> asyncTaskweakref;
    private ArrayList<RepositoryDetails> dataSet;
    private FloatingActionButton fab;
    private Realm realm;
    private RecyclerView recyclerView;
    private TextView username;
    private TextView userMembership;
    private TextView userWork;
    private TextView userFollowers;
    private TextView userFollowing;
    private TextView userRepos;
    private ImageView user_image;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        realm = Realm.getDefaultInstance();
        View parentView = getLayoutInflater().inflate(R.layout.activity_profile, null);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setUpViewChildren(parentView);
        executeAsyncTask();
    }

    private void setUpViewChildren(View parentView) {
        fab = (FloatingActionButton) parentView.findViewById(R.id.email_sign_in_button);
        username = (TextView) findViewById(R.id.repo_title);
        userMembership = (TextView) findViewById(R.id.repo_create_date);
        userWork = (TextView) findViewById(R.id.user_work);
        userFollowers = (TextView) findViewById(R.id.user_followers);
        userFollowing = (TextView) findViewById(R.id.repo_forks);
        userRepos = (TextView) findViewById(R.id.user_repos);
        if (getIntent().hasExtra("user")) {
            Bundle bundle = getIntent().getBundleExtra("user");
            userId = bundle.getString("login");
            username.setText(bundle.getString("name"));
            userMembership.setText(bundle.getString("created_at").substring(0,10));
            userWork.setText(bundle.getString("company"));
            userFollowers.setText(bundle.getString("followers"));
            userFollowing.setText(bundle.getString("following"));
            userRepos.setText(bundle.getString("public_repos"));
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.repo_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        user_image = (ImageView)findViewById(R.id.user_image);
//        setRecyclerViewAdapter();
    }

    private void executeAsyncTask() {
        AsyncTaskHelper asyncHelper = new AsyncTaskHelper(this, userId);
        asyncTaskweakref = new WeakReference<AsyncTaskHelper>(asyncHelper);
        asyncHelper.execute(ApiConstants.REPO.getS());
    }


    private void setDataSet(ArrayList<RepositoryDetails> arrayList) {
        this.dataSet = arrayList;
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void setRecyclerViewAdapter(){
        try {
            RealmQuery<RepositoryDetails> query = realm.where(RepositoryDetails.class)
                    .equalTo("owner.login", userId);
            OrderedRealmCollection<RepositoryDetails> data = query.findAll();
            MyRecyclerViewAdapter rcAdapter = new MyRecyclerViewAdapter(this, data,
                    new MyRecyclerViewAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position, final RepositoryDetails data, View currentView) {
                            Intent intent = new Intent(ProfileActivity.this, ScrollingActivity.class);
                            Bundle bundle = new Bundle();
                            Bundle iVBundle = new Bundle();
                            bundle.putParcelable("repo", data);
                            intent.putExtra("repo_details", bundle);
                            Pair<View, String> p1 = Pair.create((View)fab, "button");
                            Pair<View, String> p2 = Pair.create((View)user_image, "repo_image");
                            ActivityOptionsCompat options = ActivityOptionsCompat.
                                    makeSceneTransitionAnimation(ProfileActivity.this, p1, p2);
                            startActivity(intent, options.toBundle());
                        }
                    });
            recyclerView.setAdapter(rcAdapter);
            recyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                }
            });
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class AsyncTaskHelper extends AsyncTask<String, Void, String> {

        private static final String SUCCESSFUL = "successful";
        private static final String UNSUCCESSFUL = "unsuccessful";

        private final String userId;
        private WeakReference<ProfileActivity> mainActivityWeakRef;
        private final ArrayList<RepositoryDetails> repoList;
        private ProgressDialog progressDialog;

        AsyncTaskHelper(ProfileActivity context, String userId) {
            this.mainActivityWeakRef = new WeakReference<ProfileActivity>(context);
            this.userId = userId;
            this.repoList = new ArrayList<>();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(mainActivityWeakRef.get());
            progressDialog.setIndeterminate(true);
            progressDialog.setTitle("Bringing your riches..");
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            try(Realm realm = Realm.getDefaultInstance()){
                String url = String.format(params[0], userId);
                Log.d("github", "Attempting to connect to " + url);
                URL urls = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) urls.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                Log.d("github", "connected");

                getRepoDetails(connection);
                Log.d("github", "repo details retrieved" + (repoList.isEmpty() ? " unsuccessfully" : " successfully"));
                realm.executeTransactionAsync(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealmOrUpdate(repoList);
                    }
                });
                return SUCCESSFUL;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return UNSUCCESSFUL;
        }

        private void getRepoDetails(HttpURLConnection connection) {
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
                ObjectMapper mapper = new ObjectMapper();
                JsonFactory factory = new JsonFactory();
                JsonParser jp = factory.createParser(buffer.toString());
                jp.nextToken();
                while (jp.nextToken() == JsonToken.START_OBJECT) {
                    RepositoryDetails details = mapper.readValue(jp, RepositoryDetails.class);
                    Log.d("github", details.getName());
                    repoList.add(details);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void onPostExecute(String s) {
            ProfileActivity context = mainActivityWeakRef.get();
            if (SUCCESSFUL.equals(s)) {
                progressDialog.dismiss();
                context.setRecyclerViewAdapter();
                context.setDataSet(repoList);
            }
        }
    }
}
