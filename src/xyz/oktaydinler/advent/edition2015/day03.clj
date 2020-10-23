(ns xyz.oktaydinler.advent.edition2015.day03)

(defn to-vec
  [move] (case move
           \^ [0 1]
           \> [1 0]
           \v [0 -1]
           \< [-1 0]
           :dunno))

(defn to-move-deltas
  [directions] (reductions #(vec (map + %1 %2))
                           [0 0]
                           (map to-vec directions)))

(defn part1
  [input] (-> input to-move-deltas distinct count))

(defn group-nth
  ([s] (group-nth s 2))
  ([s n] (reduce (fn [[h & r] c] (conj (vec r) (str h c)))
                 (repeat n "") s)))

(defn part2
  [input] (count (distinct (mapcat to-move-deltas (group-nth input)))))
