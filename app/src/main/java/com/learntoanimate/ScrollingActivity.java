package com.learntoanimate;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.learntoanimate.api.RepositoryDetails;

public class ScrollingActivity extends AppCompatActivity {

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getIntent().getExtras();
        setContentView(R.layout.activity_scrolling);
        RepositoryDetails data = null;
        if(getIntent().hasExtra("repo_details")) {
            Bundle bundle = getIntent().getBundleExtra("repo_details");
            data = bundle.getParcelable("repo");
        }
        setUpViewChildren(data);
    }

    private void setUpViewChildren(RepositoryDetails data) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView repoTitle = (TextView)findViewById(R.id.repo_title);
        TextView repoDate = (TextView)findViewById(R.id.repo_created_at);
        TextView repoSize = (TextView)findViewById(R.id.repo_size);
        TextView repoUrl = (TextView)findViewById(R.id.repo_url);

        TextView repoIssues = (TextView)findViewById(R.id.repo_issues);
        TextView repoForks = (TextView)findViewById(R.id.repo_forks);
        TextView repoStars = (TextView)findViewById(R.id.repo_pulls);
        TextView repoLang = (TextView)findViewById(R.id.repo_lang);
        TextView repoDescription = (TextView)findViewById(R.id.repo_description);
        if(data != null) {
            repoTitle.setText(data.getFullName());
            repoDate.setText(data.getCreatedAt().substring(0,10));
            repoUrl.setText(data.getHtmlUrl());
            repoUrl.setClickable(true);
            repoUrl.setMovementMethod(LinkMovementMethod.getInstance());
            repoIssues.setText(data.getOpenIssuesCount()+"");
            repoForks.setText(data.getForksCount()+"");
            repoStars.setText(data.getStargazersCount()+"");
            repoLang.setText(data.getLanguage());
            repoDescription.setText(data.getDescription());
            repoSize.setText(data.getSize()+"KB");
        }
        fab = (FloatingActionButton) findViewById(R.id.email_sign_in_button);
        fab.setClickable(false);
    }
}
