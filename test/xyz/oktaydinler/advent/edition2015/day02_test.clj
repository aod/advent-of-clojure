(ns xyz.oktaydinler.advent.edition2015.day02-test
  (:require [clojure.test :refer :all]
            [clojure.java.io :as io]
            [xyz.oktaydinler.advent.edition2015.day02 :refer :all]))

(def puzzle-input
  (-> "input/2015/02.txt" io/resource slurp))

(deftest parse-dimensions-test
  (is (= (parse-dimensions "2x3x4") [2, 3, 4]))
  (is (= (parse-dimensions "1x1x10") [1, 1, 10])))

(deftest wrapping-paper-test
  (is (= (wrapping-paper [2 3 4]) 58))
  (is (= (wrapping-paper [1 1 10]) 43)))

(deftest part1-test
  (testing "sample inputs"
    (is (= (part1 "2x3x4") 58))
    (is (= (part1 "1x1x10") 43)))
  (testing "puzzle input"
    (is (= (part1 puzzle-input) 1588178))))

(deftest ribbon-test
  (is (= (ribbon [2 3 4]) 34))
  (is (= (ribbon [1 1 10]) 14)))

(deftest part2-test
  (testing "sample inputs"
    (is (= (part2 "2x3x4") 34))
    (is (= (part2 "1x1x10") 14)))
  (testing "puzzle input"
    (is (= (part2 puzzle-input) 3783758))))
