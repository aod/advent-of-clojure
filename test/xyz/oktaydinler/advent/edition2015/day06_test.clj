(ns xyz.oktaydinler.advent.edition2015.day06-test
  (:require [clojure.test :refer :all]
            [clojure.java.io :as io]
            [xyz.oktaydinler.advent.edition2015.day06 :refer :all]))

(def puzzle-input
  (-> "input/2015/06.txt" io/resource slurp))

(deftest part1-test
  (testing "sample inputs"
    (is (= (part1 "turn on 0,0 through 999,999") 1000000))
    (is (= (part1 "toggle 0,0 through 999,0") 1000))
    (is (= (part1 "turn on 499,499 through 500,500") 4)))
  (testing "puzzle input"
    (is (= (part1 puzzle-input) 400410))))

(deftest part2-test
  (testing "sample inputs"
    (is (= (part2 "turn on 0,0 through 0,0") 1))
    (is (= (part2 "toggle 0,0 through 999,999") 2000000)))
  (testing "puzzle input"
    (is (= (part2 puzzle-input) 15343601))))
