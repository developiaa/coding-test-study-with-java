package leetcode._355;

import java.util.*;

public class Review3 {

    static class Twitter {
        private class Tweet {
            int tweetId;
            int time;
            Tweet next;

            public Tweet(int tweetId) {
                this.tweetId = tweetId;
                this.time = timestamp++;
                this.next = null;
            }
        }

        static int timestamp = 0;
        Map<Integer, Set<Integer>> followMap;
        Map<Integer, Tweet> tweetMap;


        public Twitter() {
            followMap = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            Tweet newTweet = new Tweet(tweetId);
            newTweet.next = tweetMap.get(userId);
            tweetMap.put(userId, newTweet);
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> feedList = new ArrayList<>();
            Set<Integer> users = followMap.getOrDefault(userId, new HashSet<>());
            PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

            for (Integer user : users) {
                Tweet tweet = tweetMap.get(user);
                if (tweet != null) {
                    pq.offer(tweet);
                }
            }

            Tweet selfTweet = tweetMap.get(userId);
            if (selfTweet != null) {
                pq.add(selfTweet);
            }

            int count = 0;
            while (!pq.isEmpty() && count < 10) {
                Tweet latest = pq.poll();
                feedList.add(latest.tweetId);
                count++;

                if (latest.next != null) {
                    pq.offer(latest.next);
                }
            }

            return feedList;
        }

        public void follow(int followerId, int followeeId) {
            if (followerId == followeeId) {
                return;
            }
            followMap.putIfAbsent(followerId, new HashSet<>());
            followMap.get(followerId).add(followeeId);

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
