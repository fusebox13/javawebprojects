package im.goel.jreddit.submissions;

import im.goel.jreddit.user.User;
import im.goel.jreddit.utils.Utils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;


/**
 * This class offers some submission utilities.
 *
 * @author <a href="http://www.omrlnr.com">Omer Elnour</a>
 */
public class Submissions {
    public enum Popularity {
        HOT, NEW
    }

    public enum Page {
        FRONTPAGE
    }

    /**
     * This function returns a linked list containing the submissions on a given
     * subreddit and page. (in progress)
     *
     * @param redditName The subreddit's name
     * @param type       HOT or NEW and some others to come
     * @param frontpage       TODO this
     * @param user       The user
     * @return The linked list containing submissions
     * @throws IOException    If connection fails
     * @throws ParseException If JSON parsing fails
     */
    public static LinkedList<Submission> getSubmissions(String redditName,
                       Popularity type, Page frontpage, User user) throws IOException, ParseException {
        LinkedList<Submission> submissions = new LinkedList<Submission>();
        URL url;
        String urlString = "http://www.reddit.com/r/" + redditName;

        switch (type) {
            case NEW:
                urlString += "/new";
                break;
		default:
			break;
        }

        /**
         * TODO Implement Pages
         */

        urlString += ".json";
        url = new URL(urlString);

        Object obj = Utils.get("", url, user.getCookie());
        JSONObject object = (JSONObject) obj;
        JSONArray array = (JSONArray) ((JSONObject) object.get("data"))
                .get("children");
        JSONObject data;
        for (int i = 0; i < array.size(); i++) {
            data = (JSONObject) array.get(i);
            data = ((JSONObject) ((JSONObject) data).get("data"));
            /*submissions.add(new Submission(user,
                    data.get("id").toString(),
                    new URL("http://www.reddit.com" + (data.get("permalink").toString())),
                    new URL(data.get("url").toString())));*/
        }

        return submissions;
    }
    
    public static ArrayList<Submission> getSubmissions(String subredditName,
                       Popularity type, int numPages, User user) throws IOException, ParseException {
        ArrayList<Submission> submissions = new ArrayList<Submission>();
        URL url;
        String urlString = "http://www.reddit.com/r/" + subredditName;
        String nextPage = "";
        int submissionCount = 0;

        switch (type) {
            case NEW:
                urlString += "/new";
                break;
		default:
			break;
        }

        urlString +=".json";
        
        for (int i = 0; i < numPages; i++)
        {
            url = new URL(urlString + nextPage);

            //Get Request stores into a JSONArray
            Object obj = Utils.get("", url, user.getCookie());
            
            if (obj == null)
                return null;
            
            JSONObject object = (JSONObject) obj;
            JSONArray array = (JSONArray) ((JSONObject) object.get("data"))
                    .get("children");

            //Used to pull JSONObjects out of the JSONArray
            JSONObject data;
            for (int j = 0; j < array.size(); j++) {
                data = (JSONObject) array.get(j);
                data = ((JSONObject) ((JSONObject) data).get("data"));

                submissions.add(new Submission(data));
                submissionCount++;
                /*submissions.add(new Submission(user,
                        data.get("id").toString(),
                        new URL("http://www.reddit.com" + (data.get("permalink").toString())),
                        new URL(data.get("url").toString())));*/
            }
            nextPage = "?count=25&after=" +submissions.get(submissions.size() - 1).getName();
        }
        
        System.out.println("Returning " + submissionCount + " submissions");

        return submissions;
    }
}


