(ns task-service.gold
  (:gen-class)
  (:require [monger.core :as mg])
  (:require [monger.collection :as mc])
  (:use monger.operators))

(defn gold-count [& find-conditions]
  (mc/count "gold"))
