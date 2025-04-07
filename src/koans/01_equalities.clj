(ns koans.01-equalities
  (:require [koan-engine.core :refer :all]))

(meditations
  "We shall contemplate truth by testing reality, via equality"
  (= true true)

  "To understand reality, we must compare our expectations against reality"
  (= 2 (+ 1 1))

  "You can test equality of many things"
  (= (+ 3 4) 7 (+ 2 5))

  "Some things may appear different, but be the same"
  (= true (= 2 2/1))

  "You cannot generally float to heavens of integers"
  (= false (= 2 2.0))

  "But a looser equality is also possible"
  (= true (== 2.0 2))

  "Something is not equal to nothing"
  (= true (not (= 1 nil)))

  "Strings, and keywords, and symbols: oh my!"
  (= false (= "hello" :hello 'hello))

  "Make a keyword with your keyboard"
  (= :hello (keyword "hello"))

  "Symbolism is all around us"
  (= 'hello (symbol "hello"))

  "What could be equivalent to nothing?"
  (= nil nil)

  "When things cannot be equal, they must be different"
  (not= :fill-in-the-blank "hello"))

;; Playground


; Write a function that takes a list and returns a map where the keys are the distinct elements in the list, and the values are the number of times each element appears.

(defn group-frequencies [coll]
  (reduce (fn [acc v] (if (get acc v) (update acc v inc) (assoc acc v 1))) {} coll))
  
  ;; (group-frequencies [1 2 2 3 3 3])
;; => {1 1, 2 2, 3 3}


;; Write a function that takes a list and returns a new list containing only the elements that appear more than once in the original list.

(defn filter-duplicates [coll]
      (let [freqs (frequencies coll)]
      (filter (fn [v] (< 1 (freqs v)))
              coll))

;{1 1 2 2 3 3 4 1}

(filter-duplicates [1 2 2 3 3 3 4])
;; => [2 2 3 3 3]

(filter-duplicates [:a :b :a :c])
;; => [:a :a]

(filter-duplicates [1 2 3])
;; => []

(filter-duplicates [])
;; => []