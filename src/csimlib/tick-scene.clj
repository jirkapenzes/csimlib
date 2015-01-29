(ns csimlib.tick-scene
  (:require [csimlib.model :refer :all]))

(defrecord Tick [tick-time]
  Event
  (scheduled-time [this] tick-time)
  (execute [this]
           (println "Tick at " tick-time)
           (->Tick (inc tick-time))))

(defn tick-model []
  (make-model (->Tick 0.0) 0.0
              (fn [current-time] (< current-time 10))))
