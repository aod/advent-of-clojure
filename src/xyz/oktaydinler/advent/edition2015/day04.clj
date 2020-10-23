(ns xyz.oktaydinler.advent.edition2015.day04
  (:require [clojure.string :as str])
  (:import (java.security MessageDigest)))

(defn md5 [^String s]
  (let [algorithm (MessageDigest/getInstance "MD5")
        raw       (.digest algorithm (.getBytes s))]
    (format "%032x" (BigInteger. 1 raw))))


(defn md5-find-nth-zero [prefix n-zeros]
  (let [zeros (reduce str (repeat n-zeros \0))]
    (first (keep-indexed #(if (str/starts-with? %2 zeros) %1)
                         (map #(md5 (str prefix %))
                              (range))))))

(defn part1 [input] (md5-find-nth-zero input 5))
(defn part2 [input] (md5-find-nth-zero input 6))
