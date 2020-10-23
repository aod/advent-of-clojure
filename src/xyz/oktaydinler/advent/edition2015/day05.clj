(ns xyz.oktaydinler.advent.edition2015.day05
  (:require [clojure.string :as str])
  (:import (java.util.regex Pattern)))

(defn has-vowels [string]
  (let [vowels (set "aeiou")]
    (>= (count (filter #(contains? vowels %) string)) 3)))

(defn has-repeat [string] (some #(apply = %) (partition 2 1 string)))

(defn no-bad-words [string]
  (let [bad-words (set (partition 2 "abcdpqxy"))]
    (not-any? #(contains? bad-words %)
              (partition 2 1 string))))

(defn part1 [input]
  (let [is-nice (juxt has-vowels has-repeat no-bad-words)]
    (count (filter true?
                   (map #(every? true? (is-nice %))
                        (str/split-lines input))))))

(defn non-overlapped-repeat [string]
  (let [p (Pattern/compile "(..).*\\1")
        m (.matcher p string)]
    (.find m)))

(defn has-between [string]
  (some (fn [[l _ r]] (= l r))
        (partition 3 1 string)))

(defn part2 [input]
  (let [is-nice (juxt non-overlapped-repeat has-between)]
    (count (filter true?
                   (map #(every? true? (is-nice %))
                        (str/split-lines input))))))
