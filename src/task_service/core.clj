(ns task-service.core
  (:gen-class)
  (:require [task-service.services :as mts]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (let [tasks-count (time (mts/ts-count :tasks))
        gold-count (time (mts/ts-count :gold))]
    (println "There are" tasks-count "production tasks.")
    (println "There are" gold-count "gold tasks."))
  (monger.core/disconnect!))
