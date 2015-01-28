(ns csimlib.model)

(defprotocol Event
  "A protocol represent a simulation event"
  (scheduled-time [this])
  (execute [this current-time] "Should return a planned events"))

(defn make-model [initial-events initial-time end-condition]
  {
   :initial-events (conj () initial-events),
   :initial-time initial-time,
   :end-condition end-condition
   })
