package leetcode._355;

import java.util.*;

public class Solution {

    static class Twitter {
        private static int timestamp = 0;

        private class Tweet {
            public int tweetId;
            public int time;
            public Tweet next;

            public Tweet(int id) {
                this.tweetId = id;
                this.time = timestamp++;
                this.next = null;
            }
        }

        // 사용자별로 팔로우하는 사람들의 id 모음
        private Map<Integer, Set<Integer>> followMap;

        // 사용자별 트윗 리스트
        private Map<Integer, Tweet> tweetMap;


        public Twitter() {
            followMap = new HashMap<>();
            tweetMap = new HashMap<>();
            timestamp = 0;
        }

        public void postTweet(int userId, int tweetId) {
            if (!followMap.containsKey(userId)) {
                followMap.put(userId, new HashSet<>());
            }

            // 새 트윗 생성 및 연결 리스트의 Head로 추가 (가장 최근 트윗)
            Tweet newTweet = new Tweet(tweetId);
            newTweet.next = tweetMap.get(userId);
            tweetMap.put(userId, newTweet);
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> feed = new ArrayList<>();
            Set<Integer> users = followMap.getOrDefault(userId, new HashSet<>());
            PriorityQueue<Tweet> pq = new PriorityQueue<>(
                    (a, b) -> b.time - a.time
            );

            for (int followeeId : users) {
                Tweet t = tweetMap.get(followeeId);
                if (t != null) {
                    pq.add(t);
                }
            }

            Tweet selfTweet = tweetMap.get(userId);
            if (selfTweet != null) {
                pq.add(selfTweet);
            }

            int count = 0;
            while (!pq.isEmpty() && count < 10) {
                Tweet latest = pq.poll();
                feed.add(latest.tweetId);
                count++;

                if (latest.next != null) {
                    pq.add(latest.next);
                }
            }

            return feed;
        }

        public void follow(int followerId, int followeeId) {
            if (followerId == followeeId) return;

            followMap.putIfAbsent(followerId, new HashSet<>());
            followMap.get(followerId).add(followeeId);

        }


        public void unfollow(int followerId, int followeeId) {
            if (followerId == followeeId) return;

            Set<Integer> followees = followMap.get(followerId);
            if (followees != null) {
                followees.remove(followeeId);
            }
        }
    }

}
