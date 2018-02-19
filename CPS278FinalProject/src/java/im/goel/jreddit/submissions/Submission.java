package im.goel.jreddit.submissions;

import im.goel.jreddit.InvalidCookieException;
import im.goel.jreddit.Thing;
import im.goel.jreddit.user.User;
import im.goel.jreddit.utils.Utils;

import java.io.IOException;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;


/**
 * This class represents a vote on a link submission on reddit.
 *
 * @author <a href="http://www.omrlnr.com">Omer Elnour</a>
 */
public class Submission extends Thing {
    /**
     * This is the user that will vote on a submission.
     */
    private User user;
    /**
     * The path to this submission
     */
    
    
    private String domain;
    private String banned_by;
    private String subreddit;
    private String selftext_html;
    private String selftext;
    private int likes;
    private String link_flair_text;
    private String id;
    private boolean clicked;
    private boolean stickied;
    private String author;
    private String media;
    private int score;
    private String approved_by;
    private boolean over_18;
    private boolean hidden;
    private String thumbnail;
    private String subreddit_id;
    private boolean edited;
    private String link_flair_css_class;
    private String author_flair_css_class;
    private int downs;
    private boolean saved;
    private boolean is_self;
    private String permalink;
    private String name;
    private double created;
    private URL url;
    private String author_flair_text;
    private String title;
    private double created_utc;
    private int ups;
    private int num_comments;
    private boolean visited;
    private int num_reports;
    private String distinguished;


    /** 
     * An empty Submission
     */
    public Submission() {
    }
    
    /** A Submission that is loaded from a JSONObject
     * 
     * @author Evin Ugur
     * @param obj The JSONObject to load Submission data from
     * @throws Exception The JSONObject is somehow bad
     */
    public Submission(JSONObject obj){
    	try{
            domain = Utils.toString(obj.get("domain"));
            banned_by = Utils.toString(obj.get("banned__by"));
            subreddit = Utils.toString(obj.get("subreddit"));
            selftext_html = Utils.toString(obj.get("selftext_html"));
            selftext = Utils.toString(obj.get("selftext"));
            link_flair_text = Utils.toString(obj.get("link_flair_text"));
            id = Utils.toString(obj.get("id"));
            author = Utils.toString(obj.get("author"));
            media = Utils.toString(obj.get("media"));
            approved_by = Utils.toString(obj.get("approved_by"));
            thumbnail = Utils.toString(obj.get("thumbnail"));
            subreddit_id = Utils.toString(obj.get("subreddit_id"));
            link_flair_css_class = Utils.toString(obj.get("link_flair_css_class"));
            author_flair_css_class = Utils.toString(obj.get("author_flair_css_class"));
            permalink = Utils.toString(obj.get("permalink"));
            name = Utils.toString(obj.get("name"));
            url = new URL(Utils.toString(obj.get("url")));
            author_flair_text  = Utils.toString(obj.get("author_flair_text"));           
            title = Utils.toString(obj.get("title"));
            distinguished = Utils.toString(obj.get("distinguished"));
            
            try {
                created = Double.parseDouble(Utils.toString(obj.get("created")));
            } catch(NumberFormatException e) {
                created = -1.0d;
            }
            try {
                created_utc = Double.parseDouble(Utils.toString(obj.get("created_utc")));
            } catch(NumberFormatException e) {
                created_utc = -1.0d;
            }
            
            clicked = Boolean.parseBoolean(Utils.toString(obj.get("clicked")));
            stickied = Boolean.parseBoolean(Utils.toString(obj.get("stickied")));
            over_18 = Boolean.parseBoolean(Utils.toString(obj.get("over_18")));
            hidden = Boolean.parseBoolean(Utils.toString(obj.get("hidden")));
            edited = Boolean.parseBoolean(Utils.toString(obj.get("edited")));
            saved = Boolean.parseBoolean(Utils.toString(obj.get("saved")));
            is_self = Boolean.parseBoolean(Utils.toString(obj.get("is_self")));
            visited = Boolean.parseBoolean(Utils.toString(obj.get("visited")));
            
            try {
                likes = Integer.parseInt(Utils.toString(obj.get("likes")));
            } catch(NumberFormatException e) {
                likes = -1;
            }
            
            try {
                score = Integer.parseInt(Utils.toString(obj.get("score")));
            } catch(NumberFormatException e) {
                score = -1;
            }
            
            try {
                downs = Integer.parseInt(Utils.toString(obj.get("downs")));
            } catch(NumberFormatException e) {
                downs = -1;
            }
            
            try {
                ups = Integer.parseInt(Utils.toString(obj.get("ups")));
            } catch(NumberFormatException e) {
                ups = -1;
            }
            
            try {
                num_comments = Integer.parseInt(Utils.toString(obj.get("num_comments")));
            } catch(NumberFormatException e) {
                num_comments = -1;
            }
            
            try{
                num_reports = Integer.parseInt(Utils.toString(obj.get("num_reports")));
            } catch(NumberFormatException e) {
                num_reports = -1;
            }
            
    	}
    	catch(Exception e){e.printStackTrace();}
    }
    
