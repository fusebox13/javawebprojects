/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testarea;

import im.goel.jreddit.submissions.Submission;
import im.goel.jreddit.submissions.Submissions;
import im.goel.jreddit.submissions.Submissions.Page;
import im.goel.jreddit.submissions.Submissions.Popularity;
import im.goel.jreddit.user.User;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;

public final class testClass {
    public static void main(String[] args) throws Exception {
        User user = new User("Fusebot13", "Fusebot13");
        user.connect();
        
        ArrayList<URL> urls = new ArrayList<URL>();

        /*for (Submission submission : Submissions.getSubmissions("programming",
                Popularity.HOT, Page.FRONTPAGE, user)) {
            System.out.println(submission.getFullName());
        }*/
        
       
        ArrayList<Submission> submissions = Submissions.getSubmissions("earthporn", Popularity.HOT, 1, user);
       
        if(submissions != null)
        {
            for (Submission submission : submissions)
            {
                System.out.println(submission.getSubreddit());
            }
        }
    }
}

