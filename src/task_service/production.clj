(ns task-service.production
  (:gen-class)
  (:require [monger.core :as mg])
  (:require [monger.collection :as mc])
  (:use monger.operators))

(defn tasks-count [& find-conditions]
  (mc/count "tasks"))

