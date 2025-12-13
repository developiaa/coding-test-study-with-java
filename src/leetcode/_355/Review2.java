package leetcode._355;

import java.util.*;

public class Review2 {
    class Twitter {

        static class Tweet {
            int time = timestamp++;
            int tweetId;
            Tweet next;

            Tweet(int tweetId) {
                this.tweetId = tweetId;
            }
        }

        static int timestamp = 0;
        Map<Integer, Set<Integer>> followMap;
        Map<Integer, Tweet> tweetMap;

        public Twitter() {
            followMap = new HashMap<>();
            tweetMap = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            Tweet tweet = tweetMap.get(userId);
            Tweet newTweet = new Tweet(tweetId);
            newTweet.next = tweet;
            tweetMap.put(userId, newTweet);
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> feedList = new ArrayList<>();
            PriorityQueue<Tweet> pq = new PriorityQueue<>((o1, o2) -> o2.time - o1.time);

            Set<Integer> followSet = followMap.getOrDefault(userId, new HashSet<>());
            for (Integer followId : followSet) {
                Tweet tweet = tweetMap.get(followId);
                if (tweet != null) {
                    pq.offer(tweet);
                }
            }

            Tweet selfTweet = tweetMap.get(userId);
            if (selfTweet != null) {
                pq.offer(selfTweet);
            }

            int count = 0;
            while (!pq.isEmpty() && count < 10) {
                Tweet poll = pq.poll();
                feedList.add(poll.tweetId);
                count++;

                if (poll.next != null) {
                    pq.offer(poll.next);
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

            Set<Integer> followers = followMap.get(followerId);
            if (followers != null) {
                followers.remove(followeeId);
            }
        }
    }
}
