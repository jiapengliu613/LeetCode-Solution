public class Twitter {
    private int timeStamp = 0;
    private Map<Integer, User> userMap;
    private class Tweet {
        int time;
        int id;
        Tweet next;
        public Tweet(int id) {
            this.id = id;
            this.time = timeStamp++;
        }
    }
    
    private class User {
        private int id;
        private Set<Integer> followed;
        private Tweet head;
        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id);
        }
        public void follow(int id) {
            followed.add(id);
        }
        public void unfollow(int id) {
            if (!followed.contains(id)) {
                return ;
            }
            followed.remove(id);
        }
        public void post(int id) {
            Tweet tweet = new Tweet(id);
            tweet.next = head;
            head = tweet;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<>();
        
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        User user = userMap.get(userId);
        user.post(tweetId);
        
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return result;
        }
       // User user = ;
        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(), new Comparator<Tweet>() {
           @Override
           public int compare(Tweet a, Tweet b) {
               return b.time - a.time;
           }
        });
        for (int user : users) {
            Tweet tweet = userMap.get(user).head;
            if (tweet != null) {
                pq.offer(tweet);
            }
        }
        for (int i = 0; i < 10; i++) {
            if (pq.isEmpty()) {
                break;
            }
            Tweet t = pq.poll();
            result.add(t.id);
            if (t.next != null) {
                t = t.next;
                pq.offer(t);
            }
        }
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId) {
            return;
        }
        userMap.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */