(ns xyz.oktaydinler.advent.edition2015.day02
  (:require [clojure.string :as str]))

(defn parse-dimensions
  [present]
  "Parses a dimension of a present which is length, width and height to a
  vector."
  (into [] (map #(Integer/parseUnsignedInt %) (str/split present #"x"))))

(defn wrapping-paper
  [present]
  "Calculates the amount of square feet of wrapping paper that is needed for the
  given present."
  (let [[l w h] present
        [lw wh hl] (map * [w h l] present)]
    (+ (* 2 (+ lw wh hl)) (apply min [lw wh hl]))))

(defn part1
  [presents]
  "Solves Advent of Code 2015 Day 2: I Was Told There Would Be No Math - Part 1.
  Returns the total amount of square feet of wrapping paper that the elves
  should order for the given presents."
  (let [lines (str/split-lines presents)]
    (->> lines
         (map (comp wrapping-paper parse-dimensions))
         (reduce +))))

(defn ribbon
  [present]
  "Calculates the amount of feet of ribbon to wrap the present and bow for the
  given present."
  (let [[l w h] present]
    (+ (* l w h) (* 2 (- (+ l w h) (apply max [l w h]))))))

(defn part2
  [presents]
  "Solves Advent of Code 2015 Day 2: I Was Told There Would Be No Math - Part 2.
  Returns the total amount of feet of ribbon that the elves should order for the
  given presents."
  (let [lines (str/split-lines presents)]
    (->> lines
         (map (comp ribbon parse-dimensions))
         (reduce +))))
