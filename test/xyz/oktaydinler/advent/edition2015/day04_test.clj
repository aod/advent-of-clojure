(ns xyz.oktaydinler.advent.edition2015.day04-test
  (:require [clojure.test :refer :all]
            [clojure.java.io :as io]
            [xyz.oktaydinler.advent.edition2015.day04 :refer :all]))

(def puzzle-input
  (-> "input/2015/04.txt" io/resource slurp))

(deftest part1-test
  (is (= (part1 puzzle-input) 254575)))

(deftest part2-test
  (is (= (part2 puzzle-input) 1038736)))
