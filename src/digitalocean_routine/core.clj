(ns digitalocean-routine.core
  (:require [digitalocean.v2.core :as do]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn- droplets-exist? [token]
  "return 0 if droplets exist."
  (not (= (count (:droplets (do/droplets token)))
          0)))

(defn- delete-droplets [] "to be implemnted")

(defn- create-droplets [token number image-id]
  (if (droplets-exist? token)
    (delete-droplets))
  (for [name (map #(str "rance" %) (range 0 number))]
    (doall (do/create-droplet token nil {:name name :region "nyc3" :size "1gb" :image image-id}))
    ))

(defn -main [& args]
  (if (= (first args) "create")
    (create-droplets (nth args 1) (nth args 2) (nth args 3))))
