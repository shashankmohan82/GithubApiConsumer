package com.learntoanimate.api;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "full_name",
        "owner",
        "private",
        "html_url",
        "description",
        "fork",
        "url",
        "forks_url",
        "keys_url",
        "collaborators_url",
        "teams_url",
        "hooks_url",
        "issue_events_url",
        "events_url",
        "assignees_url",
        "branches_url",
        "tags_url",
        "blobs_url",
        "git_tags_url",
        "git_refs_url",
        "trees_url",
        "statuses_url",
        "languages_url",
        "stargazers_url",
        "contributors_url",
        "subscribers_url",
        "subscription_url",
        "commits_url",
        "git_commits_url",
        "comments_url",
        "issue_comment_url",
        "contents_url",
        "compare_url",
        "merges_url",
        "archive_url",
        "downloads_url",
        "issues_url",
        "pulls_url",
        "milestones_url",
        "notifications_url",
        "labels_url",
        "releases_url",
        "deployments_url",
        "created_at",
        "updated_at",
        "pushed_at",
        "git_url",
        "ssh_url",
        "clone_url",
        "svn_url",
        "homepage",
        "size",
        "stargazers_count",
        "watchers_count",
        "language",
        "has_issues",
        "has_downloads",
        "has_wiki",
        "has_pages",
        "forks_count",
        "mirror_url",
        "open_issues_count",
        "forks",
        "open_issues",
        "watchers",
        "default_branch"
})

public class RepositoryDetails extends RealmObject implements Parcelable {

