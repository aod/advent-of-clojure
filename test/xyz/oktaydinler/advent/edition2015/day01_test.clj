(ns xyz.oktaydinler.advent.edition2015.day01_test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure.java.io :as io]
            [xyz.oktaydinler.advent.edition2015.day01 :refer [part1 part2]]))

(def puzzle-input
  (-> "input/2015/01.txt" io/resource slurp))

(deftest part-1
  (testing "sample inputs"
    (is (= (part1 "(())") 0))
    (is (= (part1 "()()") 0))
    (is (= (part1 "(((") 3))
    (is (= (part1 "(()(()(") 3))
    (is (= (part1 "))(((((") 3))
    (is (= (part1 "())") -1))
    (is (= (part1 "))(") -1))
    (is (= (part1 ")))") -3))
    (is (= (part1 ")())())") -3)))
  (testing "puzzle input"
    (is (= (part1 puzzle-input) 138))))

(deftest part-2
  (testing "sample inputs"
    (is (= (part2, ")") 1))
    (is (= (part2, "()())") 5)))
  (testing "puzzle input"
    (is (= (part2 puzzle-input)) 1771)))
