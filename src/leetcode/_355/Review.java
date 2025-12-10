package leetcode._355;

import java.util.*;

public class Review {
    class Twitter {
        private static int timestamp = 0;

        class Tweet {
            int id;
            Tweet next;
            int time;

            public Tweet(int id) {
                this.id = id;
                this.next = null;
                this.time = timestamp++;
            }
        }

        Map<Integer, Set<Integer>> followMap;
        Map<Integer, Tweet> tweetMap;

        public Twitter() {
            followMap = new HashMap<>();
            tweetMap = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            if (!followMap.containsKey(userId)) {
                followMap.put(userId, new HashSet<>());
            }

            Tweet tweet = new Tweet(tweetId);
            tweet.next = tweetMap.get(userId);
            tweetMap.put(userId, tweet);
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> feed = new ArrayList<>();
            Set<Integer> followerSet = followMap.getOrDefault(userId, new HashSet<>());
            PriorityQueue<Tweet> pq = new PriorityQueue<>((o1, o2) -> o2.time - o1.time);
            for (Integer i : followerSet) {
                Tweet tweet = tweetMap.get(i);
                if (tweet != null) {
                    pq.add(tweet);
                }
            }
            Tweet selfTweet = tweetMap.get(userId);
            if (selfTweet != null) {
                pq.add(selfTweet);
            }

            int count = 0;
            while (!pq.isEmpty() && count < 10) {
                Tweet poll = pq.poll();
                feed.add(poll.id);
                count++;

                if (poll.next != null) {
                    pq.add(poll.next);
                }
            }

            return feed;
        }

        public void follow(int followerId, int followeeId) {
            if (followerId == followeeId) {
                return;
            }

            followMap.computeIfAbsent(followerId, _ -> new HashSet<>())
                    .add(followeeId);

        }

        public void unfollow(int followerId, int followeeId) {
            if (followerId == followeeId) {
                return;
            }
            Set<Integer> followees = followMap.get(followerId);
            if (followees != null) {
                followees.remove(followeeId);
            }

        }
    }
}
