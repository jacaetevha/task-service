(ns task-service.services
  (:gen-class)
  (:require [monger.core :as mg])
  (:require [task-service.production :as pts])
  (:require [task-service.gold :as gts])
  (:import [com.mongodb MongoOptions ServerAddress])
  (:require [monger.collection :as mc])
  (:use monger.operators))

;; using MongoOptions allows fine-tuning connection parameters,
;; like automatic reconnection (highly recommended for production environment)
(let [^MongoOptions opts (mg/mongo-options :threads-allowed-to-block-for-connection-multiplier 300)
      ^ServerAddress sa  (mg/server-address "127.0.0.1" 27017)]
  (mg/connect! sa opts)
  (mg/set-db! (mg/get-db "sh3")))

(defn ts-count [service-name & args]
  (if (= :tasks service-name)
    (pts/tasks-count args)
    (if (= :gold service-name)
      (gts/gold-count args))))
