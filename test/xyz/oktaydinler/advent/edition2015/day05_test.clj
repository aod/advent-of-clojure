(ns xyz.oktaydinler.advent.edition2015.day05-test
  (:require [clojure.test :refer :all]
            [clojure.java.io :as io]
            [xyz.oktaydinler.advent.edition2015.day05 :refer :all]))

(def puzzle-input
  (-> "input/2015/05.txt" io/resource slurp))

(deftest has-vowels-test
  (is (not (has-vowels "a")))
  (is (not (has-vowels "aa")))
  (is (has-vowels "aei"))
  (is (has-vowels "xazegov"))
  (is (has-vowels "aeiouaeiouaeiou")))

(deftest has-repeat-test
  (is (not (has-repeat "abc")))
  (is (has-repeat "xx"))
  (is (has-repeat "abcdde"))
  (is (has-repeat "aabbccdd")))

(deftest no-bad-words-test
  (is (no-bad-words "xzy"))
  (is (no-bad-words "acpx"))
  (is (not (no-bad-words "abkekw")))
  (is (not (no-bad-words "cdkappa")))
  (is (not (no-bad-words "pqpogchamp")))
  (is (not (no-bad-words "xydansgame"))))

(deftest part1-test
  (testing "sample inputs"
    (is (= (part1 "ugknbfddgicrmopn") 1))
    (is (= (part1 "aaa") 1))
    (is (= (part1 "jchzalrnumimnmhp") 0))
    (is (= (part1 "haegwjzuvuyypxyu") 0))
    (is (= (part1 "dvszwmarrgswjxmb") 0)))
  (testing "puzzle input"
    (is (= (part1 puzzle-input) 238))))

(deftest non-overlapped-repeat-test
  (is (non-overlapped-repeat "xyxy"))
  (is (non-overlapped-repeat "aabcdefgaa"))
  (is (not (non-overlapped-repeat "aaa"))))

(deftest has-between-test
  (is (has-between "xyx"))
  (is (has-between "aaa"))
  (is (has-between "abcdefeghi")))

(deftest part2-test
  (testing "sample inputs"
    (is (= (part2 "qjhvhtzxzqqjkmpb") 1))
    (is (= (part2 "xxyxx") 1))
    (is (= (part2 "uurcxstgmygtbstg") 0))
    (is (= (part2 "ieodomkazucvgmuy") 0)))
  (testing "puzzle input"
    (is (= (part2 puzzle-input) 69))))