    @JsonProperty("id")
    @PrimaryKey
    private long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("private")
    private boolean _private;
    @JsonProperty("html_url")
    private String htmlUrl;
    @JsonProperty("description")
    private String description;
    @JsonProperty("fork")
    private boolean fork;
    @JsonProperty("url")
    private String url;
    @JsonProperty("forks_url")
    private String forksUrl;
    @JsonProperty("keys_url")
    private String keysUrl;
    @JsonProperty("collaborators_url")
    private String collaboratorsUrl;
    @JsonProperty("teams_url")
    private String teamsUrl;
    @JsonProperty("hooks_url")
    private String hooksUrl;
    @JsonProperty("issue_events_url")
    private String issueEventsUrl;
    @JsonProperty("events_url")
    private String eventsUrl;
    @JsonProperty("assignees_url")
    private String assigneesUrl;
    @JsonProperty("branches_url")
    private String branchesUrl;
    @JsonProperty("tags_url")
    private String tagsUrl;
    @JsonProperty("blobs_url")
    private String blobsUrl;
    @JsonProperty("git_tags_url")
    private String gitTagsUrl;
    @JsonProperty("git_refs_url")
    private String gitRefsUrl;
    @JsonProperty("trees_url")
    private String treesUrl;
    @JsonProperty("statuses_url")
    private String statusesUrl;
    @JsonProperty("languages_url")
    private String languagesUrl;
    @JsonProperty("stargazers_url")
    private String stargazersUrl;
    @JsonProperty("contributors_url")
    private String contributorsUrl;
    @JsonProperty("subscribers_url")
    private String subscribersUrl;
    @JsonProperty("subscription_url")
    private String subscriptionUrl;
    @JsonProperty("commits_url")
    private String commitsUrl;
    @JsonProperty("git_commits_url")
    private String gitCommitsUrl;
    @JsonProperty("comments_url")
    private String commentsUrl;
    @JsonProperty("issue_comment_url")
    private String issueCommentUrl;
    @JsonProperty("contents_url")
    private String contentsUrl;
    @JsonProperty("compare_url")
    private String compareUrl;
    @JsonProperty("merges_url")
    private String mergesUrl;
    @JsonProperty("archive_url")
    private String archiveUrl;
    @JsonProperty("downloads_url")
    private String downloadsUrl;
    @JsonProperty("issues_url")
    private String issuesUrl;
    @JsonProperty("pulls_url")
    private String pullsUrl;
    @JsonProperty("milestones_url")
    private String milestonesUrl;
    @JsonProperty("notifications_url")
    private String notificationsUrl;
    @JsonProperty("labels_url")
    private String labelsUrl;
    @JsonProperty("releases_url")
    private String releasesUrl;
    @JsonProperty("deployments_url")
    private String deploymentsUrl;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("pushed_at")
    private String pushedAt;
    @JsonProperty("git_url")
    private String gitUrl;
    @JsonProperty("ssh_url")
    private String sshUrl;
    @JsonProperty("clone_url")
    private String cloneUrl;
    @JsonProperty("svn_url")
    private String svnUrl;
    @JsonProperty("homepage")
    private String homepage;
    @JsonProperty("size")
    private long size;
    @JsonProperty("stargazers_count")
    private long stargazersCount;
    @JsonProperty("watchers_count")
    private long watchersCount;
    @JsonProperty("language")
    private String language;
    @JsonProperty("has_issues")
    private boolean hasIssues;
    @JsonProperty("has_downloads")
    private boolean hasDownloads;
    @JsonProperty("has_wiki")
    private boolean hasWiki;
    @JsonProperty("has_pages")
    private boolean hasPages;
    @JsonProperty("forks_count")
    private long forksCount;
    @JsonProperty("mirror_url")
    private String mirrorUrl;
    @JsonProperty("open_issues_count")
    private long openIssuesCount;
    @JsonProperty("forks")
    private long forks;
    @JsonProperty("open_issues")
    private long openIssues;
    @JsonProperty("watchers")
    private long watchers;
    @JsonProperty("default_branch")
    private String defaultBranch;
    @JsonIgnore
    @Ignore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Parcelable.Creator<RepositoryDetails> CREATOR = new Creator<RepositoryDetails>() {


        @SuppressWarnings({
                "unchecked"
        })
        public RepositoryDetails createFromParcel(Parcel in) {
            RepositoryDetails instance = new RepositoryDetails();
            instance.id = ((long) in.readValue((long.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.fullName = ((String) in.readValue((String.class.getClassLoader())));
            instance.owner = ((Owner) in.readValue((Owner.class.getClassLoader())));
            instance._private = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.htmlUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.description = ((String) in.readValue((String.class.getClassLoader())));
            instance.fork = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.url = ((String) in.readValue((String.class.getClassLoader())));
            instance.forksUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.keysUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.collaboratorsUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.teamsUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.hooksUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.issueEventsUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.eventsUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.assigneesUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.branchesUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.tagsUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.blobsUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.gitTagsUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.gitRefsUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.treesUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.statusesUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.languagesUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.stargazersUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.contributorsUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.subscribersUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.subscriptionUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.commitsUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.gitCommitsUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.commentsUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.issueCommentUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.contentsUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.compareUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.mergesUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.archiveUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.downloadsUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.issuesUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.pullsUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.milestonesUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.notificationsUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.labelsUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.releasesUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.deploymentsUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.createdAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.pushedAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.gitUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.sshUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.cloneUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.svnUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.homepage = ((String) in.readValue((String.class.getClassLoader())));
            instance.size = ((long) in.readValue((long.class.getClassLoader())));
            instance.stargazersCount = ((long) in.readValue((long.class.getClassLoader())));
            instance.watchersCount = ((long) in.readValue((long.class.getClassLoader())));
            instance.language = ((String) in.readValue((String.class.getClassLoader())));
            instance.hasIssues = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.hasDownloads = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.hasWiki = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.hasPages = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.forksCount = ((long) in.readValue((long.class.getClassLoader())));
            instance.mirrorUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.openIssuesCount = ((long) in.readValue((long.class.getClassLoader())));
            instance.forks = ((long) in.readValue((long.class.getClassLoader())));
            instance.openIssues = ((long) in.readValue((long.class.getClassLoader())));
            instance.watchers = ((long) in.readValue((long.class.getClassLoader())));
            instance.defaultBranch = ((String) in.readValue((String.class.getClassLoader())));
            instance.additionalProperties = ((Map<String, Object>) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public RepositoryDetails[] newArray(int size) {
            return new RepositoryDetails[size];
        }

    };

    /**
     * No args constructor for use in serialization
     */
    public RepositoryDetails() {
    }

    /**
     * @param notificationsUrl
     * @param releasesUrl
     * @param pushedAt
     * @param gitTagsUrl
     * @param contentsUrl
     * @param blobsUrl
     * @param issueEventsUrl
     * @param htmlUrl
     * @param _private
     * @param hooksUrl
     * @param description
     * @param commentsUrl
     * @param commitsUrl
     * @param labelsUrl
     * @param assigneesUrl
     * @param mergesUrl
     * @param fork
     * @param compareUrl
     * @param stargazersUrl
     * @param gitRefsUrl
     * @param deploymentsUrl
     * @param watchersCount
     * @param openIssuesCount
     * @param mirrorUrl
     * @param homepage
     * @param url
     * @param size
     * @param keysUrl
     * @param gitCommitsUrl
     * @param milestonesUrl
     * @param downloadsUrl
     * @param issueCommentUrl
     * @param pullsUrl
     * @param owner
     * @param forksUrl
     * @param language
     * @param statusesUrl
     * @param eventsUrl
     * @param openIssues
     * @param teamsUrl
     * @param sshUrl
     * @param contributorsUrl
     * @param stargazersCount
     * @param tagsUrl
     * @param id
     * @param hasIssues
     * @param createdAt
     * @param name
     * @param treesUrl
     * @param cloneUrl
     * @param issuesUrl
     * @param gitUrl
     * @param forksCount
     * @param watchers
     * @param subscriptionUrl
     * @param svnUrl
     * @param archiveUrl
     * @param hasPages
     * @param languagesUrl
     * @param updatedAt
     * @param collaboratorsUrl
     * @param forks
     * @param hasDownloads
     * @param subscribersUrl
     * @param branchesUrl
     * @param fullName
     * @param hasWiki
     * @param defaultBranch
     */
    public RepositoryDetails(long id, String name, String fullName, Owner owner, boolean _private, String htmlUrl, String description, boolean fork, String url, String forksUrl, String keysUrl, String collaboratorsUrl, String teamsUrl, String hooksUrl, String issueEventsUrl, String eventsUrl, String assigneesUrl, String branchesUrl, String tagsUrl, String blobsUrl, String gitTagsUrl, String gitRefsUrl, String treesUrl, String statusesUrl, String languagesUrl, String stargazersUrl, String contributorsUrl, String subscribersUrl, String subscriptionUrl, String commitsUrl, String gitCommitsUrl, String commentsUrl, String issueCommentUrl, String contentsUrl, String compareUrl, String mergesUrl, String archiveUrl, String downloadsUrl, String issuesUrl, String pullsUrl, String milestonesUrl, String notificationsUrl, String labelsUrl, String releasesUrl, String deploymentsUrl, String createdAt, String updatedAt, String pushedAt, String gitUrl, String sshUrl, String cloneUrl, String svnUrl, String homepage, long size, long stargazersCount, long watchersCount, String language, boolean hasIssues, boolean hasDownloads, boolean hasWiki, boolean hasPages, long forksCount, String mirrorUrl, long openIssuesCount, long forks, long openIssues, long watchers, String defaultBranch) {
        super();
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.owner = owner;
        this._private = _private;
        this.htmlUrl = htmlUrl;
        this.description = description;
        this.fork = fork;
        this.url = url;
        this.forksUrl = forksUrl;
        this.keysUrl = keysUrl;
        this.collaboratorsUrl = collaboratorsUrl;
        this.teamsUrl = teamsUrl;
        this.hooksUrl = hooksUrl;
        this.issueEventsUrl = issueEventsUrl;
        this.eventsUrl = eventsUrl;
        this.assigneesUrl = assigneesUrl;
        this.branchesUrl = branchesUrl;
        this.tagsUrl = tagsUrl;
        this.blobsUrl = blobsUrl;
        this.gitTagsUrl = gitTagsUrl;
        this.gitRefsUrl = gitRefsUrl;
        this.treesUrl = treesUrl;
        this.statusesUrl = statusesUrl;
        this.languagesUrl = languagesUrl;
        this.stargazersUrl = stargazersUrl;
        this.contributorsUrl = contributorsUrl;
        this.subscribersUrl = subscribersUrl;
        this.subscriptionUrl = subscriptionUrl;
        this.commitsUrl = commitsUrl;
        this.gitCommitsUrl = gitCommitsUrl;
        this.commentsUrl = commentsUrl;
        this.issueCommentUrl = issueCommentUrl;
        this.contentsUrl = contentsUrl;
        this.compareUrl = compareUrl;
        this.mergesUrl = mergesUrl;
        this.archiveUrl = archiveUrl;
        this.downloadsUrl = downloadsUrl;
        this.issuesUrl = issuesUrl;
        this.pullsUrl = pullsUrl;
        this.milestonesUrl = milestonesUrl;
        this.notificationsUrl = notificationsUrl;
        this.labelsUrl = labelsUrl;
        this.releasesUrl = releasesUrl;
        this.deploymentsUrl = deploymentsUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.pushedAt = pushedAt;
        this.gitUrl = gitUrl;
        this.sshUrl = sshUrl;
        this.cloneUrl = cloneUrl;
        this.svnUrl = svnUrl;
        this.homepage = homepage;
        this.size = size;
        this.stargazersCount = stargazersCount;
        this.watchersCount = watchersCount;
        this.language = language;
        this.hasIssues = hasIssues;
        this.hasDownloads = hasDownloads;
        this.hasWiki = hasWiki;
        this.hasPages = hasPages;
        this.forksCount = forksCount;
        this.mirrorUrl = mirrorUrl;
        this.openIssuesCount = openIssuesCount;
        this.forks = forks;
        this.openIssues = openIssues;
        this.watchers = watchers;
        this.defaultBranch = defaultBranch;
    }

    @JsonProperty("id")
    public long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(long id) {
        this.id = id;
    }

    public RepositoryDetails withId(long id) {
        this.id = id;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public RepositoryDetails withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("full_name")
    public String getFullName() {
        return fullName;
    }

    @JsonProperty("full_name")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public RepositoryDetails withFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @JsonProperty("owner")
    public Owner getOwner() {
        return owner;
    }

    @JsonProperty("owner")
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public RepositoryDetails withOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    @JsonProperty("private")
    public boolean isPrivate() {
        return _private;
    }

    @JsonProperty("private")
    public void setPrivate(boolean _private) {
        this._private = _private;
    }

    public RepositoryDetails withPrivate(boolean _private) {
        this._private = _private;
        return this;
    }

    @JsonProperty("html_url")
    public String getHtmlUrl() {
        return htmlUrl;
    }

    @JsonProperty("html_url")
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public RepositoryDetails withHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
        return this;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public RepositoryDetails withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("fork")
    public boolean isFork() {
        return fork;
    }

    @JsonProperty("fork")
    public void setFork(boolean fork) {
        this.fork = fork;
    }

    public RepositoryDetails withFork(boolean fork) {
        this.fork = fork;
        return this;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    public RepositoryDetails withUrl(String url) {
        this.url = url;
        return this;
    }

    @JsonProperty("forks_url")
    public String getForksUrl() {
        return forksUrl;
    }

    @JsonProperty("forks_url")
    public void setForksUrl(String forksUrl) {
        this.forksUrl = forksUrl;
    }

    public RepositoryDetails withForksUrl(String forksUrl) {
        this.forksUrl = forksUrl;
        return this;
    }

    @JsonProperty("keys_url")
    public String getKeysUrl() {
        return keysUrl;
    }

    @JsonProperty("keys_url")
    public void setKeysUrl(String keysUrl) {
        this.keysUrl = keysUrl;
    }

    public RepositoryDetails withKeysUrl(String keysUrl) {
        this.keysUrl = keysUrl;
        return this;
    }

    @JsonProperty("collaborators_url")
    public String getCollaboratorsUrl() {
        return collaboratorsUrl;
    }

    @JsonProperty("collaborators_url")
    public void setCollaboratorsUrl(String collaboratorsUrl) {
        this.collaboratorsUrl = collaboratorsUrl;
    }

    public RepositoryDetails withCollaboratorsUrl(String collaboratorsUrl) {
        this.collaboratorsUrl = collaboratorsUrl;
        return this;
    }

    @JsonProperty("teams_url")
    public String getTeamsUrl() {
        return teamsUrl;
    }

    @JsonProperty("teams_url")
    public void setTeamsUrl(String teamsUrl) {
        this.teamsUrl = teamsUrl;
    }

    public RepositoryDetails withTeamsUrl(String teamsUrl) {
        this.teamsUrl = teamsUrl;
        return this;
    }

    @JsonProperty("hooks_url")
    public String getHooksUrl() {
        return hooksUrl;
    }

    @JsonProperty("hooks_url")
    public void setHooksUrl(String hooksUrl) {
        this.hooksUrl = hooksUrl;
    }

    public RepositoryDetails withHooksUrl(String hooksUrl) {
        this.hooksUrl = hooksUrl;
        return this;
    }

    @JsonProperty("issue_events_url")
    public String getIssueEventsUrl() {
        return issueEventsUrl;
    }

    @JsonProperty("issue_events_url")
    public void setIssueEventsUrl(String issueEventsUrl) {
        this.issueEventsUrl = issueEventsUrl;
    }

    public RepositoryDetails withIssueEventsUrl(String issueEventsUrl) {
        this.issueEventsUrl = issueEventsUrl;
        return this;
    }

    @JsonProperty("events_url")
    public String getEventsUrl() {
        return eventsUrl;
    }

    @JsonProperty("events_url")
    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public RepositoryDetails withEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
        return this;
    }

    @JsonProperty("assignees_url")
    public String getAssigneesUrl() {
        return assigneesUrl;
    }

    @JsonProperty("assignees_url")
    public void setAssigneesUrl(String assigneesUrl) {
        this.assigneesUrl = assigneesUrl;
    }

    public RepositoryDetails withAssigneesUrl(String assigneesUrl) {
        this.assigneesUrl = assigneesUrl;
        return this;
    }

    @JsonProperty("branches_url")
    public String getBranchesUrl() {
        return branchesUrl;
    }

    @JsonProperty("branches_url")
    public void setBranchesUrl(String branchesUrl) {
        this.branchesUrl = branchesUrl;
    }

    public RepositoryDetails withBranchesUrl(String branchesUrl) {
        this.branchesUrl = branchesUrl;
        return this;
    }

    @JsonProperty("tags_url")
    public String getTagsUrl() {
        return tagsUrl;
    }

    @JsonProperty("tags_url")
    public void setTagsUrl(String tagsUrl) {
        this.tagsUrl = tagsUrl;
    }

    public RepositoryDetails withTagsUrl(String tagsUrl) {
        this.tagsUrl = tagsUrl;
        return this;
    }

    @JsonProperty("blobs_url")
    public String getBlobsUrl() {
        return blobsUrl;
    }

    @JsonProperty("blobs_url")
    public void setBlobsUrl(String blobsUrl) {
        this.blobsUrl = blobsUrl;
    }

    public RepositoryDetails withBlobsUrl(String blobsUrl) {
        this.blobsUrl = blobsUrl;
        return this;
    }

    @JsonProperty("git_tags_url")
    public String getGitTagsUrl() {
        return gitTagsUrl;
    }

    @JsonProperty("git_tags_url")
    public void setGitTagsUrl(String gitTagsUrl) {
        this.gitTagsUrl = gitTagsUrl;
    }

    public RepositoryDetails withGitTagsUrl(String gitTagsUrl) {
        this.gitTagsUrl = gitTagsUrl;
        return this;
    }

    @JsonProperty("git_refs_url")
    public String getGitRefsUrl() {
        return gitRefsUrl;
    }

    @JsonProperty("git_refs_url")
    public void setGitRefsUrl(String gitRefsUrl) {
        this.gitRefsUrl = gitRefsUrl;
    }

    public RepositoryDetails withGitRefsUrl(String gitRefsUrl) {
        this.gitRefsUrl = gitRefsUrl;
        return this;
    }

    @JsonProperty("trees_url")
    public String getTreesUrl() {
        return treesUrl;
    }

    @JsonProperty("trees_url")
    public void setTreesUrl(String treesUrl) {
        this.treesUrl = treesUrl;
    }

    public RepositoryDetails withTreesUrl(String treesUrl) {
        this.treesUrl = treesUrl;
        return this;
    }

    @JsonProperty("statuses_url")
    public String getStatusesUrl() {
        return statusesUrl;
    }

    @JsonProperty("statuses_url")
    public void setStatusesUrl(String statusesUrl) {
        this.statusesUrl = statusesUrl;
    }

    public RepositoryDetails withStatusesUrl(String statusesUrl) {
        this.statusesUrl = statusesUrl;
        return this;
    }

    @JsonProperty("languages_url")
    public String getLanguagesUrl() {
        return languagesUrl;
    }

    @JsonProperty("languages_url")
    public void setLanguagesUrl(String languagesUrl) {
        this.languagesUrl = languagesUrl;
    }

    public RepositoryDetails withLanguagesUrl(String languagesUrl) {
        this.languagesUrl = languagesUrl;
        return this;
    }

    @JsonProperty("stargazers_url")
    public String getStargazersUrl() {
        return stargazersUrl;
    }

    @JsonProperty("stargazers_url")
    public void setStargazersUrl(String stargazersUrl) {
        this.stargazersUrl = stargazersUrl;
    }

    public RepositoryDetails withStargazersUrl(String stargazersUrl) {
        this.stargazersUrl = stargazersUrl;
        return this;
    }

    @JsonProperty("contributors_url")
    public String getContributorsUrl() {
        return contributorsUrl;
    }

    @JsonProperty("contributors_url")
    public void setContributorsUrl(String contributorsUrl) {
        this.contributorsUrl = contributorsUrl;
    }

    public RepositoryDetails withContributorsUrl(String contributorsUrl) {
        this.contributorsUrl = contributorsUrl;
        return this;
    }

    @JsonProperty("subscribers_url")
    public String getSubscribersUrl() {
        return subscribersUrl;
    }

    @JsonProperty("subscribers_url")
    public void setSubscribersUrl(String subscribersUrl) {
        this.subscribersUrl = subscribersUrl;
    }

    public RepositoryDetails withSubscribersUrl(String subscribersUrl) {
        this.subscribersUrl = subscribersUrl;
        return this;
    }

    @JsonProperty("subscription_url")
    public String getSubscriptionUrl() {
        return subscriptionUrl;
    }

    @JsonProperty("subscription_url")
    public void setSubscriptionUrl(String subscriptionUrl) {
        this.subscriptionUrl = subscriptionUrl;
    }

    public RepositoryDetails withSubscriptionUrl(String subscriptionUrl) {
        this.subscriptionUrl = subscriptionUrl;
        return this;
    }

    @JsonProperty("commits_url")
    public String getCommitsUrl() {
        return commitsUrl;
    }

    @JsonProperty("commits_url")
    public void setCommitsUrl(String commitsUrl) {
        this.commitsUrl = commitsUrl;
    }

    public RepositoryDetails withCommitsUrl(String commitsUrl) {
        this.commitsUrl = commitsUrl;
        return this;
    }

    @JsonProperty("git_commits_url")
    public String getGitCommitsUrl() {
        return gitCommitsUrl;
    }

    @JsonProperty("git_commits_url")
    public void setGitCommitsUrl(String gitCommitsUrl) {
        this.gitCommitsUrl = gitCommitsUrl;
    }

    public RepositoryDetails withGitCommitsUrl(String gitCommitsUrl) {
        this.gitCommitsUrl = gitCommitsUrl;
        return this;
    }

    @JsonProperty("comments_url")
    public String getCommentsUrl() {
        return commentsUrl;
    }

    @JsonProperty("comments_url")
    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    public RepositoryDetails withCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
        return this;
    }

    @JsonProperty("issue_comment_url")
    public String getIssueCommentUrl() {
        return issueCommentUrl;
    }

    @JsonProperty("issue_comment_url")
    public void setIssueCommentUrl(String issueCommentUrl) {
        this.issueCommentUrl = issueCommentUrl;
    }

    public RepositoryDetails withIssueCommentUrl(String issueCommentUrl) {
        this.issueCommentUrl = issueCommentUrl;
        return this;
    }

    @JsonProperty("contents_url")
    public String getContentsUrl() {
        return contentsUrl;
    }

    @JsonProperty("contents_url")
    public void setContentsUrl(String contentsUrl) {
        this.contentsUrl = contentsUrl;
    }

    public RepositoryDetails withContentsUrl(String contentsUrl) {
        this.contentsUrl = contentsUrl;
        return this;
    }

    @JsonProperty("compare_url")
    public String getCompareUrl() {
        return compareUrl;
    }

    @JsonProperty("compare_url")
    public void setCompareUrl(String compareUrl) {
        this.compareUrl = compareUrl;
    }

    public RepositoryDetails withCompareUrl(String compareUrl) {
        this.compareUrl = compareUrl;
        return this;
    }

    @JsonProperty("merges_url")
    public String getMergesUrl() {
        return mergesUrl;
    }

    @JsonProperty("merges_url")
    public void setMergesUrl(String mergesUrl) {
        this.mergesUrl = mergesUrl;
    }

    public RepositoryDetails withMergesUrl(String mergesUrl) {
        this.mergesUrl = mergesUrl;
        return this;
    }

    @JsonProperty("archive_url")
    public String getArchiveUrl() {
        return archiveUrl;
    }

    @JsonProperty("archive_url")
    public void setArchiveUrl(String archiveUrl) {
        this.archiveUrl = archiveUrl;
    }

    public RepositoryDetails withArchiveUrl(String archiveUrl) {
        this.archiveUrl = archiveUrl;
        return this;
    }

    @JsonProperty("downloads_url")
    public String getDownloadsUrl() {
        return downloadsUrl;
    }

    @JsonProperty("downloads_url")
    public void setDownloadsUrl(String downloadsUrl) {
        this.downloadsUrl = downloadsUrl;
    }

    public RepositoryDetails withDownloadsUrl(String downloadsUrl) {
        this.downloadsUrl = downloadsUrl;
        return this;
    }

    @JsonProperty("issues_url")
    public String getIssuesUrl() {
        return issuesUrl;
    }

    @JsonProperty("issues_url")
    public void setIssuesUrl(String issuesUrl) {
        this.issuesUrl = issuesUrl;
    }

    public RepositoryDetails withIssuesUrl(String issuesUrl) {
        this.issuesUrl = issuesUrl;
        return this;
    }

    @JsonProperty("pulls_url")
    public String getPullsUrl() {
        return pullsUrl;
    }

    @JsonProperty("pulls_url")
    public void setPullsUrl(String pullsUrl) {
        this.pullsUrl = pullsUrl;
    }

    public RepositoryDetails withPullsUrl(String pullsUrl) {
        this.pullsUrl = pullsUrl;
        return this;
    }

    @JsonProperty("milestones_url")
    public String getMilestonesUrl() {
        return milestonesUrl;
    }

    @JsonProperty("milestones_url")
    public void setMilestonesUrl(String milestonesUrl) {
        this.milestonesUrl = milestonesUrl;
    }

    public RepositoryDetails withMilestonesUrl(String milestonesUrl) {
        this.milestonesUrl = milestonesUrl;
        return this;
    }

    @JsonProperty("notifications_url")
    public String getNotificationsUrl() {
        return notificationsUrl;
    }

    @JsonProperty("notifications_url")
    public void setNotificationsUrl(String notificationsUrl) {
        this.notificationsUrl = notificationsUrl;
    }

    public RepositoryDetails withNotificationsUrl(String notificationsUrl) {
        this.notificationsUrl = notificationsUrl;
        return this;
    }

    @JsonProperty("labels_url")
    public String getLabelsUrl() {
        return labelsUrl;
    }

    @JsonProperty("labels_url")
    public void setLabelsUrl(String labelsUrl) {
        this.labelsUrl = labelsUrl;
    }

    public RepositoryDetails withLabelsUrl(String labelsUrl) {
        this.labelsUrl = labelsUrl;
        return this;
    }

    @JsonProperty("releases_url")
    public String getReleasesUrl() {
        return releasesUrl;
    }

    @JsonProperty("releases_url")
    public void setReleasesUrl(String releasesUrl) {
        this.releasesUrl = releasesUrl;
    }

    public RepositoryDetails withReleasesUrl(String releasesUrl) {
        this.releasesUrl = releasesUrl;
        return this;
    }

    @JsonProperty("deployments_url")
    public String getDeploymentsUrl() {
        return deploymentsUrl;
    }

    @JsonProperty("deployments_url")
    public void setDeploymentsUrl(String deploymentsUrl) {
        this.deploymentsUrl = deploymentsUrl;
    }

    public RepositoryDetails withDeploymentsUrl(String deploymentsUrl) {
        this.deploymentsUrl = deploymentsUrl;
        return this;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public RepositoryDetails withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public RepositoryDetails withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @JsonProperty("pushed_at")
    public String getPushedAt() {
        return pushedAt;
    }

    @JsonProperty("pushed_at")
    public void setPushedAt(String pushedAt) {
        this.pushedAt = pushedAt;
    }

    public RepositoryDetails withPushedAt(String pushedAt) {
        this.pushedAt = pushedAt;
        return this;
    }

    @JsonProperty("git_url")
    public String getGitUrl() {
        return gitUrl;
    }

    @JsonProperty("git_url")
    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    public RepositoryDetails withGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
        return this;
    }

    @JsonProperty("ssh_url")
    public String getSshUrl() {
        return sshUrl;
    }

    @JsonProperty("ssh_url")
    public void setSshUrl(String sshUrl) {
        this.sshUrl = sshUrl;
    }

    public RepositoryDetails withSshUrl(String sshUrl) {
        this.sshUrl = sshUrl;
        return this;
    }

    @JsonProperty("clone_url")
    public String getCloneUrl() {
        return cloneUrl;
    }

    @JsonProperty("clone_url")
    public void setCloneUrl(String cloneUrl) {
        this.cloneUrl = cloneUrl;
    }

    public RepositoryDetails withCloneUrl(String cloneUrl) {
        this.cloneUrl = cloneUrl;
        return this;
    }

    @JsonProperty("svn_url")
    public String getSvnUrl() {
        return svnUrl;
    }

    @JsonProperty("svn_url")
    public void setSvnUrl(String svnUrl) {
        this.svnUrl = svnUrl;
    }

    public RepositoryDetails withSvnUrl(String svnUrl) {
        this.svnUrl = svnUrl;
        return this;
    }

    @JsonProperty("homepage")
    public String getHomepage() {
        return homepage;
    }

    @JsonProperty("homepage")
    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public RepositoryDetails withHomepage(String homepage) {
        this.homepage = homepage;
        return this;
    }

    @JsonProperty("size")
    public long getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(long size) {
        this.size = size;
    }

    public RepositoryDetails withSize(long size) {
        this.size = size;
        return this;
    }

    @JsonProperty("stargazers_count")
    public long getStargazersCount() {
        return stargazersCount;
    }

    @JsonProperty("stargazers_count")
    public void setStargazersCount(long stargazersCount) {
        this.stargazersCount = stargazersCount;
    }

    public RepositoryDetails withStargazersCount(long stargazersCount) {
        this.stargazersCount = stargazersCount;
        return this;
    }

    @JsonProperty("watchers_count")
    public long getWatchersCount() {
        return watchersCount;
    }

    @JsonProperty("watchers_count")
    public void setWatchersCount(long watchersCount) {
        this.watchersCount = watchersCount;
    }

    public RepositoryDetails withWatchersCount(long watchersCount) {
        this.watchersCount = watchersCount;
        return this;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    public RepositoryDetails withLanguage(String language) {
        this.language = language;
        return this;
    }

    @JsonProperty("has_issues")
    public boolean isHasIssues() {
        return hasIssues;
    }

    @JsonProperty("has_issues")
    public void setHasIssues(boolean hasIssues) {
        this.hasIssues = hasIssues;
    }

    public RepositoryDetails withHasIssues(boolean hasIssues) {
        this.hasIssues = hasIssues;
        return this;
    }

    @JsonProperty("has_downloads")
    public boolean isHasDownloads() {
        return hasDownloads;
    }

    @JsonProperty("has_downloads")
    public void setHasDownloads(boolean hasDownloads) {
        this.hasDownloads = hasDownloads;
    }

    public RepositoryDetails withHasDownloads(boolean hasDownloads) {
        this.hasDownloads = hasDownloads;
        return this;
    }

    @JsonProperty("has_wiki")
    public boolean isHasWiki() {
        return hasWiki;
    }

    @JsonProperty("has_wiki")
    public void setHasWiki(boolean hasWiki) {
        this.hasWiki = hasWiki;
    }

    public RepositoryDetails withHasWiki(boolean hasWiki) {
        this.hasWiki = hasWiki;
        return this;
    }

    @JsonProperty("has_pages")
    public boolean isHasPages() {
        return hasPages;
    }

    @JsonProperty("has_pages")
    public void setHasPages(boolean hasPages) {
        this.hasPages = hasPages;
    }

    public RepositoryDetails withHasPages(boolean hasPages) {
        this.hasPages = hasPages;
        return this;
    }

    @JsonProperty("forks_count")
    public long getForksCount() {
        return forksCount;
    }

    @JsonProperty("forks_count")
    public void setForksCount(long forksCount) {
        this.forksCount = forksCount;
    }

    public RepositoryDetails withForksCount(long forksCount) {
        this.forksCount = forksCount;
        return this;
    }

    @JsonProperty("mirror_url")
    public String getMirrorUrl() {
        return mirrorUrl;
    }

    @JsonProperty("mirror_url")
    public void setMirrorUrl(String mirrorUrl) {
        this.mirrorUrl = mirrorUrl;
    }

    public RepositoryDetails withMirrorUrl(String mirrorUrl) {
        this.mirrorUrl = mirrorUrl;
        return this;
    }

    @JsonProperty("open_issues_count")
    public long getOpenIssuesCount() {
        return openIssuesCount;
    }

    @JsonProperty("open_issues_count")
    public void setOpenIssuesCount(long openIssuesCount) {
        this.openIssuesCount = openIssuesCount;
    }

    public RepositoryDetails withOpenIssuesCount(long openIssuesCount) {
        this.openIssuesCount = openIssuesCount;
        return this;
    }

    @JsonProperty("forks")
    public long getForks() {
        return forks;
    }

    @JsonProperty("forks")
    public void setForks(long forks) {
        this.forks = forks;
    }

    public RepositoryDetails withForks(long forks) {
        this.forks = forks;
        return this;
    }

    @JsonProperty("open_issues")
    public long getOpenIssues() {
        return openIssues;
    }

    @JsonProperty("open_issues")
    public void setOpenIssues(long openIssues) {
        this.openIssues = openIssues;
    }

    public RepositoryDetails withOpenIssues(long openIssues) {
        this.openIssues = openIssues;
        return this;
    }

    @JsonProperty("watchers")
    public long getWatchers() {
        return watchers;
    }

    @JsonProperty("watchers")
    public void setWatchers(long watchers) {
        this.watchers = watchers;
    }

    public RepositoryDetails withWatchers(long watchers) {
        this.watchers = watchers;
        return this;
    }

    @JsonProperty("default_branch")
    public String getDefaultBranch() {
        return defaultBranch;
    }

    @JsonProperty("default_branch")
    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

    public RepositoryDetails withDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public RepositoryDetails withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(fullName);
        dest.writeValue(owner);
        dest.writeValue(_private);
        dest.writeValue(htmlUrl);
        dest.writeValue(description);
        dest.writeValue(fork);
        dest.writeValue(url);
        dest.writeValue(forksUrl);
        dest.writeValue(keysUrl);
        dest.writeValue(collaboratorsUrl);
        dest.writeValue(teamsUrl);
        dest.writeValue(hooksUrl);
        dest.writeValue(issueEventsUrl);
        dest.writeValue(eventsUrl);
        dest.writeValue(assigneesUrl);
        dest.writeValue(branchesUrl);
        dest.writeValue(tagsUrl);
        dest.writeValue(blobsUrl);
        dest.writeValue(gitTagsUrl);
        dest.writeValue(gitRefsUrl);
        dest.writeValue(treesUrl);
        dest.writeValue(statusesUrl);
        dest.writeValue(languagesUrl);
        dest.writeValue(stargazersUrl);
        dest.writeValue(contributorsUrl);
        dest.writeValue(subscribersUrl);
        dest.writeValue(subscriptionUrl);
        dest.writeValue(commitsUrl);
        dest.writeValue(gitCommitsUrl);
        dest.writeValue(commentsUrl);
        dest.writeValue(issueCommentUrl);
        dest.writeValue(contentsUrl);
        dest.writeValue(compareUrl);
        dest.writeValue(mergesUrl);
        dest.writeValue(archiveUrl);
        dest.writeValue(downloadsUrl);
        dest.writeValue(issuesUrl);
        dest.writeValue(pullsUrl);
        dest.writeValue(milestonesUrl);
        dest.writeValue(notificationsUrl);
        dest.writeValue(labelsUrl);
        dest.writeValue(releasesUrl);
        dest.writeValue(deploymentsUrl);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(pushedAt);
        dest.writeValue(gitUrl);
        dest.writeValue(sshUrl);
        dest.writeValue(cloneUrl);
        dest.writeValue(svnUrl);
        dest.writeValue(homepage);
        dest.writeValue(size);
        dest.writeValue(stargazersCount);
        dest.writeValue(watchersCount);
        dest.writeValue(language);
        dest.writeValue(hasIssues);
        dest.writeValue(hasDownloads);
        dest.writeValue(hasWiki);
        dest.writeValue(hasPages);
        dest.writeValue(forksCount);
        dest.writeValue(mirrorUrl);
        dest.writeValue(openIssuesCount);
        dest.writeValue(forks);
        dest.writeValue(openIssues);
        dest.writeValue(watchers);
        dest.writeValue(defaultBranch);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return 0;
    }
}



