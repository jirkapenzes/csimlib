(ns csimlib.core
  (:require [csimlib.simulator :refer :all]
            [csimlib.tick-scene :refer :all]))

(defn -main [& args]
  (println "Start simulation")
  (simulate (tick-model)))

(-main)