    public Submission(User user, String fullName) {
//		this(user, fullName, url);
    }

    public Submission(User user, String fullName, URL url) {
        if (fullName.startsWith("t3_"))
            fullName = fullName.replaceFirst("t3_", "");

        this.user = user;
        this.fullName = "t3_" + fullName;
        this.url = url;
    }
    

    /**
     * This function comments on this submission saying the comment specified in
     * <code>text</code> (CAN INCLUDE MARKDOWN)
     *
     * @param text The text to comment
     * @throws IOException    If connection fails
     * @throws ParseException If JSON parsing fails
     */
    public void comment(String text) throws IOException, ParseException {
        JSONObject object = Utils.post("thing_id=" + fullName + "&text=" + text
                + "&uh=" + getUser().getModhash(), new URL(
                "http://www.reddit.com/api/comment"), getUser().getCookie());

        if (object.toJSONString().contains(".error.USER_REQUIRED"))
            throw new InvalidCookieException("Cookie not present");
        else
            System.out.println("Commented on thread id " + fullName
                    + " saying: \"" + text + "\"");
    }


    /**
     * This function returns true if this submission is marked as NSFW (18+)
     *
     * @return This submission is NSFW
     * @throws IOException    If connection fails
     * @throws ParseException If JSON parsing fails
     */
   

    public void markNSFW() throws IOException, ParseException {
        Utils.post(
            "id=" + fullName + "&uh=" + getUser().getModhash(),
            new URL("http://www.reddit.com/api/marknsfw"), getUser().getCookie());
    }

    public void unmarkNSFW() throws IOException, ParseException {
        Utils.post(
            "id=" + fullName + "&uh=" + getUser().getModhash(),
            new URL("http://www.reddit.com/api/unmarknsfw"), getUser().getCookie());
    }

    /**
     * This function upvotes this submission.
     *
     * @throws IOException    If connection fails
     * @throws ParseException If JSON parsing fails
     */
    public void upVote() throws IOException, ParseException {
        JSONObject object = voteResponse(1);
        if (!(object.toJSONString().length() > 2))
            // Will return "{}"
            System.out.println("Successful upboat!");
        else
            System.out.println(object.toJSONString());
    }

    /**
     * This function rescinds, or normalizes this submission. <br />
     * (i.e Removes a downvote or upvote)
     *
     * @throws IOException    If connection fails
     * @throws ParseException If JSON parsing fails
     */
    public void rescind() throws IOException, ParseException {
        JSONObject object = voteResponse(0);
        if (!(object.toJSONString().length() > 2))
            // Will return "{}"
            System.out.println("Successful rescind!");
        else
            System.out.println(object.toJSONString());
    }

    /**
     * This function downvotes this submission.
     *
     * @throws IOException    If connection fails
     * @throws ParseException If JSON parsing fails
     */
    public void downVote() throws IOException, ParseException {
        JSONObject object = voteResponse(-1);
        if (!(object.toJSONString().length() > 2))
            // Will return "{}"
            System.out.println("Successful downvote!");
        else
            System.out.println(object.toJSONString());
    }

   

