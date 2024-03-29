(ns xyz.oktaydinler.advent.edition2015.day06
  (:require [clojure.string :as str]))

(defn xy-ranges [^long x1 ^long y1 ^long x2 ^long y2]
  (let [xs (range x1 (+ 1 x2))
        ys (range y1 (+ 1 y2))]
    (for [x xs, y ys] [x y])))

(defn intermediate [actions instruction]
  (let [regex #"^(?:(turn on|turn off|toggle)) (\d+),(\d+) through (\d+),(\d+)$"
        match (re-find regex instruction)]
    (do (assert match "invalid instruction")
        [(get actions (keyword (str/replace (nth match 1) \  \-)))
         (apply xy-ranges (map #(Integer/parseUnsignedInt %)
                               (subvec match 2)))])))

(def ^:const grid-size 1000)
(defn xy-to-idx [[^long x ^long y]] (+ x (* y grid-size)))

(defn apply-action [action grid xy]
  (let [idx    (xy-to-idx xy)]
    (assoc! grid idx (action (grid idx)))))

(defn apply-intermediate [grid intermediate]
  (let [[action coords] intermediate]
    (reduce (comp conj! (partial apply-action action))
            grid coords)))

(defn solve [actions f type input]
  (let [grid          (transient (vec (make-array type (* grid-size grid-size))))
        intermediates (map (partial intermediate actions)
                           (str/split-lines input))]
    (f (persistent! (reduce apply-intermediate grid intermediates)))))

(def lit-actions
  {:turn-on  (constantly true)
   :turn-off (constantly false)
   :toggle   not})

(defn part1 [input]
  (solve lit-actions
         (comp count (partial filter true?))
         Boolean/TYPE
         input))

(def brightness-actions
  {:turn-on  inc
   :turn-off #(max 0 (dec ^int %))
   :toggle   (comp inc inc)})

(defn part2 [input]
  (solve brightness-actions
         (partial reduce +)
         Long/TYPE
         input))
