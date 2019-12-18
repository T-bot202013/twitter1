package bot;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


	public class bot extends HttpServlet{
		private static String consumerKey = "paAvtdCpmTFI0yCkGXwyDm15Z";
		private static String consumerSecret = "jAsrUiXbbx24DcPHFax1oJeCSw53DLzMqcc0lDbOaKBsdoJIhk";
		private static String accessToken = "1196226134209228800-nd5OLsaSgLNNhMotyODXsASEogcA46";
		private static String accessTokenSecret = "YREMOxLKU3iCcj3xeA4hyA5hzRzT95Y3M3wgxFG29sVwl";
		private String getTweet(){
			String tweets[] = {
					"現在準備中",
					"ネタ不足",
			};
			int randint = (int)(Math.random()*tweets.length);
			return tweets[randint];
		}

		public void main(HttpServletRequest req, HttpServletResponse resp)
				throws IOException{
			String message = getTweet();
			Twitter twitter = new TwitterFactory().getInstance();
			twitter.setOAuthConsumer(consumerKey, consumerSecret);
			twitter.setOAuthAccessToken(new AccessToken(accessToken,accessTokenSecret));
			try{
				twitter.updateStatus(message);
				System.out.println("成功");
			} catch(TwitterException e){
				System.err.println("失敗"+e.getMessage());
			}
		}
	}
	
	