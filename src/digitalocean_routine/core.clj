(ns digitalocean-routine.core
  (:require [digitalocean.v2.core :as do]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn -main []
  (do/images)
  )
