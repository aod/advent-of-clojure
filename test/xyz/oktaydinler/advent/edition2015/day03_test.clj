(ns xyz.oktaydinler.advent.edition2015.day03-test
  (:require [clojure.test :refer :all]
            [clojure.java.io :as io]
            [xyz.oktaydinler.advent.edition2015.day03 :refer :all]))

(def puzzle-input
  (-> "input/2015/03.txt" io/resource slurp))

(deftest part1-test
  (testing "sample inputs"
    (is (= (part1 ">") 2))
    (is (= (part1 "^>v<") 4))
    (is (= (part1 "^v^v^v^v^v") 2)))
  (testing "puzzle input"
    (is (= (part1 puzzle-input) 2565))))

(deftest group-nth-test
  (is (= (group-nth "v^v^v^") ["vvv" "^^^"]))
  (is (= (group-nth "abc123" 3) ["a1" "b2" "c3"])))

(deftest part2-test
  (testing "sample inputs"
    (is (= (part2 ">") 2))
    (is (= (part2 "^>v<") 3))
    (is (= (part2 "^v^v^v^v^v") 11)))
  (testing "puzzle input"
    (is (= (part2 puzzle-input) 2639))))
