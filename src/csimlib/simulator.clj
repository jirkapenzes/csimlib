(ns csimlib.simulator
    (:require [csimlib.model :refer :all])
    (:use clojure.data.priority-map))

(defn make-scheduled-event [event]
  [ event (scheduled-time event) ])

(defn schedule [events]
  (into (priority-map) (map make-scheduled-event events)))

(defn simulate [model]
  (let [end-condition (:end-condition model)]
    (loop
      [calendar (schedule (:initial-events model))
       local-time (:initial-time model)]
      (when (or (end-condition local-time) (not-empty calendar))
        (let [event (key (peek calendar))]
          (let [new-calendar (pop calendar)]
            (recur
             (into new-calendar (schedule (conj () (execute event local-time))))
             (scheduled-time event))))))))
