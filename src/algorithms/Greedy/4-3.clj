(ns algorithms.Greedy.4-3
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))


;;; Problem: Maximize Value of shipment given items of weight W, value V

;;; Item  | Weight  | Value 
;;;
;;; 1     |   5     |   3
;;; 2     |   9     |   7
;;; 3     |   2     |   1
;;; 4     |   4     |   9
;;; ...
;;; k     |   Wk    |   Vk


(defn random-item
  "return an item with random weight/value in the given range"
  [max-weight, max-val]
  (let [w (inc (rand-int max-weight))
        v (inc (rand-int max-val))]
    [w v]))

(defn random-item-list
  "generate a list of random items"
  [length max-weight max-val]
  (take length (repeatedly #(random-item max-weight max-val))))

(defn bang-for-the-buck
  "Given an item with weight w and value v, return its 'bang-for-the-buck'"
  [[w v]]
  (/ v w))

(defn sort-by-bftb
  "Sort a list of items by their 'bang-for-the-buck'"
  [items]
  (letfn [(comp-btfb
            ;; "Return the lower 'bang-for-the-buck' item"
            [[w1 v1] [w2 v2]]
            (let [bftb1 (bang-for-the-buck [w1 v1]) bftb2 (bang-for-the-buck [w2 v2])]
              (- bftb2 bftb1)))]
    (sort-by identity comp-btfb items)))


(defn greedy-knapsack
  "takes an unsorted list of items and returns the highest-value subset possible"
  [items weight-capacity]
  (let [sorted-items (sort-by-bftb items) total-weight 0]
    (while ())))
