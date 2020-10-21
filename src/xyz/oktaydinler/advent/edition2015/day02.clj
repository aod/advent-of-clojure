(ns xyz.oktaydinler.advent.edition2015.day02
  (:require [clojure.string :as str]))

(defn parse-dimensions
  [present]
  "Parses a dimension of a present which is length, width and height to a
  vector."
  (into [] (map #(Integer/parseInt %) (str/split present #"x"))))

(defn wrapping-paper
  [present]
  "Calculates the amount of square feet of wrapping paper that is needed for the
  given present."
  (let [[l w h] present
        lw (* l w)
        wh (* w h)
        hl (* h l)]
    (+ (* 2 lw) (* 2 wh) (* 2 hl) (apply min [lw wh hl]))))

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
  "Calculates the amount of feet of ribbon to wrap the present and the ribbon
  for the bow for the given present."
  (let [[l w h] present
        lw (* 2 (+ l w))
        wh (* 2 (+ w h))
        hl (* 2 (+ h l))]
    (+ (* l w h) (apply min [lw wh hl]))))

(defn part2
  [presents]
  "Solves Advent of Code 2015 Day 2: I Was Told There Would Be No Math - Part 2.
  Returns the total amount of feet of ribbon that the elves should order for the
  given presents."
  (let [lines (str/split-lines presents)]
    (->> lines
         (map (comp ribbon parse-dimensions))
         (reduce +))))