    private JSONObject voteResponse(int dir) throws IOException, ParseException {
        return Utils.post(
                "id=" + fullName + "&dir=" + dir + "&uh=" + getUser().getModhash(),
                new URL("http://www.reddit.com/api/vote"), getUser().getCookie());
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the domain
     */
    public String getDomain() {
        return domain;
    }

    /**
     * @param domain the domain to set
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * @return the banned_by
     */
    public String getBanned_by() {
        return banned_by;
    }

    /**
     * @param banned_by the banned_by to set
     */
    public void setBanned_by(String banned_by) {
        this.banned_by = banned_by;
    }

    /**
     * @return the subreddit
     */
    public String getSubreddit() {
        return subreddit;
    }

    /**
     * @param subreddit the subreddit to set
     */
    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    /**
     * @return the selftext_html
     */
    public String getSelftext_html() {
        return selftext_html;
    }

    /**
     * @param selftext_html the selftext_html to set
     */
    public void setSelftext_html(String selftext_html) {
        this.selftext_html = selftext_html;
    }

    /**
     * @return the selftext
     */
    public String getSelftext() {
        return selftext;
    }

    /**
     * @param selftext the selftext to set
     */
    public void setSelftext(String selftext) {
        this.selftext = selftext;
    }

    /**
     * @return the likes
     */
    public int getLikes() {
        return likes;
    }

    /**
     * @param likes the likes to set
     */
    public void setLikes(int likes) {
        this.likes = likes;
    }

    /**
     * @return the link_flair_text
     */
    public String getLink_flair_text() {
        return link_flair_text;
    }

    /**
     * @param link_flair_text the link_flair_text to set
     */
    public void setLink_flair_text(String link_flair_text) {
        this.link_flair_text = link_flair_text;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the clicked
     */
    public boolean isClicked() {
        return clicked;
    }

    /**
     * @param clicked the clicked to set
     */
    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    /**
     * @return the stickied
     */
    public boolean isStickied() {
        return stickied;
    }

    /**
     * @param stickied the stickied to set
     */
    public void setStickied(boolean stickied) {
        this.stickied = stickied;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the media
     */
    public String getMedia() {
        return media;
    }

    /**
     * @param media the media to set
     */
    public void setMedia(String media) {
        this.media = media;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the approved_by
     */
    public String getApproved_by() {
        return approved_by;
    }

    /**
     * @param approved_by the approved_by to set
     */
    public void setApproved_by(String approved_by) {
        this.approved_by = approved_by;
    }

    /**
     * @return the over_18
     */
    public boolean isOver_18() {
        return over_18;
    }

    /**
     * @param over_18 the over_18 to set
     */
    public void setOver_18(boolean over_18) {
        this.over_18 = over_18;
    }

    /**
     * @return the hidden
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * @param hidden the hidden to set
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * @return the thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * @param thumbnail the thumbnail to set
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * @return the subreddit_id
     */
    public String getSubreddit_id() {
        return subreddit_id;
    }

    /**
     * @param subreddit_id the subreddit_id to set
     */
    public void setSubreddit_id(String subreddit_id) {
        this.subreddit_id = subreddit_id;
    }

    /**
     * @return the edited
     */
    public boolean isEdited() {
        return edited;
    }

    /**
     * @param edited the edited to set
     */
    public void setEdited(boolean edited) {
        this.edited = edited;
    }

    /**
     * @return the link_flair_css_class
     */
    public String getLink_flair_css_class() {
        return link_flair_css_class;
    }

    /**
     * @param link_flair_css_class the link_flair_css_class to set
     */
    public void setLink_flair_css_class(String link_flair_css_class) {
        this.link_flair_css_class = link_flair_css_class;
    }

    /**
     * @return the author_flair_css_class
     */
    public String getAuthor_flair_css_class() {
        return author_flair_css_class;
    }

    /**
     * @param author_flair_css_class the author_flair_css_class to set
     */
    public void setAuthor_flair_css_class(String author_flair_css_class) {
        this.author_flair_css_class = author_flair_css_class;
    }

    /**
     * @return the downs
     */
    public int getDowns() {
        return downs;
    }

    /**
     * @param downs the downs to set
     */
    public void setDowns(int downs) {
        this.downs = downs;
    }

    /**
     * @return the saved
     */
    public boolean isSaved() {
        return saved;
    }

    /**
     * @param saved the saved to set
     */
    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    /**
     * @return the is_self
     */
    public boolean isIs_self() {
        return is_self;
    }

    /**
     * @param is_self the is_self to set
     */
    public void setIs_self(boolean is_self) {
        this.is_self = is_self;
    }

    /**
     * @return the permalink
     */
    public String getPermalink() {
        return permalink;
    }

    /**
     * @param permalink the permalink to set
     */
    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the created
     */
    public double getCreated() {
        return created;
    }

    /**
     * @param created the created to set
     */
    public void setCreated(double created) {
        this.created = created;
    }

    /**
     * @return the url
     */
    public URL getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(URL url) {
        this.url = url;
    }

    /**
     * @return the author_flair_text
     */
    public String getAuthor_flair_text() {
        return author_flair_text;
    }

    /**
     * @param author_flair_text the author_flair_text to set
     */
    public void setAuthor_flair_text(String author_flair_text) {
        this.author_flair_text = author_flair_text;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the created_utc
     */
    public double getCreated_utc() {
        return created_utc;
    }

    /**
     * @param created_utc the created_utc to set
     */
    public void setCreated_utc(double created_utc) {
        this.created_utc = created_utc;
    }

    /**
     * @return the ups
     */
    public int getUps() {
        return ups;
    }

    /**
     * @param ups the ups to set
     */
    public void setUps(int ups) {
        this.ups = ups;
    }

    /**
     * @return the num_comments
     */
    public int getNum_comments() {
        return num_comments;
    }

    /**
     * @param num_comments the num_comments to set
     */
    public void setNum_comments(int num_comments) {
        this.num_comments = num_comments;
    }

    /**
     * @return the visited
     */
    public boolean isVisited() {
        return visited;
    }

    /**
     * @param visited the visited to set
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    /**
     * @return the num_reports
     */
    public int getNum_reports() {
        return num_reports;
    }

    /**
     * @param num_reports the num_reports to set
     */
    public void setNum_reports(int num_reports) {
        this.num_reports = num_reports;
    }

    /**
     * @return the distinguished
     */
    public String getDistinguished() {
        return distinguished;
    }

    /**
     * @param distinguished the distinguished to set
     */
    public void setDistinguished(String distinguished) {
        this.distinguished = distinguished;
    }

    
    

}