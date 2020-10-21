(ns xyz.oktaydinler.advent.edition2015.day01-test
  (:require [clojure.test :refer :all]
            [clojure.java.io :as io]
            [xyz.oktaydinler.advent.edition2015.day01 :refer :all]))

(def puzzle-input
  (-> "input/2015/01.txt" io/resource slurp))

(deftest part1-test
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

(deftest part2-test
  (testing "sample inputs"
    (is (= (part2, ")") 1))
    (is (= (part2, "()())") 5)))
  (testing "puzzle input"
    (is (= (part2 puzzle-input)) 1771)))
