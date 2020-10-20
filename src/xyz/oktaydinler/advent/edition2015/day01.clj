(ns xyz.oktaydinler.advent.edition2015.day01)

(defn floor-delta
  [instruction]
  "Converts a parentheses (direction) into a 1 or -1 according to the rules of
  the puzzle."
  (let [up 1 down -1]
    (if (= instruction \() up down)))

(defn floor-deltas
  [instructions]
  "Converts a list of parentheses (directions) into a lazy seq of intermediate
  values of deltas."
  (let [start-floor 0]
    (->> instructions
         (map floor-delta)
         (reductions + start-floor))))

(defn part1
  [instructions]
  "Solves Advent of Code 2015 Day 1: Not Quite Lisp - Part 1.
  Returns the floor where Santa will deliver the presents in the large
  building."
  (-> instructions floor-deltas last))

(defn part2
  [instructions]
  "Solves Advent of Code 2015 Day 1: Not Quite Lisp - Part 2.
  Finds the position that causes Santa to first enter the basement."
  (let [basement -1]
    (->> instructions
         (floor-deltas)
         (keep-indexed #(if (= %2 basement) %1))
         (first))))
