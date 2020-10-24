(ns xyz.oktaydinler.advent.edition2015.day05
  (:require [clojure.string :as str]))

(defn has-vowels [string]
  (let [vowels (set "aeiou")]
    (>= (count (filter #(contains? vowels %) string)) 3)))

(defn has-repeat [string] (some #(apply = %) (partition 2 1 string)))

(defn no-bad-words [string]
  (let [bad-words (set (partition 2 "abcdpqxy"))]
    (not-any? #(contains? bad-words %)
              (partition 2 1 string))))

(defn solve [is-nice-fn input]
  (count (filter true?
                 (map #(every? true? (is-nice-fn %))
                      (str/split-lines input)))))

(defn part1 [input] (solve (juxt has-vowels has-repeat no-bad-words) input))

(defn non-overlapped-repeat [string] (some? (re-find #"(..).*\1" string)))

(defn has-between [string]
  (some (fn [[l _ r]] (= l r))
        (partition 3 1 string)))

(defn part2 [input] (solve (juxt non-overlapped-repeat has-between) input))
